package com.vsi.boot.service;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.security.core.GrantedAuthority;

import com.vsi.boot.domain.Person;

public class PersonCustomServiceImpl implements PersonCustomService, GrantedAuthority{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@PersistenceContext
	private EntityManager entityManager;

	public Person findByUsername(String username){
		
		return (Person) entityManager.createQuery("select e from person e where e.username like '"+username+"'").getResultList();
	}

	@Override
	public String getAuthority() {
		return null;
	}


}
