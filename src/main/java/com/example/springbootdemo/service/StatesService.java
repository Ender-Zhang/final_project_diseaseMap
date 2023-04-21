package com.example.springbootdemo.service;


import com.example.springbootdemo.bean.States;
import com.example.springbootdemo.dao.StatesRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;


@Service("statesService")
public class StatesService {
    @Autowired
    private StatesRepository StatesRepository;

    public States getByID(Long id){
        return StatesRepository.findById(id).get();
    }

//    public Admin getByName(String username) {
//        return AdminRepository.findByName(username);
//    }

    public Page<States> getAllStates(){
        Pageable pageable = PageRequest.of(0, 80);
        return StatesRepository.getAllStates(pageable);
    }

    public States getByName(String name){

        return StatesRepository.findByName(name);
    }


}
