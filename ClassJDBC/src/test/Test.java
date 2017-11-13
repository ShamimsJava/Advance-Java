package test;

import com.shamim.jdbc.domain.Student;
import com.shamim.jdbc.service.StudentService;
import java.util.List;
import java.util.Scanner;

public class Test {

    public static void main(String[] args) {
        StudentService studentService = new StudentService();
//        Student std1 = new Student(1001, "shamim");
//        studentService.save(std5);

//        List<Student> list = studentService.getStudents();
//        System.out.println("Id        Name");
//        System.out.println("------------------");
//        for(Student s : list){
//            System.out.println(s.getId()+"      "+s.getStudentName());   
//        }
//       
            Student s = studentService.getStudent(102);
            System.out.println("Student Name: " + s.getStudentName());   
            
        }
    }

