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

import com.nwt.witcher.paymentapp.model.Feedback;
import com.nwt.witcher.paymentapp.service.FeedbackService;

@RestController
@RequestMapping("/api")
public class FeedbackController {

	@Autowired
	private FeedbackService feedbackService;
	
	@GetMapping("/feedback")
	public List<Feedback> get(){
		return feedbackService.get();
	}
	
	@PostMapping("/feedback")	
	public Feedback save(@RequestBody Feedback feedbackObj ) {
		feedbackService.save(feedbackObj);
		return feedbackObj;
	}
	
	@GetMapping("/feedback/{id}")
	public Feedback get(@PathVariable int id) {
		Feedback feedbackObj = feedbackService.get(id);
		if(feedbackObj == null) {
			throw new RuntimeException("Povratna informacija/feedback sa id-om:"+id+"nije pronađen");
		}
		return feedbackObj;
	}
	@DeleteMapping("/feedback/{id}")
	public String delete(@PathVariable int id) {
		feedbackService.delete(id);
		return "Povratna informacija/feedback je obrisan sa id-om:"+id;
	}
	@PutMapping("/feedback")
	public Feedback update(@RequestBody Feedback feedbackObj) {
		feedbackService.save(feedbackObj);
		return feedbackObj;
	}
//	@RequestMapping(value = "/feedback", method = RequestMethod.GET)
//	public Feedback firstPage() {
//
//		Feedback fed = new Feedback();
//		fed.setFeedbackID(1);
//		fed.setKorisnikID(1);
//		fed.setNaplataID(2);
//		fed.setOcjena(5);
//		fed.setKomentar("Zadovoljan korisnik");
//
//		return fed;
//	}

	
}



