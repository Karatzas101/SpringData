/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.demo.services;

import com.example.demo.models.Cars;
import com.example.demo.repo.CarRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class CarServiceImpl implements CarServiceInterface {

    @Autowired
    CarRepository cr;
    
    @Override
    public void insert(Cars c) {
         
     cr.save(c);
        
    }

    @Override
    public List<Cars> all() {

        return cr.findAll();
    }

    @Override
    public Cars getById(Integer id) { 
        
        return cr.findById(id).get();
        
    }

    @Override
    @Transactional
    public void updateCar(Cars c) {
        
        
    }

    @Override
    public void deleteCar(Cars c) {
        
        cr.delete(c);
    }
    
    
    
    
}
