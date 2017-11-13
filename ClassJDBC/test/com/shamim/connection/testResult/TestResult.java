package com.shamim.connection.testResult;

import com.shamim.connection.pojoclass.Students;
import com.shamim.connection.service.StudentService;
import com.shamim.jdbc.domain.Student;
import java.util.List;

public class TestResult {
    public static void main(String[] args) {
        StudentService ss = new StudentService();
        //ss.insert(new Students(101, "shohan"));
//        ss.insert(new Students(102, "shohan2"));
//        ss.insert(new Students(103, "shohan3"));
//        ss.insert(new Students(104, "shohan4"));

ss.update(new Students(104, "urmi"));
        
//        ss.insert(new Student(101, "Shamim"));
//        ss.insert(new Student(102, "Shahin"));
//        ss.insert(new Student(103, "Shihab"));
//        ss.insert(new Student(104, "Beauty"));
//        ss.insert(new Student(105, "Sharar"));
        
//        ss.update(new Student(105, "Sarker"));
        
//        ss.delete(105);

//        List<Student> stList =  ss.getStudents();
//        for(Student s : stList){
//            System.out.println(s.getId()+"      "+s.getStudentName());
//        }

//        Students s = ss.getStudent(103);
//        System.out.println("Student Name : " + s.getStudentName());
    }
}
