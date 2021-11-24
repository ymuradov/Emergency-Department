package com.bsmp.emergency_room.domain.entity;

import com.bsmp.emergency_room.domain.enums.Sex;
import lombok.*;

import javax.persistence.*;
import java.time.LocalDate;


@Entity
@Table(name = "patients")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Patient extends Base{

    private String firstName;
    private String lastName;
    private LocalDate birthDay;
    @Enumerated(EnumType.STRING)
    private Sex sex;
    @Column(unique = true)
    private String medicalInsuranceNumber;
    @Column(unique = true)
    private String email;


}
