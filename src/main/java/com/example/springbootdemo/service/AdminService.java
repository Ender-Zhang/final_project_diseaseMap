package com.example.springbootdemo.service;

import com.example.springbootdemo.bean.Admin;
import com.example.springbootdemo.dao.AdminRepository;
import com.example.springbootdemo.dao.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.example.springbootdemo.bean.User;
        import com.example.springbootdemo.dao.UserRepository;
        import org.springframework.beans.factory.annotation.Autowired;
        import org.springframework.data.domain.Page;
        import org.springframework.data.domain.PageRequest;
        import org.springframework.data.domain.Pageable;
        import org.springframework.stereotype.Service;

@Service("adminService")
public class AdminService {
    @Autowired
    private AdminRepository adminRepository;

    public Admin getUserByID(Long id){
        return adminRepository.findById(id).get();
    }

    public Admin getByName(String username) {
        return adminRepository.findByName(username);
    }

//    public User getByName(String name){
//        return adminRepository.findByName(name);
//    }
//
//    public Page<User> findPage(){
//        Pageable pageable = PageRequest.of(0, 10);
//        return adminRepository.findAll(pageable);
//    }
//
//    public Page<User> find(Long maxId){
//        Pageable pageable = PageRequest.of(0, 10);
//        return adminRepository.findMore(maxId,pageable);
//    }
//
//    public User save(User u){
//        return adminRepository.save(u);
//    }
//
//    public User update(Long id,String name){
//        User user = adminRepository.findById(id).get();
//        user.setName(name+"_update");
//        return adminRepository.save(user);
//    }
//
//    public Boolean updateById(String  name, Long id){
//        return adminRepository.updateById(name,id)==1;
//    }

}