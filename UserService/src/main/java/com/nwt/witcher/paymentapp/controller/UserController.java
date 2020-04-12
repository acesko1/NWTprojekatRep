package com.nwt.witcher.paymentapp.controller;

import java.util.List;

import com.nwt.witcher.paymentapp.model.UserRole;
import com.nwt.witcher.paymentapp.service.UserRoleService;
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

import com.nwt.witcher.paymentapp.model.User;
import com.nwt.witcher.paymentapp.service.UserService;

@RestController
@RequestMapping("/api")
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    private UserRoleService userRoleService;

    @GetMapping("/user")
    public ResponseEntity<?> get() {
        try {
            List<User> users = userService.get();
            return ResponseEntity.ok(users);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.toString());
        }
    }

    @PostMapping("/user")
    public ResponseEntity<?> save(@RequestBody User user) {
        try {
            userService.save(user);
            return ResponseEntity.ok(user);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.toString());
        }
    }

    @GetMapping("/user/{id}")
    public ResponseEntity<?>  get(@PathVariable int id) {
        try {
            User user = userService.get(id);
            return ResponseEntity.ok(user);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.toString());
        }
    }

    @DeleteMapping("/user/{id}")
    public ResponseEntity<String> delete(@PathVariable Integer id) {
        try {
            userService.delete(id);
            return ResponseEntity.ok("User with id " + id.toString() + " successfully deleted");
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.toString());
        }
    }

    @PutMapping("/user")
    public ResponseEntity<?> update(@RequestBody User user) {
        try {
            userService.save(user);
            return ResponseEntity.ok(user);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.toString());
        }
    }

    @PostMapping("/user/{userId}/role/{roleId}")
    public ResponseEntity<String> addUserToRole(@PathVariable int userId, @PathVariable int roleId) {
        try {
            userRoleService.addUserToRole(userId, roleId);
            return ResponseEntity.ok("User added to role successfully");
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.toString());
        }
    }
}
