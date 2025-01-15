package com.example.project;

public class BookStore{
    
    Book[] books = new Book[0];
    User[] users = new User[10];

    //Empty constructor
    public BookStore(){
    }

    //Returns users
    public User[] getUsers(){
        return users;
    }

    //Changes users to parameter
    public void setUsers(User[] userList){
        users = userList;
    }

    //Returns books
    public Book[] getBooks(){
        return books;
    }

    //Adds parameter to the first null value
    public void addUser(User user){
        for(int i = 0; i < users.length; i ++){
            if(users[i] == null){
                users[i] = user;
                break;
            }
        }
    } 

    //Changes parameter to null 
    public void removeUser(User user){
        for(int i = 0; i < users.length; i ++){
            if(users[i] == user){
                users[i] = null;
                break;
            }
        }
        consolidateUsers();
            }
        
    /*
    Moves all non-null items to the front of users.
    
    */
    public void consolidateUsers(){ 
        User[] updateUsers = new User[users.length];
        int j = 0;
        for(int i = 0; i < users.length; i ++){
            if(users[i] != null){ 
                updateUsers[j] = users[i];
                j ++;
            }
        }
        users = updateUsers;
    }


    public void addBook(Book book){
        Book[] updateBooks = new Book[books.length + 1];
        for(int i = 0; i < books.length; i ++){
            updateBooks[i] = books[i];
        }
        updateBooks[books.length] = book;
        books = updateBooks;
    }

    public void removeBook(Book book){
        if(book.getQuantity() > 0){
            book.setQuantity(book.getQuantity() - 1);
        }
        if(book.getQuantity() <= 0){
            Book[] updateBooks = new Book[books.length - 1];
            int j = 0;
            for(int i = 0; i < books.length; i ++){
                if(books[i] != book){
                    updateBooks[j] = books[i];
                    j ++;
                }
            }
            books = updateBooks;
        }
    }

    /*Inserts a book inside of books at a specific index
     * 
     * Firstly, a new Book array called updateBooks is created with a length 1 greater than books
     * Then, a for loop adds the values 
     * After that, updateBooks at the specific index is set to book
     * Lastly, ...
     */
    public void insertBook(Book book, int index){
        Book[] updateBooks = new Book[books.length + 1];
        for(int i = 0; i < index; i ++){
            updateBooks[i] = books[i];
        }
        updateBooks[index] = book;
        for(int i = index + 1; i < updateBooks.length; i ++){
            updateBooks[i] = books[i - 1];
        }
        books = updateBooks;
    }
       
    public String bookStoreBookInfo(){
        String bookInfo = "";
        for(int i = 0; i < books.length; i ++){
            bookInfo += books[i].bookInfo() + "\n"; 
        }
        return bookInfo;
    } 

    public String bookStoreUserInfo(){
        String userInfo = "";
        for(int i = 0; i < users.length; i ++){
            if(users[i] != null){
                userInfo += users[i].userInfo();

            }
            else{
                userInfo += "user: empty\n";
            }
        }
        return userInfo;
    }

}