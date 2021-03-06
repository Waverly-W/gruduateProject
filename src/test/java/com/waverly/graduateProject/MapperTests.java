package com.waverly.graduateProject;

import com.waverly.graduateProject.dao.DiscussPostMapper;
import com.waverly.graduateProject.dao.UserMapper;
import com.waverly.graduateProject.entity.DiscussPost;
import com.waverly.graduateProject.entity.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Date;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
@ContextConfiguration(classes =LitemusicApplication.class)
public class MapperTests {
    @Autowired
    private UserMapper userMapper;

    @Autowired
    private DiscussPostMapper discussPostMapper;
    @Test
    public void testSelectById(){
        User user=userMapper.selectById(101);
        System.out.println(user);
        user=userMapper.selectByName("liubei");
        System.out.println(user);
        user=userMapper.selectByEmail("nowcoder101@sina.com");
        System.out.println(user);
    }

    @Test
    public void testInsertUser(){
        User user=new User();
        user.setUsername("test");
        user.setPassword("123456");
        user.setEmail("123@qwe.com");
        user.setSalt("asdasd");
        user.setHeaderUrl("http://www.nowcoder.com/101.png");
        user.setCreateTime(new Date());

        int rows= userMapper.insertUser(user);
        System.out.println(rows);
        System.out.println(user.getId());
    }

    @Test
    public void testUpdateUser(){
        int rows= userMapper.updateHeader(150,"http://www.nowcoder.com/102.png");
        User user=userMapper.selectById(150);
        System.out.println(user);
    }

    @Test
    public void testSelectPosts(){
        List<DiscussPost> list=discussPostMapper.selectDiscussPosts(11,0,10);
        for(DiscussPost post:list){
            System.out.println(post);
        }
        int rows= discussPostMapper.selectDiscussPostRows(0);
        System.out.println(rows);
    }
}
