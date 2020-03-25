package com.FitnesWeb.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import model.Radnik;

public interface RadnikRepository extends JpaRepository<Radnik, Integer>{

	@Query("select r from Radnik r where r.username = :username and r.password = :password ")
	Radnik login(@Param("username") String username, @Param("password") String password);
}
