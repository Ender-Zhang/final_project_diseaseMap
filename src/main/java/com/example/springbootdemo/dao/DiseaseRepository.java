package com.example.springbootdemo.dao;


import com.example.springbootdemo.bean.Admin;
import com.example.springbootdemo.bean.Disease;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import javax.transaction.Transactional;
import java.util.Optional;

@Repository
public interface DiseaseRepository extends JpaRepository<Disease, Long>{

    //默认提供了Optional<User> findById(Long id);

    Disease findByName(String username);

//    @Query("select d.name from Disease d where d.id=?1")
//    Page<Disease> getNameById(Integer Id, Pageable pageable);

    @Query("select d.name from Disease d where d.id=?1")
    String getNameById(Integer Id);


    Disease findById(String Id);



}