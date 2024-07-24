package com.mycompany.consumoapi.models;

/**
 *
 * @author tipolisto
 */
//https://api.thedogapi.com/v1/ 
//https://api.thedogapi.com/v1/breeds
public class BreedDog {
    	int id;
        int breed_id;
	String name;
        String name_es;
	//criado para
	String bred_for;
        String bred_for_es;
	//grupo de raza
	String breed_group;
        String breed_group_es;
	//esperanza de vida
	String life_span;
	String temperament;
        String temperament_es;
	String origin;
	String weight;
	String height;
  	String date;
  	String reference_image_id;
        String path_image;
  	int creator_id;

    public BreedDog(int id) {
        this.id = id;
    }
//                       0,idName,             name,        name_es,        bred_for,        bred_for_es,        breed_group,        breed_group_es,        life_span,        temperament,        temparament_es,        origin,        weight,        height,                     reference_image_id,         pathImage,    1)
    public BreedDog(int id, int breed_id, String name, String name_es, String bred_for, String bred_for_es, String breed_group, String breed_group_es, String life_span, String temperament, String temperament_es, String origin, String weight, String height, String date, String reference_image_id, String path_image, int creator_id) {
        this.id = id;
        this.breed_id = breed_id;
        this.name = name;
        this.name_es = name_es;
        this.bred_for = bred_for;
        this.bred_for_es = bred_for_es;
        this.breed_group = breed_group;
        this.breed_group_es = breed_group_es;
        this.life_span = life_span;
        this.temperament = temperament;
        this.temperament_es = temperament_es;
        this.origin = origin;
        this.weight = weight;
        this.height = height;
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

    public int get_breed_id() {
        return breed_id;
    }

    public void set_breed_id(int breed_id) {
        this.breed_id = breed_id;
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

    public String getBred_for() {
        return bred_for;
    }

    public void setBred_for(String bred_for) {
        this.bred_for = bred_for;
    }

    public String getBred_for_es() {
        return bred_for_es;
    }

    public void setBred_for_es(String bred_for_es) {
        this.bred_for_es = bred_for_es;
    }

    public String getBreed_group() {
        return breed_group;
    }

    public void setBreed_group(String breed_group) {
        this.breed_group = breed_group;
    }

    public String getBreed_group_es() {
        return breed_group_es;
    }

    public void setBreed_group_es(String breed_group_es) {
        this.breed_group_es = breed_group_es;
    }

    public String getLife_span() {
        return life_span;
    }

    public void setLife_span(String life_span) {
        this.life_span = life_span;
    }

    public String getTemperament() {
        return temperament;
    }

    public void setTemperament(String temperament) {
        this.temperament = temperament;
    }
    public String getTemperament_es() {
        return temperament_es;
    }

    public void setTemperament_es(String temperament_es) {
        this.temperament_es = temperament_es;
    }

    public String getOrigin() {
        return origin;
    }

    public void setOrigin(String origin) {
        this.origin = origin;
    }

    public String getWeight() {
        return weight;
    }

    public void setWeight(String weight) {
        this.weight = weight;
    }

    public String getHeight() {
        return height;
    }

    public void setHeight(String height) {
        this.height = height;
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
        return "BreedDog{" + "id=" + id + ", breed_id=" + breed_id + ", name=" + name + ", name_es=" + name_es + ", bred_for=" + bred_for + ", bred_for_es=" + bred_for_es + ", breed_group=" + breed_group + ", breed_group_es=" + breed_group_es + ", life_span=" + life_span + ", temperament=" + temperament + ", origin=" + origin + ", weight=" + weight + ", height=" + height + ", date=" + date + ", reference_image_id=" + reference_image_id + ", path_image=" + path_image + ", creator_id=" + creator_id + '}';
    }

   

    
        
        
}
