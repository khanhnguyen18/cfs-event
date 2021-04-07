package org.cfs.service;

import org.cfs.domain.entity.Agency;
import org.cfs.domain.entity.CfsEvent;
import org.cfs.domain.repository.CfsEventRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.data.domain.Pageable;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.catchThrowable;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class CfsEventApplicationServiceTest {


    @InjectMocks
    private CfsEventApplicationService cfsEventApplicationService;

    @Mock
    CfsEventRepository cfsEventRepository;

    @Test
    void create_should_throw_exception_if_not_in_same_agency() {
        // Given
        CfsEvent cfsEventInput = mock(CfsEvent.class);
        Agency agency = mock(Agency.class);
        UUID agencyId = UUID.fromString("9f55c147-896d-4892-8e9a-022c1561128a");
        when(cfsEventInput.getAgency()).thenReturn(agency);
        when(agency.getId()).thenReturn(agencyId);
        // When
        Throwable throwable = catchThrowable(() -> cfsEventApplicationService.create(cfsEventInput, null));

        // Then
        assertThat(throwable).isInstanceOf(RuntimeException.class);
        assertThat(throwable).hasMessage("Not allow to create user in another agency");
    }

    @Test
    void create_should_work_correctly() {
        // Given
        CfsEvent cfsEventInput = mock(CfsEvent.class);
        CfsEvent cfsEventResult = mock(CfsEvent.class);
        Agency agency = mock(Agency.class);
        UUID agencyId = UUID.fromString("9f55c147-896d-4892-8e9a-022c1561128a");
        when(cfsEventInput.getAgency()).thenReturn(agency);
        when(agency.getId()).thenReturn(agencyId);
        when(cfsEventRepository.create(cfsEventInput)).thenReturn(cfsEventResult);
        // When
        CfsEvent actual = cfsEventApplicationService.create(cfsEventInput, agencyId);
        // Then
        assertThat(actual).isSameAs(cfsEventResult);
        verify(cfsEventRepository).create(cfsEventInput);
    }

    @Test
    void searchByEventTime_should_delegate_to_repository() {
        // Given
        LocalDateTime eventTimeFrom = LocalDateTime.now();
        LocalDateTime eventTimeTo = LocalDateTime.now();
        Pageable pageable = mock(Pageable.class);
        UUID agencyId = UUID.fromString("9f55c147-896d-4892-8e9a-022c1561128a");
        List<CfsEvent> cfsEventResult = mock(List.class);
        when(cfsEventRepository.searchByEventTime(eventTimeFrom, eventTimeTo, agencyId, pageable)).thenReturn(cfsEventResult);
        // When
        List<CfsEvent> actual = cfsEventApplicationService.searchByEventTime(eventTimeFrom, eventTimeTo, agencyId, pageable);
        // Then
        assertThat(actual).isSameAs(cfsEventResult);
        verify(cfsEventRepository).searchByEventTime(eventTimeFrom, eventTimeTo, agencyId, pageable);
    }

    @Test
    void searchByResponderCode_should_delegate_to_repository() {
        // Given
        String responderCode ="OFFICER_001";
        UUID agencyId = UUID.fromString("9f55c147-896d-4892-8e9a-022c1561128a");
        List<CfsEvent> cfsEventResult = mock(List.class);
        when(cfsEventRepository.searchByResponderCode(responderCode, agencyId)).thenReturn(cfsEventResult);
        // When
        List<CfsEvent> actual = cfsEventApplicationService.searchByResponderCode(responderCode, agencyId);
        // Then
        assertThat(actual).isSameAs(cfsEventResult);
        verify(cfsEventRepository).searchByResponderCode(responderCode, agencyId);
    }
}