package com.bsmp.emergency_room.domain.entity;

import com.bsmp.emergency_room.domain.enums.Analyses;
import com.bsmp.emergency_room.domain.enums.RadioDiagnostics;
import com.bsmp.emergency_room.domain.enums.Treatment;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "examinations")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Examination extends Base {

    @ManyToOne( cascade = CascadeType.ALL)
    private Ticket ticket;

    private String preliminaryDiagnosis;

    @Enumerated(EnumType.STRING)
    @ElementCollection(targetClass = Analyses.class)
    @CollectionTable(name = "examination_analyses")
    private List<Analyses> analyses;
    @Enumerated(EnumType.STRING)
    @ElementCollection(targetClass = Treatment.class)
    @CollectionTable(name = "examination_treatment")
    private List<Treatment> treatment;
    @Enumerated(EnumType.STRING)
    @ElementCollection(targetClass = RadioDiagnostics.class)
    @CollectionTable(name = "examination_radiodiagnosis")
    private List<RadioDiagnostics> radioDiagnoses;
}
