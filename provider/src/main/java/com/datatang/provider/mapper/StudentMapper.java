package com.datatang.provider.mapper;

import Entity.Student;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentMapper {
    Student selectStudentByName(String name);

    boolean updateStudentByName(@Param("name")String name, @Param("filed") String field, @Param("value")String value);

    boolean deleteStudentByName(String name);

    boolean insertStudent(Student student);

}
