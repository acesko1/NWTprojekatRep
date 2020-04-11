package com.nwt.witcher.paymentapp.service;

import java.util.List;
import com.nwt.witcher.paymentapp.model.ActivityPermission;

public interface ActivityPermissionService {
	
	List<ActivityPermission> get();
	ActivityPermission get(int id);
	void save(ActivityPermission activityPermission);
	void delete(int id);
}
