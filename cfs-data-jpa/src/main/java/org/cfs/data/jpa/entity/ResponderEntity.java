package org.cfs.data.jpa.entity;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.FieldDefaults;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Setter
@Getter
@Table(name = "RESPONDER")
@FieldDefaults(level = AccessLevel.PRIVATE)
public class ResponderEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "SEQ_RESPONDER")
    Long id;

    String code;
    String name;

    @ManyToOne
    AgencyEntity agency;

}
