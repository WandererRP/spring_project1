package ru.rol.springproject1.models;

import javax.validation.constraints.Max;
import javax.validation.constraints.NotEmpty;

public class Book {

    private int book_id;
    @NotEmpty(message = "Book name should not be empty")
    private String book_name;
    @NotEmpty(message = "Author should not be empty")
    private String author;
    @Max(value = 2030,message = "Year should not be empty")
    private int year;

    public int getBook_id() {
        return book_id;
    }

    public void setBook_id(int id) {
        this.book_id = id;
    }

    public String getBook_name() {
        return book_name;
    }

    public void setBook_name(String book_name) {
        this.book_name = book_name;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

}

