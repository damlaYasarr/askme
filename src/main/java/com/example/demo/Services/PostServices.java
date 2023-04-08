package com.example.demo.Services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.CreateRequest.PostCreateRequest;
import com.example.demo.Entities.Post;
import com.example.demo.Entities.User;
import com.example.demo.Repositories.PostRepository;
import com.example.demo.Repositories.UserRepository;
@Service
public class PostServices {
    private PostRepository postrepository; 
    private UserServices  userservice;
    public PostServices(PostRepository _postrepository,UserServices  _userservice) {
   	 this.postrepository=_postrepository;
   	 this.userservice=_userservice;
    }
	public List<Post> getAllpost(@RequestParam Optional<Integer> id) {
		if(id.isPresent()) {
			return postrepository.findByUserId(id.get());
		}
		return postrepository.findAll();
	}
	public Post getOnePostById(int postid) {
		 return postrepository.findById(postid).orElse(null);
	}
	public Post createOnePost(PostCreateRequest newpost) {
		User user=userservice.getOneUser(newpost.getUser_id());
		if(user==null) {
			return null;
		}
		Post tosave=new Post(); 
		tosave.setId(newpost.getId());
		tosave.setText(newpost.getText());
		tosave.setTitle(newpost.getTitle());
		tosave.setUser(user);
		return postrepository.save(tosave);
	}
    
}
