package comcom.in28minutes.rest.webservices.restfulwebservices.user;
import java.lang.reflect.Method;

import java.net.URI;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.Servlet;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

@RestController  
public class UserResource {
	
	@Autowired
	private UserDaoServices service;
	//get /users
	//retrieveAllUsers
	
	@GetMapping("/users")
	public List<User> retriveAllUsers(){
		return service.findAll();		
	}
	//retrieveUser based on(int id)
	@GetMapping("/users/{id}")//get users /{id}
	public User retrieveUser(@PathVariable int id) {		
		User user= service.findOne(id);
		if(user==null) 
			throw new UserNotFoundException("id-"+id);
		//to link all the users to the server 
		//"all-users", Server_path + "/users" 
		//find server path and append the users
		//retrive allusers
//		Resource<User> resource=new Resource<User>(user);
//		ControllerLinkRelationProvider linkTo=linkTo(MethodOn(this.getClass()).retrieveAllUsers());
//		resource.add(linkTo.withRel("all-users"));
		return user;		
	}
 	@PostMapping("/users")
	public ResponseEntity<Object> createUser(@Valid @RequestBody User user) {
		User savedUser = service.save(user);
		
		//create status
		//user/{id}         savedUser.getid
		URI location = ServletUriComponentsBuilder
		.fromCurrentRequest().path("/{id}")
		.buildAndExpand(savedUser.getId()).toUri();
		return ResponseEntity.created(location).build();
	}
	@DeleteMapping("/users/{id}")//get users /{id}
	public void deleteUser(@PathVariable int id) {		
		User user= service.deleteById(id);
		if(user==null) 
			throw new UserNotFoundException("id-"+id);		
	} 
}
