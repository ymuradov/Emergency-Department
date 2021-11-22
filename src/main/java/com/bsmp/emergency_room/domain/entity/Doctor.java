package com.bsmp.emergency_room.domain.entity;

import com.bsmp.emergency_room.domain.enums.Sex;
import com.bsmp.emergency_room.domain.enums.Speciality;
import lombok.*;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Table;
import java.time.LocalDate;


@Entity
@Getter
@Setter
@Table(name = "doctors")
@NoArgsConstructor
@AllArgsConstructor
public class Doctor extends Base{

    private String firstName;
    private String lastName;
    private LocalDate birthDay;
    @Enumerated(EnumType.STRING)
    private Sex sex;
    @Enumerated(EnumType.STRING)
    private Speciality speciality;
}
