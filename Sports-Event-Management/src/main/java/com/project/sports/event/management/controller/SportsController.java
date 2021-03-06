package com.project.sports.event.management.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.project.sports.event.management.model.Event;
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
	
	// Sports Submission
		@RequestMapping(value = "/updateSportRegister", method = RequestMethod.GET)
		public String updateUser(@Valid @ModelAttribute("sports") Sports sports, BindingResult bindingResult,
				ModelMap map) {

			if (bindingResult.hasErrors()) {
				System.out.println("ui details not correct");
				return "sports"; 
			}
			sportRepository.updateSport(sports.getNoOfPlayers(), sports.getTimeOfMatch(), sports.getSportsId());
			map.put("successful", "Your details are submitted successfully");
			return "organizerHome";
		}
		
	
	 // Show Event Update Page
	@RequestMapping("/updateSport")
	public String showUpdateForm(@ModelAttribute("sports") Sports sports,ModelMap map) {
	if(sports!=null){
		Sports spo = sportRepository.getall(sports.getSportsId());
		
	      map.put("spo", spo);
			return "sportUpdate";
	}
	 return "SportsList";
	}

	@RequestMapping("/listsports")
	public String listform(@ModelAttribute("sports") Sports sports,ModelMap map) {
		List<Sports> li =sportRepository.findAll();
		List<String> lii = new ArrayList<>();
		for(Sports s:li) {
			lii.add(s.getSportsName());
		}
		map.put("li",li);
		
		return "SportsList";
	}
	// Event Update Submission
	
	@RequestMapping(value = "/updateSportF", method = RequestMethod.POST)
	public String registerEvent(@Valid @ModelAttribute("sports") Sports sports, BindingResult bindingResult,
			ModelMap map) {

		if (bindingResult.hasErrors()) {
			System.out.println("ui details not correct");
			return "sportUpdate";
		}

		sportRepository.updateSport(sports.getNoOfPlayers(), sports.getTimeOfMatch() ,sports.getSportsId());
		map.put("successful", sports.getSportsName()+ "  is successfully Updated");
	
		return "organizerHome";
	}
	
	

}
