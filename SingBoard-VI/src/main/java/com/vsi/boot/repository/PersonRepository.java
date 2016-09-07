package com.vsi.boot.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.vsi.boot.domain.Person;
import com.vsi.boot.service.PersonCustomService;

@Repository
public interface PersonRepository extends CrudRepository<Person, Long>,PersonCustomService {

}
