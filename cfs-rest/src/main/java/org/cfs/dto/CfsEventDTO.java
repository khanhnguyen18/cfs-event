package org.cfs.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.UUID;

@Getter
@Setter
public class CfsEventDTO {
    Long id;

    @JsonProperty("event_id")
    UUID eventId;

    @JsonProperty("event_number")
    String eventNumber;

    @JsonProperty("event_type_code")
    String eventTypeCode;

    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss.SSS")
    @JsonProperty("event_time")
    LocalDateTime eventTime;

    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss.SSS")
    @JsonProperty("dispatch_time")
    LocalDateTime dispatchTime;

    @JsonProperty("agency_id")
    UUID agencyId;

    String responder;
}
