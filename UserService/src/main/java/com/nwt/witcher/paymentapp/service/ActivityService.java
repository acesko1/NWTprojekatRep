package com.nwt.witcher.paymentapp.service;

import java.util.List;

import com.nwt.witcher.paymentapp.model.Activity;

public interface ActivityService {

    List<Activity> get();

    Activity get(int id);

    void save(Activity activity);

    void delete(int id);
}
