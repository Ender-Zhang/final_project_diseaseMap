package com.example.springbootdemo.dao;


import com.example.springbootdemo.bean.TransmissionMode;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface TransmissionModesRepository extends JpaRepository<TransmissionMode, Long>{

    //默认提供了Optional<User> findById(Long id);

//    Time findByName(String username);

//    @Query("select d.name from Disease d where d.id=?1")
//    Page<Disease> getNameById(Integer Id, Pageable pageable);

    @Query("select d.name from TransmissionMode d where d.id=?1")
    String getTMById(Integer Id);


//    Time findById(String Id);



}
