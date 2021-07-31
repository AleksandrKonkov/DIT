package com.example.docboxservice.entities;

import javax.persistence.*;
import javax.swing.text.Document;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Entity
@Table(name ="boxes")

public class Box {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long box_id;
    @Column(name = "name")
    private String name;
    @Column(name = "barcode")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long barcode;

    @OneToMany(mappedBy = "box", fetch = FetchType.EAGER, cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Document> documents=new ArrayList<>();

    public Box(String name) {
        this.name = name;
    }

    public Box() {

    }

    public Box(long box_id, String name, long barcode) {
        this.box_id = box_id;
        this.name = name;
        this.barcode = barcode;
    }

    public Box(long box_id, String name, long barcode, List<Document> documents) {
        this.box_id = box_id;
        this.name = name;
        this.barcode = barcode;
        this.documents = documents;
    }

    @Override
    public String toString() {
        return "Box{" +
                "box_id=" + box_id +
                ", name='" + name + '\'' +
                ", barcode=" + barcode +
                ", documents=" + documents +
                '}';
    }

    public long getBox_id() {
        return box_id;
    }

    public void setBox_id(long box_id) {
        this.box_id = box_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public long getBarcode() {
        return barcode;
    }

    public void setBarcode(long barcode) {
        this.barcode = barcode;
    }

    public List<Document> getDocuments() {
        return documents;
    }

    public void setDocuments(List<Document> documents) {
        this.documents = documents;
    }
}
