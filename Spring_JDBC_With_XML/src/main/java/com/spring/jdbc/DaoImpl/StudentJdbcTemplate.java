package com.spring.jdbc.DaoImpl;

import com.spring.jdbc.Dao.StudentDao;
import com.spring.jdbc.Entities.Student;
import com.spring.jdbc.MapConfig.StudentMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;
import java.util.List;

public class StudentJdbcTemplate implements StudentDao {

    private DataSource dataSource;
    private JdbcTemplate jdbcTemplateObj;
    @Override
    public void setDataSource(DataSource ds) {

        this.dataSource= ds;
        this.jdbcTemplateObj= new JdbcTemplate(dataSource);
    }

    @Override
    public void createRecord(String name, Integer age) {

        String sql= "Insert into Student(name, age) values(?, ?)";

        jdbcTemplateObj.update(sql, name, age);

        System.out.println("Details inserted for "+"Name: "+name+"Age: "+ age );
    }

    @Override
    public List<Student> listOfStudents() {

        String sql= "SELECT * FROM Student";

        List<Student> listOfAllStudents= jdbcTemplateObj.query(sql, new StudentMapper());

        return listOfAllStudents;
    }
}
