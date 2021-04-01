package org.cfs.data.jpa.entity;

import lombok.*;
import lombok.experimental.FieldDefaults;
import org.hibernate.annotations.JoinColumnOrFormula;
import org.hibernate.annotations.JoinColumnsOrFormulas;
import org.hibernate.annotations.JoinFormula;
import org.cfs.domain.vo.Colour;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Entity
@Setter
@Getter
@Table(name = "CFS_EVENT")
@FieldDefaults(level = AccessLevel.PRIVATE)
public class CfsEventEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "SEQ_PRODUCT")
    Long id;

    UUID eventId;
    String eventNumber;
    String eventTypeCode;
    LocalDateTime eventTime;
    LocalDateTime dispatchTime;

    @OneToOne(cascade = CascadeType.ALL)
    AgencyEntity agency;

    @OneToOne(cascade = CascadeType.ALL)
    ResponderEntity responder;

}
