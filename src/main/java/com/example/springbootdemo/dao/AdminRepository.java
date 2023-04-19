package com.example.springbootdemo.dao;

import com.example.springbootdemo.bean.Admin;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import javax.transaction.Transactional;

@Repository
public interface AdminRepository extends JpaRepository<Admin, Long>{

    //默认提供了Optional<User> findById(Long id);

    Admin findByName(String username);

    @Query("select u from User u where u.id <= ?1")
    Page<Admin> findMore(Long maxId, Pageable pageable);

    @Modifying
    @Transactional
    @Query("update User u set u.name = ?1 where u.id = ?2")
    int updateById(String name, Long id);


}