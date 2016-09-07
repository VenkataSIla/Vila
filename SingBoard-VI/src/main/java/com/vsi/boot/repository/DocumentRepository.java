package com.vsi.boot.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.vsi.boot.domain.ShopFile;
import com.vsi.boot.service.DocumentCustomService;

@Repository
public interface DocumentRepository extends CrudRepository<ShopFile, Long>, DocumentCustomService{


}
