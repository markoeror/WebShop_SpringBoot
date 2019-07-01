package com.comtrade.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.comtrade.entity.User;

public interface AdminRepository extends JpaRepository<User, Integer>{

}
