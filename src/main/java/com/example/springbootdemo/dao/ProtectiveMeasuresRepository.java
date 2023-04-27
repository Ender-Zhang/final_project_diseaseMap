package com.example.springbootdemo.dao;


import com.example.springbootdemo.bean.Admin;
import com.example.springbootdemo.bean.ProtectiveMeasures;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import javax.transaction.Transactional;
import java.util.Optional;

@Repository
public interface ProtectiveMeasuresRepository extends JpaRepository<ProtectiveMeasures, Long>{


    @Query("select d.name from ProtectiveMeasures d where d.id=?1")
    String getProtectiveMeasuresById(Integer Id);

    @Query("select d.description from ProtectiveMeasures d where d.id=?1")
    String getDescriptionById(Integer Id);

//    Time findById(String Id);



}
