package mani.resources;

import mani.test.FacebookUsers;
import java.util.List;
import javax.ws.rs.DefaultValue;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.QueryParam;

import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;


@Path("/mutualFriends")
public class MutualFriends {

    FacebookUsers testResult = new FacebookUsers();
    @GET
    @Path("/query")
    @Produces(MediaType.TEXT_HTML)
    public String getMutualFriends(@DefaultValue("UnDefined") @QueryParam("username1") String username1,
                                   @QueryParam("username2") String username2) {
        List <String> mutual = testResult.toFindMutualFriends(username1,username2);

        return "<h2>Mutual friends between " +username1+ " and " +username2+ " is " + "</h2>" + "<h3>" + mutual + "</h3>";

//        StringBuilder sb = new StringBuilder();
//        for (int i = 0; i < mutual.size(); i++) {
//            sb.append(mutual.get(i) + "\n");
//
//        }
//        return sb.toString();
    }
}
