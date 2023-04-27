package com.example.springbootdemo.bean;


import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import javax.persistence.*;
import java.io.Serializable;


import lombok.*;
import lombok.experimental.Accessors;
import javax.persistence.*;
import javax.swing.*;
import java.io.Serializable;
import java.util.Date;


@Data
@NoArgsConstructor
@Accessors(chain = true)
@Entity
@Table(name = "datasource")
public class DataSources implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;

}