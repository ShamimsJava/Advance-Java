package com.shamim.connection.pojoclass;

public class Students {
    private int studentId;
    private String studentName;

    public Students() {
    }

    
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

