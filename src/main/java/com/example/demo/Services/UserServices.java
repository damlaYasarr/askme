package com.example.demo.Services;

import org.springframework.stereotype.Service;

import com.example.demo.Repositories.UserRepository;

@Service
public class UserServices {
     UserRepository usrRepository; 
     public UserServices(UserRepository _usrRepository) {
    	 this.usrRepository=_usrRepository;
     }
     
}
