package com.newgen.bookapp.service;

import com.newgen.bookapp.model.Book;
import com.newgen.bookapp.repo.Bookrepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Comparator;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class Bookservices {

    @Autowired
    private Bookrepo bookrepo;

    public List<Book> getAllBooks() {
        return bookrepo.findAll();
    }

    public Optional<Book> findBookById(Long id) {  // Changed to Optional and Long
        return bookrepo.findById(id);
    }

    public Book savebook(Book book) {
        return bookrepo.save(book);
    }

    public void deleteBook(Long id) {  // Changed to Long
        bookrepo.deleteById(id);
    }
    public Book findMostExpensiveBook(List<Book> books) {
        return books.stream()
                .max(Comparator.comparingDouble(Book::getPrice))
                .orElse(null);
    }


}