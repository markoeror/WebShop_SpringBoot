package com.comtrade.repository;

import java.lang.annotation.Native;
import java.sql.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.comtrade.entity.Artikal;
import com.comtrade.entity.Porudzbine;

@Repository
public interface PorudzbinaRepository extends JpaRepository<Porudzbine, Integer> {
	@Query(value = "select max(id) from porudzbine",nativeQuery = true)
	Porudzbine findPorudzbinaById();



	
	
	
}
