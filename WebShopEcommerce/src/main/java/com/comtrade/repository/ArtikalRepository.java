package com.comtrade.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.comtrade.entity.Artikal;

@Repository
public interface ArtikalRepository extends JpaRepository<Artikal, Integer> {

}
