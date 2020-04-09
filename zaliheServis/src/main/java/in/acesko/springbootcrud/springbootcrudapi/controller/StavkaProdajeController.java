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

import in.acesko.springbootcrud.springbootcrudapi.model.StavkaProdaje;
import in.acesko.springbootcrud.springbootcrudapi.service.StavkaProdajeService;

@RestController
@RequestMapping("/api")
public class StavkaProdajeController {

	@Autowired
	private StavkaProdajeService stavkaProdajeService;
	
	@GetMapping("/stavkaProdaje")
	public List<StavkaProdaje> get(){
		return stavkaProdajeService.get();
	}
	
	@PostMapping("/stavkaProdaje")	
	public StavkaProdaje save(@RequestBody StavkaProdaje stavkaProdajeObj) {
		stavkaProdajeService.save(stavkaProdajeObj);
		return stavkaProdajeObj;
	}
	
	@GetMapping("/stavkaProdaje/{id}")
	public StavkaProdaje get(@PathVariable int id) {
		StavkaProdaje stavkaProdajeObj = stavkaProdajeService.get(id);
		if(stavkaProdajeObj == null) {
			throw new RuntimeException("Stavka prodaje sa id-om:"+id+"nije pronađena");
		}
		return stavkaProdajeObj;
	}
	@DeleteMapping("/stavkaProdaje/{id}")
	public String delete(@PathVariable int id) {
		stavkaProdajeService.delete(id);
		return "Stavka prodaje je obrisan sa id-om:"+id;
	}
	@PutMapping("/stavkaProdaje")
	public StavkaProdaje update(@RequestBody StavkaProdaje stavkaProdajeObj) {
		stavkaProdajeService.save(stavkaProdajeObj);
		return stavkaProdajeObj;
	}
//	@RequestMapping(value = "/stavkaProdaje", method = RequestMethod.GET)
//	public StavkaProdaje firstPage() {
//
//		StavkaProdaje stavkaProdaje = new StavkaProdaje();
//		stavkaProdaje.setKolicina(50);
//		stavkaProdaje.setProizvodID(1);
//		stavkaProdaje.setStavkaProdajeID(1);
//		stavkaProdaje.setUkupnaCijena(500.00);
//
//		return stavkaProdaje;
//	}
	
}
