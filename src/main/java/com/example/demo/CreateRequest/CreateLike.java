package com.example.demo.CreateRequest;

import com.example.demo.Entities.Like;

public class CreateLike {
   int user_id; 
   int post_id; 
   int id;
   
  

   
public CreateLike(Like like) {
	this.id=like.getId();
	this.user_id=like.getUser().getId();
	this.post_id=like.getPost().getId();
}



public int getUser_id() {
	return user_id;
}



public void setUser_id(int user_id) {
	this.user_id = user_id;
}



public int getPost_id() {
	return post_id;
}



public void setPost_id(int post_id) {
	this.post_id = post_id;
}



public int getId() {
	return id;
}



public void setId(int id) {
	this.id = id;
}

   
}
