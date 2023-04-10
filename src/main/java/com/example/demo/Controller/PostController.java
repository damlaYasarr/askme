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

import com.example.demo.CreateRequest.PostCreateRequest;
import com.example.demo.CreateRequest.putPost;
import com.example.demo.Entities.Post;
import com.example.demo.Repositories.PostRepository;
import com.example.demo.Services.PostServices;

@RestController
@RequestMapping("/posts")
public class PostController {
	private PostServices postservice; 
    public PostController(PostServices _postservice) {
   	 this.postservice=_postservice;
    }
    @GetMapping
    public List<Post> getAllPost(@RequestParam Integer id){
    	  return postservice.getAllpost(id);
    }
    @PostMapping
    public Post createOnePost(@RequestBody PostCreateRequest newpost) {
    	return postservice.createOnePost(newpost);
    }
    @GetMapping("/{postid}")
    public Optional<Post> getOnePost(@PathVariable int postid) {
    	var post= postservice.getOnePostById(postid);
    	return post;
    }
    
    @PutMapping("/{postid}")
    public Post updatePost(@PathVariable int postid, @RequestBody putPost newpost) {
    	var post= postservice.updateOnepost(postid,newpost);
    	return post;
    }
    @DeleteMapping("/{postid}")
    public void deletePost(@PathVariable int postid) {
    	  postservice.deleteOnepost(postid);
    	
    }
    
}

