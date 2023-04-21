package com.example.springbootdemo.dao;



import com.example.springbootdemo.bean.States;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.http.converter.json.GsonBuilderUtils;
import org.springframework.stereotype.Repository;
import javax.transaction.Transactional;
import java.util.Optional;

@Repository
public interface StatesRepository extends JpaRepository<States, Long>{

    //默认提供了Optional<User> findById(Long id);

    States findByName(String username);

//    @Query("select u from User u where u.id <= ?1")
//    Page<States> findMore(Long maxId, Pageable pageable);

//    @Modifying
//    @Transactional
//    @Query("update User u set u.name = ?1 where u.id = ?2")
//    int updateById(String name, Long id);
//
    States findById(String Id);
    Optional<States> findById(Long id);
//    @Query("select u from User u where u.id <= ?1")
//    Page<User> findMore(Long maxId, Pageable pageable);

    @Query("select s from States s where s.id <=80")
    Page<States> getAllStates(Pageable pageable);


}
