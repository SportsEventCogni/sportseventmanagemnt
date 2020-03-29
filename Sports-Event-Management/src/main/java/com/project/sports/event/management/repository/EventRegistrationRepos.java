package com.project.sports.event.management.repository;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.project.sports.event.management.model.EventRegistration;

@Transactional
@Repository
public interface EventRegistrationRepos extends JpaRepository<EventRegistration, String>{

}
