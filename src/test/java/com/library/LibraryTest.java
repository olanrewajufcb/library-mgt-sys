package com.library;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LibraryTest {

//    @Test
//    void addBook() {
//        Book book1 = new Book("The rich also cry", "Thomas David", "1985");
//        Library library = new Library();
//        assertEquals("The rich also cry", library.addBook(book1, 7));
//    }
@Test
void addBook() {
    Book book1 = new Book("The Renaisance", "James Wallace", "1985");
    Library library = new Library();
    assertEquals("James Wallace", library.addBook(book1, 7));
}

    @Test
    void makeRequest() {
        Library library = new Library();
        Borrower Shola = new Borrower("Shola", "MM", "junior student");
        assertTrue(library.makeRequest(Shola));

    }

    @Test
    void borrowBook() {
        Library library = new Library();
        Borrower Shola = new Borrower("Shola", "MM", "junior student");
        Borrower Michael = new Borrower("Michael", "Oliseh", "Teacher");
        Borrower Tope = new Borrower("Tope", "Ige", "Senior Student");
        Borrower Raheem = new Borrower("Raheem", "Issa", "teacher");
       
        Book book1 = new Book("The rich also cry", "Wole Soyinka", "1985");
        library.addBook(book1, 3);
        library.makeRequest(Shola);
        library.makeRequest(Tope);
        library.makeRequest(Michael);
        library.makeRequest(Raheem);
        assertEquals(Michael, library.borrowBook(book1));

    }

    @Test
    void returnBook() {
        Library library = new Library();
        Borrower jeniffer = new Borrower("Jeniffer", "Ezeobi", "senior student");
        Borrower ome = new Borrower("Omenebele", "Ananenu", "junior Student");
        Borrower okoro = new Borrower("Okoro", "Abbey", "Senior Student");
        Book book1 = new Book("The Renaisance", "James Wallace", "1985");
        library.addBook(book1, 3);
        library.makeRequest(okoro);
        library.makeRequest(ome);
        library.makeRequest(jeniffer);
        library.borrowBook(book1);
        assertTrue(library.returnBook(okoro, book1));
    }

    @Test
    void totalBooksTaken() {
        Library library = new Library();
        Borrower jeniffer = new Borrower("Jeniffer", "Ezeobi", "senior student");
        Borrower ome = new Borrower("Omenebele", "Ananenu", "junior Student");
        Borrower okoro = new Borrower("Okoro", "Abbey", "Senior Student");
        Borrower emmanuel = new Borrower("Emmanuel", "Ogheneovo", "teacher");
        Book book = new Book("The Renaisance", "James Wallace", "1985");
        library.addBook(book, 3);
        library.makeRequest(jeniffer);
        library.makeRequest(ome);
        library.makeRequest(emmanuel);
        library.makeRequest(jeniffer);
        library.borrowBook(book);
        library.borrowBook(book);
        assertEquals(2, library.totalBooksTaken(book));
    }

    @Test
    void addToQueue() {
        Library library = new Library();
        Borrower jeniffer = new Borrower("Jeniffer", "Ezeobi", "senior student");
        Book book = new Book("The Renaisance", "James Wallace", "1985");
        library.addBook(book, 3);
        assertTrue(library.addToQueue(jeniffer));
    }

    @Test
    void selectFromQueue() {
        Library library = new Library();
        Borrower jeniffer = new Borrower("Jeniffer", "Ezeobi", "senior student");
        Borrower ome = new Borrower("Omenebele", "Ananenu", "junior Student");
        Borrower okoro = new Borrower("Okoro", "Abbey", "Senior Student");
        Borrower emmanuel = new Borrower("Emmanuel", "Ogheneovo", "teacher");
        Book book = new Book("The Renaisance", "James Wallace", "1985");
        library.addBook(book, 3);
        library.makeRequest(jeniffer);
        library.makeRequest(ome);
        library.makeRequest(emmanuel);
        library.makeRequest(jeniffer);
        assertEquals(emmanuel, library.borrowBook(book));
    }
}