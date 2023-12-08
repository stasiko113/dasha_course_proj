package com.example.demo.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Entity
@Table(name = "prescription")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Prescription {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Long id;

    @Column(name = "drugName")
    private String drugName;

    @Column(name = "recepie_description")
    private String recepieDescription;

    @Column(name = "by_prescription")
    private Boolean byPrescription;

    @ManyToOne
    @JoinColumn(name = "doctor_id", referencedColumnName = "id")
    private DoctorInfo doctor;

    @Column(name = "date")
    private Date date;

    @ManyToOne
    @JoinColumn(name = "child_id", referencedColumnName = "id")
    private Childs child;

    @ManyToOne
    @JoinColumn(name = "visit_id", referencedColumnName = "id")
    private VisitToDoctor visit;
}
