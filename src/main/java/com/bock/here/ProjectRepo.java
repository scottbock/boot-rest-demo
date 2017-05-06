package com.bock.here;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.List;

@RepositoryRestResource
interface ProjectRepo extends PagingAndSortingRepository<Project, Long> {

    List<Project> findByEmployees_FirstName(@Param("firstName") String firstName);

    List<Project> findByEmployees_LastName(@Param("lastName") String lastName);

    List<Project> findByEmployees_EmployeeId(@Param("employeeId") Long employeeId);

}

