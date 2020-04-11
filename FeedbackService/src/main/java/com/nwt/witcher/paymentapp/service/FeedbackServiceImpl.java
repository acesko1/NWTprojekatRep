package com.nwt.witcher.paymentapp.service;

import com.nwt.witcher.paymentapp.repository.FeedbackRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.nwt.witcher.paymentapp.model.Feedback;
import java.util.List;

@Service
public class FeedbackServiceImpl implements FeedbackService {

	@Autowired
	private FeedbackRepository feedbackRepository;
	
	@Transactional
	@Override
	public List<Feedback> get() {
		return feedbackRepository.findAll();
	}

	@Transactional
	@Override
	public Feedback get(int id) {
	return feedbackRepository.getOne(id);
	}

	@Transactional
	@Override
	public void save(Feedback feedback) {
		feedbackRepository.save(feedback);
	}

	@Transactional
	@Override
	public void delete(int id) {
		feedbackRepository.deleteById(id);
	}

}
