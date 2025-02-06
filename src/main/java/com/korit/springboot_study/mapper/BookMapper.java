package com.korit.springboot_study.mapper;


import com.korit.springboot_study.entity.Author;
import com.korit.springboot_study.entity.Book;
import com.korit.springboot_study.entity.Publisher;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface BookMapper {
    List<Author> selectAuthorsAll();
    List<Book> selectBooksAll();
    List<Publisher> selectPublisherAll();
    int insertBook(Book book);
    int insertPublisher(Publisher publisher);
    int insertAuthor(Author author);


}
