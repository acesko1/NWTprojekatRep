package com.nwt.witcher.paymentapp.repository;

import com.nwt.witcher.paymentapp.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {
}
