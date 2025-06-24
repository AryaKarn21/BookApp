package com.newgen.bookapp;

import com.newgen.bookapp.model.Book;  // Updated package name
import com.newgen.bookapp.service.Bookservices;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class BookAppApplicationTests {

    @Autowired
    private Bookservices bookservices;

    @Test
    void contextLoads() {
        // Tests that the application context loads successfully
    }

    @Test
    void testFindMostExpensiveBook() {
        // Create test data from the provided table
        List<Book> books = Arrays.asList(
                createBook(2L, "To Kill a Mockingbird", "Harper Lee", "J. B. Lippincott", 10.5),
                createBook(3L, "1984", "George Orwell", "Secker & Warburg", 9.99),
                createBook(4L, "Pride and Prejudice", "Jane Austen", "T. Egerton", 8.75),
                createBook(5L, "Moby Dick", "Herman Melville", "Harper & Brothers", 11.25),
                createBook(6L, "The Hobbit", "J.R.R. Tolkien", "Allen & Unwin", 14.99),
                createBook(7L, "Harry Potter and the Sorcerer's Stone", "J.K. Rowling", "Bloomsbury", 15.5),
                createBook(10L, "Dune", "Frank Herbert", "Chilton Books", 12.5),
                createBook(11L, "Foundation", "Isaac Asimov", "Gnome Press", 10.99),
                createBook(12L, "Neuromancer", "William Gibson", "Ace", 11.75),
                createBook(13L, "The Alchemist", "Paulo Coelho", "HarperCollins", 9.5),
                createBook(14L, "The Kite Runner", "Khaled Hosseini", "Riverhead", 10.25),
                createBook(15L, "Life of Pi", "Yann Martel", "Knopf Canada", 11.99),
                createBook(16L, "The Girl with the Dragon Tattoo", "Stieg Larsson", "Norstedts", 12.75),
                createBook(17L, "Gone Girl", "Gillian Flynn", "Crown", 10.99),
                createBook(18L, "The Silent Patient", "Alex Michaelides", "Celadon", 13.25),
                createBook(19L, "Sapiens", "Yuval Noah Harari", "Harper", 14.5),
                createBook(20L, "Atomic Habits", "James Clear", "Avery", 12.99),
                createBook(21L, "Educated", "Tara Westover", "Random House", 11.5),
                createBook(22L, "Becoming", "Michelle Obama", "Crown", 13.75),
                createBook(25L, "ShareMarket", "Abhinabh", "Veltech University", 1000.0)
        );

        // Test with full dataset
        Book result = bookservices.findMostExpensiveBook(books);
        assertMostExpensiveBook(result, 25L, "ShareMarket", 1000.0, "Abhinabh");

        // Test edge cases
        testEmptyList();
        testSingleBook();
        testEqualPrices();
    }

    private void testEmptyList() {
        List<Book> emptyList = Collections.emptyList();
        Book result = bookservices.findMostExpensiveBook(emptyList);
        assertNull(result, "Should return null for empty list");
    }

    private void testSingleBook() {
        List<Book> singleBook = Collections.singletonList(
                createBook(2L, "To Kill a Mockingbird", "Harper Lee", "J. B. Lippincott", 10.5)
        );

        Book result = bookservices.findMostExpensiveBook(singleBook);
        assertMostExpensiveBook(result, 2L, "To Kill a Mockingbird", 10.5, "Harper Lee");
    }

    private void testEqualPrices() {
        List<Book> books = Arrays.asList(
                createBook(30L, "Book A", "Author A", "Publisher A", 20.0),
                createBook(31L, "Book B", "Author B", "Publisher B", 20.0)
        );

        Book result = bookservices.findMostExpensiveBook(books);
        assertNotNull(result);
        assertEquals(20.0, result.getPrice(), 0.001);
        // Should return the first book when prices are equal
        assertEquals("Book A", result.getTitle());
    }

    // Updated helper method with correct parameter order
    private Book createBook(Long id, String title, String author, String publisher, Double price) {
        return Book.builder()
                .id(id)
                .title(title)
                .author(author)
                .publisher(publisher)
                .price(price)
                .build();
    }

    private void assertMostExpensiveBook(Book book, Long id, String title, Double price, String author) {
        assertNotNull(book, "Book should not be null");
        assertEquals(id, book.getId(), "ID mismatch");
        assertEquals(title, book.getTitle(), "Title mismatch");
        assertEquals(price, book.getPrice(), 0.001, "Price mismatch");
        assertEquals(author, book.getAuthor(), "Author mismatch");
    }
}