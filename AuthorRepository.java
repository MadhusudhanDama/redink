
package com.redink.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.redink.app.entities.Authors;

public interface AuthorRepository extends JpaRepository<Authors, Integer> {

}
