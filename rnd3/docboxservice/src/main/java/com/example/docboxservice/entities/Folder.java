package com.example.docboxservice.entities;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name ="boxes")
public class Folder {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(name = "barcode")
    private Long barcode;
    @Column(name = "title")
    private String title;
    @OneToMany(mappedBy = "folder", fetch = FetchType.EAGER, cascade = CascadeType.ALL, orphanRemoval = true)
    protected List<Document> documents;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Long getBarcode() {
        return barcode;
    }

    public void setBarcode(Long barcode) {
        this.barcode = barcode;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public List<Document> getDocuments() {
        return documents;
    }

    public void setDocuments(List<Document> documents) {
        documents.forEach(d -> d.setFolder(this));
        this.documents = documents;
    }

    @Override
    public String toString() {
        return "Folder{" +
                "id=" + id +
                ", barcode=" + barcode +
                ", title='" + title + '\'' +
                ", documents=" + documents +
                '}';
    }
}

