package com.project.sports.event.management.repository;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.project.sports.event.management.model.Sports;


@Transactional
@Repository
public interface SportRepository extends JpaRepository<Sports, String>{


	@Modifying
	@Query("update Sports s set  s.noOfPlayers = ?1, s.timeOfMatch = ?2  where s.id = ?3")
	void updateEvent(String noOfPlayers, String timeOfMatch, String noOfsportId);

}
