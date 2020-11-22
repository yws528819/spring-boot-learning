package com.yws;

import com.yws.bean.Article;
import com.yws.bean.Book;
import com.yws.repository.BookRepository;
import io.searchbox.client.JestClient;
import io.searchbox.core.Index;
import io.searchbox.core.Search;
import io.searchbox.core.SearchResult;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.IOException;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringBoot03ElasticApplicationTests {

    @Autowired
	private JestClient jestClient;

    @Autowired
    private BookRepository bookRepository;

    @Test
	public void contextLoads() {
	    //1.给Es中索引（保存）一个文档
        Article article = new Article();
        article.setId(1);
        article.setAuthor("张三");
        article.setTitle("好消息");
        article.setContent("hello world");
        //构建一个索引功能
        Index index = new Index.Builder(article).index("yws").type("news").build();

        try {
            //执行
            jestClient.execute(index);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void search() {
        String queryJson = "{\n" +
                "    \"query\" : {\n" +
                "        \"match_phrase\" : {\n" +
                "            \"author\" : \"张\"\n" +
                "        }\n" +
                "    }\n" +
                "}";

        Search search = new Search.Builder(queryJson).addIndex("yws").addType("news").build();
        try {
            SearchResult result = jestClient.execute(search);
            System.out.println(result.getJsonString());
        } catch (IOException e) {
            e.printStackTrace();
        }


    }


    @Test
    public void test02() {
        Book book = new Book();
        book.setId(1);
        book.setBookName("西游记");
        book.setAuthor("吴承恩");
        bookRepository.index(book);
    }

    @Test
    public void test03() {
        List<Book> books = bookRepository.findByBookNameLike("游");
        books.stream().forEach(b -> System.out.println(b));
    }

}
