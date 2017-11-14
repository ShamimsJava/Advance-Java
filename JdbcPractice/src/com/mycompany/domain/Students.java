package com.mycompany.domain;

public class Students {

    private int studentId;
    private String studentName;

    public Students(int studentId, String studentName) {
        this.studentId = studentId;
        this.studentName = studentName;
    }

    public int getStudentId() {
        return studentId;
    }

    public String getStudentName() {
        return studentName;
    }
}
