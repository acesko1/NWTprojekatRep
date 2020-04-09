package in.acesko.springbootcrud.springbootcrudapi.controller;


import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import in.acesko.springbootcrud.springbootcrudapi.model.Aktivnosti;
import in.acesko.springbootcrud.springbootcrudapi.service.AktivnostiService;

@RestController
@RequestMapping("/api")
public class AktivnostiController {

	@Autowired
	private AktivnostiService aktivnostiService;
	
	@GetMapping("/aktivnosti")
	public List<Aktivnosti> get(){
		return aktivnostiService.get();
	}
	
	@PostMapping("/aktivnosti")	
	public Aktivnosti save(@RequestBody Aktivnosti aktivnostiObj ) {
		aktivnostiService.save(aktivnostiObj);
		return aktivnostiObj;
	}
	
	@GetMapping("/aktivnosti/{id}")
	public Aktivnosti get(@PathVariable int id) {
		Aktivnosti aktivnostiObj = aktivnostiService.get(id);
		if(aktivnostiObj == null) {
			throw new RuntimeException("Aktivnost sa id-om:"+id+"nije pronađena");
		}
		return aktivnostiObj;
	}
	@DeleteMapping("/aktivnosti/{id}")
	public String delete(@PathVariable int id) {
		aktivnostiService.delete(id);
		return "Aktivnost je obrisana sa id-om:"+id;
	}
	@PutMapping("/aktivnosti")
	public Aktivnosti update(@RequestBody Aktivnosti aktivnostiObj) {
		aktivnostiService.save(aktivnostiObj);
		return aktivnostiObj;
	}
	@RequestMapping(value = "/aktivnosti", method = RequestMethod.GET)
	public Aktivnosti firstPage() {

		Aktivnosti aktivnost = new Aktivnosti();
		aktivnost.setAktivnostiID(1);
		aktivnost.setMetoda("...");
		aktivnost.setURL("url");
		aktivnost.setURLRegex("regex");

		return aktivnost;
	}
	
}
