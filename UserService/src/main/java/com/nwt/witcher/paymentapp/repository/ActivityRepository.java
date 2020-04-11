package com.nwt.witcher.paymentapp.repository;

import com.nwt.witcher.paymentapp.model.Activity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ActivityRepository extends JpaRepository<Activity,Integer> {
}
