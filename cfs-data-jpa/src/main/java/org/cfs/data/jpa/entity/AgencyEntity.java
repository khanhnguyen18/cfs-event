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
@Table(name = "AGENCY")
@FieldDefaults(level = AccessLevel.PRIVATE)
public class AgencyEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "SEQ_ORDER")
    Long id;

    String name;

}
