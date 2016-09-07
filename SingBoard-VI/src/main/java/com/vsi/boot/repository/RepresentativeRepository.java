package com.vsi.boot.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.vsi.boot.domain.Representative;

@Repository
public interface RepresentativeRepository extends CrudRepository<Representative, Long> {

}
