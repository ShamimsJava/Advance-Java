package com.mycompany.dao;

import com.mycompany.domain.Students;
import java.util.List;

public interface StudentsDao {

    public void insert(Students s);

    public void update(Students s);

    public void delete(int id);

    public List<Students> getStudents();

    public Students getStudent(int id);
}
