package com.comtrade.repository;

import java.util.ArrayList;

import org.jboss.logging.Param;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.comtrade.entity.Stavke;
import com.comtrade.entity.User;

@Repository
public interface StavkeRepository extends JpaRepository<Stavke, Integer>{
	
	
}
