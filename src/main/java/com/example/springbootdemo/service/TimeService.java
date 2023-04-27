package com.example.springbootdemo.service;



import com.example.springbootdemo.bean.Time;
import com.example.springbootdemo.dao.TimeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.NoSuchElementException;
import java.util.Optional;

@Service("timeService")
public class TimeService {
    @Autowired
    private TimeRepository TimeRepository;

    public String findTimeById(Integer id) {
        return TimeRepository.getTimeById(id);

}

}
