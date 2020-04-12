package com.nwt.witcher.paymentapp.service;

import com.nwt.witcher.paymentapp.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.nwt.witcher.paymentapp.model.User;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Transactional
    @Override
    public List<User> get() {
        try{
            return userRepository.findAll();
        } catch (Exception e) {
            e.printStackTrace();
            throw e;
        }
    }

    @Transactional
    @Override
    public User get(int id) {
        try{
            return userRepository.getOne(id);
        } catch (Exception e) {
            e.printStackTrace();
            throw e;
        }
    }

    @Transactional
    @Override
    public void save(User user) {
        try {
            userRepository.save(user);
        } catch (Exception e){
            e.printStackTrace();
            throw e;
        }
    }

    @Transactional
    @Override
    public void delete(int id) {
        try {
            userRepository.deleteById(id);
        } catch (Exception e){
            e.printStackTrace();
            throw e;
        }
    }

}