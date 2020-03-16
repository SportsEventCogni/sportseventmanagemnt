package com.project.sports.event.management.controller;

import javax.servlet.http.HttpSession;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttribute;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.project.sports.event.management.model.Credentials;
import com.project.sports.event.management.model.Organizer;
import com.project.sports.event.management.repository.OrganizerRepository;

@SessionAttributes( {"id","notifyUpdate"}  )
@Controller
public class OrganizerLoginController {

	@Autowired
	OrganizerRepository organizerRepository;

	@RequestMapping("/home")
	public String getHomePage() {
		return "home";
	}
	
	

	// Organizer Login page
	@RequestMapping(value = "/organizerLogin", method = RequestMethod.GET)
	public String getLoginPage(@ModelAttribute("credentials") Credentials credentials) {
		 credentials = new Credentials();
		return "organizerLogin";
	}
	
	
	
	
	// Organizer Login Validation page

    @RequestMapping(value = "/orgSub", method = RequestMethod.GET)
    public String validateOrganizerRegistration(@ModelAttribute("credentials") Credentials credentials, HttpSession session, ModelMap map) {
           Organizer org = organizerRepository.getOrganizer(credentials.getId(), credentials.getPassword());
    
           if (org != null) {
                  session.setAttribute("id", credentials.getId());
                  map.put("id", credentials.getId());
                  return "organizerHome";
           } 
           
           map.addAttribute("failed", "Credentials does not matched");
                  return "organizerLogin";
                        
    }

	
	


	// Show organizer Registration Page
	@RequestMapping("/organizerRegistration")
	public String showOrganizerRegistration(@ModelAttribute("organizer") Organizer organizer) {
		organizer = new Organizer();
		return "organizerRegisPage";
	}

	// Organizer Registration Submission
	
	@RequestMapping(value = "/organizerRegisterUser", method = RequestMethod.GET)
	public String registerUser(@Valid @ModelAttribute("organizer") Organizer organizer, BindingResult bindingResult,
			ModelMap map) {

		if (bindingResult.hasErrors()) {
			System.out.println("ui details not correct");
			return "organizerRegisPage";
		}

		organizerRepository.save(organizer);
		map.put("successful", organizer.getFirstName() + " your details are submitted successfully");
		map.addAttribute("credentials", new Credentials());
		return "organizerLogin";
	}
	
	
	@RequestMapping(value = "logout", method = RequestMethod.GET)
    public String logout(HttpSession session) {
           session.removeAttribute("name");
           return "home";
    }

	

	
}
