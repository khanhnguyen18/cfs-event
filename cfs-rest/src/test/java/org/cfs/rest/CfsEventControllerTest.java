package org.cfs.rest;

import org.cfs.mapper.CfsEventDTOMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class CfsEventControllerTest {

    @InjectMocks
    private CfsEventController productController;

    @Mock
    private CfsEventDTOMapper productDTOMapper;

    @Test
    public void search_should_work_correctly(){
        // Given
        // When
        // Then
    }
}