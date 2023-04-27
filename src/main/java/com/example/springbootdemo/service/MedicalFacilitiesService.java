package com.example.springbootdemo.service;



import com.example.springbootdemo.bean.MedicalFacilities;
import com.example.springbootdemo.dao.MedicalFacilitiesRepository;
import com.example.springbootdemo.dao.SymptomRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.NoSuchElementException;
import java.util.Optional;


@Service("medicalFacilitiesService")
public class MedicalFacilitiesService {
    @Autowired
    private MedicalFacilitiesRepository medicalFacilitiesRepository;

    public void deleteMedicalFacilityById(Integer id) {
        medicalFacilitiesRepository.deleteById(id);
    }
    public MedicalFacilities updateMedicalFacility(MedicalFacilities medicalFacility){
        medicalFacilitiesRepository.save(medicalFacility);
        return medicalFacility;
    }
}
