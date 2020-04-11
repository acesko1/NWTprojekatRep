package com.nwt.witcher.paymentapp.controller;


import java.util.List;
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
	public List<Activity> get(){

		return activityService.get();
	}
	
	@PostMapping("/activity")	
	public Activity save(@RequestBody Activity activity) {
		activityService.save(activity);
		return activity;
	}
	
	@GetMapping("/activity/{id}")
	public Activity get(@PathVariable int id) {
		Activity activity = activityService.get(id);
		if(activity == null) {
			throw new RuntimeException("Aktivnost sa id-om:"+id+"nije pronađena");
		}
		return activity;
	}
	@DeleteMapping("/activity/{id}")
	public String delete(@PathVariable int id) {
		activityService.delete(id);
		return "Aktivnost je obrisana sa id-om:"+id;
	}
	@PutMapping("/activity")
	public Activity update(@RequestBody Activity activity) {
		activityService.save(activity);
		return activity;
	}

//	@RequestMapping(value = "/activity", method = RequestMethod.GET)
//	public Aktivnosti firstPage() {
//
//		Aktivnosti aktivnost = new Aktivnosti();
//		aktivnost.setAktivnostiID(1);
//		aktivnost.setMetoda("...");
//		aktivnost.setURL("url");
//		aktivnost.setURLRegex("regex");
//
//		return aktivnost;
//	}
	
}
