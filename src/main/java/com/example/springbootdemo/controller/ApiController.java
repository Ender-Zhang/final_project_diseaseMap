package com.example.springbootdemo.controller;



import com.example.springbootdemo.bean.*;
import com.example.springbootdemo.service.*;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/")
public class ApiController {

    @Autowired
    private UserService userService;

    @Autowired
    private AdminService adminService;

    @Autowired
    private StatesService statesService;

    @Autowired
    private DiseaseService diseaseService;

    @Autowired
    private  TimeService timeService;

    @Autowired
    private  TransmissionModesService transmissionModesService;

    @Autowired
    private  DataSourcesService dataSourcesService;


    @Autowired
    private  ProtectiveMeasuresService protectiveMeasuresService;

    @Autowired
    private SymptomService symptomService;

    @Autowired
    private  MedicalFacilitiesService medicalFacilitiesService;






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

//    @GetMapping("/userByName/{username}")
//    public User getUserByName(@PathVariable("username") String username) {
//        return userService.getByName(username);
//    }

    @PostMapping("/userByName")
    public User addUser(@RequestBody User user) {
        return userService.postaddUser(user);
    }

//    @GetMapping("/userById/{userid}")
//    public User getUserById(@PathVariable("userid") Long userid) {
//        return userService.getUserByID(userid);
//    }

//    @GetMapping("/page")
//    public Page<User> getPage() {
//        return userService.findPage();
//    }

//    @GetMapping("/page/{maxID}")
//    public Page<User> getPageByMaxID(@PathVariable("maxID") Long maxID) {
//        return userService.find(maxID);
//    }

//    @RequestMapping("/update/{id}/{name}")
//    public User update(@PathVariable Long id, @PathVariable String name) {
//        return userService.update(id, name);
//    }

//    @RequestMapping("/update/{id}")
//    public Boolean updateById(@PathVariable Long id) {
//        return userService.updateById("newName", id);
//    }



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
                    .put("commonDisease", diseaseService.getNameById(state.getCommon_disease_id()))
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
    @GetMapping ("/getTime/{id}")
    @CrossOrigin(origins = "http://127.0.0.1:5173")
    public String getTime(@PathVariable("id") Integer id) {
        return timeService.findTimeById(id);
    }

    @GetMapping ("/getTransMethod/{id}")
    @CrossOrigin(origins = "http://127.0.0.1:5173")
    public String getTransMethod(@PathVariable("id") Integer id) {
        System.out.println(id);
        return transmissionModesService.findTMById(id);
    }


    @GetMapping ("/getDataSources/{id}")
    @CrossOrigin(origins = "http://127.0.0.1:5173")
    public String getDataSources(@PathVariable("id") Integer id) {
        return dataSourcesService.findDataSourcesId(id);
    }


    @GetMapping ("/getProtectiveMeasures/{id}")
    @CrossOrigin(origins = "http://127.0.0.1:5173")
    public ArrayList<String> getProtectiveMeasures(@PathVariable("id") Integer id) {
        return protectiveMeasuresService.findProtectiveMeasuresId(id);
    }

    @DeleteMapping("/Symptom/{id}")
    @CrossOrigin(origins = "http://127.0.0.1:5173")
    public String deleteUserById(@PathVariable Long id) {
        symptomService.deleteUserById(id);
        return "User with id: " + id + " has been deleted.";
    }

    @DeleteMapping("/delete/{id}")
    @CrossOrigin(origins = "http://127.0.0.1:5173")
    public ResponseEntity<Void> deleteMedicalFacility(@PathVariable("id") Integer id) {
        medicalFacilitiesService.deleteMedicalFacilityById(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/update")
    @CrossOrigin(origins = "http://127.0.0.1:5173")
    public ResponseEntity<MedicalFacilities> updateMedicalFacility(@RequestBody MedicalFacilities medicalFacility) {
        MedicalFacilities updatedMedicalFacility = medicalFacilitiesService.updateMedicalFacility(medicalFacility);
        return ResponseEntity.ok(updatedMedicalFacility);
    }



}

