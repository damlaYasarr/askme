package com.example.demo.Entities;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Data;

@Entity
@Table(name="like")
@Data
public class Like {
      @Id
      int id;
      @ManyToOne(fetch=FetchType.LAZY)
      @JoinColumn(name="postId")
      @JsonIgnore
      Post post;
       
      @ManyToOne(fetch=FetchType.LAZY)
      @JoinColumn(name="userId")
      @JsonIgnore
      User user;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Post getPost() {
		return post;
	}

	public void setPost(Post post) {
		this.post = post;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Like() {
		super();
	} 
      
}
