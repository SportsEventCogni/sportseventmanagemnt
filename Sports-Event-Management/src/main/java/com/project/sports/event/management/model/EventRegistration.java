package com.project.sports.event.management.model;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class EventRegistration {

	@Id
	private String eventId;
	private String eventName;

	private String sponsorId;
	private String sponsorName;

	private String coachId;
	private String coachName;
	
	
	

	@Override
	public String toString() {
		return  eventId + ":" + eventName + ":" + sponsorId + ":" + sponsorName + ":" + coachId + ":" + coachName + ":";
	}

	public String getEventId() {
		return eventId;
	}

	public void setEventId(String eventId) {
		this.eventId = eventId;
	}

	public String getEventName() {
		return eventName;
	}

	public void setEventName(String eventName) {
		this.eventName = eventName;
	}

	public String getSponsorId() {
		return sponsorId;
	}

	public void setSponsorId(String sponsorId) {
		this.sponsorId = sponsorId;
	}

	public String getSponsorName() {
		return sponsorName;
	}

	public void setSponsorName(String sponsorName) {
		this.sponsorName = sponsorName;
	}

	public String getCoachId() {
		return coachId;
	}

	public void setCoachId(String coachId) {
		this.coachId = coachId;
	}

	public String getCoachName() {
		return coachName;
	}

	public void setCoachName(String coachName) {
		this.coachName = coachName;
	}

	public EventRegistration(String eventId, String eventName, String sponsorId, String sponsorName, String coachId,
			String coachName) {
		super();
		this.eventId = eventId;
		this.eventName = eventName;
		this.sponsorId = sponsorId;
		this.sponsorName = sponsorName;
		this.coachId = coachId;
		this.coachName = coachName;
	}

	public EventRegistration() {
		super();
		// TODO Auto-generated constructor stub
	}

}
