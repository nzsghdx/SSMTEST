package com.demo.demo1.service.impl;

import com.demo.demo1.BaseTest;
import com.demo.demo1.dao.BookDao;
import com.demo.demo1.dto.AppointExecution;
import com.demo.demo1.entity.Book;
import com.demo.demo1.service.BookService;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class BookServiceImplTest extends BaseTest {
    @Autowired
    private BookService bookService;
    @Test
    public void testAppoint() throws Exception{
        long bookId=1001;
        long studentId=123456L;
        AppointExecution execution=bookService.appoint(bookId,studentId);
        System.out.println(execution);
    }
    @Test
    public void testGetById() throws Exception{
        long bookId=1000;
        Book book = bookService.getById(bookId);
        System.out.println(book);
    }
    @Test
    public void testGetList() throws Exception{
        List<Book> books = bookService.getList();
        for (Book book:books
             ) {
            System.out.println(book);
        }
    }
}
