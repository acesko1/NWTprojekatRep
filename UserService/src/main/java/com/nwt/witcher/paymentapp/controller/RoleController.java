package com.nwt.witcher.paymentapp.controller;

import java.util.List;

import com.nwt.witcher.paymentapp.model.User;
import com.nwt.witcher.paymentapp.service.RolePermissionService;
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

import com.nwt.witcher.paymentapp.model.Role;
import com.nwt.witcher.paymentapp.service.RoleService;

@RestController
@RequestMapping("/api")
public class RoleController {

    @Autowired
    private RoleService roleService;
    @Autowired
    private RolePermissionService rolePermissionService;

    @GetMapping("/role")
    public ResponseEntity<?> get() {
        try {
            List<Role> roles = roleService.get();
            return ResponseEntity.ok(roles);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.toString());
        }
    }

    @PostMapping("/role")
    public ResponseEntity<?> save(@RequestBody Role role) {
        try {
            roleService.save(role);
            return ResponseEntity.ok(role);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.toString());
        }
    }

    @GetMapping("/role/{id}")
    public ResponseEntity<?> get(@PathVariable int id) {
        try {
            Role role = roleService.get(id);
            return ResponseEntity.ok(role);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.toString());
        }
    }

    @DeleteMapping("/role/{id}")
    public ResponseEntity<String> delete(@PathVariable Integer id) {
        try {
            roleService.delete(id);
            return ResponseEntity.ok("Role with id " + id.toString() + " successfully deleted.");
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.toString());
        }
    }

    @PutMapping("/role")
    public ResponseEntity<?> update(@RequestBody Role role) {
        try {
            roleService.save(role);
            return ResponseEntity.ok(role);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.toString());
        }
    }

    @PostMapping("/role/{roleId}/permission/{permissionId}")
    public ResponseEntity<String> addPermissionToRole(@PathVariable int roleId, @PathVariable int permissionId) {
        try {
            rolePermissionService.addPermissionToRole(roleId, permissionId);
            return ResponseEntity.ok("Permission added to role successfully");
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.toString());
        }
    }


}
