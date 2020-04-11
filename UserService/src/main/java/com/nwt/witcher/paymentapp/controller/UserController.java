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
	public List<User> get(){
		return userService.get();
	}
	
	@PostMapping("/user")
	public User save(@RequestBody User user) {
		userService.save(user);
		return user;
	}
	
	@GetMapping("/user/{id}")
	public User get(@PathVariable int id) {
		User userObj = userService.get(id);
		if(userObj == null) {
			throw new RuntimeException("Korisnik sa id-om:"+id+"nije pronađen");
		}
		return userObj;
	}
	@DeleteMapping("/user/{id}")
	public String delete(@PathVariable int id) {
		userService.delete(id);
		return "Korisnik je obrisan sa id-om:"+id;
	}
	@PutMapping("/user")
	public User update(@RequestBody User user) {
		userService.save(user);
		return user;
	}

	@PostMapping("/user/{userId}/role/{roleId}")
	public ResponseEntity<String> addUserToRole (@PathVariable int userId,@PathVariable int roleId){
		try {
			userRoleService.addUserToRole(userId,roleId);
			return ResponseEntity.ok("User added to role successfully");
		} catch (Exception e){
			return ResponseEntity.badRequest().body(e.toString());
		}
	}

//	@RequestMapping(value = "/korisnik", method = RequestMethod.GET)
//	public Korisnik firstPage() {
//
//		Korisnik kor = new Korisnik();
//		kor.setKorisnikID(1);
//		kor.setBrojKartice("12345678");
//		kor.setGodine(20);
//		kor.setIme("Ime");
//		kor.setPrezime("Prezime");
//
//		return kor;
//	}

	
}
