package org.cfs.rest;

import lombok.AllArgsConstructor;
import org.cfs.dto.CfsEventDTO;
import org.cfs.mapper.CfsEventDTOMapper;
import org.cfs.security.vo.CfsUser;
import org.cfs.service.CfsEventApplicationService;
import org.springframework.data.domain.Pageable;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;


@RestController
@RequestMapping("/rest/api/v1/cfs-event")
@AllArgsConstructor
public class CfsEventController {

    private final CfsEventApplicationService cfsEventApplicationService;
    private final CfsEventDTOMapper mapper;

    @PostMapping("/create")
    public ResponseEntity<CfsEventDTO> create(@RequestBody CfsEventDTO cfsEventDTO) {
        CfsUser currentUser = (CfsUser) SecurityContextHolder
                .getContext()
                .getAuthentication()
                .getPrincipal();

        return ResponseEntity.status(HttpStatus.CREATED)
                .body(mapper.map(cfsEventApplicationService.create(mapper.map(cfsEventDTO),
                        currentUser.getAgencyId())));
    }

    @GetMapping("/searchByEventTime")
    public List<CfsEventDTO> searchByEventTime(
            @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss.SSS") LocalDateTime eventTimeFrom,
            @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss.SSS") LocalDateTime eventTimeTo,
            Pageable pageable) {
        CfsUser currentUser = (CfsUser) SecurityContextHolder
                .getContext()
                .getAuthentication()
                .getPrincipal();
        return mapper.map(cfsEventApplicationService.searchByEventTime(
                eventTimeFrom,
                eventTimeTo,
                currentUser.getAgencyId(),
                pageable));
    }

    @GetMapping("/searchByResponderCode")
    public List<CfsEventDTO> searchByResponderCode(String responderCode) {
        CfsUser currentUser = (CfsUser) SecurityContextHolder
                .getContext()
                .getAuthentication()
                .getPrincipal();
        return mapper.map(cfsEventApplicationService.searchByResponderCode(responderCode, currentUser.getAgencyId()));
    }

}