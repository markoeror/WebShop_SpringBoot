package com.comtrade.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.comtrade.entity.Kategorije;
@Repository
public interface KategorijaRepository extends JpaRepository<Kategorije, Integer>{

}
