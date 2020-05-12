package com.project.services;

import com.project.dao.ActivityDAO;
import com.project.entities.Activity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ActivityService {
    Activity findById(int id);

    List<Activity> getAllActivities();

    void create(String name, int duration, int intensity);

    void update(String name, int duration, int intensity, int id);

    void delete(int id);

    List<ActivityDAO> getAllActivitiesDAO();

}
