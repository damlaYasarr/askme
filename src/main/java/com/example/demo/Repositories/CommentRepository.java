package com.example.demo.Repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.Entities.Comment;

@Repository
public interface CommentRepository extends JpaRepository<Comment,Integer> {

	List<Comment> findByUserIdandpostId(Integer userid, Integer postid);

	List<Comment> findByUserId(Integer userid);

	List<Comment> findByPostId(Integer postid);

}

