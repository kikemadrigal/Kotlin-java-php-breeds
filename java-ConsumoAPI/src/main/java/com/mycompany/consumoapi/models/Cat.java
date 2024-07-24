/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.consumoapi.models;

/**
 *
 * @author kikem
 */
public class Cat {
    private int id;
    private String name;
    private String name_es;
    private int breed_id;
    private String path;
    private String family;
    private String description;
    private String description_es;
    private String path_image;
    private String date;
    private int creator_id;

    public Cat(int id, String name, String name_es, int breed_id, String path, String family, String description, String description_es, String path_image, String date, int creator_id) {
        this.id = id;
        this.name = name;
        this.name_es = name_es;
        this.breed_id = breed_id;
        this.path = path;
        this.family = family;
        this.description = description;
        this.description_es = description_es;
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

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
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

    public String getDescription_es() {
        return description_es;
    }

    public void setDescription_es(String description_es) {
        this.description_es = description_es;
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
        return "Cat{" + "id=" + id + ", name=" + name + ", name_es=" + name_es + ", breed_id=" + breed_id + ", path=" + path + ", family=" + family + ", description=" + description + ", description_es=" + description_es + ", path_image=" + path_image + ", date=" + date + ", creator_id=" + creator_id + '}';
    }

    
   


    
    
}
