package com.waverly.graduateProject.controller;

import com.waverly.graduateProject.service.AlphaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.*;

@Controller
@RequestMapping("/alpha")
public class AlphaController {

    @Autowired
    private AlphaService alphaService;

    @RequestMapping("/hello")
    @ResponseBody
    public String sayHello(){
        return "Hello World";
    }

    @RequestMapping("/data")
    @ResponseBody
    public String getData(){
        return alphaService.find();
    }

    @RequestMapping("/http")
    public void http(HttpServletRequest request, HttpServletResponse response){
        System.out.println(request.getMethod());
        System.out.println(request.getServletPath());
        Enumeration<String> enumeration= request.getHeaderNames();
        while (enumeration.hasMoreElements()){
            String name=enumeration.nextElement();
            String value=request.getHeader(name);
            System.out.println(name+":"+value);
        }
        System.out.println(request.getParameter("code"));

        response.setContentType("text/html;charset=utf-8");
        try(
                PrintWriter writer=response.getWriter();){
            writer.write("<h1>轻音社</h1>");
        }catch (IOException e){
            e.printStackTrace();
        }
    }

    //GET请求
    @RequestMapping(path="/students",method = RequestMethod.GET)
    @ResponseBody
    public String getStudents(@RequestParam(name = "current",required = false,defaultValue = "1")int current,//设置参数默认值
                              @RequestParam(name = "limit",required = false,defaultValue = "1")int limit){
        System.out.println("current = " + current + ", limit = " + limit);
        return "student show up";
    }
    @RequestMapping(path="/students/(id)",method = RequestMethod.GET)
    @ResponseBody
    public String getStudent(@PathVariable("id") int id){
        return "a student:"+id;
    }

    //POST请求
    @RequestMapping(path="/student",method = RequestMethod.POST)
    @ResponseBody
    public String saveStudent(String name){
        return "a student:"+name+"saved success";
    }

    //响应HTML页面
    @RequestMapping(path="/teacher",method = RequestMethod.GET)
    public ModelAndView getTeacher(){
        ModelAndView modelAndView=new ModelAndView();
        modelAndView.addObject("name","waverly");
        modelAndView.addObject("age","30");
        modelAndView.setViewName("/demo/view");
        return modelAndView;
    }
    @RequestMapping(path="/school",method = RequestMethod.GET)
    public String getSchool(Model model){//自动实例化model对象
        model.addAttribute("name","waverly");
        model.addAttribute("age","30");
        return "/demo/view";
    }

    //响应JSON数据（异步请求）
    //Java对象->JSON字符串->JS对象（跨语言转换对象）

    @RequestMapping(path = "/emp",method = RequestMethod.GET)
    @ResponseBody
    public Map<String,Object> getEmp(){
        Map<String,Object> emp=new HashMap<>();
        emp.put("name","waverly");
        emp.put("age","23");
        emp.put("salary","11111");
        return emp;
    }
    @RequestMapping(path = "/emps",method = RequestMethod.GET)
    @ResponseBody
    public List<Map<String,Object>> getEmps(){
        List<Map<String,Object>> mapList=new ArrayList<>();
        Map<String,Object> emp=new HashMap<>();
        emp.put("name","waverly");
        emp.put("age","23");
        emp.put("salary","11111");
        mapList.add(emp);
        return mapList;
    }
}
