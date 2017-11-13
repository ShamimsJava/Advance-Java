package com.shamim.jdbc.service;

import com.shamim.jdbc.connection.DbConnection;
import com.shamim.jdbc.dao.StudentDao;
import com.shamim.jdbc.domain.Student;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class StudentService implements StudentDao{

    Connection conn = DbConnection.getConnections("hr", "hr");
    
    @Override
    public void save(Student s) {
        try {
            if(s.getStudentName() != null){
                PreparedStatement stmt = conn.prepareStatement("insert into students(id, student_name) values(?,?)");
                stmt.setInt(1, s.getId());
                stmt.setString(2, s.getStudentName());
                
                int i = stmt.executeUpdate();
                System.out.println(i + " records inserted");
            }
            //conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void update(Student s) {
        try {
            if(s.getId() != 0){
                PreparedStatement stmt = conn.prepareStatement("update students set student_name = ? where id=?"); 
                stmt.setString(1, s.getStudentName());
                stmt.setInt(2, s.getId());
                int i = stmt.executeUpdate();
                System.out.println(i + " records updated");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void delete(int id) {
        try {
            if(id != 0){
                PreparedStatement stmt = conn.prepareStatement("delete from studentbd where id=?"); 
                stmt.setInt(1, id);
                int i = stmt.executeUpdate();
                System.out.println(i + " records deleted");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<Student> getStudents() {
        List<Student> list = new ArrayList<>();
        try {
            Student s;
            PreparedStatement stmt = conn.prepareStatement("select * from students");
            ResultSet rs = stmt.executeQuery();
            while(rs.next()){
                s = new Student();
                s.setId(rs.getInt(1));
                s.setStudentName(rs.getString(2));
                list.add(s);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        return list;  
    }

    @Override
    public Student getStudent(int id) {
        Student s = null;
        try {
            PreparedStatement stmt = conn.prepareStatement("select * from students where student_id = ?");
            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();
            while(rs.next()){
                s = new Student();
                s.setId(rs.getInt(1));
                s.setStudentName(rs.getString(2));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return s;
    }  
}
