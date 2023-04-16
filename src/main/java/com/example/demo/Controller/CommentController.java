package com.example.demo.Controller;

import java.util.List;
import java.util.Optional;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.CreateRequest.CommentCreateRequest;
import com.example.demo.CreateRequest.PostCreateRequest;
import com.example.demo.CreateRequest.putPost;
import com.example.demo.Entities.Comment;
import com.example.demo.Entities.Post;
import com.example.demo.Services.CommentServices;
import com.example.demo.Services.PostServices;

@RestController
@RequestMapping("/comments")
public class CommentController {
	private CommentServices commentservice;
    public CommentController(CommentServices _commentservice) {
   	 this.commentservice=_commentservice;
    }
    @GetMapping
    public List<Comment> getAllComment(@RequestParam Integer userid, @RequestParam Integer postid){
    	  return commentservice.getAllcomment(userid,postid);
    }
    @PostMapping
    public Comment createOneComment(@RequestBody CommentCreateRequest newcomment) {
    	return commentservice.createOneComment(newcomment);
    }
    @GetMapping("/{commentid}")
    public Comment getOneComment(@PathVariable Integer commentid) {
    	return  commentservice.getOnecommentById(commentid);
    	
    }
    
    @PutMapping("/{commentid}")
    public Comment updateComment(@PathVariable Integer commentid, @RequestBody String commn) {
    	return commentservice.updateOneComment(commentid,commn);
    	
    }
    @DeleteMapping("/{commid}")
    public void deleteComment(@PathVariable Integer commid) {
    	  commentservice.deleteOnecomment(commid);
    	
    }
    
}
