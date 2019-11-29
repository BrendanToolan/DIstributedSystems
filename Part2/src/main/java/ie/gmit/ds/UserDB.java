package ie.gmit.ds;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class UserDB {

	public static HashMap<Integer, UserClass> usersMap = new HashMap<>();
	static {
		usersMap.put(1, new UserClass(01, "Brendan", "Password1", "btoolan73@gmail.com"));
		usersMap.put(2, new UserClass(02, "Moe", "Password2", "Moe@gmail.com"));
		usersMap.put(3, new UserClass(03, "Jimbo", "Password3", "Jimbo@hotmai;.com"));
	}
	
	//shows all users
	public static List<UserClass> getUsers(){
		return new ArrayList<UserClass>(usersMap.values());
	}
	
	//get user by id
	public static UserClass getUserById(int userID) {
		return usersMap.get(userID);
	}
	
	//update user
	public static void updateUser(int userID, UserClass user){
	        usersMap.put(userID, user);
	    }
	
	//remove user
	public static void removeUser(int userID){
        usersMap.remove(userID);
    }
	
}
