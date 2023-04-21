package com.example.springbootdemo.controller;



import com.example.springbootdemo.bean.*;
import com.example.springbootdemo.dao.DoctorRepository;
import com.example.springbootdemo.service.*;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

import java.util.Iterator;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/")
public class ApiController {

    @Autowired
    private UserService userService;
    @Autowired
    private DoctorService doctorService;

    @Autowired
    private PatientService patientService;

    @Autowired
    private ReminderService reminderService;

    @Autowired
    private AdminService adminService;

    @Autowired
    private StatesService statesService;

    @GetMapping("/init")
    public String init() {
//        User user = null;
//        for(int i=0;i<10;i++){
//            user = new User();
//            user.setName("test"+i);
//            userService.save(user);
//        }
        return "初始化完成。";
    }

    @GetMapping("/userByName/{username}")
    public User getUserByName(@PathVariable("username") String username) {
        return userService.getByName(username);
    }

    @GetMapping("/userById/{userid}")
    public User getUserById(@PathVariable("userid") Long userid) {
        return userService.getUserByID(userid);
    }

    @GetMapping("/page")
    public Page<User> getPage() {
        return userService.findPage();
    }

    @GetMapping("/page/{maxID}")
    public Page<User> getPageByMaxID(@PathVariable("maxID") Long maxID) {
        return userService.find(maxID);
    }

    @RequestMapping("/update/{id}/{name}")
    public User update(@PathVariable Long id, @PathVariable String name) {
        return userService.update(id, name);
    }

    @RequestMapping("/update/{id}")
    public Boolean updateById(@PathVariable Long id) {
        return userService.updateById("newName", id);
    }

    @RequestMapping("/isDoctor")
    public Boolean isDoctor(@RequestParam Long id, @RequestParam String password) {
//        return userService.isDoctor(id);
        return doctorService.isDoctor(id, password);
//        return true;
    }

    @RequestMapping("/doctor/{id}")
    public Doctor getDoctor(@PathVariable Integer id) {
        return doctorService.getDoctorByIDAll(Long.valueOf(id));
    }

    @PostMapping("/doctor")
    public Integer addDoctor(@RequestParam String name, @RequestParam String password) {
        return doctorService.addDoctor(name, password);
//        return doctorService.save(name, password);
    }

    @RequestMapping("/patient/{id}")
    public Patient getPatient(@PathVariable Long id) {
        return patientService.getPatientByID(id);
    }

    @PostMapping("/patient")
    public Integer addPatient(@RequestParam String name, @RequestParam String password, @RequestParam String doctor_id) {
        return patientService.addPatient(name, password, doctor_id);
    }

    @RequestMapping("/reminder/{id}")
    public Reminder getReminder(@PathVariable Long id) {
        return reminderService.getReminderByID(id);
    }

    @PostMapping("/reminder")
    public Integer addReminder(@RequestParam String content, @RequestParam String date, @RequestParam String time, @RequestParam String type, @RequestParam Integer patient_id, @RequestParam Integer doctor_id) {
        return reminderService.addReminder(content, date, time, type, patient_id, doctor_id);
    }


    @GetMapping("/adminByName/{username}")
    @CrossOrigin(origins = "http://127.0.0.1:5173")
    public Admin getAdminByName(@PathVariable("username") String username) {
        return adminService.getByName(username);
    }


    @RequestMapping("/isAdmin")
    @CrossOrigin(origins = "http://127.0.0.1:5173")
    public Boolean isAdmin(@RequestParam Long id, @RequestParam String password) {
//        return userService.isDoctor(id);
        return adminService.isAdmin(id, password);
//        return true;
    }

    @RequestMapping("/getMap")
    @CrossOrigin(origins = "http://127.0.0.1:5173")
    public States getMap() {
        return statesService.getByName("Alabama");
    }


    @RequestMapping("/getAllMap")
    @CrossOrigin(origins = "http://127.0.0.1:5173")
    public String getAllMap() {
//        return statesService.getAllStates().getContent();
        List listStates = statesService.getAllStates().getContent();
        JSONObject stateJson = new JSONObject();
        for(int i=0; i<listStates.size();i++){
            States state = new States(listStates.get(i));

            stateJson.put(state.getAbbreviation(), new JSONObject()
                    .put("name", state.getName())
                    .put("abbreviation", state.getAbbreviation())
//                .put("commonDisease", getCommonDiseaseName(state.getCommonDiseaseId()))
                    .put("id", state.getId())
                    .put("commonDisease", state.getCommon_disease_id())
                    .put("description", state.getDescription()));
        }
        String jsonString = stateJson.toString();


        JSONObject jsonObject = new JSONObject();

        // 向 JSON 对象中添加一些属性
        jsonObject.put("name", "John");
        jsonObject.put("age", 30);
        jsonObject.put("isMarried", true);
        return jsonString;

    }

}

