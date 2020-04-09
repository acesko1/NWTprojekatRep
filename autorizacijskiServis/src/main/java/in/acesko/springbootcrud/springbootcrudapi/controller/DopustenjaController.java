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

import in.acesko.springbootcrud.springbootcrudapi.model.Dopustenja;

import in.acesko.springbootcrud.springbootcrudapi.service.DopustenjaService;

@RestController
@RequestMapping("/api")
public class DopustenjaController {

	@Autowired
	private DopustenjaService dopustenjaService;
	
	@GetMapping("/dopustenja")
	public List<Dopustenja> get(){
		return dopustenjaService.get();
	}
	
	@PostMapping("/dopustenja")	
	public Dopustenja save(@RequestBody Dopustenja dopustenjaObj ) {
		dopustenjaService.save(dopustenjaObj);
		return dopustenjaObj;
	}
	
	@GetMapping("/dopustenja/{id}")
	public Dopustenja get(@PathVariable int id) {
		Dopustenja dopustenjaObj = dopustenjaService.get(id);
		if(dopustenjaObj == null) {
			throw new RuntimeException("Dopuštenja sa id-om:"+id+"nisu pronađena");
		}
		return dopustenjaObj;
	}
	@DeleteMapping("/dopustenja/{id}")
	public String delete(@PathVariable int id) {
		dopustenjaService.delete(id);
		return "Dopuštenja su obrisana sa id-om:"+id;
	}
	@PutMapping("/dopustenja")
	public Dopustenja update(@RequestBody Dopustenja dopustenjaObj) {
		dopustenjaService.save(dopustenjaObj);
		return dopustenjaObj;
	}
	@RequestMapping(value = "/dopustenja", method = RequestMethod.GET)
	public Dopustenja firstPage() {

		Dopustenja dopustenja = new Dopustenja();
		dopustenja.setAzuriranaU(null);
		dopustenja.setKreiranaU(null);
		dopustenja.setDopustenjaID(1);
		dopustenja.setNaziv("Naziv dopustenja");
		return dopustenja;
	}
	
}
