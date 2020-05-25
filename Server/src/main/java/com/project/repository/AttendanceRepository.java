package com.project.repository;

import com.project.entities.Attendance;
import com.project.entities.Client;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AttendanceRepository extends JpaRepository<Attendance, Integer> {

    void deleteByClient(Client client);
}
