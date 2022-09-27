package comcom.in28minutes.rest.webservices.restfulwebservices.user2;

import java.io.FileNotFoundException;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;
import java.util.function.Supplier;
import javax.management.AttributeNotFoundException;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import comcom.in28minutes.rest.webservices.restfulwebservices.user.UserNotFoundException;
@RestController
public class UserResource2 {
	
	private static final ResponseEntity<Object> ResponseEntity = null;
	@Autowired
	private UserRepository2 userRepository2;	
	
	@GetMapping
	public String connect() {
		return "connected";
	}
	
	@GetMapping(path = "/users2")
	public List<User2> retriveAllUsers2() {		
		return userRepository2.findAll();
	}
	
	@GetMapping("/users2/{id}")
	public Optional<User2> retriveUser(@PathVariable int id) {
			Optional<User2> user2=userRepository2.findById(id);
			if(user2==null)
				throw new UserNotFoundException("Can not get the file because it is not present is the records");
				return user2;
	}
	
	@DeleteMapping("/users2")
	public List<User2> DeleteUser() {				
            userRepository2.deleteAll();			
            return null;						
	}
	@DeleteMapping("/users2/{id}")
	public List<User2> DeleteUser(@Valid @PathVariable int id) throws FileNotFoundException {		
			if((userRepository2.findById(id))==null){
				throw new FileNotFoundException("Cannot delete the file because it is not present");
			}	

            userRepository2.deleteById(id);
			return null;						
	}
	@PostMapping("/users2")
	public  List<User2> saveUser( @RequestBody final List<User2> user2) throws FileNotFoundException {
		for (User2 user22 : user2) {
			if((user22.getId())==null){
				throw new FileNotFoundException("Cannot post as we dont have the file");
			}
		}
		userRepository2.saveAll(user2);
	 return  userRepository2.findAll();
	}
	@PutMapping("/users2/{id}")
	public ResponseEntity<User2> UpdateUser2(@PathVariable int id,@RequestBody User2 users2) throws AttributeNotFoundException{
		Iterator<User2> iterator=new Iterator<User2>() {
			
			@Override
			public User2 next() {
				// TODO Auto-generated method stub
				return null;
			}
			
			@Override
			public boolean hasNext() {
				// TODO Auto-generated method stub
				return false;
			}
		};  
		 while(iterator.hasNext()) {
				User2 user2=iterator.next();
				if(user2.getId()!=id) {
					throw new UserNotFoundException("User is not found in that ID");
					}
			}
		 User2 user2 = userRepository2.findById(id).orElseThrow(() -> new AttributeNotFoundException("Users2 not exist with id: " + id));
		 user2.setId(users2.getId());
		 user2.setTitle(user2.getTitle());
		 users2.setPrice(user2.getPrice());
		 users2.setDescription(user2.getDescription());
		 users2.setCategory(user2.getDescription());
		 users2.setImage(user2.getImage());		
	       userRepository2.save(users2);
	        return ResponseEntity.ok(users2);
	}		
}




















