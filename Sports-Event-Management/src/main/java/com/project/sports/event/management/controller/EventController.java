package com.project.sports.event.management.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.project.sports.event.management.model.Credentials;
import com.project.sports.event.management.model.Event;
import com.project.sports.event.management.model.Organizer;
import com.project.sports.event.management.repository.EventRepository;


@SessionAttributes({"id", "notifyUpdate"} )
@Controller
public class EventController {

	@Autowired
	EventRepository eventRepository;

	// Show Event Registration Page
	@RequestMapping("/eventRegistration")
	public String showEventRegistration(@ModelAttribute("event") Event event ) {
		event = new Event();
		return "eventRegisPage";
	}

	// Event Registration Submission
	
	@RequestMapping(value = "/eventRegister", method = RequestMethod.GET)
	public String registerUser(@Valid @ModelAttribute("event") Event event, BindingResult bindingResult,
			ModelMap map) {

		if (bindingResult.hasErrors()) {
			System.out.println("ui details not correct");
			return "eventRegisPage";
		}

		eventRepository.save(event);
		map.put("successful", event.getEventName()+ "  is successfully Registered");
	
		return "organizerHome";
	}
	
	
	
	  // Show Event Update Page
		@RequestMapping("/updateEvent")
		public String showUpdateForm(@ModelAttribute("event") Event event ) {
			event = new Event();
			return "updateEvent";
		}

		// Event Update Submission
		@RequestMapping(value = "/updateEventF", method = RequestMethod.GET)
		public String registerEvent(@Valid @ModelAttribute("event") Event event, BindingResult bindingResult,
				ModelMap map) {

			if (bindingResult.hasErrors()) {
				System.out.println("ui details not correct");
				return "updateEvent";
			}
			map.put("notifyUpdate", event.getEventId());
			eventRepository.updateEvent(event.getEventId(), event.getDate(), event.getTime(), event.getVenue(), event.getNoOfSlots());
			map.put("successful", event.getEventName()+ "  is successfully Updated");
			
		
			return "organizerHome";
		}
		
		
		// Delete Event
		@RequestMapping("/deleteEvent")
		public String deleteEvent(@ModelAttribute("event") Event event, ModelMap map ) {
			event = new Event();
			eventRepository.deleteEvent(event.getEventId());
			map.addAttribute("notifyUpdate", event.getEventName() + " is deleted");
			return "updateEvent";
		}

		
//
}
