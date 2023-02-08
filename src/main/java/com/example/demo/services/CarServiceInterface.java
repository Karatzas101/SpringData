/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.example.demo.services;

import com.example.demo.models.Car;
import java.util.List;


public interface CarServiceInterface {
    
    public void insert(Car c);
    
    public List<Car> all();
    
    public Car getById(Integer id);
    
    public void updateCar(Car c);
    
    public void deleteCar(Car c);
}
