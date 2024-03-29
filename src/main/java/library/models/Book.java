package library.models;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

public class Book {
    private int id;

    @Size(min = 2, max = 30, message = "Name should be between 2 and 30 characters")
    @NotEmpty(message = "Name should not be empty")
    private String name;

    @Size(min = 2, max = 30, message = "Name should be between 2 and 30 characters")
    @NotEmpty(message = "Author name should not be empty")
    private String author_name;

    @NotEmpty(message = "Year should not be empty")
    private int year;

    public Book() {
    }

    public Book(int id, String name, String author_name, int year) {
        this.id = id;
        this.name = name;
        this.author_name = author_name;
        this.year = year;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAuthor_name() {
        return author_name;
    }

    public void setAuthor_name(String author_name) {
        this.author_name = author_name;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }
}
