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

import java.util.NoSuchElementException;
import java.util.Optional;

@Service("adminService")
public class AdminService {
    @Autowired
    private AdminRepository AdminRepository;

    public Admin getUserByID(Long id){
        return AdminRepository.findById(id).get();
    }

    public Admin getByName(String username) {
        return AdminRepository.findByName(username);
    }

    public boolean isAdmin(Long id, String password){
        try {
            Optional<Admin> adminOptional = AdminRepository.findById(id);
            if (adminOptional.isPresent() && adminOptional.get().getPassword().equals(password)) {
                return true;
            } else {
                return false;
            }
        } catch (NoSuchElementException e) {
            return false;
        }
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