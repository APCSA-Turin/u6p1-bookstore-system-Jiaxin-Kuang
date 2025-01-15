package com.example.project;

public class IdGenerate{
    //CurrentId updates to the latest Id given to a user. CurrentId is static, so that it represents the latest id for all users, not just one 
    private static String currentId = "99";

    //Empty constructor
    public IdGenerate(){
    }

    //Returns currentId
    public static String getCurrentId(){
        return currentId;
    }

    //Resets Id to 99
    public static void reset(){
        currentId = "99";
    } 

    //Generates and returns the next user Id. Makes sure to increment currentId by 1, so that currentId is up to date
    public static String generateID(){
        currentId = String.valueOf(Integer.parseInt(currentId) + 1);
        return currentId;
    } 
}