package org.cfs.domain.vo;

import lombok.Getter;
import lombok.Setter;
import lombok.experimental.FieldDefaults;

import java.time.LocalDateTime;

import static lombok.AccessLevel.PRIVATE;

@Getter
@Setter
@FieldDefaults(level = PRIVATE)
public class SearchCriteria {
    LocalDateTime eventTimeFrom;
    LocalDateTime eventTimeTo;
}
