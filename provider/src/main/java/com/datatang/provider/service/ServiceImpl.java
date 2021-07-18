package com.datatang.provider.service;

import Entity.Student;
import com.alibaba.dubbo.config.annotation.Service;
import com.datatang.provider.mapper.StudentMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import service.StudentService;

import javax.annotation.Resource;

@org.springframework.stereotype.Service
@Service(interfaceClass = StudentService.class,version = "1.0.0",timeout = 15000)
public class ServiceImpl implements StudentService {


   @Autowired
   StudentMapper studentMapper;

    @Override
    public Student queryStudent(String name) {
        return studentMapper.selectStudentByName(name);
    }

    @Override
    public boolean deleteStudent(String name) {

            return studentMapper.deleteStudentByName(name);

    }

    @Override
    public boolean updateStudent(String name,String field,String value) {
           return studentMapper.updateStudentByName(name,field,value);
    }

    @Override
    public boolean insertStudent(Student student) {
        return studentMapper.insertStudent(student);
    }




}
