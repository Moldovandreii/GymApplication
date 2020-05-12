package com.project.services;

import com.project.entities.Admin;
import com.project.repository.AdminRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AdminServiceImpl implements AdminService{
    private AdminRepository adminRepository;

    @Autowired
    public AdminServiceImpl(AdminRepository adminRepository){
        this.adminRepository = adminRepository;
    }

    @Override
    public Admin findById(int id) {
        return adminRepository.findById(id).orElse(null);
    }

    @Override
    public Admin findByName(String username) {
        return adminRepository.findByUsername(username);
    }

    @Override
    public Admin save(String username) {
        return adminRepository.save(Admin.builder().username(username).build());
    }

    @Override
    public List<Admin> getAllAdmins() {
        return adminRepository.findAll();
    }
}
