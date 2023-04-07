package com.example.demo.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.Entities.Post;
@Repository
public interface PostRepository extends JpaRepository<Post, Integer>{

}
