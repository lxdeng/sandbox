package threadlocal.sharedmap;

public class Test {
    public static void main(String args[]) {

    	SharedMapWithUserContext firstUser = new SharedMapWithUserContext(1);
    	SharedMapWithUserContext secondUser = new SharedMapWithUserContext(2);
    	new Thread(firstUser).start();
    	new Thread(secondUser).start();
    	 
    	assert(SharedMapWithUserContext.userContextPerUserId.size() == 2);
    }
}
