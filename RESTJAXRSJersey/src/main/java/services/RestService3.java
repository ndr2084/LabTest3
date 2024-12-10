package services;

import java.util.Date;

import javax.ws.rs.DefaultValue;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Response;
 
@Path("/restService3")

public class RestService3 {
	@GET
	@Path("/op1")
	public Response service3Op1(
			@QueryParam("firstName") String firstName, 
			@QueryParam("lastName") String lastName) {
 
		String output = "Service 3 says : Hello " + firstName + " " 
						+ lastName;
 
		return Response.status(200).entity(output).build();
 
	}
}
