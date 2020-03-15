package com.project.sports.event.management.repository;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.project.sports.event.management.model.Coach;
import com.project.sports.event.management.model.Organizer;

@Transactional
@Repository
public interface CoachRepository extends JpaRepository<Coach, String>{
	
	@Query("select s from Coach s where coachId=?1 and password=?2")
	Coach getCoach(String coachId,String password);

}
