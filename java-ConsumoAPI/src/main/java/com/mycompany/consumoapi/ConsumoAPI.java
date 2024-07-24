package com.mycompany.consumoapi;


import com.mycompany.consumoapi.controllers.BreedCatController;
import com.mycompany.consumoapi.controllers.BreedDogController;
import com.mycompany.consumoapi.controllers.FishController;
import com.mycompany.consumoapi.controllers.SpecieFishController;
import com.mycompany.consumoapi.utils.StringManager;





/**
 *
 * @author tipolisto
 */
public class ConsumoAPI {

    public static void main(String[] args) {
        StringManager stringManager=new StringManager();      
        //breedCats(stringManager);
        //breedDogs(stringManager);
        //specieFish(stringManager);
        fish(stringManager);
    }
    public static void breedCats(StringManager stringManager){     	
        BreedCatController catController=new BreedCatController(stringManager);
        //Aqui definimos los objetos y rellenamos los obejtos breed_cat con los datos que nos dá la api, después la añadimos a l arraylist de la clase BreedCat
        catController.createModels();
        //Con el arraylist lleno de breedCats nos bajamos las imagenes a través de la utl https://api.thecatapi.com/v1/images/0XYvRd7oD por ejemplo
        catController.downloadListBreedCatImages();
        //catController.createFileBreedCatSQL();
        //1.Apoyándonos en el arraylist nos descargamos 10 imágenes de cada raza a través de https://api.thecatapi.com/v1/images/search?limit=1&breed_ids="+breedCat.getIdName()+""
        //2.Las guardamos en images-cat
        //3. creamos el archivo sqlactAPI.sql
        //el parámetro son las repeticiones
        //catController.downloadImagesCatNotList(9);
    }
    
    public static void breedDogs(StringManager stringManager){        
        BreedDogController dogController=new BreedDogController(stringManager);
        dogController.createArrayModelsDogs();
        dogController.downloadListBreedDogImages(1);
        //dogController.createFileSQL();
        //dogController.downloadImagesDogNotList(9);
        //dogController.createUpdateFile();
    }
    
    public static void specieFish(StringManager stringManager){
        SpecieFishController fishController=new SpecieFishController(stringManager);
        fishController.createModelsFish();
        fishController.dowloadListSpecieFishImages();
        //fishController.createFileSpeciesFishSQL();
        //fishController.downloadImagesFishNotList(1);
    }
    
    public static void fish(StringManager stringManager){
        FishController fishController=new FishController( stringManager);
        fishController.createModelsFish();
    }
        
    
    
}
