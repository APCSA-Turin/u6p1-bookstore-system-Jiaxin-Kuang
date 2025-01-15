package com.example.project;

public class Book{
    //Private instance variables, each detailing information about the book's attributes 
    private String title;
    private String author;
    private int yearPublished;
    private String isbn;
    private int quantity;

    //Constructor sets private instance variables to values
    public Book(String title, String author, int yearPublished, String isbn, int quantity){
        this.title = title;
        this.author = author;
        this.yearPublished = yearPublished;
        this.isbn = isbn;
        this.quantity = quantity;
    }

    //Returns title
    public String getTitle(){
        return title;
    }
    
    //Changes title to the parameter  
    public void setTitle(String newTitle){
        title = newTitle;
    }

    //Returns author
    public String getAuthor(){
        return author;
    }

    //Changes author to the parameter  
    public void setAuthor(String newAuthor){
        author = newAuthor;
    }

    //Returns yearPublished
    public int getYearPublished(){
        return yearPublished;
    }

    //Changes yearPublished to parameter
    public void setYearPublished(int newYearPublished){
        yearPublished = newYearPublished;
    }

    //Returns isbn
    public String getIsbn(){
        return isbn;
    }

    //Changes isbn to parameter
    public void setIsbn(String newIsbn){
        isbn = newIsbn;
    }

    //Returns quantity
    public int getQuantity(){
        return quantity;
    }

    //Changes quantity to parameter
    public void setQuantity(int newQuantity){
        quantity = newQuantity;
    }

    //Returns a string detailing all the values of the instance variables  
    public String bookInfo(){
        return "Title: " + title + ", Author: " + author + ", Year: " + yearPublished + ", ISBN: " + isbn + ", Quantity: " + quantity;
    }
}