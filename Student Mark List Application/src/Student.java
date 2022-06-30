import java.util.ArrayList;
import java.util.List;

public class Student {
    String name;
    int rollNo;
    List<Mark> marks = new ArrayList<>();

    Student(String name,int rollNo){
        this.name = name;
        this.rollNo = rollNo;

    }

    public String getName() {
        return name;
    }

    public int getRollNo() {
        return rollNo;
    }

    public List<Mark> getMarks(){
        return marks;
    }

    public void setMarks(List<Mark> marks) {
        this.marks = marks;
    }

    public void setName(String name) {
        this.name = name;
    }
}

