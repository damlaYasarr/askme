package com.example.demo.Services;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.CreateRequest.CreateLike;
import com.example.demo.CreateRequest.PostCreateRequest;
import com.example.demo.CreateRequest.putPost;
import com.example.demo.Entities.Like;
import com.example.demo.Entities.Post;
import com.example.demo.Entities.User;
import com.example.demo.Repositories.PostRepository;

@Service
public class PostServices {
	@Autowired
    private PostRepository postrepository; 
    private UserServices  userservice;
    private LikeServices  likeservice;
    public PostServices(PostRepository _postrepository,LikeServices  _likeservice,UserServices  _userservice) {
   	 this.postrepository=_postrepository;
   	 this.userservice=_userservice;
   	 this.likeservice=_likeservice;
    }
	public List<PostCreateRequest> getAllpost(@RequestParam Integer id) {
		List<Post> list;
		if(id!=null) {
			list= postrepository.findByUserId(id);
		}
		list= postrepository.findAll();
		//most important part
		return list.stream().map(p->{
			List<CreateLike> like= likeservice.getAllLikewithParam(Optional.ofNullable(null),Optional.of(p.getId()));
		    return new PostCreateRequest(p,like);
		    }).collect(Collectors.toList());
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
