package com.example.project;

public class BookStore{
    
    /*
     * books is a dyanmic array with no null values that'll change its length each time a book is added, removed, or inserted
     * users is a static array with a length of 10 unless setUsers changes its length
     */
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

    //Adds user parameter to the first null value
    public void addUser(User user){
        for(int i = 0; i < users.length; i ++){
            if(users[i] == null){
                users[i] = user;
                break;
            }
        }
    } 

    //Changes user parameter to null 
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
        1. Creates an empty User[] called udpateUsers that has the same length as users
        2. Loops through all items in users, and if the current item isn't null, it'll be added as the next item of updateUsers
        3. Sets users to updateUsers
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

    /* 
    Adds the book parameter to the end of books
        1. Creates an empty Book[] called updateBooks that has a length one greater than books
        2. Loops through books, adding each item to updateBooks
        3. Last item of updateBooks is set to the book parameter
        4. Books is set to updateBooks
     * 
     */
    public void addBook(Book book){
        Book[] updateBooks = new Book[books.length + 1];
        for(int i = 0; i < books.length; i ++){
            updateBooks[i] = books[i];
        }
        updateBooks[books.length] = book;
        books = updateBooks;
    }

    /*
     * Decreases the quantity of the book parameter by 1 if the current quantity is 1 or more. If the quantity is 0, the book parameter will be removed from books 
     * Checks if the book parameter's quantity is greater than 0, if so, decreases quantity by 1
     * After the changes, if book quantity is 0, an empty Book[] called updateBooks will be initialized with a length one less than books
     * Loops through all items inside of books, adding them into updateBooks unless they're equivalent to the book parameter
     * Sets books to updateBooks
     */
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
     * Firstly, an empty Book[] called updateBooks is created with a length 1 greater than books
     * Then, a for loop adds all the items between 0 and index - 1 in books to updateBooks
     * After that, updateBooks at the specific index is set to the book parameter
     * Lastly, a for loop adds all the items after index in books to updateBooks and books is set to updateBooks
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
       
    /*
     * Returns a String about books by looping through each item in books and using bookInfo()
     */
    public String bookStoreBookInfo(){
        String bookInfo = "";
        for(int i = 0; i < books.length; i ++){
            bookInfo += books[i].bookInfo() + "\n"; 
        }
        return bookInfo;
    } 

    /*
     * Returns a String about users by looping through each item in users and using userInfo()
     */
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