package com.example.managementLaw.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.managementLaw.Entity.Task;

public interface taskRepository extends JpaRepository<Task, Long>{

}
