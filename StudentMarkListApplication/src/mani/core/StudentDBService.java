package mani.core;

import mani.model.Student;
import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.type.TypeReference;

import java.io.FileReader;
import java.io.Reader;
import java.util.List;

public class StudentDBService {

    static List<Student> studentDetails;

    public static List<Student> readStudentDetails() {

        ObjectMapper objectMapper = new ObjectMapper();
        try(Reader reader = new FileReader(System.getProperty("user.dir") +("/students.json"))){
//            studentDetails = objectMapper.readValue(reader,
//                    TypeFactory.defaultInstance().constructCollectionType(List.class,
//                            Student.class));
            studentDetails = objectMapper.readValue(reader,new TypeReference<List<Student>>(){});
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        return studentDetails;
    }
}
