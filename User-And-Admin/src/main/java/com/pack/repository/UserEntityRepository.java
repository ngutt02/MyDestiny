package com.pack.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.pack.entity.UserEntity;
@Repository
public interface UserEntityRepository extends JpaRepository<UserEntity,String> {

}
