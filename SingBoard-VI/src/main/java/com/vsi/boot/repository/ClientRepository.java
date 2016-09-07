package com.vsi.boot.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.vsi.boot.domain.Client;

@Repository
public interface ClientRepository extends CrudRepository<Client, Long> {

}
