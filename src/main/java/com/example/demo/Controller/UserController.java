package com.example.demo.Controller;

import java.util.List;
import java.util.Optional;

import org.apache.coyote.http11.upgrade.UpgradeServletOutputStream;
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
import com.example.demo.Services.UserServices;


@RestController
@RequestMapping("/users")
public class UserController {
	   
		private UserServices userservice;
		public UserController(UserServices _userservice) {
			this.userservice=_userservice;
		}
		@GetMapping
		public List<User> getAll(){
			return userservice.getAll();
		}
		 @PostMapping
		 public User save(@RequestBody User customer) {
		     return userservice.saveperson(customer);
		 
		 }
		 @PutMapping("/{id}")
		 public User updateUser(@PathVariable int id, @RequestBody User nweuser) {
			 return userservice.updateusr(id, nweuser);
		 }
		 @DeleteMapping("/{id}")
		 public void deleteusr(@PathVariable int id) {
		      userservice.deleteUserById(id);
		 
		 }
		 @GetMapping("/{id}")
		 public User getuser(@PathVariable int id) {
			 User var=userservice.findUserById(id).orElse(null);
		     return var;
		 
		 }
}
