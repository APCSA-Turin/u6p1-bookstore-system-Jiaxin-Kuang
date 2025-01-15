package com.example.project;
import java.util.Arrays;

public class User{
    //String variables contain user's name and ID and a book array listing the books they're reading
    private String name;
    private String Id;
    private Book[] book = new Book[5];

    //Constructor sets user's name and ID (ID is set up using IdGenerate.generateId())
    public User(String name, String Id){
        this.Id = Id;
        this.name = name;
    }
 
    //Returns name
    public String getName(){
        return name;
    }

    //Changes name to parameter
    public void setName(String newName){
        name = newName;
    }

    //Returns Id
    public String getId(){
        return Id;
    }

    //Changes Id to parameter
    public void setId(String newId){
        Id = newId;
    }

    //Returns book
    public Book[] getBooks(){
        return book;
    }

    //Sets book to parameter
    public void setBooks(Book[] newBook){
        book = newBook;
    }

    //Returns a string detailing user's book list using bookInfo(). If an item in user's book list is null, string will say "empty" 
    public String bookListInfo(){
        String bookInfo = "\n";
        for(int i = 0; i < book.length; i ++){
            if(book[i] == null){
                bookInfo += "empty\n";
            }
            else{
                bookInfo += book[i].bookInfo() + "\n";
            }
        }
        return bookInfo;
    } 

    //Returns a string detailing user's name, id, and book list using bookListInfo()
    public String userInfo(){
        return "Name: " + name + "\nId: " + Id + "\nBooks: " + bookListInfo();
    } 
}