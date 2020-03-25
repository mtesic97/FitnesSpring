package com.FitnesWeb.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import model.Komentar;
import model.Trener;

public interface KomentarRepository extends JpaRepository<Komentar, Integer> {
	
	@Query("select k from Komentar k where k.trener = :trener")
	List<Komentar> sviKomentariZaTrenera(@Param("trener") Trener trener);

}
