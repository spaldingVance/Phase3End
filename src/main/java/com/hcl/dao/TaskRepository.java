package com.hcl.dao;

import java.util.Set;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.hcl.model.Task;

@Repository
public interface TaskRepository extends JpaRepository<Task, Long> {
//	
//	Set<Task> findByUserEmail(String userEmail);
}
