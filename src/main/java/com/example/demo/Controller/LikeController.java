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

import com.example.demo.CreateRequest.CreateLike;
import com.example.demo.CreateRequest.PostCreateRequest;
import com.example.demo.CreateRequest.putPost;
import com.example.demo.Entities.Like;
import com.example.demo.Entities.Post;
import com.example.demo.Services.LikeServices;

@RestController
@RequestMapping("/likes")
public class LikeController {
       private LikeServices likeservice;
       public LikeController(LikeServices _likeservice) {
    	   this.likeservice=_likeservice;
       }
       
       @GetMapping("/likeid")
       public Like getOneLike(@RequestParam(required = false, defaultValue = "0") Integer id){
       	  return  likeservice.getOneLikeById(id);
       }
       @PostMapping
       public Like createOnelike(@RequestBody CreateLike newlike) {
       	return likeservice.createOneLike(newlike);
       }
       @GetMapping
       public List<CreateLike> getAllLike(@RequestParam Optional<Integer> user_id,@RequestParam Optional<Integer> id) {
       	return likeservice.getAllLikewithParam(user_id,id);
        
       }
      
       @DeleteMapping("/{likeid}")
       public void deletePost(@PathVariable Integer likeid) {
       	  likeservice.deleteOneLike(likeid);
       	
       }
}
