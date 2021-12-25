package com.pack.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.pack.entity.Employee;

public interface AbcDAO extends JpaRepository<Employee, Integer> {

}
