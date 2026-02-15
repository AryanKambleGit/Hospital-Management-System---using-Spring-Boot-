package com.codingshuttle.youtube.demo.Entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.HashSet;
import java.util.Set;

@Entity
@Getter
@Setter
public class Department {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true, length = 50)
    private String name;

    @OneToOne
    @JoinColumn(name = "head_doctor_id")
    private Doctors headDoctor;

    @ManyToMany
    @JoinTable(
            name = "my_doc_dep",
            joinColumns = @JoinColumn(name = "dept_id"),
            inverseJoinColumns = @JoinColumn(name = "doct_id")
    )
    private Set<Doctors> doctors = new HashSet<>();
}
