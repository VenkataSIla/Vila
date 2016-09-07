package com.vsi.boot.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vsi.boot.dao.PersonDAO;
import com.vsi.boot.domain.LoginUser;
import com.vsi.boot.domain.Person;
import com.vsi.boot.repository.PersonRepository;

@Service
public class PersonService {

    @Autowired
    private PersonDAO personDAO;

    @Autowired
    private PersonRepository personRepository;
    
    public Object findAll(){
        return personRepository.findAll();
    }

    public Person findById(Long id){
        return personRepository.findOne(id);
    }

    public Person save(Person person){
        return personRepository.save(person);
    }
    
    public Person findByUsername(LoginUser loginUser){
        return personRepository.findByUsername(loginUser.getUsername());
    }
}
