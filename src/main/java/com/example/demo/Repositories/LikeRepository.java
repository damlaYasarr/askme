package com.example.demo.Repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.Entities.Like;
@Repository
public interface LikeRepository extends JpaRepository<Like, Integer>{

    List<Like> findAllByPostId(Integer postid);

	List<Like> findByUserIdAndPostId(Optional<Integer> optional, Optional<Integer> optional2);

	List<Like> findByUserId(Optional<Integer> optional);

}
