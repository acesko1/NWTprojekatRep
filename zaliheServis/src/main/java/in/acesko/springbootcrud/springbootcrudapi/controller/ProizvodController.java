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

import in.acesko.springbootcrud.springbootcrudapi.model.Proizvod;
import in.acesko.springbootcrud.springbootcrudapi.service.ProizvodService;

@RestController
@RequestMapping("/api")
public class ProizvodController {

	@Autowired
	private ProizvodService proizvodService;
	
	@GetMapping("/proizvod")
	public List<Proizvod> get(){
		return proizvodService.get();
	}
	
	@PostMapping("/proizvod")	
	public Proizvod save(@RequestBody Proizvod proizvodObj ) {
		proizvodService.save(proizvodObj);
		return proizvodObj;
	}
	
	@GetMapping("/proizvod/{id}")
	public Proizvod get(@PathVariable int id) {
		Proizvod proizvodObj = proizvodService.get(id);
		if(proizvodObj == null) {
			throw new RuntimeException("Proizvod sa id-om:"+id+"nije pronađen");
		}
		return proizvodObj;
	}
	@DeleteMapping("/proizvod/{id}")
	public String delete(@PathVariable int id) {
		proizvodService.delete(id);
		return "Proizvod je obrisan sa id-om:"+id;
	}
	@PutMapping("/proizvod")
	public Proizvod update(@RequestBody Proizvod proizvodObj) {
		proizvodService.save(proizvodObj);
		return proizvodObj;
	}
//	@RequestMapping(value = "/proizvod", method = RequestMethod.GET)
//	public Proizvod firstPage() {
//
//		Proizvod proizvod = new Proizvod();
//		proizvod.setCijena(10.00);
//		proizvod.setNaziv("Proizvod");
//		proizvod.setProizvodID(1);
//		proizvod.setRaspolozivaKolicina(100);
//
//		return proizvod;
//	}
	
}
