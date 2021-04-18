package com.waverly.graduateProject.service;

import com.waverly.graduateProject.dao.AlphaDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

@Service
public class AlphaService {
    @Autowired
    private AlphaDao alphaDao;
    public AlphaService(){
        System.out.println("实例化Service");
    }
    @PostConstruct
    public  void init(){
        System.out.println("初始化Service");
    }
    @PreDestroy
    public void destroy(){
        System.out.println("销毁Service");//销毁前调用可以释放某些资源
    }
    public String find(){
        return alphaDao.select();
    }

}
