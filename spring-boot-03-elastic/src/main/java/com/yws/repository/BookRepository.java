package com.yws.repository;

import com.yws.bean.Book;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

import java.util.List;

public interface BookRepository extends ElasticsearchRepository<Book, Integer> {
    //自定义方法
    public List<Book> findByBookNameLike(String bookName);
}
