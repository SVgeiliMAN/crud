package com.datatang.consumer.controller;

import Entity.Student;
import com.alibaba.dubbo.config.annotation.Reference;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;
import service.StudentService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@RestController

public class StudentController {

    @Reference(interfaceClass =StudentService.class,version = "1.0.0",check = false)
    @Autowired(required = false)
    private StudentService studentService;


    @RequestMapping(value = "/query",method = RequestMethod.GET)
    public Student selectStudent(HttpServletRequest request){
        String name = request.getParameter("name");
        Student student = studentService.queryStudent(name);
        System.out.println(student);
        return student;
    }

    @RequestMapping(value = "/delete")
    public boolean deleteStudent(HttpServletRequest request){
        String name = request.getParameter("name");
        return studentService.deleteStudent(name);

    }

    @RequestMapping(value = "/insert")
    public boolean insertStudent(HttpServletRequest request){
        Student student = new Student();
        String name = request.getParameter("name");
        String age = request.getParameter("age");
        student.setName(name);
        student.setAge(Integer.valueOf(age));
        return studentService.insertStudent(student);
    }
    @RequestMapping(value = "/update")
    public Student  updateStudent(HttpServletRequest request){

        String name = request.getParameter("name");
        String field = request.getParameter("filed");
        String value = request.getParameter("value");
        boolean success = studentService.updateStudent(name, field, value);

        return success?studentService.queryStudent(name):null;
    }

}
