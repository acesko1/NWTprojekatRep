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
        try {
            return permissionRepository.findAll();
        } catch (Exception e){
            e.printStackTrace();
            throw e;
        }

    }

    @Transactional
    @Override
    public Permission get(int id) {
        try {
            return permissionRepository.getOne(id);
        } catch (Exception e){
            e.printStackTrace();
            throw e;
        }
    }

    @Transactional
    @Override
    public void save(Permission permission) {
        try {
            permissionRepository.save(permission);
        } catch (Exception e){
            e.printStackTrace();
            throw e;
        }
    }

    @Transactional
    @Override
    public void delete(int id) {
        try {
            permissionRepository.deleteById(id);
        } catch (Exception e){
            e.printStackTrace();
            throw e;
        }
    }

}
