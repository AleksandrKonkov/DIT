package com.example.docboxservice.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;

import org.hibernate.annotations.Generated;
import org.hibernate.annotations.GeneratorType;

import javax.persistence.*;


@Entity
@Table(name = "documents")

public class Document {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "name")
    private String name;

    @GeneratedValue(strategy = GenerationType.AUTO)
    private long barcode;

    @ManyToOne
    @JoinColumn(name="box_id", nullable=false)
    @JsonIgnore
    private Box box;

    public Document(String name,Box box) {
        this.name = name;
        this.box=box;
    }

    public Document() {

    }


    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
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

    @Override
    public String toString() {
        return "Document{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", barcode=" + barcode +
                '}';
    }

    public Box getBox() {
        return box;
    }

    public void setBox(Box box) {
        this.box = box;
    }
}
