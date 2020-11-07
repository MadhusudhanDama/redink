package com.redink.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.redink.app.entities.Comments;

public interface CommentsRepository extends JpaRepository<Comments, Integer> {

}
