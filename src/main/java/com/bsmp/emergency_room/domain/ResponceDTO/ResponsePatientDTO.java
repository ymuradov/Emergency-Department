package com.bsmp.emergency_room.domain.ResponceDTO;

import com.bsmp.emergency_room.domain.enums.Sex;
import lombok.*;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.time.LocalDate;
import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class ResponsePatientDTO {

    private UUID id;
    private String firstName;
    private String lastName;
    private LocalDate birthDay;
    private Sex sex;
    private String medicalInsuranceNumber;
    private String email;
}
