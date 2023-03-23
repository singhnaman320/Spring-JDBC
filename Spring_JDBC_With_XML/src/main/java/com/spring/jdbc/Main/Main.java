package com.spring.jdbc.Main;

import com.spring.jdbc.DaoImpl.StudentJdbcTemplate;
import com.spring.jdbc.Entities.Student;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

public class Main {

    public static void main(String[] args) {

        ApplicationContext applicationContext= new ClassPathXmlApplicationContext("applicationContext.xml");

        StudentJdbcTemplate studentJdbcTemplate = (StudentJdbcTemplate) applicationContext.getBean("StudentJdbcTemplate");

        System.out.println("Record created....."+"\n");

        studentJdbcTemplate.createRecord("Naman ", 26);
        studentJdbcTemplate.createRecord("Kaushik ", 18);
        studentJdbcTemplate.createRecord("Prashant ", 23);
        studentJdbcTemplate.createRecord("Nishant ", 20);

        System.out.println("\n"+"All records are....."+"\n");

         List<Student> allStudents = studentJdbcTemplate.listOfStudents();

         for(Student record: allStudents){

             System.out.println("Student_Id: "+ record.getId()+", Student_Name: "+record.getName()
                     + ", Student_Age: "+record.getAge());
         }

    }
}
