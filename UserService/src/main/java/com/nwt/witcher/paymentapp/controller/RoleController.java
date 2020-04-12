package com.nwt.witcher.paymentapp.controller;

import java.util.List;

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
    public List<Role> get() {
        return roleService.get();
    }

    @PostMapping("/role")
    public Role save(@RequestBody Role roleObj) {
        roleService.save(roleObj);
        return roleObj;
    }

    @GetMapping("/role/{id}")
    public Role get(@PathVariable int id) {
        Role roleObj = roleService.get(id);
        if (roleObj == null) {
            throw new RuntimeException("Rola sa id-om:" + id + "nije pronađena");
        }
        return roleObj;
    }

    @DeleteMapping("/role/{id}")
    public String delete(@PathVariable int id) {
        roleService.delete(id);
        return "Rola je obrisana sa id-om:" + id;
    }

    @PutMapping("/role")
    public Role update(@RequestBody Role roleObj) {
        roleService.save(roleObj);
        return roleObj;
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
//	@RequestMapping(value = "/role", method = RequestMethod.GET)
//	public Role firstPage() {
//
//		Role role = new Role();
//		role.setAzuriranaU(null);
//		role.setKreiranaU(null);
//		role.setNazivRole("Premium korisnik");
//		role.setRolaID(1);
//
//		return role;
//	}


}
