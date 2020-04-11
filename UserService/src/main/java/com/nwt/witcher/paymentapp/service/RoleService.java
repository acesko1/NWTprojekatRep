package com.nwt.witcher.paymentapp.service;

import java.util.List;
import com.nwt.witcher.paymentapp.model.Role;

public interface RoleService {
	
	List<Role> get();
	Role get(int id);
	void save(Role role);
	void delete(int id);
}
