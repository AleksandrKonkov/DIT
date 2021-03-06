package com.example.docboxservice.service;

import com.example.docboxservice.entities.Box;
import com.example.docboxservice.entities.Document;
import com.example.docboxservice.repository.BoxRepository;
import com.example.docboxservice.repository.DocumentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;
import java.util.Map;

@Service
public class DocumentService {

    private final DocumentRepository docRepository;
    private final BoxRepository boxRepository;

    @Autowired
    public DocumentService(DocumentRepository docRepository, BoxRepository boxRepository) {
        this.docRepository = docRepository;
        this.boxRepository = boxRepository;
    }

    public List<Document> getAll() {
        return docRepository.findAll();
    }
    @Transactional
    public Document update(Document doc) {
        Document document = docRepository.getById(doc.getId());
        document.setBarcode(doc.getBarcode());
        document.setName(doc.getName());
        return document;
    }
    @Transactional
    public Document getById(Long id) {
        Document document=docRepository.findById(id).get();
        return document;
    }

    public void delete(Long id) {
        docRepository.deleteById(id);
    }

    @Transactional
    public Document create(Map<String,String> jsonRequest) {
        long boxId = Long.parseLong(jsonRequest.get("boxId"));
        String docName = jsonRequest.get("name");
        Box box=boxRepository.getById(boxId);
        List<Document> list=box.getDocuments();
        Document document=new Document(docName,box);
        list.add(document);
        box.setDocuments(list);

        return document;
    }
}