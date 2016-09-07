package com.vsi.boot.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.vsi.boot.config.AppConstant;
import com.vsi.boot.domain.Client;
import com.vsi.boot.domain.LoginUser;
import com.vsi.boot.domain.Person;
import com.vsi.boot.domain.Representative;
import com.vsi.boot.domain.Vendor;
import com.vsi.boot.service.ClientService;
import com.vsi.boot.service.PersonService;



@Controller
public class UserController {
	
	private static final Logger log = LoggerFactory.getLogger(UserController.class);

    @Autowired
    private PersonService personService;
    @Autowired
    private ClientService clientService;
  
    @RequestMapping(value = "login" , method = RequestMethod.POST)
    public ModelAndView login(HttpServletRequest request,LoginUser user, Model model,HttpServletResponse response){
    	
    	if(user != null)
    	{
		   
		   Person person = personService.findByUsername(user);
		   
		   if (person != null)
		   {
			   
		     if(person.getUsername().equalsIgnoreCase(user.getUsername()) && person.getPassword().equalsIgnoreCase(user.getPassword()) && user.getUserType().equalsIgnoreCase(AppConstant.LOGIN_USER_TYPE_VENDOR))
		     {
				HttpSession httpSession = request.getSession();
				httpSession.setAttribute(AppConstant.LOGIN_USER_SESSION, user);
				model.addAttribute("persons", personService.findAll());
				if(user.getUserType().equalsIgnoreCase(AppConstant.LOGIN_USER_TYPE_CLIENT))
				{
					 List<Client> clientJobs = clientService.findAllClient();
					 System.out.println(clientJobs.toString());
				     model.addAttribute("clientJobs", clientJobs);
				     model.addAttribute("client", clientJobs);
		        return new ModelAndView("redirect:/clientView");
				}else
				{
					
				}
				
				if(user.getUserType().equalsIgnoreCase(AppConstant.LOGIN_USER_TYPE_VENDOR))
				{
					Vendor vendor = new Vendor();
					model.addAttribute("vendor",vendor);
		        return new ModelAndView("vendor/vendorView");
				}
				if(user.getUserType().equalsIgnoreCase(AppConstant.LOGIN_USER_TYPE_REPRESENTATIVE))
				{
					Representative representative = new Representative();
					model.addAttribute("representative",representative);
		        return new ModelAndView("representative/representativeView");
				}
				if(user.getUserType().equalsIgnoreCase(AppConstant.LOGIN_USER_TYPE_ADMIN))
				{
		        return  new ModelAndView("redirect:person/personView");
				}
		     }
		   }
    	}
		return new ModelAndView("index");
    }
	
	@RequestMapping(value = "logout" )
    public String logOut(HttpServletRequest request,HttpServletResponse response,LoginUser user){
		/*Authentication auth = SecurityContextHolder.getContext().getAuthentication();
	    if (auth != null){    
	        new SecurityContextLogoutHandler().logout(request, response, auth);
	    }*/
		HttpSession session = request.getSession(true);
		session.invalidate();
        return "redirect:/";
    }
	

    @RequestMapping(value = "login/{userType}")
    public ModelAndView vendor(@PathVariable String userType, Model model){
    	
    	model.addAttribute("userType", userType);
        return new ModelAndView("login","userType",userType);
    }
    
    
    @RequestMapping(value = "error1")
    public String error(HttpServletRequest request,HttpServletResponse response, Model model){
    	log.error("error page");
        return "error1";
    }
    
   
    
}