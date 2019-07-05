package com.comtrade.repository;

import java.util.Collection;
import java.util.List;
import java.util.Set;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import com.comtrade.entity.Artikal;




@Repository
public interface ArtikalRepository extends JpaRepository<Artikal, Integer> {

	Artikal findArtikalById(int artikalId);

	@Query("select a from Artikal a where a.kategorije.id = :id")
	List<Artikal> listaArtikalaZaKat(@Param("id")int id);
	
	
	/*
	 * @Query("select v from Vlasnik v left join fetch v.setLjubimaca where v.prezime like :prezime%"
	 * ) Collection<Vlasnik> findByPrezime(@Param ("prezime")String prezime);
	 */
	
	
	
	
}
