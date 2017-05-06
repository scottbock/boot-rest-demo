package com.bock.here;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Set;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(exclude={"dependants", "projects"})
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String firstName;

    private String lastName;

    private Long employeeId;

    @OneToMany(mappedBy = "employee", cascade = CascadeType.ALL)
    private Set<Dependant> dependants;

    @ManyToMany(mappedBy = "employees")
    private Set<Project> projects;
}
