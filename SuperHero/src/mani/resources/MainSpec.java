package mani.resources;

import mani.test.InputReadService;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.io.IOException;

@Path("/Classification")
public class MainSpec {

    static InputReadService result = new InputReadService();

      @Path("/SuperHero")
      @GET
      @Produces(MediaType.APPLICATION_JSON)
      public Response getDataValue() throws IOException {
            Object superVal = result.readDataFromJson();
          return Response
                  .status(200)
                  .header("Access-Control-Allow-Origin", "*")
                  .header("Access-Control-Allow-Credentials", "true")
                  .header("Access-Control-Allow-Headers",
                          "origin, content-type, accept, authorization")
                  .header("Access-Control-Allow-Methods",
                          "GET, POST, PUT, DELETE, OPTIONS, HEAD")
                  .entity(superVal)
                  .build();
      }

    @Path("/superHero")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getInputValue() throws IOException {
        Object superVal = result.readInputFromJson();
        return Response
                .status(200)
                .header("Access-Control-Allow-Origin", "*")
                .header("Access-Control-Allow-Credentials", "true")
                .header("Access-Control-Allow-Headers",
                        "origin, content-type, accept, authorization")
                .header("Access-Control-Allow-Methods",
                        "GET, POST, PUT, DELETE, OPTIONS, HEAD")
                .entity(superVal)
                .build();
    }
}
