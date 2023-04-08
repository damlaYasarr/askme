package com.example.demo.Services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.example.demo.Entities.User;
import com.example.demo.Repositories.UserRepository;

@Service
public class UserServices {
     UserRepository usrRepository; 
     public UserServices(UserRepository _usrRepository) {
    	 this.usrRepository=_usrRepository;
     }
	public List<User> getAll() {
		return usrRepository.findAll();
	}
	public User saveperson(User customer) {
		return usrRepository.save(customer);
	}
	public Optional<User> findUserById(int id) {
		return usrRepository.findById(id);
	}
	public void deleteUserById(int id) {
		usrRepository.deleteById(id);
	}  
	public User updateusr(int id, User newusr) {
		 Optional<User> user= usrRepository.findById(id); 
		 if(user.isPresent()) {
			 User founduser=user.get(); 
			 founduser.setUsername(newusr.getUsername());
			 founduser.setPassword(newusr.getPassword());
			 usrRepository.save(founduser);
			 return founduser;
		 }else {
			 return null;
		 }
	}
	
}