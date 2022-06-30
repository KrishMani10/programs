package mani.model;

public class Subject {
    private String subjectName;
    private int subjectScore;


    public Subject(){

    }
    public void setSubjectScore(int subjectScore) {
        this.subjectScore = subjectScore;
    }

    public int getSubjectScore() {
        return this.subjectScore;
    }

    public void setSubjectName(String subjectName) {
        this.subjectName = subjectName;
    }

    public String getSubjectName() {
        return this.subjectName;
    }
}
