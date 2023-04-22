package com.example.springbootdemo.service;

import com.example.springbootdemo.bean.Disease;
import com.example.springbootdemo.dao.DiseaseRepository;
import com.example.springbootdemo.dao.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.NoSuchElementException;
import java.util.Optional;

@Service("diseaseService")
public class DiseaseService {
    @Autowired
    private DiseaseRepository DiseaseRepository;

    public Disease getUserByID(Long id){
        return DiseaseRepository.findById(id).get();
    }

    public Disease getByName(String username) {
        return DiseaseRepository.findByName(username);
    }


    public String getNameById(Integer id){
        return DiseaseRepository.getNameById(id);
    }



}
