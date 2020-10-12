package com.yws;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

@SpringBootTest
class SpringBootDataJdbcApplicationTests {

    @Autowired
    private DataSource dataSource;


    @Test
    void contextLoads() throws SQLException {
        //com.zaxxer.hikari.HikariDataSource
        System.out.println(dataSource.getClass());

        Connection connection = dataSource.getConnection();
        //HikariProxyConnection@1323828508 wrapping com.mysql.cj.jdbc.ConnectionImpl@53125718
        System.out.println(connection);
        connection.close();
    }

}
