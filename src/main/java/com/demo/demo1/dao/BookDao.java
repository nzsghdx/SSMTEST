package com.demo.demo1.dao;

import com.demo.demo1.entity.Book;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface BookDao {
    Book queryById(long id);
    List<Book> queryAll(@Param("offset") int offset,@Param("limit") int limit);
    int reduceNumber(long bookId);
}
