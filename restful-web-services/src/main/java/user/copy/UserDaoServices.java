package user.copy;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Component;

@Component
public class UserDaoServices {
	private  static  List<User> users= new ArrayList<>();
	private int usercount=3;
	static {
		users.add(new User(1,"Manu",new Date()));
		users.add(new User(2,"Manohar",new Date()));
		users.add(new User(3,"Manohar R",new Date()));		
		
	}
//	public List<User> findAll()
//	public User save(User user)
//	public User findOne(int id)

	public List<User> findAll(){
		return users;
	}
	
	public User save(User user) {
		if(user.getId()==null) {
			user.setId(++usercount);
		}
		users.add(user);
		return user;
	}

	public User findOne(int id) {
		for(User user:users) {
			if(user.getId()==id) {
				return user;
			}
		}
		return null;
	}
}
