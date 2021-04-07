package org.cfs.rest;

import org.cfs.domain.entity.CfsEvent;
import org.cfs.dto.CfsEventDTO;
import org.cfs.mapper.CfsEventDTOMapper;
import org.cfs.security.service.CurrentUserService;
import org.cfs.security.vo.CfsUser;
import org.cfs.service.CfsEventApplicationService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class CfsEventControllerTest {

    @InjectMocks
    private CfsEventController cfsEventController;

    @Mock
    CfsEventApplicationService cfsEventApplicationService;

    @Mock
    private CfsEventDTOMapper mapper;

    @Mock
    private CurrentUserService currentUserService;

    @Test
    public void create_should_work_correctly() {
        // Given
        CfsEventDTO cfsEventDTOInput = mock(CfsEventDTO.class);
        CfsEventDTO cfsEventDTOResult = mock(CfsEventDTO.class);
        CfsEvent cfsEventIntput = mock(CfsEvent.class);
        CfsEvent cfsEventResult = mock(CfsEvent.class);
        CfsUser cfsUser = mock(CfsUser.class);
        UUID agencyId = UUID.fromString("9f55c147-896d-4892-8e9a-022c1561128a");
        when(currentUserService.getCurrentUser()).thenReturn(cfsUser);
        when(cfsUser.getAgencyId()).thenReturn(agencyId);
        when(mapper.map(cfsEventDTOInput)).thenReturn(cfsEventIntput);
        when(cfsEventApplicationService.create(cfsEventIntput, agencyId)).thenReturn(cfsEventResult);
        when(mapper.map(cfsEventResult)).thenReturn(cfsEventDTOResult);
        // When
        ResponseEntity<CfsEventDTO> result = cfsEventController.create(cfsEventDTOInput);
        // Then
        assertThat(result.getStatusCode()).isEqualTo(HttpStatus.CREATED);
        assertThat(result.getBody()).isEqualTo(cfsEventDTOResult);
    }

    @Test
    public void searchByEventTime_should_work_correctly() {
        LocalDateTime eventTimeFrom = LocalDateTime.now();
        LocalDateTime eventTimeTo = LocalDateTime.now();
        Pageable pageable = mock(Pageable.class);
        // Given
        List<CfsEventDTO> cfsEventDTOS = mock(List.class);
        List<CfsEvent> cfsEventS = mock(List.class);

        CfsUser cfsUser = mock(CfsUser.class);
        UUID agencyId = UUID.fromString("9f55c147-896d-4892-8e9a-022c1561128a");
        when(currentUserService.getCurrentUser()).thenReturn(cfsUser);
        when(cfsUser.getAgencyId()).thenReturn(agencyId);

        when(cfsEventApplicationService.searchByEventTime(eventTimeFrom, eventTimeTo, agencyId, pageable))
                .thenReturn(cfsEventS);
        when(mapper.map(cfsEventS)).thenReturn(cfsEventDTOS);
        // When
        List<CfsEventDTO> result = cfsEventController.searchByEventTime(eventTimeFrom, eventTimeTo, pageable);
        // Then
        assertThat(result).isSameAs(cfsEventDTOS);
    }

    @Test
    public void searchByResponderCode_should_work_correctly() {
        String responderCode = "OFFICE_001";
        // Given
        List<CfsEventDTO> cfsEventDTOS = mock(List.class);
        List<CfsEvent> cfsEventS = mock(List.class);

        CfsUser cfsUser = mock(CfsUser.class);
        UUID agencyId = UUID.fromString("9f55c147-896d-4892-8e9a-022c1561128a");
        when(currentUserService.getCurrentUser()).thenReturn(cfsUser);
        when(cfsUser.getAgencyId()).thenReturn(agencyId);

        when(cfsEventApplicationService.searchByResponderCode(responderCode, agencyId))
                .thenReturn(cfsEventS);
        when(mapper.map(cfsEventS)).thenReturn(cfsEventDTOS);
        // When
        List<CfsEventDTO> result = cfsEventController.searchByResponderCode(responderCode);
        // Then
        assertThat(result).isSameAs(cfsEventDTOS);
    }
}