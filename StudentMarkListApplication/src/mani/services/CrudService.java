package mani.services;

import mani.core.StudentDBService;
import mani.model.Student;
import mani.model.Subject;
import org.codehaus.jackson.map.ObjectMapper;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;



public class CrudService {

    static List<Student> studentList = StudentDBService.readStudentDetails();
    static List<Student> studTemp = new ArrayList<>();

    public static void displayStudentDetails(){

        System.out.println("STUDENT INFORMATION");
        for (Student student : studentList) {
            int j = 0;
            System.out.println("===============================");
            System.out.println("studentName : " + student.getName());
            System.out.println("roll No : " + student.getRollNo());
            while (j < student.getSubjects().size()) {
                System.out.println("subject Name : " + student.getSubjects().get(j).getSubjectName());
                System.out.println("subject Mark : " + student.getSubjects().get(j).getSubjectScore());
                j++;
            }
            System.out.println("Total marks " + student.getTotalMarks());
            System.out.println("===============================");
            System.out.println();
        }
        System.out.println();
    }

    public static void sortingOnRollNumber() {

        studentList.sort(Comparator.comparingInt(Student::getRollNo));

        System.out.println("Sorting based on rollNumber: ");
        System.out.println("=========================");

        for (Student student : studentList) {
            System.out.println("Student name : " + student.getName());
            System.out.println("Student rollNo : " + student.getRollNo());
        }

        System.out.println("=========================");

    }

    public static void sortingOnStudTotalMarks() {

        boolean found = false;

        studentList.sort((Student s1, Student s2) -> s2.getTotalMarks() - s1.getTotalMarks());
        for(int i =0;i<studentList.size()-1;i++)
        {
            for (int j = i + 1; j < studentList.size(); j++)
            {

                if (studentList.get(i).getTotalMarks() == studentList.get(j).getTotalMarks())
                {

                    if (studentList.get(i).getSubjects().get(0).getSubjectScore() == studentList.get(j).getSubjects().get(0)
                            .getSubjectScore())
                    {
                        if(studentList.get(i).getRollNo() > studentList.get(j).getRollNo())
                        {
                            found = true;
                            Collections.swap(studentList,i,j);
                        }
                    } else if (studentList.get(i).getSubjects().get(0).getSubjectScore() < studentList.get(j).getSubjects().get(0)
                            .getSubjectScore()) {
                        Collections.swap(studentList, i, j);
                        studTemp = studentList;
                    }
                    else {
                        found = false;
                    }
                }
            }//        Comparator<Student>compareByTotalMarks = Comparator.comparing(Student::getTotalMarks).reversed()
//                        .thenComparing(Student::getRollNo);
//
//        studTemp = studentList.stream().sorted(compareByTotalMarks).collect(Collectors.toList());

        }

                if(found){
                    for(Student stud :studentList){
                        System.out.println("Student name : " +stud.getName());
                        System.out.println("Student rNumber : " +stud.getRollNo());
                        System.out.println("Student totalMarks : " +stud.getTotalMarks());
                    }
                }
                else
                {
                    for(Student stud :studentList){
                        System.out.println("Student name : " +stud.getName());
                        System.out.println("Student rNumber : " +stud.getRollNo());
                        System.out.println("Student totalMarks : " +stud.getTotalMarks());
                }
            }


        System.out.println("Sorting based on total marks got by the students : ");
        System.out.println("=========================");
        for (Student student : studentList) {
            System.out.println("Student name : " + student.getName());
            System.out.println("Student rollNo : " + student.getRollNo());
            System.out.println("Student totalMarks : " + student.getTotalMarks());
        }
        System.out.println("=========================");

    }

    public static void searchRollNumber(int rollNoTobeFind){
        String nameForRollNoGiven = "";
        boolean found = false;
        for (Student student : studentList) {
            if (rollNoTobeFind == student.getRollNo()) {
                nameForRollNoGiven = student.getName();
                found = true;
                break;
            }
        }
        if(found) {
            System.out.println("Student name for given roll Number to find : " + nameForRollNoGiven);
        }
        else {
            System.out.println("Given roll number is not found in student list");
        }
    }

    public static void searchStudentName(String nameToBeFind) {
        String nameIsFound = " ";
        boolean found = false;
        for (Student student : studentList) {
            if (nameToBeFind.equalsIgnoreCase(student.getName())) {
                nameIsFound = student.getName();
                found =true;
                break;
            }
        }
        if(found) {
            System.out.println("Student name for given name to find : " + nameIsFound);
        }
        else {
            System.out.println("Given input name is not found in student list ");
        }
    }

//    public static void flushStudentInfo() {
//        try {
//            File file = new File(Paths.get(System.getProperty("user.dir") + ("/students.json")).toString());
//            file.setWritable(true);
//           BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(new FileOutputStream
//                    (Paths.get(System.getProperty("user.dir") + ("/students.json")).toString()));
//            bufferedOutputStream.flush();
//        }
//        catch (Exception e){
//            System.out.println("Exception Happened");
//        }
//    }

    public static void addNewStudentInfo(String name,String[] subName,int [] subScore){

        studentList.sort(Comparator.comparingInt(Student::getRollNo));
        int length = studentList.size()-1;
        int autoGeneratedRollNumber = studentList.get(length).getRollNo()+1;


        int totMarks = 0;

        Student s1 = new Student();
        s1.setName(name);
        s1.setRollNo(autoGeneratedRollNumber);
        List<Subject> subjects = new ArrayList<>();
        for(int i =0;i<6;i++){
            Subject s = new Subject();
            s.setSubjectName(subName[i]);
            s.setSubjectScore(subScore[i]);
            totMarks = totMarks  + subScore[i];
            subjects.add(s);
        }
         s1.setSubjects(subjects);
         s1.setTotalMarks(totMarks);

         studentList.add(s1);
         studTemp = studentList;

         ObjectMapper objectMapper = new ObjectMapper();
         try {
             objectMapper.writeValue(new File(System.getProperty("user.dir")+("/students.json")),studTemp);
             for(Student stud : studTemp) {
                 System.out.println("Student name : " +stud.getName());
                 System.out.println("Student rNumber :" +stud.getRollNo());
                 System.out.println("Student totalMarks : " +stud.getTotalMarks());
             }
         }
         catch (Exception e){
             System.out.println("Exception occurred");
         }
    }

    public static void removeOldStudentInfo(int rNumber){
        int i;
        boolean found = false;
        for (i=0;i<studentList.size();i++) {
            if (rNumber == studentList.get(i).getRollNo()) {
                found = true;
                break;
            }
        }
        if(found){
            studentList.remove(studentList.get(i));
            studTemp = studentList;
            ObjectMapper obj = new ObjectMapper();
            try {
                 obj.writeValue(new File(System.getProperty("user.dir")+("/students.json")),studTemp);

                for(Student student : studTemp){
                    System.out.println("student name : "+student.getName());
                    System.out.println("student roll no : " +student.getRollNo());
                }
            }
            catch (Exception e){
                System.out.println("Exception occurred");
            }
        }
        else{
            System.out.println("Given student rollNumber is not in the list so try again");
        }
    }
}
