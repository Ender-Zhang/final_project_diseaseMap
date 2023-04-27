package com.example.springbootdemo.dao;


import com.example.springbootdemo.bean.Admin;
import com.example.springbootdemo.bean.Time;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import javax.transaction.Transactional;
import java.util.Optional;

@Repository
public interface TimeRepository extends JpaRepository<Time, Long>{
    @Query("select d.time from Time d where d.id=?1")
    String getTimeById(Integer Id);





}