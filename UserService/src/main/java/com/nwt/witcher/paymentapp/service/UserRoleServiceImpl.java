package com.nwt.witcher.paymentapp.service;

import com.nwt.witcher.paymentapp.model.Role;
import com.nwt.witcher.paymentapp.model.User;
import com.nwt.witcher.paymentapp.repository.RoleRepository;
import com.nwt.witcher.paymentapp.repository.UserRepository;
import com.nwt.witcher.paymentapp.repository.UserRoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.nwt.witcher.paymentapp.model.UserRole;

import java.util.List;

@Service
public class UserRoleServiceImpl implements UserRoleService {

    @Autowired
    private UserRoleRepository userRoleRepository;
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private RoleRepository roleRepository;

    @Transactional
    @Override
    public List<UserRole> get() {
        try {
            return userRoleRepository.findAll();
        } catch (Exception e){
            e.printStackTrace();
            throw e;
        }
    }

    @Transactional
    @Override
    public UserRole get(int id) {
        try {
            return userRoleRepository.getOne(id);
        } catch (Exception e){
            e.printStackTrace();
            throw e;
        }
    }

    @Transactional
    @Override
    public void save(UserRole userRole) {
        try {
            userRoleRepository.save(userRole);
        } catch (Exception e){
            e.printStackTrace();
            throw e;
        }
    }

    @Transactional
    @Override
    public void delete(int id) {
        try {
            userRoleRepository.deleteById(id);
        } catch (Exception e) {
            e.printStackTrace();
            throw e;
        }
    }

    @Transactional
    @Override
    public void addUserToRole(int userId, int roleId) {

        try {
            User user = userRepository.getOne(userId);
            Role role = roleRepository.getOne(roleId);
            UserRole userRole = new UserRole();
            userRole.setUser(user);
            userRole.setRole(role);
            userRole.setUserId(userId);
            userRole.setRoleId(roleId);
            userRoleRepository.save(userRole);

        } catch (Exception e) {
            e.printStackTrace();
            throw e;
        }
    }

}
