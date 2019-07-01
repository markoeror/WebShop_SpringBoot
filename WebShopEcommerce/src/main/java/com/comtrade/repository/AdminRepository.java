package com.comtrade.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.comtrade.entity.User;
@Repository
public interface AdminRepository extends JpaRepository<User, Integer>{

}
