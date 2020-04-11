package com.nwt.witcher.paymentapp.repository;


import com.nwt.witcher.paymentapp.model.ActivityPermission;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ActivityPermissionRepository extends JpaRepository<ActivityPermission,Integer> {
}
