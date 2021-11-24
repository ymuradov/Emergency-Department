package com.bsmp.emergency_room.domain.ResponceDTO;

import com.bsmp.emergency_room.domain.enums.Sex;
import com.bsmp.emergency_room.domain.enums.Speciality;
import lombok.*;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.UUID;

@Data
@NoArgsConstructor
public class ResponseDoctorDTO {

    private UUID id;
    @Size(min = 2, message = "Last name must be at least 2 symbols")
    @NotBlank
    private String firstName;
    @Size(min = 2, message = "Last name must be at least 2 symbols")
    @NotBlank
    private String lastName;
    @NotNull(message = "Choose your sex")
    @NotBlank
    private Sex sex;
    @Size(min = 7)
    @NotBlank
    private Speciality speciality;
}
