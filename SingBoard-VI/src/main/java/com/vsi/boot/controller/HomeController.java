package com.vsi.boot.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.vsi.boot.config.AppConstant;
import com.vsi.boot.domain.LoginUser;

@Controller
@RequestMapping("/")
public class HomeController {

	private static final Logger log = LoggerFactory.getLogger(HomeController.class);

	
	@RequestMapping(value = {"/","index"})
    public String index(Model model){
        return "index";
    }
	
	@RequestMapping(value = "about" )
    public String about(HttpServletRequest request,LoginUser user){
        return "about";
    }
	
	@RequestMapping(value = "contactUs" )
    public String contactUs(HttpServletRequest request,LoginUser user){		
		HttpSession httpSession = request.getSession();
		httpSession.setAttribute(AppConstant.LOGIN_USER_SESSION, user);
		
		httpSession.invalidate();
        return "contactUs";
    }
}
