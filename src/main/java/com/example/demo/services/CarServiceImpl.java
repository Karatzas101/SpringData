/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.demo.services;

import com.example.demo.models.Car;
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
    public void insert(Car c) {
         
     cr.save(c);
        
    }

    @Override
    public List<Car> all() {

        return cr.findAll();
    }

    @Override
    public Car getById(Integer id) { 
        
        return cr.findById(id).get();
        
    }

    @Override
    @Transactional
    public void updateCar(Car c) {
        
        
    }

    @Override
    public void deleteCar(Car c) {
        
        cr.delete(c);
    }
    
    
    
    
}
