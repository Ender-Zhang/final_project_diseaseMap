package com.example.springbootdemo.bean;

import lombok.*;
import lombok.experimental.Accessors;
import javax.persistence.*;
import java.io.Serializable;
@Data
@NoArgsConstructor
@Accessors(chain = true)
@Entity
@Table(name = "user")
public class User implements Serializable{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String password;
    private String name;

    public String getPassword() {
        return this.password;
    }
}


