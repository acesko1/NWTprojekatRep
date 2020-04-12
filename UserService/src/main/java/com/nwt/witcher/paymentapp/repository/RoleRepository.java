package com.nwt.witcher.paymentapp.repository;

import com.nwt.witcher.paymentapp.model.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleRepository extends JpaRepository<Role, Integer> {
}
