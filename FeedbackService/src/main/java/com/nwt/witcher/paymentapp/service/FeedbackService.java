package com.nwt.witcher.paymentapp.service;

import java.util.List;
import com.nwt.witcher.paymentapp.model.Feedback;

public interface FeedbackService {
	
	List<Feedback> get();
	Feedback get(int id);
	void save(Feedback feedback);
	void delete(int id);
}
