package com.project.sports.event.management.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.project.sports.event.management.model.Sponsor;
import com.project.sports.event.management.model.Sports;
import com.project.sports.event.management.repository.SponsorRepository;
import com.project.sports.event.management.repository.SportRepository;

@Controller
public class SportsController {

	@Autowired
	SportRepository sportRepository;

	// Show Sports Registration Page
	@RequestMapping("/sportRegistration")
	public String showSportRegistration(@ModelAttribute("sports") Sports sports) {
		sports = new Sports();
		return "sports";
	}

	// Sports Submission
	@RequestMapping(value = "/sportRegister", method = RequestMethod.GET)
	public String registerUser(@Valid @ModelAttribute("sports") Sports sports, BindingResult bindingResult,
			ModelMap map) {

		if (bindingResult.hasErrors()) {
			System.out.println("ui details not correct");
			return "sports";
		}
		sportRepository.save(sports);
		map.put("successful", "Your details are submitted successfully");
		return "organizerHome";
	}

}
