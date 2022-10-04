package com.sanria.test.controllers;
import java.nio.file.FileAlreadyExistsException;
//import java.util.Iterator;
//import java.util.LinkedList;
import java.util.UUID;
import javax.validation.Valid;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
//import com.sanria.test.domain.User;
import com.sanria.test.repository.UserRepository;
import com.sanria.test.request.model.UserRequestModel;
import com.sanria.test.response.model.UserResponseModel;
import com.sanria.test.service.UserService;
import com.sanria.test.shared.UserDto;

@RestController
@RequestMapping("/users")
public class UsersController {

	@Autowired
	UserService userService;
	@Autowired
	UserRepository userRepository;

	@GetMapping("/status")
	public String status(){
		return "Users started";
	}

	@PostMapping("/poststatus")
	public ResponseEntity<UserResponseModel> createUser(@Valid @RequestBody UserRequestModel userDetail) throws FileAlreadyExistsException {
	String email = userDetail.getEmail();
		userService.getUserByEmail(email);			
		UserDto userDto = new UserDto();
		BeanUtils.copyProperties(userDetail, userDto);
		userDto.setUserId(UUID.randomUUID().toString());
		UserDto dbUserDto = userService.createUser(userDto);
		UserResponseModel userResponseModel = new UserResponseModel();
		BeanUtils.copyProperties(dbUserDto, userResponseModel);
		return new ResponseEntity<UserResponseModel>(userResponseModel, HttpStatus.OK);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<UserResponseModel> getUserById(@PathVariable(name = "id") Long userId) {
		UserDto dbUserDto = userService.getUserById(userId);
		UserResponseModel userResponseModel = null;
		if(dbUserDto != null) {
			userResponseModel = new UserResponseModel();
			BeanUtils.copyProperties(dbUserDto, userResponseModel);
		}
		return new ResponseEntity<UserResponseModel>(userResponseModel, HttpStatus.OK);
	}
	
	@GetMapping("/unique/{id}")
	public ResponseEntity<UserResponseModel> getUserByUUID(@PathVariable(name = "id") String userUUID) {
		UserDto dbUserDto = userService.getUserByUUID(userUUID);
		UserResponseModel userResponseModel = null;
		if(dbUserDto != null) {
			userResponseModel = new UserResponseModel();
			BeanUtils.copyProperties(dbUserDto, userResponseModel);
		}
		return new ResponseEntity<UserResponseModel>(userResponseModel, HttpStatus.OK);
	}
	
	

}
