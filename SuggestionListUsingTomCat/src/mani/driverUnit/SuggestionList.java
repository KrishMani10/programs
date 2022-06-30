package mani.driverUnit;

import mani.testService.FacebookUsers;

import java.util.List;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;


@Path("/suggestion")

public class SuggestionList{

    FacebookUsers testResult = new FacebookUsers();

    @GET
    @Path("/query")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.TEXT_HTML)
    public String getMutualFriends(@DefaultValue("UnDefined") @QueryParam("userName1") String userName1) {
        List<String> suggestionForYou = testResult.peopleYouMayKnow(userName1);
        return "<h2>Suggestion list of people for " + userName1 + " is " + "</h2>" + "<h3>" +suggestionForYou + "</h3>";
    }
}
