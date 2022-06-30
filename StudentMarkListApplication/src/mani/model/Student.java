package mani.model;

import java.util.ArrayList;
import java.util.List;

public class Student {
    private String name;
    private int rollNo;
    private List<Subject> subjects = new ArrayList<>();
    private int totalMarks;


    public Student(){
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setRollNo(int rollNo) {
        this.rollNo = rollNo;
    }

    public int getRollNo() {
        return rollNo;
    }

    public List<Subject> getSubjects()
    {
        return subjects;
    }

    public void setSubjects(List<Subject> subjects)
    {
        this.subjects = subjects;
    }

    public void setTotalMarks(int totalMarks) {
        this.totalMarks = totalMarks;
    }

    public int getTotalMarks() {
        return totalMarks;
    }
}

