package com.korit.springboot_study.repository;

import com.korit.springboot_study.entity.Author;
import com.korit.springboot_study.entity.Book;
import com.korit.springboot_study.entity.Publisher;
import com.korit.springboot_study.exception.CustomDuplicateKeyException;
import com.korit.springboot_study.mapper.BookMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;
import java.util.Optional;

@Repository
public class BookRepository {
    @Autowired
    private BookMapper bookMapper;

    public Optional<List<Book>> findBookAll(){
        List<Book> foundBooks = bookMapper.selectBooksAll();
        return foundBooks.isEmpty()
                ? Optional.empty()
                : Optional.ofNullable(foundBooks);
    }

    public Optional<List<Author>> findAuthorAll(){
        List<Author> foundAuthors = bookMapper.selectAuthorsAll();
        return foundAuthors.isEmpty()
                ? Optional.empty()
                : Optional.ofNullable(foundAuthors);
    }

    public Optional<List<Publisher>> findPublisherAll(){
        List<Publisher> foundPublisher = bookMapper.selectPublisherAll();
        return foundPublisher.isEmpty()
                ? Optional.empty()
                : Optional.ofNullable(foundPublisher);
    }

    public Optional<List<Book>> saveBook(Book book) throws DuplicateKeyException {
        try {
            bookMapper.insertBook(book);
        }catch (DuplicateKeyException e){
            throw new CustomDuplicateKeyException(e.getMessage(),
                    Map.of("bookName", "이미 존재하는 도서명입니다"));

        }
        return Optional.of(bookMapper.selectBooksAll());
    }



}
