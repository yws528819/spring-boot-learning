package com.yws;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * SpringBoot默认支持两种技术和ES交互
 * 1.Jest
 * 需要导入jest的工具包 (io.searchbox.client.JestClient)
 * 2.SpringData ElaticSearch
 *      1）、Clent  节点信息clusterNodes； clusterName
 *      2）、ElasticSearchTemplate 操作es
 *      3）、编写一个ElasticsearchRepository的子接口来操作es
 */
@SpringBootApplication
public class SpringBoot03ElasticApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringBoot03ElasticApplication.class, args);
    }

}
