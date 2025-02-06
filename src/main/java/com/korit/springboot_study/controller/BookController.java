package com.korit.springboot_study.controller;


import com.korit.springboot_study.dto.request.ReqAddBookDto;
import com.korit.springboot_study.dto.response.common.SuccessResponseDto;
import com.korit.springboot_study.entity.Author;
import com.korit.springboot_study.entity.Book;
import com.korit.springboot_study.entity.Publisher;
import com.korit.springboot_study.service.BookService;
import org.apache.ibatis.javassist.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.List;

@RestController
public class BookController {
    @Autowired
    private BookService bookService;

    @GetMapping("/api/books")
    public ResponseEntity<SuccessResponseDto<List<Book>>> getAllBooks() throws NotFoundException {
        return ResponseEntity.ok().body(bookService.getBookAll());
    }

    @GetMapping("/api/authors")
    public ResponseEntity<SuccessResponseDto<List<Author>>> getAllAuthors() throws NotFoundException {
        return ResponseEntity.ok().body(bookService.getAuthorAll());
    }

    @GetMapping("/api/publisher")
    public ResponseEntity<SuccessResponseDto<List<Publisher>>> getAllPublishers() throws NotFoundException {
        return ResponseEntity.ok().body(bookService.getPublisherAll());
    }

    @PostMapping("/api/book")
    public ResponseEntity<SuccessResponseDto<Book>> addBook(@Valid @RequestBody ReqAddBookDto reqAddBookDto) throws MethodArgumentNotValidException {
        System.out.println(reqAddBookDto);
        return ResponseEntity.ok().body(bookService.addBook());
    }




}
