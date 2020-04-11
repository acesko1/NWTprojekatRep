package com.nwt.witcher.paymentapp.service;

import com.nwt.witcher.paymentapp.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.nwt.witcher.paymentapp.model.Product;
import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {

	@Autowired
	private ProductRepository productRepository;
	
	@Transactional
	@Override
	public List<Product> get() {
		return productRepository.findAll();
	}

	@Transactional
	@Override
	public Product get(int id) {
	return productRepository.getOne(id);
	}

	@Transactional
	@Override
	public void save(Product product) {
		productRepository.save(product);
	}

	@Transactional
	@Override
	public void delete(int id) {
		productRepository.deleteById(id);
	}

}
