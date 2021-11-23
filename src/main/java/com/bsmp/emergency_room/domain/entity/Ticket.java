package com.bsmp.emergency_room.domain.entity;

import com.bsmp.emergency_room.domain.enums.Symptom;
import com.bsmp.emergency_room.domain.enums.Treatment;
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

    @ManyToMany
    @CollectionTable
    private List<Doctor> doctors;

    @Enumerated
    @ElementCollection(targetClass = Symptom.class)
    @CollectionTable(name = "ticket_symptom")
    private List<Symptom> symptoms;

    private boolean isHandled;

    @OneToMany(cascade = CascadeType.ALL)
    @CollectionTable
    private List<Examination> examinationsOfTicket;
}
