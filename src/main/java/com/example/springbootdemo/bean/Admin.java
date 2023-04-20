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
@Table(name = "admin")
public class Admin implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String password;

    public String getUsername() {
        return name;
    }


}