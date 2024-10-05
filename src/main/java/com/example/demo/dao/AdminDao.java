package com.example.demo.dao;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.demo.model.Admins;

@Repository
public interface AdminDao extends JpaRepository<Admins,Integer>{

	@Query("from Admins where email =?1")
	Admins findByEmail(String email);

}
