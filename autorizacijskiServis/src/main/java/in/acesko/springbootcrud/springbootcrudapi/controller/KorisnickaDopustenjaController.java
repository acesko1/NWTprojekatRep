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


import in.acesko.springbootcrud.springbootcrudapi.model.KorisnickaDopustenja;
import in.acesko.springbootcrud.springbootcrudapi.service.KorisnickaDopustenjaService;

@RestController
@RequestMapping("/api")
public class KorisnickaDopustenjaController {

	@Autowired
	private KorisnickaDopustenjaService korisnickaDopustenjaService;
	
	@GetMapping("/korisnickaDopustenja")
	public List<KorisnickaDopustenja> get(){
		return  korisnickaDopustenjaService.get();
	}
	
	@PostMapping("/korisnickaDopustenja")	
	public KorisnickaDopustenja save(@RequestBody KorisnickaDopustenja korisnickaDopustenjaObj ) {
		 korisnickaDopustenjaService.save(korisnickaDopustenjaObj);
		return korisnickaDopustenjaObj;
	}
	
	@GetMapping("/korisnickaDopustenja/{id}")
	public KorisnickaDopustenja get(@PathVariable int id) {
		KorisnickaDopustenja korisnickaDopustenjaObj =  korisnickaDopustenjaService.get(id);
		if(korisnickaDopustenjaObj == null) {
			throw new RuntimeException("Korisnička dopuštenja sa id-om:"+id+"nisu pronađena");
		}
		return korisnickaDopustenjaObj;
	}
	@DeleteMapping("/korisnickaDopustenja/{id}")
	public String delete(@PathVariable int id) {
		 korisnickaDopustenjaService.delete(id);
		return "Korisnička dopuštenja su obrisana sa id-om:"+id;
	}
	@PutMapping("/korisnickaDopustenja")
	public KorisnickaDopustenja update(@RequestBody KorisnickaDopustenja korisnickaDopustenjaObj) {
		 korisnickaDopustenjaService.save(korisnickaDopustenjaObj);
		return korisnickaDopustenjaObj;
	}
	@RequestMapping(value = "/korisnickaDopustenja", method = RequestMethod.GET)
	public KorisnickaDopustenja firstPage() {

		KorisnickaDopustenja korisnickaDopustenja = new KorisnickaDopustenja();
		korisnickaDopustenja.setDopustenjaID(1);
		korisnickaDopustenja.setKorisnickaDopustenjaID(1);
		korisnickaDopustenja.setUlogaID(1);

		return korisnickaDopustenja;
	}
	
}
