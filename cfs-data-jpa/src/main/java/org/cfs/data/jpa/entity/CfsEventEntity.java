package org.cfs.data.jpa.entity;

import lombok.*;
import lombok.experimental.FieldDefaults;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Setter
@Getter
@Table(name = "CFS_EVENT")
@FieldDefaults(level = AccessLevel.PRIVATE)
public class CfsEventEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "SEQ_CFS_EVENT")
    Long id;

    UUID eventId;
    String eventNumber;
    String eventTypeCode;
    LocalDateTime eventTime;
    LocalDateTime dispatchTime;

    @ManyToOne
    AgencyEntity agency;

    @ManyToOne
    ResponderEntity responder;

}
