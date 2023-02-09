package com.example.demo.controllers;

import com.example.demo.models.Car;
import com.example.demo.services.CarServiceInterface;
import java.io.IOException;
import java.net.http.HttpClient;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

@Controller
@RequestMapping("car")
public class CarController {
    
    @Autowired
    CarServiceInterface cs;  
    
    @GetMapping("/showlist")
    public String showAllCars(ModelMap mm){
        
         mm.addAttribute("cars",cs.all()); 
         
        return "carlist";
        
    }
    
    @PostMapping("/insert")
    public String insertCar(@RequestParam("plate") String plate,
            @RequestParam("power") Integer power,
            @RequestParam("insurance") MultipartFile insurance,
            ModelMap mm){
        
        Car car = new Car(plate,power);
        
        car.setInsurancefilename(insurance.getOriginalFilename());
        
        try {
           car.setInsurancefile(insurance.getBytes());
        } catch (IOException ex) {
            Logger.getLogger(CarController.class.getName()).log(Level.SEVERE, null, ex);
        }
                
        cs.insert(car);               
            
        return "redirect:showlist";
    }
    
    @GetMapping("/update/{carid}")
    public String updateCar(@PathVariable Integer carid,ModelMap mm){
        
        Car car = cs.getById(carid);
        System.out.println(car);
        
        mm.addAttribute("cartoupdate", car);
        
        return "carupdate";
    }
    
    @PostMapping("/doupdate")
    public String doupdate(@RequestParam("carid") Integer id,
            @RequestParam("plate") String plate,
            @RequestParam("power") Integer power,ModelMap mm){
        
        Car car = cs.getById(id);            
        car.setPlate(plate);
        car.setPower(power);
               
        cs.insert(car);
                
        mm.addAttribute("cars",cs.all());
        
        return "carlist";
    }
    
        @GetMapping("/delete/{carid}")
        public String deleteCar(@PathVariable Integer carid,ModelMap mm){
        
        Car car = cs.getById(carid);
        cs.deleteCar(car);
        
        mm.addAttribute("cars",cs.all());
        
        return "carlist";
    }
        
        // 1) Τρόπος
        
//        @GetMapping(value = "/download/{carid}",
//                produces = MediaType.APPLICATION_PDF_VALUE)
//        @ResponseBody
//        public byte[] downloadInsurance(@PathVariable Integer carid){
//        
//            
//        Car car = cs.getById(carid);
//        
//        
//        
//        return car.getInsurancefile();
//    }
        
        // 2) Τρόπος        
        @GetMapping(value = "/download/{carid}")
        public ResponseEntity<Resource> downloadInsurance(
                @PathVariable Integer carid){        
            
        Car car = cs.getById(carid);       
        byte[] insurance = car.getInsurancefile();
                            
        HttpHeaders headers = new HttpHeaders();        
        headers.add(HttpHeaders.CONTENT_DISPOSITION,"attachment;filename=" + car.getInsurancefilename());
        
        return ResponseEntity.ok()
                .headers(headers)
                .contentLength(insurance.length)
                .contentType(MediaType.parseMediaType("application/octet-stream"))
                .body(new ByteArrayResource(insurance));
    }
        
}
