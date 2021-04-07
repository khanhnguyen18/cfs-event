package org.cfs.rest;

import lombok.AllArgsConstructor;
import org.cfs.dto.CfsEventDTO;
import org.cfs.mapper.CfsEventDTOMapper;
import org.cfs.security.service.CurrentUserService;
import org.cfs.service.CfsEventApplicationService;
import org.springframework.data.domain.Pageable;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;


@RestController
@RequestMapping("/rest/api/v1/cfs-event")
@AllArgsConstructor
public class CfsEventController {

    private final CfsEventApplicationService cfsEventApplicationService;
    private final CfsEventDTOMapper mapper;
    private final CurrentUserService userService;

    @PostMapping("/create")
    public ResponseEntity<CfsEventDTO> create(@RequestBody CfsEventDTO cfsEventDTO) {
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(mapper.map(cfsEventApplicationService.create(mapper.map(cfsEventDTO),
                        userService.getCurrentUser().getAgencyId())));
    }

    @GetMapping("/searchByEventTime")
    public List<CfsEventDTO> searchByEventTime(
            @DateTimeFormat(pattern = "yTyyy-MM-dd HH:mm:ss.SSS") LocalDateTime eventTimeFrom,
            @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss.SSS") LocalDateTime eventTimeTo,
            Pageable pageable) {
        return mapper.map(cfsEventApplicationService.searchByEventTime(
                eventTimeFrom,
                eventTimeTo,
                userService.getCurrentUser().getAgencyId(),
                pageable));
    }

    @GetMapping("/searchByResponderCode")
    public List<CfsEventDTO> searchByResponderCode(String responderCode) {
        return mapper.map(
                cfsEventApplicationService.searchByResponderCode(
                        responderCode, userService.getCurrentUser().getAgencyId())
        );
    }

}