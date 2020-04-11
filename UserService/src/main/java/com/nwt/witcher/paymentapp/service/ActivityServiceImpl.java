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
		return activityRepository.findAll();
	}

	@Transactional
	@Override
	public Activity get(int id) {
	return activityRepository.getOne(id);
	}

	@Transactional
	@Override
	public void save(Activity activity) {
		activityRepository.save(activity);
	}

	@Transactional
	@Override
	public void delete(int id) {
		activityRepository.deleteById(id);
	}

}
