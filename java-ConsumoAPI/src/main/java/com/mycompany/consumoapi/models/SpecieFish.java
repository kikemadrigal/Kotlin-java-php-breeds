package com.mycompany.consumoapi.models;

/**
 *
 * @author kikem
 */
public class SpecieFish {
    private int id;
    private String name;
    private String name_es;
    private String description;
    private String urlWiki;
    private String url_image;
    private String path_image;
    private String date;
    private int creator_id;

    public SpecieFish() {
    }

    public int getId() {
        return id;
    }

    public SpecieFish(int id, String name, String name_es, String description, String urlWiki, String url_image,String path_image, String date, int creator_id) {
        this.id = id;
        this.name = name;
        this.name_es = name_es;
        this.description = description;
        this.urlWiki = urlWiki;
        this.url_image = url_image;
        this.path_image = path_image;
        this.date = date;
        this.creator_id = creator_id;
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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getUrlWiki() {
        return urlWiki;
    }

    public void setUrlWiki(String urlWiki) {
        this.urlWiki = urlWiki;
    }
    
    
    
    public String getURL_image() {
        return url_image;
    }

    public void setURL_image(String url_image) {
        this.url_image = url_image;
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
        return "SpecieFish{" + "id=" + id + ", name=" + name + ", name_es=" + name_es + ", description=" + description + ", urlWiki=" + urlWiki + ", path_image=" + path_image + ", date=" + date + ", creator_id=" + creator_id + '}';
    }

  
    
    
}
