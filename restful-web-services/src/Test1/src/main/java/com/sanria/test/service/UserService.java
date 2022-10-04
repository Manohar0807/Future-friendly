package com.sanria.test.service;

import java.nio.file.FileAlreadyExistsException;

import com.sanria.test.shared.UserDto;

public interface UserService {

	public UserDto createUser(UserDto userDetail);

	public UserDto getUserById(Long userId);

	public UserDto getUserByUUID(String userUUID);

	public boolean getUserByEmail(String email) throws FileAlreadyExistsException; 
}
