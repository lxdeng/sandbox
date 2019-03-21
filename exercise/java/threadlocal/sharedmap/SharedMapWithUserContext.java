package threadlocal.sharedmap;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class SharedMapWithUserContext implements Runnable {
	  
    public static Map<Integer, Context> userContextPerUserId
      = new ConcurrentHashMap<>();
    
    private Integer userId;
    private UserRepository userRepository = new UserRepository();
 
    @Override
    public void run() {
        String userName = userRepository.getUserNameForUserId(userId);
        userContextPerUserId.put(userId, new Context(userName));
    }
 
    // standard constructor
    
    public SharedMapWithUserContext(int userId) {
    	this.userId = userId;
    }
    
    
}

class UserRepository {
	String getUserNameForUserId(int id) {
		if (id == 1)
			return "Tom";
		else
			return "Jack";
	}
}