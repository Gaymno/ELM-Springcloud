package org.example.controller;


import org.example.po.User;
import org.example.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/UserController")
public class UserController {
	
	@Autowired
	private UserService userService;

	@PostMapping("/getUserByIdByPass")
	public User getUserByIdByPass(@RequestBody User user) {
		return userService.getUserByIdByPass(user);
	}
	
	@PostMapping("/getUserById")
	public int getUserById(@RequestBody User user) {
		return userService.getUserById(user.getUserId());
	}
	
	@PostMapping ("/saveUser")
	public int saveUser(@RequestBody User user){
		return userService.saveUser(user);
	}
}
