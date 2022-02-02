import com.google.gson.Gson;
import java.io.FileReader;
import java.io.Reader;
import java.util.*;

public class MainSpec {
    public static void main(String[] args) throws Exception {
        countMutualFriend();
    }

    public static void countMutualFriend() throws Exception {
        int nodeCount;
        int adjMatrix[][];
        Scanner s = new Scanner(System.in);
        Gson gson = new Gson();
        Reader reader = new FileReader(System.getProperty("user.dir") + "/friendlist.json");
        FbUser faceBookUsers = gson.fromJson(reader, FbUser.class);
        nodeCount = faceBookUsers.facebookUsers.size();
        adjMatrix = new int[nodeCount][nodeCount];
        for(int i=0;i<nodeCount;i++){
             faceBookUsers.facebookUsers.get(i).setId(i);
        }
        for(int i=0;i<nodeCount;i++)
        {
            int row ;
            int column = 0 ;

            FbProfileUser fbUser = faceBookUsers.facebookUsers.get(i);
            row = fbUser.getId();
            System.out.println(" id : " +row+ " -----> username :" +fbUser.userName );

            Iterator<String> it = fbUser.friends.iterator();
            while(it.hasNext()) {
                String name = it.next();
                for (int j = 0; j < nodeCount; j++) {
                    if (faceBookUsers.facebookUsers.get(j).userName.equals(name)) {
                        column = faceBookUsers.facebookUsers.get(j).getId();
                        break;
                    }
                }
                adjMatrix[row][column] = 1;
            }
        }
        System.out.println("Adjacency matrix for the given list of friends is :" );
        for(int i=0;i<nodeCount;i++)
        {
            for(int j=0;j<nodeCount;j++)
            {
                System.out.print(adjMatrix[i][j] +"\t");
            }

            System.out.println();
        }

//        for(int j=0;j<nodeCount;j++)
//        {
//            FbProfileUser fbUser = faceBookUsers.facebookUsers.get(j);
//            for (int k = 0; k < fbUser.friends.size(); k++)
//            {
//                for (int i = 0; i < nodeCount; i++)
//                {
//                    if (faceBookUsers.facebookUsers.get(i).userName.equals(fbUser.friends.get(k)))
//                    {
//                        int id = faceBookUsers.facebookUsers.get(i).userId;
//                        adjMatrix[j][id] = 1;
//                    }
//                }
//            }
//        }
//        for(int i=0;i<nodeCount;i++)
//        {
//            for (int j = 0; j < nodeCount; j++)
//            {
//                System.out.print(adjMatrix[i][j] +"\t");
//            }
//            System.out.println();
//        }

        System.out.println("Enter the first userId: ");
        int id1 =  s.nextInt();
        System.out.println("Enter the second userId: ");
        int id2 = s.nextInt();
        System.out.println("Mutual friends between " +id1+ " & " +id2+  " is: ");
        List <String> mutualFriends = new ArrayList<>();
        for(int i=0;i<nodeCount;i++)
        {
            if((adjMatrix[id1][i])==1 && (adjMatrix[id2][i])==1)
            {
                    mutualFriends.add(faceBookUsers.facebookUsers.get(i).userName);

            }
        }
        System.out.println(mutualFriends);

    }
}
