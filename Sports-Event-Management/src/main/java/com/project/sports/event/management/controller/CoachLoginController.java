package com.project.sports.event.management.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.project.sports.event.management.model.Coach;
import com.project.sports.event.management.model.Credentials;
import com.project.sports.event.management.model.Organizer;
import com.project.sports.event.management.repository.CoachRepository;

@Controller
public class CoachLoginController {
	@Autowired
	CoachRepository coachRepository;

	
	
	
	// Show coach Login Page
	@RequestMapping("/coachLogin")
	public String getLoginPage(@ModelAttribute("credentials") Credentials credentials) {
		credentials = new Credentials();
		return "coachLogin";
	}
	

	// Coach Login
	@RequestMapping(value = "/coachSub", method = RequestMethod.GET)
	public String validateCoachLogin(@ModelAttribute("credentials") Credentials credentials, ModelMap map) {
		Coach coach = coachRepository.getCoach(credentials.getId(), credentials.getPassword());
	
		if (coach != null) {
			return "redirect:/coachHome";
		} 
		
		map.addAttribute("failed", "Credentials does not matched");
			return "coachLogin";
				
	}
	
	
	// Show coach Registration Page
	@RequestMapping("/coachRegistration")
	public String showCoachRegistration(@ModelAttribute("coach") Coach coach) {
		coach = new Coach();
		return "coachRegisPage";
	}

	// coach Submission
	@RequestMapping(value = "/coachRegisterUser", method = RequestMethod.GET)
	public String registerUser(@Valid @ModelAttribute("coach") Coach coach, BindingResult bindingResult, ModelMap map) {
		
		if (bindingResult.hasErrors()) {
			System.out.println("ui details not correct");
			return "coachRegisPage";
		}
		coachRepository.save(coach);
		map.put("successful", coach.getFirstName() + " your details are submitted successfully");
		map.addAttribute("credentials", new Credentials());
		return "coachLogin";
	}
	
	

}
