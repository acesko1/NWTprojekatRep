package com.nwt.witcher.paymentapp.service;

import com.nwt.witcher.paymentapp.repository.ActivityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.nwt.witcher.paymentapp.model.Activity;

import java.util.List;

@Service
public class ActivityServiceImpl implements ActivityService {

    @Autowired
    private ActivityRepository activityRepository;

    @Transactional
    @Override
    public List<Activity> get() {
        try {
            return activityRepository.findAll();
        } catch (Exception e){
            e.printStackTrace();
            throw e;
        }
    }

    @Transactional
    @Override
    public Activity get(int id) {
        try {
            return activityRepository.getOne(id);
        } catch (Exception e){
            e.printStackTrace();
            throw e;
        }
    }

    @Transactional
    @Override
    public void save(Activity activity) {
        try {
            activityRepository.save(activity);
        } catch (Exception e){
            e.printStackTrace();
            throw e;
        }
    }

    @Transactional
    @Override
    public void delete(int id) {
        try {
            activityRepository.deleteById(id);
        } catch (Exception e){
            e.printStackTrace();
            throw e;
        }
    }

}
