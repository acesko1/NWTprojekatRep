package com.nwt.witcher.paymentapp.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
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
	public List<Permission> get(){
		return permissionService.get();
	}
	
	@PostMapping("/permission")	
	public Permission save(@RequestBody Permission permission) {
		permissionService.save(permission);
		return permission;
	}
	
	@GetMapping("/permission/{id}")
	public Permission get(@PathVariable int id) {
		Permission permission = permissionService.get(id);
		if(permission == null) {
			throw new RuntimeException("Dopuštenja sa id-om:"+id+"nisu pronađena");
		}
		return permission;
	}
	@DeleteMapping("/permission/{id}")
	public String delete(@PathVariable int id) {
		permissionService.delete(id);
		return "Dopuštenja su obrisana sa id-om:"+id;
	}
	@PutMapping("/permission")
	public Permission update(@RequestBody Permission permission) {
		permissionService.save(permission);
		return permission;
	}
//	@RequestMapping(value = "/permission", method = RequestMethod.GET)
//	public Dopustenja firstPage() {
//
//		Dopustenja permission = new Dopustenja();
//		permission.setAzuriranaU(null);
//		permission.setKreiranaU(null);
//		permission.setDopustenjaID(1);
//		permission.setNaziv("Naziv permission");
//		return permission;
//	}
	
}
