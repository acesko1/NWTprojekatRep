package com.nwt.witcher.paymentapp.service;

import com.nwt.witcher.paymentapp.repository.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.nwt.witcher.paymentapp.model.Role;

import java.util.List;

@Service
public class RoleServiceImpl implements RoleService {

    @Autowired
    private RoleRepository roleRepository;

    @Transactional
    @Override
    public List<Role> get() {
        return roleRepository.findAll();
    }

    @Transactional
    @Override
    public Role get(int id) {
        return roleRepository.getOne(id);
    }

    @Transactional
    @Override
    public void save(Role role) {
        roleRepository.save(role);
    }

    @Transactional
    @Override
    public void delete(int id) {
        roleRepository.deleteById(id);
    }

}