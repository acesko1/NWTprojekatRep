package com.nwt.witcher.paymentapp.service;

import java.util.List;
import com.nwt.witcher.paymentapp.model.User;

public interface UserService {
	
	List<User> get();
	User get(int id);
	void save(User user);
	void delete(int id);
}
