package com.example.demo.Services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.CreateRequest.PostCreateRequest;
import com.example.demo.CreateRequest.putPost;
import com.example.demo.Entities.Post;
import com.example.demo.Entities.User;
import com.example.demo.Repositories.PostRepository;

@Service
public class PostServices {
	@Autowired
    private PostRepository postrepository; 
    private UserServices  userservice;
    public PostServices(PostRepository _postrepository,UserServices  _userservice) {
   	 this.postrepository=_postrepository;
   	 this.userservice=_userservice;
    }
	public List<Post> getAllpost(@RequestParam Integer id) {
		if(id!=null) {
			return postrepository.findByUserId(id);
		}
		return postrepository.findAll();
	}
	public Post getOnePostById(Integer postid) {
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
	public Post updateOnepost(Integer postid, @RequestBody putPost newpost){
		 Optional<Post> post= postrepository.findById(postid); 
		 if(post.isPresent()) {
			 Post foundpost=post.get(); 
			 foundpost.setTitle(newpost.getTitle());
			 foundpost.setText(newpost.getText());
			 return postrepository.save(foundpost);
		 }else {
			 return null;
		 }
	}
	public void deleteOnepost(Integer postid) {
		postrepository.deleteById(postid);
	}
    
}
