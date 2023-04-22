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


@Data
@NoArgsConstructor
@Accessors(chain = true)
@Entity
@Table(name = "disease")
public class Disease implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;
    private String description;

    private Integer protective_method_id;
    private Integer datasource_id;
    private Integer time_id;
    private Integer transmission_mode_id;
    private Integer symptom_id;


}