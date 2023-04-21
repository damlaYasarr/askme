package com.example.demo.Services;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import com.example.demo.CreateRequest.CreateLike;
import com.example.demo.CreateRequest.PostCreateRequest;
import com.example.demo.Entities.Like;
import com.example.demo.Entities.Post;
import com.example.demo.Entities.User;
import com.example.demo.Repositories.LikeRepository;
@Service
public class LikeServices {
	  @Autowired
	  private LikeRepository likerepository; 
	  public UserServices  userservice;
	   public PostServices  postservice;
	  public LikeServices(LikeRepository _likerepo,
			 UserServices  _userservice,
	    PostServices  _postservice) {
		  this.likerepository=_likerepo;
		  this.userservice=_userservice;
		  this.postservice=_postservice;
		  
	  }
	public List<Like> getAlllike(Integer id) {
		return (List<Like>) likerepository.findById(id).orElse(null);
	}

	public Like createOneLike(@RequestBody CreateLike newlike) {
		User user=userservice.getOneUser(newlike.getUser_id());
		Post post=postservice.getOnePostById(newlike.getPost_id());
		if(user!=null && post!=null) {
			Like tosave=new Like(); 
			tosave.setId(newlike.getId());
			tosave.setPost(post);
			tosave.setUser(user);
			
			return likerepository.save(tosave);
		}
		return null;
	}


	public void deleteOneLike(Integer likeid) {
		// TODO Auto-generated method stub
		likerepository.deleteById(likeid);
		
	}
	public List<CreateLike> getAllLikewithParam(Optional<Integer> optional, Optional<Integer> optional2) {
		//int id POST ID
		List<Like> list;
	 if(optional.isPresent() && optional2.isPresent()) {
		 list= likerepository.findByUserIdAndPostId(optional, optional2);
	 }else if(optional2.isPresent()){
		 list= likerepository.findByUserId(optional);
	 }else {
		 list= likerepository.findAll();
	 }
	 return list.stream().map(p-> new CreateLike(p)).collect(Collectors.toList());
		
	}
	public Like getOneLikeById(Integer id) {
		return (Like) likerepository.findAllByPostId(id);
	}
    
}
