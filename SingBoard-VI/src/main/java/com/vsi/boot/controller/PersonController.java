package com.vsi.boot.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.util.WebUtils;

import com.vsi.boot.config.AppConstant;
import com.vsi.boot.domain.LoginUser;
import com.vsi.boot.domain.Person;
import com.vsi.boot.service.PersonService;

@Controller
@RequestMapping(value = {"","/person"})
public class PersonController {

	private static final Logger log = LoggerFactory.getLogger(PersonController.class);

    @Autowired
    private PersonService personService;
       
    @RequestMapping(value = "personView")
    public String indexPerson(HttpServletRequest request,Model model){
        System.out.println(personService.findAll());
        model.addAttribute("persons", personService.findAll());
        
        return "person/personView";
    }

    @RequestMapping(value = "create")
    public String create(HttpServletRequest request, Model model){
        LoginUser loginUser = (LoginUser)WebUtils.getSessionAttribute(request,AppConstant.LOGIN_USER_SESSION);
        System.out.println(loginUser.toString());
        
        List<String> listString = new ArrayList<String>();
        listString.add(0, "");
        listString.add(1, "Client");
        listString.add(2, "Venodr");
        listString.add(3, "Representative");
        model.addAttribute("loginUser",WebUtils.getSessionAttribute(request,AppConstant.LOGIN_USER_SESSION));
        model.addAttribute("listString",listString);
        return "person/create";
    }

    @RequestMapping(value = "save", method = RequestMethod.POST)
    public String save(HttpServletRequest request,Person person, Model model){
    	LoginUser loginUser = (LoginUser) WebUtils.getSessionAttribute(request,AppConstant.LOGIN_USER_SESSION);
    	person.setCreatedBy(loginUser.getUsername());
    	person.setUpdatedBy(loginUser.getUsername());
        personService.save(person);
        

        return "redirect:personView";
    }

    @RequestMapping(value = "edit/{id}")
    public String edit(HttpServletRequest request,@PathVariable Long id, Model model){
    	Person person = personService.findById(id);
        model.addAttribute("person",person);
        return "person/edit";
    }


    @RequestMapping(value = "update",method = RequestMethod.POST)
    public String update(HttpServletRequest request,Person person, Model model){
    	LoginUser loginUser = (LoginUser) WebUtils.getSessionAttribute(request,AppConstant.LOGIN_USER_SESSION);
    	person.setUpdatedBy(loginUser.getUsername());
        personService.save(person);
        return "redirect:personView";
    }


    @RequestMapping(value = "/test")
    public String test(HttpServletRequest request){
        return " hello world";
    }


}
