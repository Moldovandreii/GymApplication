package com.project.services;

import com.project.entities.Activity;
import com.project.entities.Program;
import com.project.entities.Trainer;
import com.project.repository.ProgramRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProgramServiceImpl implements ProgramService{
    private ProgramRepository programRepository;

    @Autowired
    public ProgramServiceImpl(ProgramRepository programRepository){
        this.programRepository = programRepository;
    }

    @Override
    public Program findById(int id) {
        return programRepository.findById(id).orElse(null);
    }

    @Override
    public void createProgram(String name, Trainer trainer, List<Activity> activities) {
        programRepository.save(Program.builder().programName(name).trainer(trainer).activities(activities).build());
    }

    @Override
    public List<Program> findByTrainer(Trainer trainer){
        return programRepository.findByTrainer(trainer);
    }

}
