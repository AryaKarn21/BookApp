package com.newgen.bookapp.repo;

import com.newgen.bookapp.model.Book;
import org.hibernate.type.descriptor.converter.spi.JpaAttributeConverter;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface Bookrepo extends JpaRepository<Book,Long> {
}
