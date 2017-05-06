package com.bock.here;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import java.util.HashSet;
import java.util.Set;

@Component
public class DataLoader implements ApplicationRunner{

    private EmployeeRepo employeeRepo;

    private DependantRepo dependantRepo;

    private ProjectRepo projectRepo;

    @Autowired
    public DataLoader(EmployeeRepo employeeRepo, DependantRepo dependantRepo, ProjectRepo projectRepo){
        this.employeeRepo = employeeRepo;
        this.dependantRepo = dependantRepo;
        this.projectRepo = projectRepo;
    }

    public void run(ApplicationArguments args){
        Employee me = employeeRepo.save(new Employee(new Long(1), "Scott", "Bock", new Long(1234), new HashSet<Dependant>(), new HashSet<Project>()));
        Employee micheal = employeeRepo.save(new Employee(new Long(2), "Micheal", "Bolton", new Long(1235), new HashSet<Dependant>(), new HashSet<Project>()));
        Employee mike = employeeRepo.save(new Employee(new Long(3), "Mike", "Bolton", new Long(1236), new HashSet<Dependant>(), new HashSet<Project>()));
        Employee samir = employeeRepo.save(new Employee(new Long(4), "Samir", "Notgonnaworkhereanymore", new Long(1237), new HashSet<Dependant>(), new HashSet<Project>()));


        dependantRepo.save(new Dependant(new Long(1), "Joe", "Montana", me));


        Project p1 = projectRepo.save(new Project(new Long(1), "Watch Superman 2", new Long(1000), new HashSet<Employee>()));
        p1.getEmployees().add(me);
        p1.getEmployees().add(micheal);
        p1.getEmployees().add(samir);

        projectRepo.save(p1);


        Project p2 = projectRepo.save(new Project(new Long(2), "Write a new song", new Long(2000), new HashSet<Employee>()));
        p2.getEmployees().add(me);
        p2.getEmployees().add(mike);

        projectRepo.save(p2);


    }
}