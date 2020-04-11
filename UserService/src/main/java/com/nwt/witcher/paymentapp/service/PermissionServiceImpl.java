package com.nwt.witcher.paymentapp.service;

import com.nwt.witcher.paymentapp.repository.PermissionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.nwt.witcher.paymentapp.model.Permission;
import java.util.List;

@Service
public class PermissionServiceImpl implements PermissionService {

	@Autowired
	private PermissionRepository permissionRepository;
	
	@Transactional
	@Override
	public List<Permission> get() {
		return permissionRepository.findAll();
	}

	@Transactional
	@Override
	public Permission get(int id) {
	return permissionRepository.getOne(id);
	}

	@Transactional
	@Override
	public void save(Permission permission) {
		permissionRepository.save(permission);
	}

	@Transactional
	@Override
	public void delete(int id) {
		permissionRepository.deleteById(id);
	}

}
