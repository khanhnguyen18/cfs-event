package org.cfs.rest;

import org.cfs.domain.entity.CfsEvent;
import org.cfs.dto.CfsEventDTO;
import org.cfs.mapper.CfsEventDTOMapper;
import org.cfs.service.CfsEventApplicationService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class CfsEventControllerTest {

    @InjectMocks
    private CfsEventController cfsEventController;

    @Mock
    CfsEventApplicationService cfsEventApplicationService;

    @Mock
    private CfsEventDTOMapper mapper;

    @Test
    public void create_should_work_correctly() {
//        // Given
//        CfsEventDTO cfsEventDTOInput = mock(CfsEventDTO.class);
//        CfsEventDTO cfsEventDTOResult = mock(CfsEventDTO.class);
//        CfsEvent cfsEventIntput = mock(CfsEvent.class);
//        CfsEvent cfsEventResult = mock(CfsEvent.class);
//        when(mapper.map(cfsEventDTOInput)).thenReturn(cfsEventIntput);
//        when(cfsEventApplicationService.create(cfsEventIntput, null)).thenReturn(cfsEventResult);
//        when(mapper.map(cfsEventResult)).thenReturn(cfsEventDTOResult);
//        // When
//        ResponseEntity<CfsEventDTO> result = cfsEventController.create(cfsEventDTOInput);
//        // Then
//        assertThat(result.getStatusCode()).isEqualTo(HttpStatus.CREATED);
//        assertThat(result.getBody()).isEqualTo(cfsEventDTOResult);
    }
}