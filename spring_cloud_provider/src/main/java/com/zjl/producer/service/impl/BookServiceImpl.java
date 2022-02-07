package com.zjl.producer.service.impl;

import com.zjl.producer.repository.BookRepository;
import com.zjl.producer.service.BookService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author zhou
 * @version 1.0
 * @className BookServiceImpl
 * @description
 * @date 2022/02/07 10:48
 **/
@Slf4j
@Service
public class BookServiceImpl implements BookService {

    @Autowired
    private BookRepository bookRepository;

    @Override
    public void deduct(Long bookId, Integer bookCount) {

    }
}
