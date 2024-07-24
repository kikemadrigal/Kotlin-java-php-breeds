package com.mycompany.consumoapi.controllers;


import com.mycompany.consumoapi.ConsumoAPI;
import com.mycompany.consumoapi.models.BreedDog;
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
public class BreedDogController {
    ArrayList<BreedDog> arrayListBreed;
    URL url=null;
    HttpURLConnection con=null;
    StringManager stringManager;
    public BreedDogController(StringManager stringManager) {
        arrayListBreed=new ArrayList();
        connectWithHttpURLConnection();
        this.stringManager=stringManager;
    }
    private void connectWithHttpURLConnection(){
        HashMap<String, String> params = new HashMap<>();
        params.put(Constants.PARAM_XAPIKEY_URL_THEDOGAPI, Constants.PARAM_XAPIKEY_URL_THEDOGAPI_VALUE);		
        try{
            url=new URL(Constants.URL_THEDOGAPI);
            con=(HttpURLConnection) url.openConnection();
            Iterator it = params.keySet().iterator();
            while(it.hasNext()){
              String key =  (String) it.next();
              String value=params.get(key);
              con.setRequestProperty(key, value);
            }
            con.setRequestMethod("GET");
            con.connect();
        } catch (MalformedURLException ex) {
            Logger.getLogger(ConsumoAPI.class.getName()).log(Level.SEVERE, null, ex);
        } catch (org.json.JSONException ex) {
            Logger.getLogger(ConsumoAPI.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            System.err.println("Fallo al leer: "+ex);;
        } 
    }
    
    public void createArrayModelsDogs(){
        try {
            //1.Estudia la estructura de la tabla que quieres poner, está en: C:\xampp\htdocs\breeds\sql
            //2.¿petición correcta?
            int responseCode=con.getResponseCode();
            if(responseCode!=200){
                System.out.println("error html "+responseCode);
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
                //System.out.println(informationString);
                //4.Interpretamos el contenido de la respuesta
                JSONArray jsonArray=new JSONArray(informationString.toString());
                // Gson gson=new Gson();
                //5.Creamos el modelo del objeto breedDog y una lista con todos los breedDogs
                for(int i=0; i<jsonArray.length();i++){
                    JSONObject jsonObject = jsonArray.getJSONObject(i);
                    
                    int breedId=(jsonObject.has("id"))?jsonObject.getInt("id"):0;
                    
                    String name=(jsonObject.has("name"))?jsonObject.getString("name"):"";
                    name=stringManager.deleteComa(name);
                    String name_es=name;
                    //criado para
                    String bred_for=(jsonObject.has("bred_for"))?jsonObject.getString("bred_for"):"";
                    bred_for=stringManager.deleteComa(bred_for);
                    String bred_for_es=bred_for;
                    //grupo de raza
                    String breed_group=(jsonObject.has("breed_group"))?jsonObject.getString("breed_group"):"";
                    breed_group=stringManager.deleteComa(breed_group);
                    String breed_group_es=breed_group;
                    //esperanza de vida
                    String life_span=(jsonObject.has("life_span"))?jsonObject.getString("life_span"):"";
                    life_span=stringManager.deleteComa(life_span);
                    String temperament=(jsonObject.has("temperament"))?jsonObject.getString("temperament"):"";
                    temperament=stringManager.deleteComa(temperament);
                    String temparament_es=temperament;
                    String origin=(jsonObject.has("origin"))?jsonObject.getString("origin"):"";
                    origin=stringManager.deleteComa(origin);
                    
                    String weight="";
                    if(jsonObject.has("weight") ){
                        Object weightJsonObject=jsonObject.get("weight");
                        if(weightJsonObject instanceof JSONObject){
                            //Obtenemos solo el que tenga https
                            weight=weightJsonObject.toString();
                        }
                    }
                    String height="";
                    if(jsonObject.has("height") ){
                        Object heightJsonObject=jsonObject.get("height");
                        if(heightJsonObject instanceof JSONObject){
                            //Obtenemos solo el que tenga https
                            height=heightJsonObject.toString();
                        }
                    }
                    String reference_image_id=(jsonObject.has("reference_image_id"))?jsonObject.getString("reference_image_id"):"";
                    reference_image_id=stringManager.deleteComa(reference_image_id);
                    String pathImage="media/images-list-dogs/"+name+".jpg";
                    pathImage=stringManager.deleteSpaces(pathImage);
                    BreedDog breedDog=new BreedDog(0,breedId,name,name_es,bred_for,bred_for_es, breed_group,breed_group_es,life_span,temperament,temparament_es,origin,weight,height,"",reference_image_id,pathImage,1);
                    arrayListBreed.add(breedDog);
                }
            }   
        }catch (IOException ex) {
            System.err.println("Fallo al leer: "+ex);;
        } 
    }
    
    public void createFileSQL(){
        ArrayList<String> arrayListSQL=new ArrayList();
        String sql="""
                   INSERT INTO breed_dog( id, breed_id,name,name_es,bred_for,bred_for_es,breed_group,breed_group_es,life_span,temperament,temperament_es,origin,weight,height,date,reference_image_id,path_image,creator_id) VALUES
                   """;
        arrayListSQL.add(sql);
        int count=0;
        for(BreedDog breedDog:arrayListBreed){
            if(count==arrayListBreed.size()-1){
                sql="(null,'"+
                breedDog.get_breed_id()+"','"+       
                breedDog.getName()+"','"+
                breedDog.getName_es()+"','"+
                breedDog.getBred_for()+"','"+
                breedDog.getBred_for_es()+"','"+
                breedDog.getBreed_group()+"','"+
                breedDog.getBreed_group_es()+"','"+
                breedDog.getLife_span()+"','"+
                breedDog.getTemperament()+"','"+
                breedDog.getTemperament_es()+"','"+
                breedDog.getOrigin()+"','"+
                breedDog.getWeight()+"','"+
                breedDog.getHeight()+"','"+
                breedDog.getDate()+"','"+
                breedDog.getReference_image_id()+"','"+
                breedDog.getPath_image()+"','"+
                breedDog.getCreator_id()+
                "')\n";  
            }else{
                sql="(null,'"+
                breedDog.get_breed_id()+"','"+   
                breedDog.getName()+"','"+       
                breedDog.getName_es()+"','"+
                breedDog.getBred_for()+"','"+
                breedDog.getBred_for_es()+"','"+
                breedDog.getBreed_group()+"','"+
                breedDog.getBreed_group_es()+"','"+
                breedDog.getLife_span()+"','"+
                breedDog.getTemperament()+"','"+
                breedDog.getTemperament_es()+"','"+
                breedDog.getOrigin()+"','"+
                breedDog.getWeight()+"','"+
                breedDog.getHeight()+"','"+
                breedDog.getDate()+"','"+
                breedDog.getReference_image_id()+"','"+
                breedDog.getPath_image()+"','"+
                breedDog.getCreator_id()+
                "'),\n";   
            }
            arrayListSQL.add(sql);              
            count++;
        }
        File file=new File("breedDogListAPI.sql");
        FileManager.writeFile(file, arrayListSQL);
    }
    
    //repetition:número de repeticiones por 
    public void downloadListBreedDogImages(int repetitions){
        // Directory Path
        Path dirPath = Paths.get("images-list-dogs");
        // Si no existe lo creamos
        if (Files.notExists(dirPath)) {
            // Directory not exists
            File directory = new File("images-list-dogs");
            directory.mkdir();
        }
        for(BreedDog breedDog:arrayListBreed){
            try{
                Thread.sleep(3000);
                //https://api.thedogapi.com/v1/images/search?bree_id=HJ7Pzg5EQ
                if(!breedDog.getReference_image_id().isEmpty()){
                    //String urlImage="https://api.thedogapi.com/v1/images/search?bree_id="+breedDog.getReference_image_id();
                    String urlImage="https://api.thedogapi.com/v1/images/search?limit=1&breed_ids="+breedDog.get_breed_id();
                   
                    String name=breedDog.getName();
                    name=stringManager.deleteSpaces(name);
                    name="images-list-dogs\\"+name+".jpg";
                    System.out.println("Descargando "+name);
                    breedDog.setPath_image(name);
                    downloadImage(urlImage,name,con,repetitions);       
                }
            } catch (InterruptedException ex) {  
                System.err.println("InterruptedException "+ex);
            }
        }
    }
    
    private void downloadImage(String urlImage,String name,HttpURLConnection con, int repeat) {
        try {
            for(int i=0; i<repeat;i++){
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
                    JSONArray jsonArray=new JSONArray(informationString.toString());
                    JSONObject jsonObject = jsonArray.getJSONObject(0);
                    String image=(jsonObject.has("url"))?jsonObject.getString("url"):"";
                    if(image!=null){
                        saveImage(image,name);
                    }
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
        private void downloadImageBreedDog(String urlImage,String name) {
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
                    image=stringManager.deleteComa(image);
                    String nameImage="images-breeds-cats\\"+name+".jpg";
                    saveImage(image,nameImage);
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
    private void downloadImageDogNotList(String urlImage,String name) {
        System.out.println("Url imagen a descargar: "+urlImage);

        try {
            url=new URL(urlImage);
            con=(HttpURLConnection) url.openConnection();
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
                JSONArray jsonArray=new JSONArray(informationString.toString());
                JSONObject jsonObject = jsonArray.getJSONObject(0);
                System.out.println("Imagen Dog descargado: "+jsonObject.toString());
                String image=(jsonObject.has("url"))?jsonObject.getString("url"):"";
                if(image!=null){
                    System.out.println("Obtenida la image: "+image);
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
    
    
     public void downloadImagesDogNotList(int repetitions){
         int count=0;
        ArrayList<String> arrayListSQL=new ArrayList();
        String sql="INSERT INTO dog(name,name_es,breed_id,family,description,year_of_birth,sex,address,vaccines,path_image,date,creator_id) VALUES";
        arrayListSQL.add(sql);
        Path dirPath = Paths.get("images-dogs");
        // Si no existe lo creamos
        if (Files.notExists(dirPath)) {
            // Directory not exists
            File directory = new File("images-dogs");
            directory.mkdir();
        }
       
        for(BreedDog breedDog:arrayListBreed){

            try{
                for(int i=0; i<repetitions;i++){
                    Thread.sleep(5000);
                    
                    String urlImage="https://api.thedogapi.com/v1/images/search?limit=1&breed_ids="+breedDog.get_breed_id();
                    //System.err.println("Vamos a descargar "+breedCat.getIdName());
                    String nameFile=breedDog.getName();
                    nameFile=stringManager.deleteSpaces(nameFile);
                    String pathFile="media/images-dogs/"+nameFile+"-"+count+".jpg";
                    String pathOnServer="images-dogs/"+nameFile+"-"+count+".jpg";
                    System.out.println("Descargando la imagen "+pathOnServer);
                    downloadImageDogNotList(urlImage,pathOnServer); 
                    String nameDog = stringManager.getNameFromArray();
                    String family =stringManager.getFamilyFromFile();
                    String description =stringManager.getDescriptionDogsFromArray(count);

                    Date birth=stringManager.getFecha();
                    String year_of_birth=birth.toString();
                    int sex=stringManager.getSex();
                    String address=stringManager.getDireccionesFromArray();
                    int vaccines=0;
                    String fecha=stringManager.getFecha().toString();
                    if(count==arrayListBreed.size()*repetitions){
                        //id, nombre, nombre_es, breed_id, path_image, date, creator_id
                        sql="('"+nameDog+"','"+nameDog+"','"+breedDog.get_breed_id()+"' , '"+family+"' , '"+description+"' , '"+year_of_birth+"' , '"+sex+"' , '"+address+"' , '"+vaccines+"' , '"+pathFile+"' , '"+fecha+"', 1)";
                    }else
                        sql="('"+nameDog+"','"+nameDog+"','"+breedDog.get_breed_id()+"' , '"+family+"' , '"+description+"' , '"+year_of_birth+"' , '"+sex+"' , '"+address+"' , '"+vaccines+"' , '"+pathFile+"' , '"+fecha+"', 1),";
                    count++;
                    arrayListSQL.add(sql);
                }
                
            } catch (InterruptedException ex) {  
                 System.err.println("InterruptedException "+ex);
            } 
        }
        
        File file=new File("dogAPI.sql");
        FileManager.writeFile(file, arrayListSQL);
        
    }
    
     public void createUpdateFile(){
        ArrayList<String> arrayListSQL=new ArrayList();
        String sql="";
        for(int i=0; i<1547;i++){
            String family =stringManager.getFamilyFromFile();
            String description =stringManager.getDescriptionDogsFromArray(i);
            Date birth=stringManager.getFecha();
            String year_of_birth=birth.toString();
            int sex=stringManager.getSex();
            String address=stringManager.getDireccionesFromArray();
            int vaccines=0;
            String fecha=stringManager.getFecha().toString();
            sql="update dog set family='"+family.trim()+"' , description_es='"+description+"' , year_of_birth='"+year_of_birth+"' , sex='"+sex+"' , address='"+address+"' WHERE id='"+i+"';";
            arrayListSQL.add(sql);
        }
        File file=new File("updateDog.sql");
        FileManager.writeFile(file, arrayListSQL);
     }
}
