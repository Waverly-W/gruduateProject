package com.waverly.graduateProject.dao;

import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.ResponseBody;

@Repository("alphaHibernate")
public class AlphaDaoHibernate implements AlphaDao{
    @Override
    public String select() {
        return "Hibernate";
    }
}
