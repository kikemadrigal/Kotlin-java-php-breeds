/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.consumoapi.models;

/**
 *
 * @author kikem
 */
public class Dog {
    private int id;
    private String name;
    private String name_es;
    private int breed_id;
    private String family;
    private String description;
    private String year_of_birth;
    private String sex;
    private String address;
    private String vaccines;
    private String path_image;
    private String date;
    private int creator_id;

    public Dog(int id, String name, String name_es, int breed_id, String family, String description, String year_of_birth, String sex, String address, String vaccines, String path_image, String date, int creator_id) {
        this.id = id;
        this.name = name;
        this.name_es = name_es;
        this.breed_id = breed_id;
        this.family = family;
        this.description = description;
        this.year_of_birth = year_of_birth;
        this.sex = sex;
        this.address = address;
        this.vaccines = vaccines;
        this.path_image = path_image;
        this.date = date;
        this.creator_id = creator_id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName_es() {
        return name_es;
    }

    public void setName_es(String name_es) {
        this.name_es = name_es;
    }

    public int getBreed_id() {
        return breed_id;
    }

    public void setBreed_id(int breed_id) {
        this.breed_id = breed_id;
    }

    public String getFamily() {
        return family;
    }

    public void setFamily(String family) {
        this.family = family;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getYear_of_birth() {
        return year_of_birth;
    }

    public void setYear_of_birth(String year_of_birth) {
        this.year_of_birth = year_of_birth;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getVaccines() {
        return vaccines;
    }

    public void setVaccines(String vaccines) {
        this.vaccines = vaccines;
    }

    public String getPath_image() {
        return path_image;
    }

    public void setPath_image(String path_image) {
        this.path_image = path_image;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public int getCreator_id() {
        return creator_id;
    }

    public void setCreator_id(int creator_id) {
        this.creator_id = creator_id;
    }

    @Override
    public String toString() {
        return "Dog{" + "id=" + id + ", name=" + name + ", name_es=" + name_es + ", breed_id=" + breed_id + ", family=" + family + ", description=" + description + ", year_of_birth=" + year_of_birth + ", sex=" + sex + ", address=" + address + ", vaccines=" + vaccines + ", path_image=" + path_image + ", date=" + date + ", creator_id=" + creator_id + '}';
    }


    
    
    
}
