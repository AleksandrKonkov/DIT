package com.example.docboxservice.controller;


import com.example.docboxservice.entities.Document;
import com.example.docboxservice.service.DocumentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;


@Controller
public class DocumentController {

    private final DocumentService documentService;

    @Autowired
    public DocumentController(DocumentService documentService) {
        this.documentService = documentService;
    }

    @PostMapping(value = "/createDocument")
    public ResponseEntity<Document> createDocument(@RequestBody Map<String,String> map){
        return ResponseEntity.ok(documentService.create(map));
    }

    @GetMapping("/getAllDocuments")
    public ResponseEntity<List<Document>> getAllDocuments(){
        return ResponseEntity.ok(documentService.getAll());
    }

    @GetMapping("/getDocumentById/{id}")
    public ResponseEntity<Document> getDocumentById(@PathVariable Long id){
        return ResponseEntity.ok(documentService.getById(id));
    }

    @PutMapping("/updateDocumentById")
    public ResponseEntity<Document> updateDocument(@RequestBody Document document){
        return ResponseEntity.ok(documentService.update(document));
    }

    @DeleteMapping("/deleteDocument/{id}")
    public void deleteDocument(@PathVariable Long id) {
        documentService.delete(id);
    }
}
