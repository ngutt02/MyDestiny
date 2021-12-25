package com.pack.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.pack.entity.LoanEntity;
@Repository
public interface LoanEntityRepository extends JpaRepository<LoanEntity,Integer> {

}
