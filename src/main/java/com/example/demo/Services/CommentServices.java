package com.example.demo.Services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.demo.CreateRequest.putPost;
import com.example.demo.Entities.Comment;
import com.example.demo.Repositories.CommentRepository;
import com.example.demo.Repositories.PostRepository;

@Service
public class CommentServices {
	 private CommentRepository commentrepository; 
	   // private UserServices  userservice;
	    public CommentServices( CommentRepository _commentrepository) {
	   	 this.commentrepository=_commentrepository;
	    }
	public List<Comment> getAllcomment(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

	public void deleteOnecomment(int commid) {
		// TODO Auto-generated method stub
		
	}

	public Object updateOneComment(int commentid, putPost newpost) {
		// TODO Auto-generated method stub
		return null;
	}

	public Object getOnecommentById(int commentid) {
		// TODO Auto-generated method stub
		return null;
	}

}
