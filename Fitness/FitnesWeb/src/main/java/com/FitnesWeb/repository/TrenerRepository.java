package com.FitnesWeb.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import model.Trener;

public interface TrenerRepository extends JpaRepository<Trener, Integer>{

	@Query("select t from Trener t where t.email = :email and t.password = :password ")
	Trener login(@Param("email") String email, @Param("password") String password);
}
