package com.nwt.witcher.paymentapp.service;

import com.nwt.witcher.paymentapp.repository.SalesItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.nwt.witcher.paymentapp.model.SalesItem;

import java.util.List;

@Service
public class SalesItemServiceImpl implements SalesItemService {

    @Autowired
    private SalesItemRepository salesItemRepository;

    @Transactional
    @Override
    public List<SalesItem> get() {
        return salesItemRepository.findAll();
    }

    @Transactional
    @Override
    public SalesItem get(int id) {
        return salesItemRepository.getOne(id);
    }

    @Transactional
    @Override
    public void save(SalesItem salesItem) {
        salesItemRepository.save(salesItem);
    }

    @Transactional
    @Override
    public void delete(int id) {
        salesItemRepository.deleteById(id);
    }

}
