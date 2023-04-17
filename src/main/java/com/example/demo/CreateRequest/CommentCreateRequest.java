package com.example.demo.CreateRequest;

public class CommentCreateRequest {
    int id;
    int user_id; 
    int post_id; 
	String text;
	public CommentCreateRequest() {
	
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
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
	public String getText() {
		return text;
	}
	public void setText(String comment) {
		this.text = comment;
	} 

}
