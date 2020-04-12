package com.nwt.witcher.paymentapp.repository;

import com.nwt.witcher.paymentapp.model.RolePermission;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RolePermissionRepository extends JpaRepository<RolePermission, Integer> {
}
