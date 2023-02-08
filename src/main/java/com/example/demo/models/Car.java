/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.demo.models;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

/**
 *
 * @author karat
 */
@Entity
@Table(name = "car")
@NamedQueries({
    @NamedQuery(name = "Car.findAll", query = "SELECT c FROM Car c"),
    @NamedQuery(name = "Car.findById", query = "SELECT c FROM Car c WHERE c.id = :id"),
    @NamedQuery(name = "Car.findByPlate", query = "SELECT c FROM Car c WHERE c.plate = :plate"),
    @NamedQuery(name = "Car.findByPower", query = "SELECT c FROM Car c WHERE c.power = :power"),
    @NamedQuery(name = "Car.findByInsurancefilename", query = "SELECT c FROM Car c WHERE c.insurancefilename = :insurancefilename")})
public class Car implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Column(name = "plate")
    private String plate;
    @Column(name = "power")
    private Integer power;
    @Lob
    @Column(name = "insurancefile")
    private byte[] insurancefile;
    @Column(name = "insurancefilename")
    private String insurancefilename;

    public Car() {
    }

    public Car(String plate, Integer power) {
        this.plate = plate;
        this.power = power;
    }

    public Car(Integer id, String plate, Integer power) {
        this.id = id;
        this.plate = plate;
        this.power = power;
    }

    public Car(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getPlate() {
        return plate;
    }

    public void setPlate(String plate) {
        this.plate = plate;
    }

    public Integer getPower() {
        return power;
    }

    public void setPower(Integer power) {
        this.power = power;
    }

    public byte[] getInsurancefile() {
        return insurancefile;
    }

    public void setInsurancefile(byte[] insurancefile) {
        this.insurancefile = insurancefile;
    }

    public String getInsurancefilename() {
        return insurancefilename;
    }

    public void setInsurancefilename(String insurancefilename) {
        this.insurancefilename = insurancefilename;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Car)) {
            return false;
        }
        Car other = (Car) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.example.demo.models.Car[ id=" + id + " ]";
    }
    
}
