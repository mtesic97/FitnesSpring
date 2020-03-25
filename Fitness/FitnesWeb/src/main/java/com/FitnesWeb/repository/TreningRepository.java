package com.FitnesWeb.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import model.Clan;
import model.Trener;
import model.Trening;

public interface TreningRepository extends JpaRepository<Trening, Integer> {

	@Query("select t from Trening t where t.clan = :clan")
	List<Trening> sviTrenizni(@Param("clan") Clan clan);
	
	@Query("select t from Trening t where t.trener = :trener")
	List<Trening> sviTrenizniZaTrenera(@Param("trener") Trener trener);
}
