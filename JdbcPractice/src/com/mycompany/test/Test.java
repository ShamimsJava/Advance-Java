package com.mycompany.test;

import com.mycompany.domain.Students;
import com.mycompany.service.StudentsService;
import java.util.List;

public class Test {
    public static void main(String[] args) {
        StudentsService ss = new StudentsService();
        //ss.insert(new Students(103, "shahin"));
        //ss.update(new Students(101, "shihab"));
        //ss.delete(101);
//        List<Students> list = ss.getStudents();
//        for(Students s : list){
//            System.out.println(s.getStudentId()+"       "+s.getStudentName());
//        }

        Students s = ss.getStudent(103);
        System.out.println("Name is : "+s.getStudentName());
    }
}
