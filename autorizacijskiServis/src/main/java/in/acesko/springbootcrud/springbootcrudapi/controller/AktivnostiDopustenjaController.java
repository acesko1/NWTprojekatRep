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

import in.acesko.springbootcrud.springbootcrudapi.model.AktivnostiDopustenja;
import in.acesko.springbootcrud.springbootcrudapi.service.AktivnostiDopustenjaService;

@RestController
@RequestMapping("/api")
public class AktivnostiDopustenjaController {

	@Autowired
	private AktivnostiDopustenjaService aktivnostiDopustenjaService;
	
	@GetMapping("/aktivnostiDopustenja")
	public List<AktivnostiDopustenja> get(){
		return aktivnostiDopustenjaService.get();
	}
	
	@PostMapping("/aktivnostiDopustenja")	
	public AktivnostiDopustenja save(@RequestBody AktivnostiDopustenja aktivnostiDopustenjaObj ) {
		aktivnostiDopustenjaService.save(aktivnostiDopustenjaObj);
		return aktivnostiDopustenjaObj;
	}
	
	@GetMapping("/aktivnostiDopustenja/{id}")
	public AktivnostiDopustenja get(@PathVariable int id) {
		AktivnostiDopustenja aktivnostiDopustenjaObj = aktivnostiDopustenjaService.get(id);
		if(aktivnostiDopustenjaObj == null) {
			throw new RuntimeException("Aktivnosti-Dopustenja sa id-om:"+id+"nisu pronađeni");
		}
		return aktivnostiDopustenjaObj;
	}
	@DeleteMapping("/aktivnostiDopustenja/{id}")
	public String delete(@PathVariable int id) {
		aktivnostiDopustenjaService.delete(id);
		return "Aktivnosti-Dopuštenja su obrisani sa id-om:"+id;
	}
	@PutMapping("/aktivnostiDopustenja")
	public AktivnostiDopustenja update(@RequestBody AktivnostiDopustenja aktivnostiDopustenjaObj) {
		aktivnostiDopustenjaService.save(aktivnostiDopustenjaObj);
		return aktivnostiDopustenjaObj;
	}
	@RequestMapping(value = "/aktivnostiDopustenja", method = RequestMethod.GET)
	public AktivnostiDopustenja firstPage() {

		AktivnostiDopustenja aktivnostiDopustenja = new AktivnostiDopustenja();
		aktivnostiDopustenja.setAktivnostiDopustenjaID(1);
		aktivnostiDopustenja.setAktivnostiID(1);
		aktivnostiDopustenja.setDopustenjaID(1);

		return aktivnostiDopustenja;
	}
	
}
