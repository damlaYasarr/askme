package com.example.demo.CreateRequest;

import java.util.List;

import com.example.demo.Entities.Like;
import com.example.demo.Entities.Post;

public class PostCreateRequest {
     int id; 
     String username;
     String text; 
	 String title; 
     int user_id;
     List<CreateLike>postlike;
     
	public PostCreateRequest(Post entity, List<CreateLike> like) {
		this.id=entity.getId();
		this.user_id=entity.getUser().getId();
		this.username=entity.getUser().getUsername(); 
		this.title=entity.getTitle(); 
		this.text=entity.getText(); 
		this.postlike=like;
		}
	
	
	
	 public List<CreateLike> getPostlike() {
		return postlike;
	}



	public void setPostlike(List<CreateLike> postlike) {
		this.postlike = postlike;
	}



	public String getUsername() {
			return username;
		}
		public void setUsername(String username) {
			this.username = username;
		}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getText() {
		return text;
	}
	public void setText(String text) {
		this.text = text;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public int getUser_id() {
		return user_id;
	}
	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}
     
}
