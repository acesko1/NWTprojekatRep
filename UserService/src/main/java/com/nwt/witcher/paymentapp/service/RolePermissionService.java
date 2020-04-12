package com.nwt.witcher.paymentapp.service;

import java.util.List;

import com.nwt.witcher.paymentapp.model.RolePermission;

public interface RolePermissionService {

    List<RolePermission> get();

    RolePermission get(int id);

    void save(RolePermission rolePermission);

    void delete(int id);

    void addPermissionToRole(int roleId, int permissionId);
}

