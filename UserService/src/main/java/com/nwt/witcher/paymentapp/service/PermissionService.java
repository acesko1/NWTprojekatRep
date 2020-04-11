package com.nwt.witcher.paymentapp.service;

import java.util.List;
import com.nwt.witcher.paymentapp.model.Permission;

public interface PermissionService {
	
	List<Permission> get();
	Permission get(int id);
	void save(Permission permission);
	void delete(int id);
}
