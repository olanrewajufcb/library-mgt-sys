package com.library;

public class Book implements Comparable{
    private final String ISBN;
    private final String name;
    private final String author;
    private final String yearOfPublication;

    public Book(String isbn, String name, String author, String yearOfPublication) {
        ISBN = isbn;
        this.name = name;
        this.author = author;
        this.yearOfPublication = yearOfPublication;
    }

    public String getName() {
        return name;
    }

    public String getAuthor() {
        return author;
    }

    public String getYearOfPublication() {
        return yearOfPublication;
    }
    
    public String getISBN() {
        return ISBN;
    }
    
    @Override
    public int compareTo(Object o) {
        return 0;
    }
}
