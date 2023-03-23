package com.spring.jdbc.Dao;

import com.spring.jdbc.Entities.Student;

import javax.sql.DataSource;
import java.util.List;

public interface StudentDao {

    /** This is the method to be used to initialize database resources, ie. connection. */

    public void setDataSource(DataSource ds);

    /** This is the method to be used to create a record in the Student table */
    public void createRecord(String name, Integer age);

    /** This is the method to be used to list down all the records from the Student table. */
    public List<Student> listOfStudents();
}
