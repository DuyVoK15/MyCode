/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DTO;

import java.text.SimpleDateFormat;
import java.time.Duration;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Comparator;
import java.util.Date;

/**
 *
 * @author ASUS
 */
public class Food {

    private String ID;
    private String name;
    private double weight;
    private String type;
    private String place;
    private Date expiredDate;
    private SimpleDateFormat df = new SimpleDateFormat("dd/MM/yyyy");
    
    public Food() {
    }

    public Food(String ID, String name, double weight, String type, String place, Date expiredDate) {
        this.ID = ID;
        this.name = name;
        this.weight = weight;
        this.type = type;
        this.place = place;
        this.expiredDate = expiredDate;
    }

    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getPlace() {
        return place;
    }

    public void setPlace(String place) {
        this.place = place;
    }

    public Date getExpiredDate() {
        return expiredDate;
    }

    public void setExpiredDate(Date expiredDate) {
        this.expiredDate = expiredDate;
    }

    public String getStrExpiredDate() {
        return df.format(expiredDate);
    }

    
    
    

    @Override
    public String toString() {
        return "Food{" + "ID = " + ID + ", name = " + name + ", weight = " + weight
                + ", type = " + type + ", place = " + place + ", expiredDate = " + df.format(expiredDate) + '}';
    }

   
}
