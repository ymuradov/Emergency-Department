package com.bsmp.emergency_room.domain.entity;

import com.bsmp.emergency_room.domain.enums.Symptom;
import lombok.*;


import javax.persistence.*;
import java.util.List;


@Entity
@Table(name = "tickets")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Ticket extends Base{

    @ManyToOne
    private Patient patient;

    @ManyToOne
    private Doctor doctor;

    @Enumerated
    @ElementCollection(targetClass = Symptom.class)
    @CollectionTable(name = "ticket_symptom")
    private List<Symptom> symptoms;

    private boolean isHandled;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "examination_id")
    private List<Examination> examinationOfTicket;
}
