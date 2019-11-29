package ie.gmit.ds;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.Set;

import javax.validation.ConstraintViolation;
import javax.validation.Validator;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;


@Path("/users")
@Produces(MediaType.APPLICATION_JSON)
public class UserApiResources {

	//private HashMap<Integer, UserClass> userMap = new HashMap<>();
	
	private final Validator v;
	
	public UserApiResources(Validator v) {
		this.v = v;
	}
	
	//shows all users
	@GET
	public Response getUsers() {
		return Response.ok(UserDB.getUsers()).build();
	}
	
	//gets a user by ID
	@GET
	@Path("/{userID}")
	public Response getUserByID(@PathParam("userID") int userID) {
		UserClass user = UserDB.getUserById(userID);
		if (user != null)
			return Response.ok(user).build();
		else
			return Response.status(Status.NOT_FOUND).build();
	}
	
	//create a user
	@POST
	public Response createUser(UserClass user) throws URISyntaxException {
        // validation
        Set<ConstraintViolation<UserClass>> violations = v.validate(user);
        UserClass u = UserDB.getUserById(user.getUserID());
        if (violations.size() > 0) {
            ArrayList<String> validationMessages = new ArrayList<String>();
            for (ConstraintViolation<UserClass> violation : violations) {
                validationMessages.add(violation.getPropertyPath().toString() + ": " + violation.getMessage());
            }
            return Response.status(Status.BAD_REQUEST).entity(validationMessages).build();
        }
        if (u != null) {
            UserDB.updateUser(user.getUserID(), user);
            return Response.created(new URI("/users/" + user.getUserID()))
                    .build();
        } else
            return Response.status(Status.NOT_FOUND).build();
    }
	
	//update user
	@PUT
	@Path("/{userID}")
	public Response updateUserByID(@PathParam("userID") int userID, UserClass user)
	{
		
		Set<ConstraintViolation<UserClass>> violations = v.validate(user);
		UserClass u = UserDB.getUserById(user.getUserID());
		
		if(violations.size() > 0) {
			ArrayList<String> validationMessage = new ArrayList<String>();
			for(ConstraintViolation<UserClass> violation : violations) {
				validationMessage.add(violation.getPropertyPath().toString() + ": "+ violation.getMessage());
			}
			return Response.status(Status.BAD_REQUEST).entity(validationMessage).build();
		}
		
		if(u != null) {
			//user.setUserID(userID);
			UserDB.updateUser(userID, user);
			return Response.status(Status.OK).build();
		}
		else
			return Response.status(Status.NOT_FOUND).build();
		
	}
	//deletes a user
	@DELETE
	@Path("/{userID}")
	public Response deleteUserByID(@PathParam("userID") int userID) {
		UserClass user = UserDB.getUserById(userID);
		if (user != null) {
			UserDB.removeUser(userID);
			return Response.ok().build();
		}
		else
			return Response.status(Status.NOT_FOUND).build();
	}
	
}
