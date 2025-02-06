package com.korit.springboot_study.service;


import com.korit.springboot_study.dto.request.ReqAddBookDto;
import com.korit.springboot_study.dto.response.common.SuccessResponseDto;
import com.korit.springboot_study.entity.Author;
import com.korit.springboot_study.entity.Book;
import com.korit.springboot_study.entity.Publisher;
import com.korit.springboot_study.repository.BookRepository;
import org.apache.ibatis.javassist.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class BookService {
    @Autowired
    private BookRepository bookRepository;

    public SuccessResponseDto<List<Book>> getBookAll() throws NotFoundException {
        return new SuccessResponseDto<>(
                bookRepository
                        .findBookAll()
                        .orElseThrow(() -> new NotFoundException("도서가 존재하지 않습니다.")));
    }

    public SuccessResponseDto<List<Author>> getAuthorAll() throws NotFoundException {
        return new SuccessResponseDto<>(
                bookRepository
                        .findAuthorAll()
                        .orElseThrow(() -> new NotFoundException("저자가 존재하지 않는단다")));
    }

    public SuccessResponseDto<List<Publisher>> getPublisherAll() throws NotFoundException{
        return new SuccessResponseDto<>(
                bookRepository
                        .findPublisherAll()
                        .orElseThrow(() -> new NotFoundException("출판사가 존재하지않습니다")));

    }
    @Transactional(rollbackFor = Exception.class)
    public SuccessResponseDto<List<Book>> addBook(ReqAddBookDto reqAddBookDto) throws DuplicateKeyException{
        return new SuccessResponseDto<>(
                bookRepository
                        .saveBook(new Book(0, reqAddBookDto.getBookName()))
                        .get()
        );
    }



}
