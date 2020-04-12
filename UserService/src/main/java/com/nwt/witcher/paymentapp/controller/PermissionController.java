package com.nwt.witcher.paymentapp.controller;

import java.util.List;

import com.nwt.witcher.paymentapp.model.Role;
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

import com.nwt.witcher.paymentapp.model.Permission;

import com.nwt.witcher.paymentapp.service.PermissionService;

@RestController
@RequestMapping("/api")
public class PermissionController {

    @Autowired
    private PermissionService permissionService;

    @GetMapping("/permission")
    public ResponseEntity<?> get() {
        try {
            List<Permission> permissions = permissionService.get();
            return ResponseEntity.ok(permissions);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.toString());
        }
    }

    @PostMapping("/permission")
    public ResponseEntity<?> save(@RequestBody Permission permission) {
        try {
            permissionService.save(permission);
            return ResponseEntity.ok(permission);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.toString());
        }
    }

    @GetMapping("/permission/{id}")
    public ResponseEntity<?> get(@PathVariable int id) {
        try {
            Permission permission = permissionService.get(id);
            return ResponseEntity.ok(permission);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.toString());
        }
    }

    @DeleteMapping("/permission/{id}")
    public ResponseEntity<String> delete(@PathVariable Integer id) {
        try {
            permissionService.delete(id);
            return ResponseEntity.ok("Permission with id " + id.toString() + " successfully deleted.");
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.toString());
        }
    }

    @PutMapping("/permission")
    public ResponseEntity<?> update(@RequestBody Permission permission) {
        try {
            permissionService.save(permission);
            return ResponseEntity.ok(permission);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.toString());
        }
    }

}
