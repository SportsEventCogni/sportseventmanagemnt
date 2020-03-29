package com.project.sports.event.management.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
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
import com.project.sports.event.management.model.Event;
import com.project.sports.event.management.model.EventRegistration;
import com.project.sports.event.management.model.Notification;
import com.project.sports.event.management.model.Organizer;
import com.project.sports.event.management.repository.EventRegistrationRepos;
import com.project.sports.event.management.repository.EventRepository;
import com.project.sports.event.management.repository.NotificationRepos;
import com.project.sports.event.management.repository.OrganizerRepository;

@Controller
@SessionAttributes("li")
public class OrganizerLoginController {

	@Autowired
	OrganizerRepository organizerRepository;

	@Autowired
	EventRegistrationRepos eventRegistrationRepos;

	@Autowired
	NotificationRepos notificationRepos;

	@Autowired
	EventRepository eventRepository;

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
	public String validateOrganizerRegistration(@ModelAttribute("credentials") Credentials credentials,
			HttpSession session, ModelMap map) {
		Organizer org = organizerRepository.getOrganizer(credentials.getId(), credentials.getPassword());

		if (org != null) {
			session.setAttribute("id", credentials);
			map.put("credentials", credentials);
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
		session.invalidate();
		return "redirect:/home";
	}

	@RequestMapping("/listRequest")
	public String listRequest(@ModelAttribute("eventregistration") EventRegistration eventRegistration, ModelMap m, HttpSession session) {
		List<EventRegistration> li = eventRegistrationRepos.findAll();

		session.removeAttribute("li");
		session.setAttribute("li", li);
		//m.put("li", li);
		return "listrequest";
	}
	
	@RequestMapping("headerHome")
	public String organizerHomeForHeader()
	{
		return "organizerHome";
	}

	@RequestMapping("/hello")
	public String hello(ModelMap map, HttpServletRequest req, HttpSession session) {
		String eventRegistration = (String) req.getParameter("EventRegistration");
		String notify[] = eventRegistration.split(":");

		String eventId = notify[0];
		String eventName = notify[1];

		String sponsorId = notify[2];
		String sponsorName = notify[3];

		String coachId = notify[4];
		String coachName = notify[5];

		String status = "accepted";
		String request = "";
		
		List<EventRegistration> list =  (List<EventRegistration>) session.getAttribute("li");
		
		for(int i=0; i<list.size(); i++)
		{
			if(list.get(i).getEventId().equals(eventId) )
			{
				list.remove(i);
				break;
			}
		}
		

		if(list.isEmpty())
			session.invalidate();

		if (coachId == null || coachId.length() <= 1) {
			coachId = "NA";
			coachName = "NA";
			request = sponsorName;
		}

		if (sponsorId == null || sponsorId.length() <= 1) {
			sponsorId = "NA";
			sponsorName = "NA";
			
			request = coachName;
		}
		
		
		

		Notification notification = new Notification(eventId, sponsorId, coachId, status);
		notificationRepos.save(notification);
		eventRegistrationRepos.deleteById(eventId);

		map.put("req", request + " request is Accepted Successfully");
		return "listrequest";
	}

	@RequestMapping("/deletehello")
	public String hellodelete(ModelMap map, HttpServletRequest req, HttpSession session) {
		
		String eventRegistration = (String) req.getParameter("EventRegistration");
		String notify[] = eventRegistration.split(":");
		
		System.out.println("yasir" +eventRegistration);

		String eventId = notify[0];
		String eventName = notify[1];

		String sponsorId = notify[2];
		String sponsorName = notify[3];

		String coachId = notify[4];
		String coachName = notify[5];

		String status = "rejected";
		String request = "";
		
		

		List<EventRegistration> list =  (List<EventRegistration>) session.getAttribute("li");
		
		for(int i=0; i<list.size(); i++)
		{
			if(list.get(i).getEventId().equals(eventId) )
			{
				list.remove(i);
				break;
			}
		}
		
		if(list.isEmpty())
			session.invalidate();

		if (coachId == null || coachId.length() <= 1) {
			coachId = "NA";
			coachName = "NA";
			request = sponsorName;
		}

		if (sponsorId == null || sponsorName.length() <= 1) {
			sponsorId = "NA";
			sponsorName = "NA";
			request = coachName;
		}

		Notification notification = new Notification(eventId, sponsorId, coachId, status);
		notificationRepos.save(notification);
		eventRegistrationRepos.deleteById(eventId);

		map.put("req", request + " request is Rejected Successfully");
		return "listrequest";

	}

}
