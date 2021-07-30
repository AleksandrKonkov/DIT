package com.example.docboxservice.entities;
import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;



@Entity //specifies that the class is an entity and is mapped to a database table
@Table(name = "documents") //specifies the name of the database table to be used for mapping
public class Document {
    @Id //marks a field in a model class as the primary key
    @ GeneratedValue(strategy = GenerationType.IDENTITY) //автоинкремент
    private Integer id;

    @Column(name = "barcode") //для указания соответствия между атрибутом базовой сущности (Entity класса) и столбцом таблицы базы данных.
    private Long barcode;
    @Column(name = "title")
    private String title;

    @ManyToOne //определяет отношение многие к одному — когда множество объект сущности (Entity класса) ссылается на один объект другой сущности

    @JoinColumn(name ="folder_id", nullable = false) //annotation to map the foreign key column of a managed association.
    @JsonIgnore
    private Box box;


    public Document(Integer id, Long barcode, String title) {
        this.id = id;
        this.barcode = barcode;
        this.title = title;
        this.box = box;
    }

    public Document() {

    }

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

    public Box getFolder() {
        return box;
    }

    public void setFolder(Box box) {
        this.box = box;
    }

    @Override
    public String toString() {
        return "Document{" +
                "id=" + id +
                ", barcode=" + barcode +
                ", title='" + title + '\'' +
                '}';
    }
}
