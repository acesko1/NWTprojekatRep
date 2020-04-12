package com.nwt.witcher.paymentapp.service;

import com.nwt.witcher.paymentapp.repository.ActivityPermissionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.nwt.witcher.paymentapp.model.ActivityPermission;

import java.util.List;

@Service
public class ActivityPermissionServiceImpl implements ActivityPermissionService {

    @Autowired
    private ActivityPermissionRepository activityPermissionRepository;

    @Transactional
    @Override
    public List<ActivityPermission> get() {
        try {
            return activityPermissionRepository.findAll();
        } catch (Exception e){
            e.printStackTrace();
            throw e;
        }

    }

    @Transactional
    @Override
    public ActivityPermission get(int id) {
        try {
            return activityPermissionRepository.getOne(id);
        } catch (Exception e){
            e.printStackTrace();
            throw e;
        }
    }

    @Transactional
    @Override
    public void save(ActivityPermission activityPermission) {
        try {
            activityPermissionRepository.save(activityPermission);
        } catch (Exception e){
            e.printStackTrace();
            throw e;
        }
    }

    @Transactional
    @Override
    public void delete(int id) {
        try {
            activityPermissionRepository.deleteById(id);
        } catch (Exception e){
            e.printStackTrace();
            throw e;
        }
    }

}

