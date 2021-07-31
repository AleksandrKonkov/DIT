package com.example.docboxservice.repository;

import com.example.docboxservice.entities.Box;
import org.springframework.data.jpa.repository.JpaRepository;



public interface BoxRepository extends JpaRepository<Box,Long> {

}
