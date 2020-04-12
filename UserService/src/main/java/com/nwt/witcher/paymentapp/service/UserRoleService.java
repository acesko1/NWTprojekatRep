package com.nwt.witcher.paymentapp.service;

import java.util.List;

import com.nwt.witcher.paymentapp.model.UserRole;

public interface UserRoleService {

    List<UserRole> get();

    UserRole get(int id);

    void save(UserRole userRole);

    void delete(int id);

    void addUserToRole(int userId, int roleId);
}
