package com.project.repository;

import com.project.entities.Program;
import com.project.entities.Trainer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProgramRepository extends JpaRepository<Program, Integer> {
    //Program findByName(String name);
    List<Program> findByTrainer(Trainer trainer);
}
