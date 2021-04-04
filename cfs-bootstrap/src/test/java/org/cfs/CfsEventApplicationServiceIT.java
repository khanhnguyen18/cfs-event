package org.cfs;

import org.cfs.service.CfsEventApplicationService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest(classes = {CfsApplication.class})
public class CfsEventApplicationServiceIT {

    @Autowired
    private CfsEventApplicationService cfsEventApplicationService;

    @Test
    public void search_should_return_correct_list() {
        // Given
    }

}