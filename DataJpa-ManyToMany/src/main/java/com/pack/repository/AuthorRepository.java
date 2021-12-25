package com.pack.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.pack.entity.Author;
@Repository
public interface AuthorRepository extends JpaRepository<Author,Integer> {

}
