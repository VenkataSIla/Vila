package com.vsi.boot.service;

import com.vsi.boot.domain.Person;

public interface PersonCustomService  {
	
	public Person findByUsername(String name);

}
