package com.example.demo;

import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.Entities.User;
import com.example.demo.Repositories.UserRepository;

import lombok.RequiredArgsConstructor;

@SpringBootApplication
public class DemoApplication {
    
	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}
	
}
