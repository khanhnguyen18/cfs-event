package org.cfs;

import org.cfs.domain.entity.Responder;
import org.cfs.domain.vo.SearchCriteria;
import org.cfs.service.CfsEventApplicationService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest(classes = {CfsApplication.class})
class CfsEventApplicationServiceIT {

    @Autowired
    private CfsEventApplicationService cfsEventApplicationService;

    @Test
    void search_should_return_correct_list() {
        // Given
    }

}