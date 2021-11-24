package com.bsmp.emergency_room.domain.RequestDTO;

import com.bsmp.emergency_room.domain.enums.Sex;
import lombok.*;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class RequestPatientDTO {

    @Size(min = 2, message = "Last name must be at least 2 symbols")
    @NotBlank
    private String firstName;
    @Size(min = 2, message = "Last name must be at least 2 symbols")
    @NotBlank
    private String lastName;
    private LocalDate birthDay;
    @NotNull(message = "Choose your sex")
    @NotBlank
    private Sex sex;
    @Size(min = 16, max = 16, message = "Please enter 16 numbers")
    private String medicalInsuranceNumber;
    @Email
    private String email;
}
