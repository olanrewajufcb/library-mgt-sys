package com.library;

import java.util.*;

public class Library {
    // To keep track of copies of a specific book available in the library
    private final HashMap<Book, Integer> availableCopies = new HashMap<>();
    // keeps track of total copies supplied to the library
    private final HashMap<Book, Integer> noOfCopies = new HashMap<>();
    // This keeps track of collection of books by borrower
    private final HashMap<Borrower, ArrayList<Book>> borrowersCollection = new HashMap<>();
    //Potential borrowers list with order of priority
    private final PriorityQueue<Borrower> request = new PriorityQueue<>();
    private final PriorityQueue<Book> bookWithPriority = new PriorityQueue<>();
  
    Queue<Borrower> queue = new LinkedList<>(); //List of potential borrowers of books without priority
    
    /**
     * creating a constructor method
     */
    public Library() {
        String name = "Udacity Library";
        System.out.println("Welcome to " + name );
    }

    //add books to the list of collections in library
    public String addBook(Book book, int copies){
        noOfCopies.put(book, noOfCopies.getOrDefault(book, 0) + copies);
        availableCopies.put(book, availableCopies.getOrDefault(book, 0) + copies);
        System.out.println(copies + " books of " + book.getName() + " published by " + book.getAuthor() + " have been added to library book collections," +
                " available copies: " + availableCopies.get(book));
        
        return book.getAuthor();
    }
    
    /**
     *  Request is made to borrow book, check if eligible before adding to li
     * @param borrower
     * @return
     */
    public boolean makeRequest(Borrower borrower){
        
        return addToPriorityQueue(borrower, "makeRequest");
    }
    
   
    
    
    /**
     * A method that checks to see if a person can borrow books
     * @param borrower
     * @param typeOfOperation
     * @return
     */
    private boolean addToPriorityQueue(Borrower borrower, String typeOfOperation){
        if(!(borrowersCollection.containsKey(borrower)) || borrowersCollection.get(borrower).size() < 3){
            if (typeOfOperation.equals("makeRequest")) {
                request.add(borrower);
            } else {
                queue.add(borrower);
            }
            if(!(borrowersCollection.containsKey(borrower))){
                ArrayList<Book> book = new ArrayList<>();
                borrowersCollection.put(borrower, book);
            }
            return true;
        }
        System.out.println(borrower.getFullName() + " is not eligible to borrow books from the library");
        if (typeOfOperation.equals("makeRequest")) {
            request.remove(borrower);
        } else {
            queue.remove(borrower);
        }
        return false;
    }
    
    
    /**
     * Check if the borrower is yet to return books previously borrowed
     *  Check if the book he is returning is among the books he borrowed
     *  Check if that particular collection of book is already complete in the library
      * @param borrower
     * @param book
     * @return
     */
    public boolean returnBook(Borrower borrower, Book book){
        if(borrowersCollection.containsKey(borrower) && borrowersCollection.get(borrower).contains(book)
        && noOfCopies.get(book) > availableCopies.get(book)){
            System.out.println(borrowersCollection.get(borrower).size());
            borrowersCollection.get(borrower).remove(book);
            availableCopies.put(book, availableCopies.getOrDefault(book, 0) + 1);
            System.out.println(borrower.getFullName() + " has returned " + book.getName() +". Remaining books to return is: " + borrowersCollection.get(borrower).size());
            return true;
        }
        return false;
    }
    
    /**
     * Returns the total number of copies of a particular book that has been taken from the library
     * @param book
     * @return
     */
    public int totalBooksTaken(Book book){

        if(!noOfCopies.containsKey(book)){
            System.out.println(book.getName() + " is not yet in our collections");
            return 0;
        }
        int taken = noOfCopies.get(book) - availableCopies.get(book);
        System.out.println((taken == 0 ? "0" : taken)
                + book.getName() + (taken < 2 ? "book has been " : "books have been ") + "taken from the library\n" +
                "total \"" +  book.getName() +  "\" books available: " + availableCopies.get(book));
        return taken;
    }

    public boolean addToQueue(Borrower borrower){
        
        return addToPriorityQueue(borrower, "addToQueue");
    }

    public Borrower selectFromQueue(Book book){
        
        return selectFromList(book, "selectFromQueue");
    }
    
    /**
     * If there is no one in priority queue, no books will be given out
     * @param book
     * @return
     */
    public Borrower borrowBook(Book book){
        
        return selectFromList(book, "borrowBook");
    }
   
    private Borrower selectFromList(Book book, String typeOfOperation){
        //If there is no one in list, no books will be given out
        if(typeOfOperation.equals("borrowBook")){
            if(request.peek() == null){
                return null;
            }
        }else if(queue.peek() == null){
            return null;
        }

        Borrower person = null;

        //If the book to be borrowed is not in library's collection, then no book is handed out
        if(!availableCopies.containsKey(book)){
            System.out.println("\"" + book.getName() + "\" is not yet part of this library's collection.");
            return null;
        }
        int remainingCopies = availableCopies.get(book);

        //If book required from the library is currently available, then it can be given out to the first person
        if(remainingCopies > 0){
            person = typeOfOperation.equals("borrowBook") ? request.poll() : queue.poll();

            //If the first person has borrowed a similar copy, deny the request
            if(borrowersCollection.containsKey(person) && borrowersCollection.get(person).contains(book)){
                assert person != null;
                System.out.println(person.getFullName() + ", you already have this book in your list of collections");
                if (typeOfOperation.equals("borrowBook")) {
                    request.remove(person);
                } else {
                    queue.remove(person);
                }
                return person;
            }
            availableCopies.put(book, remainingCopies - 1);
            if (typeOfOperation.equals("borrowBook")) {
                request.remove(person);
            } else {
                queue.remove(person);
            }
            ArrayList<Book> collect = borrowersCollection.get(person);
            collect.add(book);
            borrowersCollection.put(person, collect);
            assert person != null;
            System.out.println(person.getFullName() + " has borrowed " + "\"" + book.getName() + "\""+ " from the library, \n"
                    + "Total number of books borrowed by " +  person.getFullName() +": "
                    + borrowersCollection.get(person).size() + ", total number of \"" + book.getName() + "\" available: " +
                    (availableCopies.get(book)));
        }else{
            System.out.println("\"" + book.getName() + "\" not in shelf.");
        }
        return person;
    }
}
