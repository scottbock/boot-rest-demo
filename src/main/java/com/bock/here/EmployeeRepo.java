package com.bock.here;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.List;

@RepositoryRestResource
interface EmployeeRepo extends PagingAndSortingRepository<Employee, Long> {

    List<Employee> findByEmployeeId(@Param("employeeId") Long id);

    List<Employee> findByLastName(@Param("lastName") String lastName);

    List<Employee> findByFirstNameOrLastName(@Param("firstName") String firstName, @Param("lastName") String lastName);

    List<Employee> findByFirstNameAndLastName(@Param("firstName") String firstName, @Param("lastName") String lastName);

    List<Employee> findByLastNameIgnoreCase(@Param("lastName") String lastName);


}

