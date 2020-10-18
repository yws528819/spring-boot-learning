package com.yws.config;

import com.yws.bean.Department;
import com.yws.bean.Employee;
import org.springframework.cache.interceptor.KeyGenerator;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.data.redis.cache.RedisCacheManager;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.Jackson2JsonRedisSerializer;

import java.lang.reflect.Method;
import java.net.UnknownHostException;
import java.util.Arrays;

@Configuration
public class MyConifg {

    @Bean
    public KeyGenerator myKeyGenerator() {
        return new KeyGenerator() {
            @Override
            public Object generate(Object target, Method method, Object... params) {
                return method.getName() +  "[" + Arrays.asList(params).toString() + "]";
            }
        };
    }


    @Bean
    public RedisTemplate<Object, Employee> empRedisTemplate(
            RedisConnectionFactory redisConnectionFactory)
            throws UnknownHostException {
        RedisTemplate<Object, Employee> template = new RedisTemplate<>();
        template.setConnectionFactory(redisConnectionFactory);

        Jackson2JsonRedisSerializer<Employee> jsonSer = new Jackson2JsonRedisSerializer<>(Employee.class);
        template.setDefaultSerializer(jsonSer);

        return template;
    }


    //CacheManagerCustomizers可以来指定一些缓存规则（一般不用）
    @Primary//将某个缓存管理器作为默认的
    @Bean
    public RedisCacheManager empRedisCacheManager(RedisTemplate<Object, Employee> employeeRedisTemplate) {
        RedisCacheManager redisCacheManager = new RedisCacheManager(employeeRedisTemplate);
        //使用前缀，默认会将CacheName作为key的前缀
        redisCacheManager.setUsePrefix(true);

        return redisCacheManager;
    }



    @Bean
    public RedisTemplate<Object, Department> depRedisTemplate(
            RedisConnectionFactory redisConnectionFactory)
            throws UnknownHostException {
        RedisTemplate<Object, Department> template = new RedisTemplate<>();
        template.setConnectionFactory(redisConnectionFactory);

        Jackson2JsonRedisSerializer<Department> jsonSer = new Jackson2JsonRedisSerializer<>(Department.class);
        template.setDefaultSerializer(jsonSer);

        return template;
    }


    //CacheManagerCustomizers可以来指定一些缓存规则（一般不用）
    @Bean
    public RedisCacheManager depRedisCacheManager(RedisTemplate<Object, Department> depRedisTemplate) {
        RedisCacheManager redisCacheManager = new RedisCacheManager(depRedisTemplate);
        //使用前缀，默认会将CacheName作为key的前缀
        redisCacheManager.setUsePrefix(true);

        return redisCacheManager;
    }



}
