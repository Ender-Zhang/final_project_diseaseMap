package com.example.springbootdemo.bean;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;
import org.json.JSONObject;

import javax.persistence.*;
import java.io.Serializable;

@Data
@NoArgsConstructor
@Accessors(chain = true)
@Entity
@Table(name = "states")
public class States implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private Integer common_disease_id;

    private Integer medical_facilities_id;

    private String abbreviation;

    private String description;

    public States (Object state) {
        JSONObject json = new JSONObject(state);
        this.id = Long.valueOf(json.getInt("id"));
        this.name = json.getString("name");
        this.common_disease_id = json.getInt("common_disease_id");
        this.medical_facilities_id = json.getInt("medical_facilities_id");
        this.abbreviation = json.getString("abbreviation");
        this.description = json.getString("description");
    }
}