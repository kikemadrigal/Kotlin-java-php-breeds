
package com.mycompany.consumoapi.controllers;


import com.mycompany.consumoapi.ConsumoAPI;
import com.mycompany.consumoapi.models.BreedCat;
import com.mycompany.consumoapi.utils.Constants;
import com.mycompany.consumoapi.utils.FileManager;
import com.mycompany.consumoapi.utils.StringManager;
import static com.mycompany.consumoapi.utils.FileManager.saveImage;

import java.io.File;
import java.io.IOException;

import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.json.JSONArray;
import org.json.JSONObject;

/**
 *
 * @author tipolisto
 */
public class BreedCatController {
    ArrayList<BreedCat> arrayList;
    URL url=null;
    HttpURLConnection con=null;
    StringManager stringManager;
    public BreedCatController(StringManager stringManager) {
        arrayList=new ArrayList();
        connectWithHttpURLConnection();
        this.stringManager=stringManager;
    }
    private void connectWithHttpURLConnection(){
        HashMap<String, String> params = new HashMap<>();
        params.put(Constants.PARAM_XAPIKEY_URL_THECATAPI, Constants.PARAM_XAPIKEY_URL_THECATAPI_VALUE);	
        try{
            url=new URL(Constants.URL_THECATAPI);
            con=(HttpURLConnection) url.openConnection();
            Iterator it = params.keySet().iterator();
            while(it.hasNext()){
              String key =  (String) it.next();
              String value=params.get(key);
              con.setRequestProperty(key, value);
            }
            con.setRequestMethod("GET");
            con.connect();
        } catch (org.json.JSONException ex) {
            Logger.getLogger(ConsumoAPI.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            System.err.println("Fallo al leer: "+ex);;
        } 
    }
    
    public void createModels(){
        try {
            int responseCode=con.getResponseCode();
            if(responseCode!=200){
                throw new RuntimeException("Exception "+responseCode);
            }else{
                //3.Abrir un scanner que lea el flujo de datos
                StringBuilder informationString=new StringBuilder();
                Scanner scanner=new Scanner(url.openStream());
                try {
                    while (scanner.hasNext()){
                        informationString.append(scanner.nextLine());
                    }
                }finally{
                    scanner.close(); 
                }
                //4.Interpretamos el contenido de la respuesta
                JSONArray jsonArray=new JSONArray(informationString.toString());
                for(int i=0; i<jsonArray.length();i++){
                    JSONObject jsonObject = jsonArray.getJSONObject(i);
                    
                    String id_name=(jsonObject.has("id"))?jsonObject.getString("id"):"";
                    id_name=stringManager.deleteComa(id_name);
                    
                    String name=(jsonObject.has("name"))?jsonObject.getString("name"):"";
                    name=stringManager.deleteComa(name);
                    String name_es=name;
                    //criado para
                    String cfa_url=(jsonObject.has("cfa_url"))?jsonObject.getString("cfa_url"):"";
                    cfa_url=stringManager.deleteComa(cfa_url);
                    //grupo de raza
                    String vetstreet_url=(jsonObject.has("vetstreet_url"))?jsonObject.getString("vetstreet_url"):"";
                    vetstreet_url=stringManager.deleteComa(vetstreet_url);
                     //esperanza de vida
                    String vcahospitals_url=(jsonObject.has("vcahospitals_url"))?jsonObject.getString("vcahospitals_url"):"";
                    vcahospitals_url=stringManager.deleteComa(vcahospitals_url);
                    
                    String temperament=(jsonObject.has("temperament"))?jsonObject.getString("temperament"):"";
                    temperament=stringManager.deleteComa(temperament);
                    String temperament_es=temperament;
                    
                    String origin=(jsonObject.has("origin"))?jsonObject.getString("origin"):"";
                    origin=stringManager.deleteComa(origin);
                    
                    String country_codes=(jsonObject.has("country_codes"))?jsonObject.getString("country_codes"):"";
                    country_codes=stringManager.deleteComa(country_codes);
                    
                    String country_code=(jsonObject.has("country_code"))?jsonObject.getString("country_code"):"";
                    country_code=stringManager.deleteComa(country_code);
                   
                    String description=(jsonObject.has("description"))?jsonObject.getString("description"):"";
                    description=stringManager.deleteComa(description);
                    
                    String description_es=description;
                    
                    String life_span=(jsonObject.has("life_span"))?jsonObject.getString("life_span"):"";
                    life_span=stringManager.deleteComa(life_span);
                    
                    int indoor=(jsonObject.has("indoor"))?jsonObject.getInt("indoor"):0;                    
                    int lap=(jsonObject.has("lap"))?jsonObject.getInt("lap"):0;    
                    
                    String alt_names=(jsonObject.has("alt_names"))?jsonObject.getString("alt_names"):"";
                    alt_names=stringManager.deleteComa(alt_names);
                    
                    int adaptability=(jsonObject.has("adaptability"))?jsonObject.getInt("adaptability"):0;                    
                    int affection_level=(jsonObject.has("affection_level"))?jsonObject.getInt("affection_level"):0;
                    int child_friendly=(jsonObject.has("child_friendly"))?jsonObject.getInt("child_friendly"):0;
                    int cat_friendly=(jsonObject.has("cat_friendly"))?jsonObject.getInt("cat_friendly"):0;
                    int dog_friendly=(jsonObject.has("dog_friendly"))?jsonObject.getInt("dog_friendly"):0;
                    int energy_level=(jsonObject.has("energy_level"))?jsonObject.getInt("energy_level"):0;
                    int grooming=(jsonObject.has("grooming"))?jsonObject.getInt("grooming"):0;
                    int health_issues=(jsonObject.has("health_issues"))?jsonObject.getInt("health_issues"):0;
                    int intelligence=(jsonObject.has("intelligence"))?jsonObject.getInt("intelligence"):0;
                    int shedding_level=(jsonObject.has("shedding_level"))?jsonObject.getInt("shedding_level"):0;
                    int social_needs=(jsonObject.has("social_needs"))?jsonObject.getInt("social_needs"):0;
                    int stranger_friendly=(jsonObject.has("stranger_friendly"))?jsonObject.getInt("stranger_friendly"):0;
                    int vocalisation=(jsonObject.has("vocalisation"))?jsonObject.getInt("vocalisation"):0;
                    int experimental=(jsonObject.has("experimental"))?jsonObject.getInt("experimental"):0;
                    int hairless=(jsonObject.has("hairless"))?jsonObject.getInt("hairless"):0;
                    int natural=(jsonObject.has("natural"))?jsonObject.getInt("natural"):0;
                    int rare=(jsonObject.has("rare"))?jsonObject.getInt("rare"):0;
                    int rex=(jsonObject.has("rex"))?jsonObject.getInt("rex"):0;
                    int suppressed_tail=(jsonObject.has("suppressed_tail"))?jsonObject.getInt("suppressed_tail"):0;
                    int short_legs=(jsonObject.has("short_legs"))?jsonObject.getInt("short_legs"):0;
                    
                    String wikipedia_url=(jsonObject.has("wikipedia_url"))?jsonObject.getString("wikipedia_url"):"";
                    wikipedia_url=stringManager.deleteComa(wikipedia_url);
                    
                    int hypoallergenic=(jsonObject.has("hypoallergenic"))?jsonObject.getInt("hypoallergenic"):0;
                    
                    String weight="";
                    if(jsonObject.has("weight") ){
                        Object weightJsonObject=jsonObject.get("weight");
                        if(weightJsonObject instanceof JSONObject){
                            //Obtenemos solo el que tenga https
                            weight=weightJsonObject.toString();
                        }
                    }
                    
                     
                    String date=(jsonObject.has("date"))?jsonObject.getString("date"):"";
                    date=stringManager.deleteComa(date);
                    
                    String reference_image_id=(jsonObject.has("reference_image_id"))?jsonObject.getString("reference_image_id"):"";
                    reference_image_id=stringManager.deleteComa(reference_image_id);
                    
                    String pathWithoutSpaces=stringManager.deleteSpaces(name);
                    String path_image="media/images-list-cats/"+pathWithoutSpaces+".jpg";
                    
                    BreedCat breedCat=new BreedCat(
                            0,
                            id_name,
                            name,
                            name_es,
                            cfa_url,
                            vetstreet_url,
                            vcahospitals_url,
                            temperament,
                            temperament_es,
                            origin,
                            country_codes,
                            country_code,
                            description,
                            description_es,
                            life_span,
                            indoor,
                            lap,
                            alt_names,
                            adaptability,
                            affection_level,
                            child_friendly,
                            dog_friendly,
                            energy_level,
                            grooming,
                            health_issues,
                            intelligence,
                            shedding_level,
                            social_needs,
                            stranger_friendly,
                            vocalisation,
                            experimental,
                            hairless,
                            natural,
                            rare,
                            rex,
                            suppressed_tail,
                            short_legs,
                            wikipedia_url,
                            hypoallergenic,
                            weight,
                            date,
                            reference_image_id,
                            path_image,
                            1 );
                    arrayList.add(breedCat);
                }
                con.disconnect();
            }
        } catch (MalformedURLException ex) {
            Logger.getLogger(ConsumoAPI.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(ConsumoAPI.class.getName()).log(Level.SEVERE, null, ex);
        }catch (org.json.JSONException ex) {
            Logger.getLogger(ConsumoAPI.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    public void createFileBreedCatSQL(){
        ArrayList<String> arrayListSQL=new ArrayList();
        
        /*String sql="INSERT INTO breed_cat(null,"+
                "id,"+
                "id_name,"+
                "name, "+
                "name_es,"+
                "cfa_url,"+
                "vetstreet_url,"+
                "vcahospitals_url,"+
                "temperament,"+
                "temperament_es,"+
                "origin,"+
                "country_codes,"+
                "country_code,"+
                "description,"+
                "description_es,"+
                "life_span,"+
                "indoor,"+
                "lap,"+
                "alt_names, "+
                "adaptability,"+
                "affection_level,"+
                "child_friendly,"+
                "dog_friendly,"+
                "energy_level, "+
                "grooming,"+
                "health_issues,"+
                "intelligence,"+
                "shedding_level,"+
                "social_needs,"+
                "stranger_friendly,"+
                "vocalisation,"+
                "experimental,"+
                "hairless,"+
                "natural,"+
                "rare,"+
                "rex,"+
                "suppressed_tail,"+
                "short_legs, "+
                 "wikipedia_url,"+
                "hypoallergenic,"+
                "weight,"+
                "date,"+
                "reference_image_id, "+
                "path_image,"+
                "creator_id"+
             ") VALUES\n";
        */
        String sql="INSERT INTO `breed_cat` (`id`, `id_name`, `name`, `name_es`, `cfa_url`, `vetstreet_url`, `vcahospitals_url`, `temperament`, `temperament_es`, `origin`, `country_codes`, `country_code`, `description`, `description_es`, `life_span`, `indoor`, `lap`, `alt_names`, `adaptability`, `affection_level`, `child_friendly`, `dog_friendly`, `energy_level`, `grooming`, `health_issues`, `intelligence`, `shedding_level`, `social_needs`, `stranger_friendly`, `vocalisation`, `experimental`, `hairless`, `natural`, `rare`, `rex`, `suppressed_tail`, `short_legs`, `wikipedia_url`, `hypoallergenic`, `weight`, `date`, `reference_image_id`, `path_image`, `creator_id`)VALUES\n";
       
       arrayListSQL.add(sql);
       int count=0;
       for(BreedCat breedCat:arrayList){
            if(count==arrayList.size()-1){
                sql="(null,'"+
                breedCat.getIdName()+"','"+
                breedCat.getName()+"','"+
                breedCat.getName_es()+"','"+
                breedCat.getCfa_url()+"','"+
                breedCat.getVetstreet_url()+
                "','"+breedCat.getVcahospitals_url()+
                "','"+breedCat.getTemperament()+
                "','"+breedCat.getTemperament_es()+
                "','"+breedCat.getOrigin()+
                "','"+breedCat.getCountry_codes()+
                "','"+breedCat.getCountry_code()+
                "','"+breedCat.getDescription()+
                "','"+breedCat.getDescription_es()+
                "','"+breedCat.getLife_span()+
                "','"+breedCat.getIndoor()+
                "','"+breedCat.getLap()+
                "','"+breedCat.getAlt_names()+
                "','"+breedCat.getAdaptability()+
                "','"+breedCat.getAffection_level()+
                "','"+breedCat.getChild_friendly()+
                "','"+breedCat.getDog_friendly()+
                "','"+breedCat.getEnergy_level()+   
                "','"+breedCat.getGrooming()+
                "','"+breedCat.getHealth_issues()+
                "','"+breedCat.getIntelligence()+
                "','"+breedCat.getShedding_level()+
                "','"+breedCat.getSocial_needs()+
                "','"+breedCat.getStranger_friendly()+
                "','"+breedCat.getVocalisation()+
                "','"+breedCat.getExperimental()+
                "','"+breedCat.getHairless()+
                "','"+breedCat.getNatural()+
                "','"+breedCat.getRare()+
                "','"+breedCat.getRex()+
                "','"+breedCat.getSuppressed_tail()+
                "','"+breedCat.getShort_legs()+
                "','"+breedCat.getWikipedia_url()+
                "','"+breedCat.getHypoallergeni()+
                "','"+breedCat.getWeight()+
                "','"+breedCat.getDate()+
                "','"+breedCat.getReference_image_id()+
                "','"+breedCat.getPath_image()+
                "',"+breedCat.getCreator_id()+")\n";
            }else{
                sql="(null,'"+
                breedCat.getIdName()+"','"+
                breedCat.getName()+"','"+
                breedCat.getName_es()+"','"+
                breedCat.getCfa_url()+"','"+
                breedCat.getVetstreet_url()+
                "','"+breedCat.getVcahospitals_url()+
                "','"+breedCat.getTemperament()+
                "','"+breedCat.getTemperament_es()+
                "','"+breedCat.getOrigin()+
                "','"+breedCat.getCountry_codes()+
                "','"+breedCat.getCountry_code()+
                "','"+breedCat.getDescription()+
                "','"+breedCat.getDescription_es()+
                "','"+breedCat.getLife_span()+
                "','"+breedCat.getIndoor()+
                "','"+breedCat.getLap()+
                "','"+breedCat.getAlt_names()+
                "','"+breedCat.getAdaptability()+
                "','"+breedCat.getAffection_level()+
                "','"+breedCat.getChild_friendly()+
                "','"+breedCat.getDog_friendly()+
                "','"+breedCat.getEnergy_level()+   
                "','"+breedCat.getGrooming()+
                "','"+breedCat.getHealth_issues()+
                "','"+breedCat.getIntelligence()+
                "','"+breedCat.getShedding_level()+
                "','"+breedCat.getSocial_needs()+
                "','"+breedCat.getStranger_friendly()+
                "','"+breedCat.getVocalisation()+
                "','"+breedCat.getExperimental()+
                "','"+breedCat.getHairless()+
                "','"+breedCat.getNatural()+
                "','"+breedCat.getRare()+
                "','"+breedCat.getRex()+
                "','"+breedCat.getSuppressed_tail()+
                "','"+breedCat.getShort_legs()+
                "','"+breedCat.getWikipedia_url()+
                "','"+breedCat.getHypoallergeni()+
                "','"+breedCat.getWeight()+
                "','"+breedCat.getDate()+
                "','"+breedCat.getReference_image_id()+
                "','"+breedCat.getPath_image()+
                "',"+breedCat.getCreator_id()+"),\n";
            } 
            arrayListSQL.add(sql);  
            count++;
        }
        File file=new File("breedCatListAPI.sql");
        FileManager.writeFile(file, arrayListSQL);
    }
    public void downloadListBreedCatImages(){
        //https://api.thecatapi.com/v1/images/0XYvRd7oD
        
        // Directory Path
        Path dirPath = Paths.get("images-breeds-cats");
        // Si no existe lo creamos
        if (Files.notExists(dirPath)) {
            // Directory not exists
            File directory = new File("images-list-cats");
            directory.mkdir();
        }
        for(BreedCat breedCat:arrayList){
             try{
                Thread.sleep(1000);
                if(!breedCat.getReference_image_id().isEmpty()){
                    String urlImage="https://api.thecatapi.com/v1/images/"+breedCat.getReference_image_id();
                    System.out.println("descargando "+urlImage);
                    String name=breedCat.getName();
                    name=stringManager.deleteSpaces(name);
                    name="images-list-cats/"+name+".jpg";
                    breedCat.setPath_image(name);
                    downloadImageBreedCat(urlImage,name);       
                }
            } catch (InterruptedException ex) {  
                 System.err.println("InterruptedException "+ex);
            }
        }
    }
    private void downloadImageBreedCat(String urlImage,String name) {
        //https://api.thecatapi.com/v1/images/0XYvRd7oD
        try {
            URL url=new URL(urlImage);
            //2.¿petición correcta?
            int responseCode=con.getResponseCode();
            if(responseCode!=200){
                throw new RuntimeException("Exception "+responseCode);
            }else{
                StringBuilder informationString=new StringBuilder();
                Scanner scanner=new Scanner(url.openStream());
                try {
                    while (scanner.hasNext()){
                        informationString.append(scanner.nextLine());
                    }
                }finally{
                    scanner.close(); 
                }
                //4.Interpretamos el contenido de la respuesta
                JSONObject jsonObject=new JSONObject(informationString.toString());
                String image=(jsonObject.has("url"))?jsonObject.getString("url"):"";
                if(image!=null){
                    saveImage(image,name);
                }
            }
        }
        catch (MalformedURLException ex) {
            Logger.getLogger(ConsumoAPI.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(ConsumoAPI.class.getName()).log(Level.SEVERE, null, ex);
        }catch (org.json.JSONException ex) {
            Logger.getLogger(ConsumoAPI.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    private void downloadImageCatNotList(String urlImage,String name) {
        System.out.println(urlImage);

        try {
            url=new URL(urlImage); 
            con=(HttpURLConnection) url.openConnection();
            //2.¿petición correcta?
            int responseCode=con.getResponseCode();
            if(responseCode!=200){
                //throw new RuntimeException("Exception "+responseCode);
                System.out.println("error html "+responseCode);
            }else{
                StringBuilder informationString=new StringBuilder();
                Scanner scanner=new Scanner(url.openStream());
                try {
                    while (scanner.hasNext()){
                        informationString.append(scanner.nextLine());
                    }
                }finally{
                    scanner.close(); 
                }
                JSONArray jsonArray=new JSONArray(informationString.toString());
                JSONObject jsonObject = jsonArray.getJSONObject(0);
                System.out.println(""+jsonObject.toString());
                String image=(jsonObject.has("url"))?jsonObject.getString("url"):"";
                if(image!=null){
                    saveImage(image,name);
                }
            }
        }
        catch (MalformedURLException ex) {
            Logger.getLogger(ConsumoAPI.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(ConsumoAPI.class.getName()).log(Level.SEVERE, null, ex);
        }catch (org.json.JSONException ex) {
            Logger.getLogger(ConsumoAPI.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void downloadImagesCatNotList(int repetitions){
        ArrayList<String> arrayListSQL=new ArrayList();
        String sql="INSERT INTO cat(name,name_es,breed_id,family, description,description_es,year_of_birth,sex,address,vaccines,path_image,date,creator_id) VALUES";
        arrayListSQL.add(sql);
        Path dirPath = Paths.get("images-cats");
        // Si no existe lo creamos
        if (Files.notExists(dirPath)) {
            // Directory not exists
            File directory = new File("images-cats");
            directory.mkdir();
        }
       
        for(BreedCat breedCat:arrayList){
             int count=0;
            try{
                for(int i=0; i<repetitions;i++){
                    Thread.sleep(3000);
                    String urlImage="https://api.thecatapi.com/v1/images/search?limit=1&breed_ids="+breedCat.getIdName()+"";
                    //String nameFile="images-cats\\"+ breedCat.getName()+"-"+count+".jpg";
                    String nameFile=breedCat.getName();
                    nameFile=stringManager.deleteSpaces(nameFile);
                    String pathFile="media/images-cats/"+nameFile+"-"+count+".jpg";
                    String pathOnServer="images-cats/"+nameFile+"-"+count+".jpg";
                    System.out.println("Creando "+pathOnServer);
                    //downloadImageCatNotList(urlImage,pathOnServer); 
                    //String nameCat = new String(stringManager.getNameFromArray(), StandardCharsets.UTF_8);
                    String nameCat =stringManager.getNameFromArray();
                    String family =stringManager.getFamilyFromFile();
                    String description =stringManager.getDescriptionCatsFromArray();
                    String description_es=description;
                    int year_of_birth=stringManager.getYearsOfBirthFromArray();
                    int sex=stringManager.getSex();
                    String address=stringManager.getDireccionesFromArray();
                    int vaccines=0;
                    Date fecha=stringManager.getFecha();
                    if(count==arrayList.size()*repetitions){
                        sql="('"+nameCat+"','"+nameCat+"','"+breedCat.getIdName()+"' , '"+family+"' , '"+description+"' , '"+description_es+"' , '"+year_of_birth+"' , '"+sex+"', '"+address+"' , '"+vaccines+"' , '"+pathFile+"','"+fecha+"', 1)";
                    }
                    else
                         sql="('"+nameCat+"','"+nameCat+"','"+breedCat.getIdName()+"' , '"+family+"' , '"+description+"' , '"+description_es+"' , '"+year_of_birth+"' , '"+sex+"', '"+address+"' , '"+vaccines+"' , '"+pathFile+"','"+fecha+"', 1),";
                    count++;
                    
                    arrayListSQL.add(sql);
                }
                
            } catch (InterruptedException ex) {  
                 System.err.println("InterruptedException "+ex);
            } 
        }
        
        File file=new File("catAPI.sql");
        FileManager.writeFile(file, arrayListSQL);
        
    }


    
}
