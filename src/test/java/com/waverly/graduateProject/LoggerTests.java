package com.waverly.graduateProject;

import com.waverly.graduateProject.dao.DiscussPostMapper;
import com.waverly.graduateProject.dao.UserMapper;
import com.waverly.graduateProject.entity.DiscussPost;
import com.waverly.graduateProject.entity.User;
import org.junit.Test;
import java.util.logging.Logger;
import org.junit.runner.RunWith;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Date;
import java.util.List;
import java.util.logging.Logger;

@RunWith(SpringRunner.class)
@SpringBootTest
@ContextConfiguration(classes =LitemusicApplication.class)
public class LoggerTests {

    private static final org.slf4j.Logger logger=LoggerFactory.getLogger(LoggerTests.class);
    @Test
    public void testLogger(){
        System.out.println(logger.getName());

        logger.debug("debug log");
        logger.info("info log");
        logger.warn("warn log");
        logger.error("error log");
    }
}
