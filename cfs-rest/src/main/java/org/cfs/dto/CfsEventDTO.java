package org.cfs.dto;

import lombok.Getter;
import lombok.Setter;
import org.cfs.domain.entity.Agency;
import org.cfs.domain.entity.Responder;

import java.time.LocalDateTime;
import java.util.UUID;

@Getter
@Setter
public class CfsEventDTO {
    Long id;

    UUID eventId;
    String eventNumber;
    String eventTypeCode;
    LocalDateTime eventTime;
    LocalDateTime dispatchTime;


    Agency agency;

    Responder responder;
}
