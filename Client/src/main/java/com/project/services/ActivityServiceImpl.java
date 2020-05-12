//package com.project.services;
//
//import com.project.entities.Activity;
//import com.project.repository.ActivityRepository;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//
//import java.util.List;
//
//@Service
//public class ActivityServiceImpl implements ActivityService{
//    private ActivityRepository activityRepository;
//
//    @Autowired
//    public ActivityServiceImpl(ActivityRepository activityRepository){
//        this.activityRepository = activityRepository;
//    }
//
//    @Override
//    public Activity findById(int id) {
//        return activityRepository.findById(id).orElse(null);
//    }
//
//
//    public void create(String name, int duration, int intensity){
//        activityRepository.save(Activity.builder().name(name).duration(duration).intensity(intensity).build());
//    }
//
//    public void update(String name, int duration, int intensity, int id){
//        activityRepository.save(Activity.builder().activityId(id).name(name).duration(duration).intensity(intensity).build());
//    }
//
//    public void delete(int id){
//        activityRepository.deleteById(id);
//    }
//
//    @Override
//    public List<Activity> getAllActivities() {
//        return activityRepository.findAll();
//    }
//}
