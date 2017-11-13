package com.shamim.connection.StudentDao;

import com.shamim.connection.pojoclass.Students;
import java.util.List;

public interface StudentDao {

    public void insert(Students s);

    public void update(Students s);

    public void delete(int id);

    public List<Students> getStudents();

    public Students getStudent(int id);
}
