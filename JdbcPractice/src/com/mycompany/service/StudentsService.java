package com.mycompany.service;

import com.mycompany.dao.StudentsDao;
import com.mycompany.dbconnection.DbConnection;
import com.mycompany.domain.Students;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class StudentsService implements StudentsDao {

    Connection conn = DbConnection.getConnections("shamim", "shamim");

    @Override
    public void insert(Students s) {
        if (s.getStudentName() != null) {
            String sql = "insert into Students values(?, ?)";
            try {
                PreparedStatement st = conn.prepareStatement(sql);
                st.setInt(1, s.getStudentId());
                st.setString(2, s.getStudentName());
                st.executeUpdate();
                System.out.println("Data inserted...");
                st.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public void update(Students s) {
        if (s.getStudentId() != 0) {
            String sql = "update students set st_name = ? where st_id = ?";
            try {
                PreparedStatement st = conn.prepareStatement(sql);
                st.setInt(2, s.getStudentId());
                st.setString(1, s.getStudentName());
                st.executeUpdate();
                System.out.println("Data updated...");
                st.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public void delete(int id) {
        if (id != 0) {
            String sql = "delete from students where st_id = ?";
            try {
                PreparedStatement st = conn.prepareStatement(sql);
                st.setInt(1, id);
                st.executeUpdate();
                System.out.println("Data deleted...");
                st.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public List<Students> getStudents() {
        List<Students> list = new ArrayList<>();
        String sql = "select * from students";
        try {
            PreparedStatement st = conn.prepareStatement(sql);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                Students s = new Students(rs.getInt(1), rs.getString(2));
                list.add(s);
            }
        } catch (Exception e) {
        }
        return list;
    }

    @Override
    public Students getStudent(int id) {
        Students s = null;
        String sql = "select * from students where st_id = ?";
        try {
            PreparedStatement st = conn.prepareStatement(sql);
            st.setInt(1, id);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                s = new Students(rs.getInt(1), rs.getString(2));
            }
        } catch (Exception e) {
        }
        return s;
    }
}
