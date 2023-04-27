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
@Table(name = "medical_facilities")
public class MedicalFacilities implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name ;
    private String address;
    private String city ;
    private String state;
    private String zip ;

}





