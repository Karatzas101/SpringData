package com.example.demo.controllers;

import com.example.demo.models.Cars;
import com.example.demo.services.CarServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 *
 * @author karat
 */
@Controller
@RequestMapping("car")
public class CarController {
    
    @Autowired
    CarServiceInterface cs;  
    
    @PostMapping("/insert")
    public String insertCar(@RequestParam("plate") String plate,
            @RequestParam("power") Integer power,ModelMap mm){
        
        Cars car = new Cars(plate,power);
        System.out.println(car);        
        cs.insert(car);
                
        mm.addAttribute("cars",cs.all());
        
        return "carlist";
    }
    
    @GetMapping("/update/{carid}")
    public String updateCar(@PathVariable Integer carid,ModelMap mm){
        
        Cars car = cs.getById(carid);
        System.out.println(car);
        
        mm.addAttribute("cartoupdate", car);
        
        return "carupdate";
    }
    
    @PostMapping("/doupdate")
    public String doupdate(@RequestParam("carid") Integer id,
            @RequestParam("plate") String plate,
            @RequestParam("power") Integer power,ModelMap mm){
        
        Cars car = cs.getById(id);            
        car.setPlate(plate);
        car.setPower(power);
               
        cs.insert(car);
                
        mm.addAttribute("cars",cs.all());
        
        return "carlist";
    }
    
        @GetMapping("/delete/{carid}")
        public String deleteCar(@PathVariable Integer carid,ModelMap mm){
        
        Cars car = cs.getById(carid);
        cs.deleteCar(car);
        
        mm.addAttribute("cars",cs.all());
        
        return "carlist";
    }
    
}
