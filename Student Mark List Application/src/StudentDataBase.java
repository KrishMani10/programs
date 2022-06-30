import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.google.gson.reflect.TypeToken;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;


import java.io.FileNotFoundException;
import java.io.FileReader;

import java.io.Reader;
import java.util.*;

public class StudentDataBase {
    static  Scanner iP = new Scanner(System.in);
    static List<Student> students;
    static List<Student> studentTemp= new ArrayList<>();
    public static void main(String[] args) throws FileNotFoundException {

        System.out.println("Enter Staff name : ");
        String userName = iP.next();
        System.out.println("Enter Password : ");
        String password = iP.next();
        if(AuthenticationCheck.checkDetails(userName,password)){
           readStudentDetails();
        }
        else {
            System.out.println("Given credentials are incorrect");
        }
        sortingUsingRollNo();
        sortingUsingTotalMark();
        getStudNameUsingRno();
        getStudNameUsingName();
        Staff staff = new Staff("ss","dd"); 
        System.out.println(staff.getPassword());

    }

    public static void readStudentDetails() throws FileNotFoundException {
        Gson g = new Gson();
        Reader input = new FileReader(System.getProperty("user.dir") + ("/students.json"));
        students = g.fromJson(input, new TypeToken<List<Student>>() {
        }.getType());
        display();
    }

    public static void display(){
        System.out.println("********************** STUDENT MARK DETAILS ************************");
        for(int i=0;i<students.size();i++) {
            int j=0;
            System.out.println("========================");
            System.out.println("studentName :" +students.get(i).getName());
            System.out.println("rollNo :" +students.get(i).getRollNo());
            while(j<students.get(i).marks.size()) {
                System.out.println(students.get(i).marks.get(j).getSubject().getSubjectName() + " = " + students.get(i).marks.get(j).getSubjectScore());
                j++;
            }
            System.out.println("========================");
        }
    }

    public static void sortingUsingRollNo() {
        List<Integer> rNumber = new ArrayList<>();

        for (int i = 0; i < students.size(); i++) {
            rNumber.add(students.get(i).getRollNo());
        }
        Collections.sort(rNumber);
        for(int k=0;k< rNumber.size();k++) {
            for (int j = 0; j < students.size(); j++) {
                if (rNumber.get(k) == students.get(j).getRollNo()) {
                    studentTemp.add(students.get(j));
                    break;
                }
            }
        }
        System.out.println("Sorting students based on roll number : ");
        System.out.println("=========================================");
        for(int i =0;i< studentTemp.size();i++){
            System.out.println("student name : " +studentTemp.get(i).getName());
            System.out.println("roll number : " +studentTemp.get(i).getRollNo());
        }
        System.out.println("=========================================");
    }

    public static void sortingUsingTotalMark(){

        Map<Integer,Integer> studTotalMarks = new HashMap<>();
        List<Integer> total = new ArrayList<>();
        for(int i =0;i< students.size();i++){
            int j =0,totalMarks=0;

            while(j<students.get(i).marks.size()) {
                totalMarks = totalMarks + students.get(i).marks.get(j).getSubjectScore();
                j++;
            }
            total.add(totalMarks);
        }
        for(int i=0;i< students.size();i++) {
            studTotalMarks.put(students.get(i).getRollNo(), total.get(i));
        }
//        for(Map.Entry<Integer,Integer> entry : studTotalMarks.entrySet()){
//            System.out.println(entry.getKey()+ " "+ entry.getValue());
//        }

    }

    public static void getStudNameUsingRno(){
        System.out.println("Enter a roll no to find student name : ");
        int rNoToFind = iP.nextInt();
         String studName= " " ;
         try {
             for (int i = 0; i < students.size(); i++) {
                 if (rNoToFind == students.get(i).getRollNo()) {
                     studName = students.get(i).getName();
                     break;
                 }
             }
             System.out.println("Corresponding name for roll number given is : " + studName);
         }
         catch (Exception e){
             System.out.println("Input mismatch --- give input properly ");
         }
    }

    public static void getStudNameUsingName() {
        System.out.println("Enter the input to find student name: ");
        String studNameToFind = iP.next();
        String studNameFound = " ";
        try {
            for(int i =0;i< students.size();i++) {
                if(studNameToFind.equals(students.get(i).getName())){
                    studNameFound = students.get(i).getName();
                    break;
                }
            }
            System.out.println("Student Name for corresponding input is " +studNameFound);
        }
        catch (Exception e){
            System.out.println("Input mismatch ");
        }
    }

//    public static void removeStudentData(){
//        System.out.println("Enter the roll no you want to delete information :  " );
//        int rollNumber = iP.nextInt();
//        JSONParser parser = new JSONParser();
//
//        try {
//            Object obj = parser.parse(new FileReader(System.getProperty("user.dir")+"/students.json"));
//            JSONArray array = (JSONArray) obj;
//            FileWriter file = new FileWriter(System.getProperty("user.dir")+"/students.json");
//            for(int i = 0;i<array.size();i++){
//                JSONObject jsonObject = (JSONObject) array.get(i);
//
//                jsonObject.remove(  );
//                file.write(jsonObject.toJSONString());
//            }
//        }
//        catch (Exception e){
//            e.printStackTrace();
//        }
//    }
}
