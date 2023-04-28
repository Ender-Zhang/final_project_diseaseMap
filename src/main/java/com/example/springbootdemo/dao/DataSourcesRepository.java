package com.example.springbootdemo.dao;

import com.example.springbootdemo.bean.DataSource;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface DataSourcesRepository extends JpaRepository<DataSource, Long> {
    @Query("select d.name from DataSource d where d.id=?1")
    String getDataSourcesById(Integer Id);
}
