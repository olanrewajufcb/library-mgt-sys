package com.library;

import java.util.Comparator;

public class Borrower implements Comparable<Borrower> {
    private final String firstName;
    private final String lastName;
    private final String designation;
    private int rank;
    private Book book;
    
    /**
     * A constructor method to set borrowers' properties
     * @param firstName
     * @param lastName
     * @param designation
     */
    public Borrower(String firstName, String lastName, String designation) {
       try {
            String description = String.join("", designation.split(" "));
           switch (description){
               case "teacher":
                   this.rank = 1;
                   break;
               case "seniorstudent":  case "senior":
                   this.rank = 2;
                   break;
               case "juniorstudent": case "junior":
                   this.rank = 3;
                   break;
               default:
                   throw new IllegalArgumentException(firstName + " " + lastName + " is not authorised to perform this action");
           }
          
       }
       catch (Exception e){
           System.out.println("An error has occurred " + e);
       }
        this.firstName = firstName;
        this.lastName = lastName;
        this.designation = designation;
        
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public int getRank() {
        return this.rank;
    }
    
    public Book getBook() {
        return book;
    }
    
    public String getFullName(){
        return getFirstName() + " " + getLastName();
    }
    
    public boolean checkSameBook (Book book){
    return this.book.getISBN().equals(book.getISBN());

    }

    @Override
    public int compareTo(Borrower obj) {
        if(obj.rank < this.rank) {
            return 1;
        }else if(obj.rank > this.rank){
            return -1;
        }
        return 0;
    }

    
    
    @Override
    public String toString() {
        return
                "First Name=" + firstName +
                ", Last Name=" + lastName +
                ", designation='" + designation + '\'' +
                ", rank=" + rank;
    }
}
