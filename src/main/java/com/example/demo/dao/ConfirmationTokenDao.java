package com.example.demo.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.example.demo.model.*;

@Repository
public interface ConfirmationTokenDao extends JpaRepository<ConfirmationToken,Integer>{
	

}
