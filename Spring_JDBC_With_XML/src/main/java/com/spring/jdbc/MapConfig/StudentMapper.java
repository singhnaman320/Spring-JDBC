package com.spring.jdbc.MapConfig;

import com.spring.jdbc.Entities.Student;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

//        RowMapper<T> interface is used by JdbcTemplate for mapping rows of a ResultSet on a per-row basis. Implementations
//        of this interface perform the actual work of mapping each row to a result object. SQLExceptions if any thrown will
//        be caught and handled by the calling JdbcTemplate.
//        OR
//        RowMapper is a callback interface that is called for each row and maps the row of relations with the instances
//        to the model(user-defined) class. Unlike ResultSetExtractor the RowMapper iterates the ResultSet internally and
//        adds the extracted data into a collection, And we do not need to write the code for collections as we do in
//        ResultSetExtractor. It has only one method mapRow() which takes two arguments ResultSet and rowNumber
//        respectively. In order to use RowMapper, we need to implement this interface and provide the definition for
//        mapRow() method.

public class StudentMapper implements RowMapper<Student> {
    public Student mapRow(ResultSet rs, int rowNum) throws SQLException {

        Student student= new Student();

        student.setId(rs.getInt("Id"));
        student.setName(rs.getString("name"));
        student.setAge(rs.getInt("age"));

        return student;
    }
}
