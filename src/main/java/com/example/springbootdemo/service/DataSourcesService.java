package com.example.springbootdemo.service;



import com.example.springbootdemo.bean.Time;
import com.example.springbootdemo.dao.DataSourcesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.NoSuchElementException;
import java.util.Optional;

@Service("dataSourcesService")
public class DataSourcesService {
    @Autowired
    private DataSourcesRepository DataSourcesRepository;

    public String findDataSourcesId(Integer id) {
        System.out.println(DataSourcesRepository.getDataSourcesById(id));
        return DataSourcesRepository.getDataSourcesById(id);

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
