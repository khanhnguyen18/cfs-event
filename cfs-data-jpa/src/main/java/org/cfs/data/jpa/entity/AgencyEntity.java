package org.cfs.data.jpa.entity;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.FieldDefaults;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Entity
@Setter
@Getter
@Table(name = "AGENCY")
@FieldDefaults(level = AccessLevel.PRIVATE)
public class AgencyEntity {

    @Id
    UUID id;

    String name;
}
