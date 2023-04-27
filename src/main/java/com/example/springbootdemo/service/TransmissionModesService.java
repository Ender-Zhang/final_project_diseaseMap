package com.example.springbootdemo.service;



import com.example.springbootdemo.bean.Time;
import com.example.springbootdemo.dao.TransmissionModesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.NoSuchElementException;
import java.util.Optional;

@Service("transmissionModesService")
public class TransmissionModesService {
    @Autowired
    private TransmissionModesRepository TransmissionModesRepository;

    public String findTMById(Integer id) {
        System.out.println(TransmissionModesRepository.getTMById(id));
        return TransmissionModesRepository.getTMById(id);

    }


//    public Time getByName(String username) {
//        return TimeRepository.findByName(username);
//    }
//
//
//    public String getNameById(Integer id){
//        return TimeRepository.getNameById(id);
//    }



}
