package com.library;

public class Main {

    public static void main(String[] args) {
        Library library = new Library();
    
        Book book = new Book("a01", "The lion and the jewel", "Wole Shoyinka", "1990");
        Book book1 = new Book("b22", "The rich also cry", "Thomas David", "1985");
        Book book2 = new Book("tt44", "Computer Maintenance", "Taye Taiwo", "2000");
        Book book3 = new Book("p023", "Programming made easy", "Kyle Samson", "2016");
        library.addBook(book, 10);
        library.addBook(book, 4);
        library.addBook(book1, 7);
        library.addBook(book2, 9);
        library.addBook(book3, 12);
    
        Borrower Shola = new Borrower("Shola", "MM", "junior student");
//        Borrower Michael = new Borrower("Michael", "Oliseh", "Teacher");
//        Borrower Tope = new Borrower("Tope", "Ige", "Senior Student");
        Borrower Raheem = new Borrower("Raheem", "Issa", "teacher");
//        Borrower Janet = new Borrower("Janet", "Tobi", "senior student");
//        Borrower sman = new Borrower("Sman", "Lawal", "junior Student");
//
//        library.totalBooksTaken(book);
        library.makeRequest(Shola);
//        library.makeRequest(Tope);
//        library.makeRequest(Janet);
        library.makeRequest(Raheem);
//        library.makeRequest(Michael);
//        library.makeRequest(sman);
        Borrower person1 = library.borrowBook(book);
        System.out.println(person1);

//        library.makeRequest(Raheem);
        Borrower person2 = library.borrowBook(book);
        System.out.println(Shola.compareTo(person2));

//        library.makeRequest(Raheem);
//        System.out.println(person2);
//        Borrower person3 = library.borrowBook(book);
//        System.out.println(person3);
//        library.addToQueue(sman);
//        library.addToQueue(Michael);
//        Borrower borrower = library.selectFromQueue(book2);
//        Borrower oneBor = library.selectFromQueue(book2);
//        Borrower opec = library.selectFromQueue(book3);
//        library.makeRequest(Raheem);
//        library.returnBook(Raheem, book);
//        Borrower bb2 = library.borrowBook(book);
//        library.makeRequest(Raheem);
//        Borrower bb = library.borrowBook(book1);
//        library.totalBooksTaken(book);
//        Borrower razor = library.borrowBook(book);
//        Borrower volley = library.borrowBook(book);
//        library.totalBooksTaken(book);

    }
}
