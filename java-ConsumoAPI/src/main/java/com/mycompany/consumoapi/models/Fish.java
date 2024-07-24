/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.consumoapi.models;

/**
 *
 * @author kikem
 */
public class Fish {
    private int id;
    private String name;
    private String name_es;
    private String specie_id;
    private String path_image;
    private String date;
    private int creator_id;

    public Fish(int id, String name, String name_es, String specie_id, String path_image, String date, int creator_id) {
        this.id = id;
        this.name = name;
        this.name_es = name_es;
        this.specie_id = specie_id;
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

    public String getSpecie_id() {
        return specie_id;
    }

    public void setSpecie_id(String specie_id) {
        this.specie_id = specie_id;
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
        return "Fish{" + "id=" + id + ", name=" + name + ", name_es=" + name_es + ", specie_id=" + specie_id + ", path_image=" + path_image + ", date=" + date + ", creator_id=" + creator_id + '}';
    }

    

       
    
}
