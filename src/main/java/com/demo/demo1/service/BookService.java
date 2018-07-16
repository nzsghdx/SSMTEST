package com.demo.demo1.service;

import com.demo.demo1.dto.AppointExecution;
import com.demo.demo1.entity.Book;

import java.util.List;

public interface BookService {
    Book getById(long bookId);
    List<Book> getList();
    AppointExecution appoint(long bookId,long studentId);
}
