package com.waverly.graduateProject.controller;

import com.waverly.graduateProject.entity.DiscussPost;
import com.waverly.graduateProject.entity.Page;
import com.waverly.graduateProject.entity.User;
import com.waverly.graduateProject.service.DiscussPostService;
import com.waverly.graduateProject.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class HomeController {

    @Autowired
    private DiscussPostService discussPostService;

    @Autowired
    private UserService userService;

    @RequestMapping(path = "/index",method = RequestMethod.GET)
    private String getIndexPage(Model model, Page page){
        page.setRows(discussPostService.findDiscussPostRows(0));
        page.setPath("/index");

        List<DiscussPost> list=discussPostService.findDiscussPosts(0,page.getOffset(),page.getLimit());
        List<Map<String,Object>> discussPosts=new ArrayList<>();
        if(list!=null){
            for(DiscussPost post:list){
                Map<String,Object> map=new HashMap<>();
                map.put("post",post);
                User user=userService.findUserById(post.getUserId());
                map.put("user",user);
                discussPosts.add(map);
            }
        }

        model.addAttribute("page",page);
        model.addAttribute("discussPosts",discussPosts);
        return "/index";
    }

}
