package service;

import Entity.Student;


public interface StudentService {


    Student queryStudent(String name);
    boolean deleteStudent(String name);
    boolean updateStudent(String name,String field,String value);
    boolean insertStudent(Student student);



}
