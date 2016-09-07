package com.vsi.boot.config;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Repository;

import com.vsi.boot.domain.Person;
import com.vsi.boot.repository.PersonRepository;
import com.vsi.boot.service.PersonCustomServiceImpl;


@Repository
public class UserDetailServiceImpl implements UserDetailsService  {

    @Autowired
    private PersonRepository repo;

    @Override
    public UserDetails loadUserByUsername(String username)
            throws UsernameNotFoundException, DataAccessException
    {
        System.out.println("GETTING LOGIN DETAILS!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
        UserDetails user = null;
      Person person =  repo.findByUsername(username);
        if(person != null && person.getUsername() != null && person.getPassword() != null)
        {
         List<GrantedAuthority> gas = new ArrayList<GrantedAuthority>();
        gas.add(new PersonCustomServiceImpl());
         user = new org.springframework.security.core.userdetails.User(
            username, person.getPassword(), true, true, true, true, gas);
        }
        return user;
    }
}