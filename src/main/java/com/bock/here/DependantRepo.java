package com.bock.here;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.List;

@RepositoryRestResource
interface DependantRepo extends PagingAndSortingRepository<Dependant, Long> {

}

