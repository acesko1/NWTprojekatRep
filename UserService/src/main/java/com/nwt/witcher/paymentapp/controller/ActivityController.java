package com.nwt.witcher.paymentapp.controller;


import java.util.List;

import com.nwt.witcher.paymentapp.model.Permission;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nwt.witcher.paymentapp.model.Activity;
import com.nwt.witcher.paymentapp.service.ActivityService;

@RestController
@RequestMapping("/api")
public class ActivityController {

    @Autowired
    private ActivityService activityService;

    @GetMapping("/activity")
    public ResponseEntity<?> get() {
        try {
            List<Activity> activities = activityService.get();
            return ResponseEntity.ok(activities);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.toString());
        }
    }

    @PostMapping("/activity")
    public ResponseEntity<?> save(@RequestBody Activity activity) {
        try {
            activityService.save(activity);
            return ResponseEntity.ok(activity);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.toString());
        }
    }

    @GetMapping("/activity/{id}")
    public ResponseEntity<?> get(@PathVariable int id) {
        try {
            Activity activity = activityService.get(id);
            return ResponseEntity.ok(activity);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.toString());
        }
    }

    @DeleteMapping("/activity/{id}")
    public ResponseEntity<String> delete(@PathVariable Integer id) {
        try {
            activityService.delete(id);
            return ResponseEntity.ok("Activity with id " + id.toString() + " successfully deleted.");
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.toString());
        }
    }

    @PutMapping("/activity")
    public ResponseEntity<?> update(@RequestBody Activity activity) {
        try {
            activityService.save(activity);
            return ResponseEntity.ok(activity);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.toString());
        }
    }
}
