package mani.test;

import java.io.FileNotFoundException;
import java.io.FileReader;

public class InputReadService {
//    static Object heroes;
//    public Object readDataFromJson() throws IOException{
//            Gson gson = new Gson();
//            Reader reader = new FileReader(System.getProperty("user.dir") + "/superhero.json");
//
//            heroes = gson.fromJson(reader,ArrayList.class);
//            System.out.println(heroes);
//            return heroes;
//    }
//    static Object heroes;
//    public Object parseReader() throws IOException, ParseException {
//        JSONParser jsonParser = new JSONParser();
//        Object object = jsonParser.parse(new FileReader(System.getProperty("user.dir")+ "/superhero.json"));
//
//        JSONObject jsonObject = (JSONObject)object;
//        System.out.println(jsonObject);
//        return jsonObject;


     public Object readDataFromJson() throws FileNotFoundException {
         FileReader fr = new FileReader(System.getProperty("user.dir")+ "/superhero.json");
         return fr;
   }

   public Object readInputFromJson() throws FileNotFoundException {
       FileReader fr2 = new FileReader(System.getProperty("user.dir")+ "/hero.json");
         return fr2;
   }
}
