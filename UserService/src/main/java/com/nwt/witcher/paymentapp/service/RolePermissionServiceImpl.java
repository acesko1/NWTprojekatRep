package com.nwt.witcher.paymentapp.service;

import com.nwt.witcher.paymentapp.model.*;
import com.nwt.witcher.paymentapp.repository.PermissionRepository;
import com.nwt.witcher.paymentapp.repository.RolePermissionRepository;
import com.nwt.witcher.paymentapp.repository.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class RolePermissionServiceImpl implements RolePermissionService {

    @Autowired
    private RolePermissionRepository rolePermissionRepository;
    @Autowired
    private RoleRepository roleRepository;
    @Autowired
    private PermissionRepository permissionRepository;

    @Transactional
    @Override
    public List<RolePermission> get() {
        try {
            return rolePermissionRepository.findAll();
        } catch (Exception e){
            e.printStackTrace();
            throw e;
        }
    }

    @Transactional
    @Override
    public RolePermission get(int id) {
        try {
            return rolePermissionRepository.getOne(id);
        } catch (Exception e){
            e.printStackTrace();
            throw e;
        }
    }

    @Transactional
    @Override
    public void save(RolePermission rolePermission) {
        try {
            rolePermissionRepository.save(rolePermission);
        } catch (Exception e){
            e.printStackTrace();
            throw e;
        }
    }

    @Transactional
    @Override
    public void delete(int id) {
        try {
            rolePermissionRepository.deleteById(id);
        } catch (Exception e){
            e.printStackTrace();
            throw e;
        }
    }

    @Transactional
    @Override
    public void addPermissionToRole(int roleId, int permissionId) {
        try {
            Role role = roleRepository.getOne(roleId);
            Permission permission = permissionRepository.getOne(permissionId);
            RolePermission rolePermission = new RolePermission();
            rolePermission.setPermission(permission);
            rolePermission.setPermissionId(permissionId);
            rolePermission.setRole(role);
            rolePermission.setRoleId(roleId);
        } catch (Exception e) {
            e.printStackTrace();
            throw e;
        }
    }

}
