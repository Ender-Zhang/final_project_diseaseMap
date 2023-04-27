package com.example.springbootdemo.dao;

import com.example.springbootdemo.bean.DataSources;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface DataSourcesRepository extends JpaRepository<DataSources, Long> {
    @Query("select d.name from DataSources d where d.id=?1")
    String getDataSourcesById(Integer Id);
}
