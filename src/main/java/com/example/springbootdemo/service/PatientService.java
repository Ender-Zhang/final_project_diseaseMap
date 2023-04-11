package com.example.springbootdemo.service;


import com.example.springbootdemo.bean.Patient;
import com.example.springbootdemo.dao.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("patientService")
public class PatientService {
    @Autowired
    private PatientRepository PatientRepository;

    public Patient getPatientByID(Long id){
        return PatientRepository.findById(id).get();
    }

    public boolean isPatient(Long id, String password){
        if (PatientRepository.findById(id).get().getPassword().equals(password)){
            return true;
        }
        else {
            return false;
        }
    }

    public Integer addPatient(String name, String password, String doctor_id){
        Patient patient = new Patient(name, password, doctor_id);
        Patient p = PatientRepository.save(patient);
        Long id = p.getId();
        return id.intValue();
    }

}




