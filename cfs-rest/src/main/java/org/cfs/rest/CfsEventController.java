package org.cfs.rest;

import lombok.AllArgsConstructor;
import org.cfs.domain.vo.SearchCriteria;
import org.cfs.dto.CfsEventDTO;
import org.cfs.mapper.CfsEventDTOMapper;
import org.cfs.service.CfsEventApplicationService;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/rest/api/v1/cfs-event")
@AllArgsConstructor
public class CfsEventController {

    private final CfsEventApplicationService cfsEventApplicationService;
    private final CfsEventDTOMapper mapper;

    @PostMapping("/search")
    public List<CfsEventDTO> search(@RequestBody SearchCriteria searchCriteria) {
        return mapper.map(cfsEventApplicationService.search(searchCriteria));
    }

}
