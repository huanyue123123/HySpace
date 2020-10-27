package com.gm.wj;

import java.io.Serializable;
import java.util.List;

public class User implements Serializable {

    private Integer id ;

    private String name;

    private Book book;

    public User() {
    }

    public User(Integer id, String name, Book book) {
        this.id = id;
        this.name = name;
        this.book = book;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }
}
