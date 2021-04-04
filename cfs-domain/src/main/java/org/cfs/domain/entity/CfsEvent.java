package org.cfs.domain.entity;


import lombok.Builder;
import lombok.Getter;
import lombok.experimental.FieldDefaults;


import java.time.LocalDateTime;
import java.util.UUID;

import static lombok.AccessLevel.PRIVATE;

@Getter
@Builder(toBuilder = true)
@FieldDefaults(level = PRIVATE)
public class CfsEvent {
    Long id;
    UUID eventId;
    String eventNumber;
    String eventTypeCode;
    LocalDateTime eventTime;
    LocalDateTime dispatchTime;

    Agency agency;
    Responder responder;
}
