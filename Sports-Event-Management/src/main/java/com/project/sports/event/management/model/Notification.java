package com.project.sports.event.management.model;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Notification {

	@Id
	private String eventId;

	private String sponsorId;
	private String coachId;
	private String status;

	public String getEventId() {
		return eventId;
	}

	public void setEventId(String eventId) {
		this.eventId = eventId;
	}

	public String getSponsorId() {
		return sponsorId;
	}

	public void setSponsorId(String sponsorId) {
		this.sponsorId = sponsorId;
	}

	public String getCoachId() {
		return coachId;
	}

	public void setCoachId(String coachId) {
		this.coachId = coachId;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Notification(String eventId, String sponsorId, String coachId, String status) {
		super();
		this.eventId = eventId;
		this.sponsorId = sponsorId;
		this.coachId = coachId;
		this.status = status;
	}

	public Notification() {
		super();
		// TODO Auto-generated constructor stub
	}

}
