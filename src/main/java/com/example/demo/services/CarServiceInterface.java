/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.example.demo.services;

import com.example.demo.models.Cars;
import java.util.List;


public interface CarServiceInterface {
    
    public void insert(Cars c);
    
    public List<Cars> all();
    
    public Cars getById(Integer id);
    
    public void updateCar(Cars c);
    
    public void deleteCar(Cars c);
}
