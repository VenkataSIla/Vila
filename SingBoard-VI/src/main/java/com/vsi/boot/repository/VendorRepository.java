package com.vsi.boot.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.vsi.boot.domain.Vendor;

@Repository
public interface VendorRepository extends CrudRepository<Vendor, Long> {

}
