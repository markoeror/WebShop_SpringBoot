package com.comtrade.repository;



import java.util.List;
import java.util.Set;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.comtrade.entity.Artikal;
import com.comtrade.entity.Kategorije;



@Repository
public interface ArtikalRepository extends JpaRepository<Artikal, Integer> {

	Artikal findArtikalById(int artikalId);

	@Query("select a from Artikal a where a.kategorije.id = :id")
	List<Artikal> listaArtikalaZaK(@Param("id")Kategorije k);
	
	
			
	
	
}
