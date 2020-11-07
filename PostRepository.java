package com.redink.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.redink.app.entities.Posts;

public interface PostRepository extends JpaRepository<Posts, Integer> {

}
