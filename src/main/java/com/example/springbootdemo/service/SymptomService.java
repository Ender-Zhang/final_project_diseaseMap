package com.example.springbootdemo.service;




import com.example.springbootdemo.bean.Symptom;
import com.example.springbootdemo.dao.SymptomRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.NoSuchElementException;
import java.util.Optional;

@Service("symptomService")
public class SymptomService {
    @Autowired
    private SymptomRepository SymptomRepository;

    public void deleteUserById(Long id) {
        SymptomRepository.deleteById(id);
    }
}
