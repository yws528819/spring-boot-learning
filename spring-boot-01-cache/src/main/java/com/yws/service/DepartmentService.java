package com.yws.service;

import com.yws.bean.Department;
import com.yws.mapper.DepartmentMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.Cache;
import org.springframework.data.redis.cache.RedisCacheManager;
import org.springframework.stereotype.Service;

@Service
public class DepartmentService {

    @Autowired
    private DepartmentMapper departmentMapper;

    @Autowired
    private RedisCacheManager deptCacheManager;


    /**
     * 缓存的数据能存入redis；
     * 第二次从缓存中查询就不能反序列化回来；
     * 存的是dept的json数据；CacheManager默认使用RedisTemplate<Object,Employee>操作Redis
     *
     * @param id
     * @return
     */
//    @Cacheable(cacheNames = {"dept"}, cacheManager = "depRedisCacheManager")
//    public Department getDeptById(Integer id) {
//        System.out.println("查询部门：" + id);
//        return departmentMapper.getDeptById(id);
//    }


    //使用缓存管理器得到缓存，进行api调用
    public Department getDeptById(Integer id) {
        System.out.println("查询部门：" + id);

        Department department = departmentMapper.getDeptById(id);
        //获取某个缓存
        Cache dept = deptCacheManager.getCache("dept");
        dept.put("dept:1", department);

        return department;
    }
}
