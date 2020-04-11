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
		return activityPermissionRepository.findAll();
	}

	@Transactional
	@Override
	public ActivityPermission get(int id) {
	return activityPermissionRepository.getOne(id);
	}

	@Transactional
	@Override
	public void save(ActivityPermission activityPermission) {
		activityPermissionRepository.save(activityPermission);
	}

	@Transactional
	@Override
	public void delete(int id) {
		activityPermissionRepository.deleteById(id);
	}

}

