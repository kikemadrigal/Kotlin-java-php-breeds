/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.consumoapi.models;

import com.mycompany.consumoapi.utils.StringManager;

/**
 *
 * @author kikem
 */
public class BreedCat {
    int id;
    String idName;
    String name;
    String name_es;
    //criado para
    String cfa_url;
    //grupo de raza
    String vetstreet_url;
     //esperanza de vida
    String vcahospitals_url;

    String temperament;
    
    String temperament_es;

    String origin;

    String country_codes;

    String country_code;

    String description;
    
    String description_es;

    String life_span;

    int indoor;

    int lap;

    String alt_names;

    int adaptability;

    int affection_level;

    int child_friendly;

    int dog_friendly;
    
    int energy_level;

    int grooming;

    int health_issues;

    int intelligence;

    int shedding_level;

    int social_needs;

    int stranger_friendly;

    int vocalisation;
    
    int experimental;

    int hairless;

    int natural;

    int rare;

    int rex;

    int suppressed_tail;

    int short_legs;

    String wikipedia_url;

    int hypoallergeni;

    String weight;

    String date;

    String reference_image_id;
    
    String path_image;
    
    int creator_id;

    public BreedCat(int id) {
        this.id = id;
    }

    public BreedCat(int id, String idName, String name, String name_es, String cfa_url, String vetstreet_url, String vcahospitals_url, String temperament, String temperament_es, String origin, String country_codes, String country_code, String description, String description_es, String life_span, int indoor, int lap, String alt_names, int adaptability, int affection_level, int child_friendly, int dog_friendly, int energy_level, int grooming, int health_issues, int intelligence, int shedding_level, int social_needs, int stranger_friendly, int vocalisation, int experimental, int hairless, int natural, int rare, int rex, int suppressed_tail, int short_legs, String wikipedia_url, int hypoallergeni, String weight, String date, String reference_image_id, String path_image, int creator_id) {
        this.id = id;
        this.idName = idName;
        this.name = name;
        this.name_es = name_es;
        this.cfa_url = cfa_url;
        this.vetstreet_url = vetstreet_url;
        this.vcahospitals_url = vcahospitals_url;
        this.temperament = temperament;
        this.temperament_es = temperament_es;
        this.origin = origin;
        this.country_codes = country_codes;
        this.country_code = country_code;
        this.description = description;
        this.description_es = description_es;
        this.life_span = life_span;
        this.indoor = indoor;
        this.lap = lap;
        this.alt_names = alt_names;
        this.adaptability = adaptability;
        this.affection_level = affection_level;
        this.child_friendly = child_friendly;
        this.dog_friendly = dog_friendly;
        this.energy_level = energy_level;
        this.grooming = grooming;
        this.health_issues = health_issues;
        this.intelligence = intelligence;
        this.shedding_level = shedding_level;
        this.social_needs = social_needs;
        this.stranger_friendly = stranger_friendly;
        this.vocalisation = vocalisation;
        this.experimental = experimental;
        this.hairless = hairless;
        this.natural = natural;
        this.rare = rare;
        this.rex = rex;
        this.suppressed_tail = suppressed_tail;
        this.short_legs = short_legs;
        this.wikipedia_url = wikipedia_url;
        this.hypoallergeni = hypoallergeni;
        this.weight = weight;
        this.date = date;
        this.reference_image_id = reference_image_id;
        this.path_image = path_image;
        this.creator_id = creator_id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getIdName() {
        return idName;
    }

    public void setIdName(String idName) {
        this.idName = idName;
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

    public String getCfa_url() {
        return cfa_url;
    }

    public void setCfa_url(String cfa_url) {
        this.cfa_url = cfa_url;
    }

    public String getVetstreet_url() {
        return vetstreet_url;
    }

    public void setVetstreet_url(String vetstreet_url) {
        this.vetstreet_url = vetstreet_url;
    }

    public String getVcahospitals_url() {
        return vcahospitals_url;
    }

    public void setVcahospitals_url(String vcahospitals_url) {
        this.vcahospitals_url = vcahospitals_url;
    }

    public String getTemperament() {
        return temperament;
    }

    public void setTemperament_es(String temperament_es) {
        this.temperament_es = temperament_es;
    }
        public String getTemperament_es() {
        return temperament_es;
    }

    public void setTemperament(String temperament) {
        this.temperament = temperament;
    }

    

    public String getOrigin() {
        return origin;
    }

    public void setOrigin(String origin) {
        this.origin = origin;
    }

    public String getCountry_codes() {
        return country_codes;
    }

    public void setCountry_codes(String country_codes) {
        this.country_codes = country_codes;
    }

    public String getCountry_code() {
        return country_code;
    }

    public void setCountry_code(String country_code) {
        this.country_code = country_code;
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

    public String getLife_span() {
        return life_span;
    }

    public void setLife_span(String life_span) {
        this.life_span = life_span;
    }

    public int getIndoor() {
        return indoor;
    }

    public void setIndoor(int indoor) {
        this.indoor = indoor;
    }

    public int getLap() {
        return lap;
    }

    public void setLap(int lap) {
        this.lap = lap;
    }

    public String getAlt_names() {
        return alt_names;
    }

    public void setAlt_names(String alt_names) {
        this.alt_names = alt_names;
    }

    public int getAdaptability() {
        return adaptability;
    }

    public void setAdaptability(int adaptability) {
        this.adaptability = adaptability;
    }

    public int getAffection_level() {
        return affection_level;
    }

    public void setAffection_level(int affection_level) {
        this.affection_level = affection_level;
    }

    public int getChild_friendly() {
        return child_friendly;
    }

    public void setChild_friendly(int child_friendly) {
        this.child_friendly = child_friendly;
    }

    public int getDog_friendly() {
        return dog_friendly;
    }

    public void setDog_friendly(int dog_friendly) {
        this.dog_friendly = dog_friendly;
    }

    public int getEnergy_level() {
        return energy_level;
    }

    public void setEnergy_level(int energy_level) {
        this.energy_level = energy_level;
    }

    public int getGrooming() {
        return grooming;
    }

    public void setGrooming(int grooming) {
        this.grooming = grooming;
    }

    public int getHealth_issues() {
        return health_issues;
    }

    public void setHealth_issues(int health_issues) {
        this.health_issues = health_issues;
    }

    public int getIntelligence() {
        return intelligence;
    }

    public void setIntelligence(int intelligence) {
        this.intelligence = intelligence;
    }

    public int getShedding_level() {
        return shedding_level;
    }

    public void setShedding_level(int shedding_level) {
        this.shedding_level = shedding_level;
    }

    public int getSocial_needs() {
        return social_needs;
    }

    public void setSocial_needs(int social_needs) {
        this.social_needs = social_needs;
    }

    public int getStranger_friendly() {
        return stranger_friendly;
    }

    public void setStranger_friendly(int stranger_friendly) {
        this.stranger_friendly = stranger_friendly;
    }

    public int getVocalisation() {
        return vocalisation;
    }

    public void setVocalisation(int vocalisation) {
        this.vocalisation = vocalisation;
    }

    public int getExperimental() {
        return experimental;
    }

    public void setExperimental(int experimental) {
        this.experimental = experimental;
    }

    public int getHairless() {
        return hairless;
    }

    public void setHairless(int hairless) {
        this.hairless = hairless;
    }

    public int getNatural() {
        return natural;
    }

    public void setNatural(int natural) {
        this.natural = natural;
    }

    public int getRare() {
        return rare;
    }

    public void setRare(int rare) {
        this.rare = rare;
    }

    public int getRex() {
        return rex;
    }

    public void setRex(int rex) {
        this.rex = rex;
    }

    public int getSuppressed_tail() {
        return suppressed_tail;
    }

    public void setSuppressed_tail(int suppressed_tail) {
        this.suppressed_tail = suppressed_tail;
    }

    public int getShort_legs() {
        return short_legs;
    }

    public void setShort_legs(int short_legs) {
        this.short_legs = short_legs;
    }

    public String getWikipedia_url() {
        return wikipedia_url;
    }

    public void setWikipedia_url(String wikipedia_url) {
        this.wikipedia_url = wikipedia_url;
    }

    public int getHypoallergeni() {
        return hypoallergeni;
    }

    public void setHypoallergeni(int hypoallergeni) {
        this.hypoallergeni = hypoallergeni;
    }

    public String getWeight() {
        return weight;
    }

    public void setWeight(String weight) {
        this.weight = weight;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getReference_image_id() {
        return reference_image_id;
    }

    public void setReference_image_id(String reference_image_id) {
        this.reference_image_id = reference_image_id;
    }

    public String getPath_image() {
        return path_image;
    }

    public void setPath_image(String path_image) {
        this.path_image = path_image;
    }

    public int getCreator_id() {
        return creator_id;
    }

    public void setCreator_id(int creator_id) {
        this.creator_id = creator_id;
    }

    @Override
    public String toString() {
        return "BreedCat{" + "id=" + id + ", idName=" + idName + ", name=" + name + ", name_es=" + name_es + ", cfa_url=" + cfa_url + ", vetstreet_url=" + vetstreet_url + ", vcahospitals_url=" + vcahospitals_url + ", temperament=" + temperament + ", origin=" + origin + ", country_codes=" + country_codes + ", country_code=" + country_code + ", description=" + description + ", description_es=" + description_es + ", life_span=" + life_span + ", indoor=" + indoor + ", lap=" + lap + ", alt_names=" + alt_names + ", adaptability=" + adaptability + ", affection_level=" + affection_level + ", child_friendly=" + child_friendly + ", dog_friendly=" + dog_friendly + ", energy_level=" + energy_level + ", grooming=" + grooming + ", health_issues=" + health_issues + ", intelligence=" + intelligence + ", shedding_level=" + shedding_level + ", social_needs=" + social_needs + ", stranger_friendly=" + stranger_friendly + ", vocalisation=" + vocalisation + ", experimental=" + experimental + ", hairless=" + hairless + ", natural=" + natural + ", rare=" + rare + ", rex=" + rex + ", suppressed_tail=" + suppressed_tail + ", short_legs=" + short_legs + ", wikipedia_url=" + wikipedia_url + ", hypoallergeni=" + hypoallergeni + ", weight=" + weight + ", date=" + date + ", reference_image_id=" + reference_image_id + ", path_image=" + path_image + ", creator_id=" + creator_id + '}';
    }

   
   

    
}
