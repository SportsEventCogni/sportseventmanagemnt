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
import com.project.sports.event.management.model.Sponsor;
import com.project.sports.event.management.repository.CoachRepository;
import com.project.sports.event.management.repository.SponsorRepository;

@Controller
public class SponsorLoginController {

	@Autowired
	SponsorRepository sponsorRepository;

	// Show Sponsor Login Page
	@RequestMapping("/sponsorLogin")
	public String getLoginPage(@ModelAttribute("credentials") Credentials credentials) {
		credentials = new Credentials();

		return "sponsorLogin";
	}

	// Sponsor Login Validation page
	@RequestMapping(value = "/sponsorSub", method = RequestMethod.GET)
	public String validateSponsorRegistration(@ModelAttribute("credentials") Credentials credentials, ModelMap map) {
		Sponsor sponsor = sponsorRepository.getSponsor(credentials.getId(), credentials.getPassword());

		if (sponsor != null) {
			return "home";
		}

		map.addAttribute("failed", "Credentials does not matched");
		return "organizerLogin";

	}

	// Show sponsor Registration Page
	@RequestMapping("/sponsorRegistration")
	public String showSponsorRegistration(@ModelAttribute("sponsor") Sponsor sponsor) {
		sponsor = new Sponsor();
		return "sponsorRegisPage";
	}

	// sponsor Submission
	@RequestMapping(value = "/sponsorRegisterUser", method = RequestMethod.GET)
	public String registerUser(@Valid @ModelAttribute("sponsor") Sponsor sponsor, BindingResult bindingResult,
			ModelMap map) {

		if (bindingResult.hasErrors()) {
			System.out.println("ui details not correct");
			return "sponsorRegisPage";
		}
		sponsorRepository.save(sponsor);
		map.put("successful", "Your details are submitted successfully");
		map.addAttribute("credentials", new Credentials());
		return "sponsorLogin";
	}

	// background: linear-gradient(to bottom left, #EF8D9C 40%, #FFC39E 100%);

}
