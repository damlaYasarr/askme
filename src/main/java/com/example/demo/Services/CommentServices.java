package com.example.demo.Services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.CreateRequest.CommentCreateRequest;
import com.example.demo.CreateRequest.putPost;
import com.example.demo.Entities.Comment;
import com.example.demo.Entities.Post;
import com.example.demo.Entities.User;
import com.example.demo.Repositories.CommentRepository;


@Service
public class CommentServices {
	   @Autowired
	    private CommentRepository commentrepository; 
	    public UserServices  userservice;
	    public PostServices  postservice;
	    public CommentServices( CommentRepository _commentrepository, 
	    		 UserServices  _userservice,
	            PostServices  _postservice ) {
	   	 this.commentrepository=_commentrepository;
	   	 this.userservice=_userservice;
	   	 this.postservice=_postservice;
	    }
	public List<Comment> getAllcomment(@RequestParam Integer userid, @RequestParam Integer postid) {
		if(userid!=null && postid!=null) {
			return commentrepository.findByUserIdAndPostId(userid,postid);
		}else if(userid!=null){
			return commentrepository.findByUserId(userid);
		}else if(postid!=null){
			return commentrepository.findByPostId( postid);
		}else {
			return commentrepository.findAll();
		}
		
	}

	public void deleteOnecomment(Integer commid) {
		commentrepository.deleteById(commid);
		
	}

	public Comment updateOneComment(@PathVariable Integer commentid,@RequestBody String commn) {
		Comment comm=commentrepository.getOne(commentid);
		if(comm!=null) {
			 Comment commtoupdate=comm;
			 commtoupdate.setText(commn);
			 return commentrepository.save(commtoupdate);
		}else {
			return null;
		}
	}

	public Comment getOnecommentById(Integer commentid) {
		return commentrepository.findById(commentid).orElse(null);
	}
	public Comment createOneComment( @RequestBody CommentCreateRequest newcomment) {
		User user=userservice.getOneUser(newcomment.getUser_id());
		Post post=postservice.getOnePostById(newcomment.getPost_id()); 
		if(user!=null && post!=null) {
			Comment tosave=new Comment(); 
			tosave.setId(newcomment.getId());
			tosave.setPost(post);
			tosave.setUser(user);
			tosave.setText(newcomment.getText());
			return commentrepository.save(tosave);
		}
		
		return null;
	}

}
