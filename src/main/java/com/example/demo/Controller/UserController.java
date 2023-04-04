package com.example.demo.Controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.Entities.User;
import com.example.demo.Repositories.UserRepository;


@RestController
@RequestMapping("/users")
public class UserController {
	   
		private UserRepository userservice;
		public UserController(UserRepository _userservice) {
			this.userservice=_userservice;
		}
		@GetMapping
		public List<User> getAll(){
			return userservice.findAll();
		}
		  @PostMapping
		   public User save(@RequestBody User customer) {
		        return userservice.save(customer);
		    }
}
