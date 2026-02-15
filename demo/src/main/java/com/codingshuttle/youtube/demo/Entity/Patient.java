package com.codingshuttle.youtube.demo.Entity;

//import com.codingshuttle.youtube.demo.Enumm.BloodGroup;//////////////////////////////////
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(
        name = "patient",
        uniqueConstraints = {
                @UniqueConstraint(name = "unique_patient_email", columnNames = {"email"})
        },
        indexes = {
                @Index(name = "idx_patient_birthdate", columnList = "birth_date")
        }
)
@Getter
@Setter
@ToString(exclude = {"insurance", "appointmentList"})
public class Patient {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 30, nullable = false)
    private String name;

    @Column( nullable = false)
    private LocalDate birthDate;

    @Column(unique = true, length = 50, nullable = false)
    private String email;


    @Column( length = 10)
    private String bloodGroup;

    @Column(nullable = false)
    private Integer age;

    @CreationTimestamp
    @Column( updatable = false)
    private LocalDateTime createdAt;

    @OneToOne(cascade = {CascadeType.MERGE , CascadeType.PERSIST } , orphanRemoval = true)
    @JoinColumn(name="patient_insurance_id")
    private Insurance insurance;

    @OneToMany(mappedBy = "patient" , cascade = {CascadeType.REMOVE} , orphanRemoval = true)   //inverse side so you have to mapped By
    private List<Appointment> appointmentList = new ArrayList<>();
}
