package com.FitnesWeb.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import model.Clan;

public interface ClanRepository extends JpaRepository<Clan, Integer> {
	
	@Query("select c from Clan c where c.email = :email and c.password = :password ")
	Clan login(@Param("email") String email, @Param("password") String password);
}
