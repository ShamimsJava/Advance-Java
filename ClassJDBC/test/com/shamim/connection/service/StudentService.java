package com.shamim.connection.service;

import com.shamim.connection.StudentDao.StudentDao;
import com.shamim.connection.pojoclass.Students;
import com.shamim.jdbc.connection.DbConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class StudentService implements StudentDao{

    Connection conn = DbConnection.getConnections("shamim", "shamim");
    
    @Override
    public void insert(Students s) {
        try {
            String sql = "insert into students "
                    + "values(?, ?)";
            PreparedStatement st = conn.prepareStatement(sql);
            st.setInt(1, s.getStudentId());
            st.setString(2, s.getStudentName());
            st.executeUpdate();
            System.out.println("Data inserted successfully...");
        } catch (SQLException ex) {
            Logger.getLogger(StudentService.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void update(Students s) {
        try {
            String sql = "update students set student_name = ? where student_id = ?";
            PreparedStatement st = conn.prepareStatement(sql);
            st.setString(1, s.getStudentName());
            st.setInt(2, s.getStudentId());
            st.executeUpdate();
            System.out.println("Data updated successfully...");
        } catch (SQLException ex) {
            Logger.getLogger(StudentService.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void delete(int id) {
        try {
            String sql = "delete from students where student_id = ?";
            PreparedStatement st = conn.prepareStatement(sql);
            st.setInt(1, id);
            st.executeUpdate();
            System.out.println("Data deleted successfully...");
        } catch (SQLException ex) {
            Logger.getLogger(StudentService.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public List<Students> getStudents() {
        List<Students> list = new ArrayList<>();
        Students s;
        String sql = "select * from students";
        try {
            PreparedStatement st = conn.prepareStatement(sql);
            ResultSet rs = st.executeQuery();
            while(rs.next()){
                s = new Students(rs.getInt(1), rs.getString(2));
                list.add(s);
            }
        } catch (SQLException ex) {
            Logger.getLogger(StudentService.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }

    @Override
    public Students getStudent(int id) {
        Students s = null;
        String sql = "select * from students where student_id = ?";
        try {
            PreparedStatement st = conn.prepareStatement(sql);
            st.setInt(1, id);
            ResultSet rs = st.executeQuery();
            while(rs.next()){
                s = new Students(rs.getInt(1), rs.getString(2));   
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(StudentService.class.getName()).log(Level.SEVERE, null, ex);
        }
        return s;
    }
    
}
