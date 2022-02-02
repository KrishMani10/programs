import java.util.ArrayList;
import java.util.List;

public class FbUser {
        List<FbProfileUser> facebookUsers;
    }
    class FbProfileUser {

        String userName;

        int id;


        List<String> friends = new ArrayList<>();

        FbProfileUser(String userName,int id) {
            this.userName = userName;
            this.id = id;
        }

        public void setId(int id){
            this.id = id;
        }

        public int getId()
        {
            return this.id ;
        }

}
