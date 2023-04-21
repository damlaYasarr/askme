package com.example.demo.Entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

//it will be created automated in database
@Entity
@Table(name="user_infox")
public class User {
  
  @Id
  @GeneratedValue(strategy= GenerationType.IDENTITY)
  private int id;
  private String username;
  private String password;
public User() {
	
}

public User(int i, String username, String password) {

	this.id = i;
	this.username = username;
	this.password = password;
}

public int getId() {
	return id;
}

public void setId(int id) {
	this.id = id;
}

public String getUsername() {
	return username;
}

public void setUsername(String username) {
	this.username = username;
}

public String getPassword() {
	return password;
}

public void setPassword(String password) {
	this.password = password;
}




 
  
}
