package com.example.docboxservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import javax.swing.text.Document;

public interface DocumentRepository extends JpaRepository<Document,Long> {
}
