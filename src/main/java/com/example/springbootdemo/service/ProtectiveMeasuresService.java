package com.example.springbootdemo.service;



import com.example.springbootdemo.bean.Time;
import com.example.springbootdemo.dao.ProtectiveMeasuresRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.NoSuchElementException;
import java.util.Optional;

@Service("protectiveMeasuresService")
public class ProtectiveMeasuresService {
    @Autowired
    private ProtectiveMeasuresRepository ProtectiveMeasuresRepository;

    public ArrayList<String> findProtectiveMeasuresId(Integer id) {
        ArrayList<String> resultArray = new ArrayList<String>();
        resultArray.add(ProtectiveMeasuresRepository.getProtectiveMeasuresById(id));
        resultArray.add(ProtectiveMeasuresRepository.getDescriptionById(id));
        return resultArray;
    }
}




