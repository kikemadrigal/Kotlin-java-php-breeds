package com.mycompany.consumoapi.controllers;


import com.mycompany.consumoapi.models.SpecieFish;
import com.mycompany.consumoapi.utils.Constants;
import com.mycompany.consumoapi.utils.FileManager;
import static com.mycompany.consumoapi.utils.FileManager.saveImage;
import com.mycompany.consumoapi.utils.StringManager;

import java.io.File;
import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashMap;
import org.json.JSONArray;
import org.json.JSONObject;




/**
 *
 * @author tipolisto
 */
public class SpecieFishController {
    ArrayList<SpecieFish> arrayListFish;
    HttpResponse<String> response;
    StringManager stringManager;
    public SpecieFishController(StringManager stringManager){
        arrayListFish=new ArrayList();
        connectWithHttpClient();
        this.stringManager=stringManager;
    }
    private void connectWithHttpClient(){
        /*HashMap<String, String> map = new HashMap<String, String>();
        map.put(Constants.PARAM_X_API_KEY_URL_RAPIDAPI, Constants.PARAM_X_API_KEY_URL_RAPIDAPI_VALUE);	
        map.put(Constants.PARAM_X_HOST_URL_RAPIDAPI, Constants.PARAM_X_HOST_URL_RAPIDAPI_value);
        String headers[]=new String[2];
        int count=0;
        Iterator it = map.keySet().iterator();
        while(it.hasNext()){
          String key =  (String) it.next();
          String value=map.get(key);
          headers[count]=value;
          count++;
        }*/
        try{
            HttpRequest request = HttpRequest.newBuilder()
             .uri(URI.create(Constants.URL_RAPIDAPI))
             .header(Constants.PARAM_X_API_KEY_URL_RAPIDAPI, Constants.PARAM_X_API_KEY_URL_RAPIDAPI_VALUE)
             .header(Constants.PARAM_X_HOST_URL_RAPIDAPI, Constants.PARAM_X_HOST_URL_RAPIDAPI_value)
             .method("GET", HttpRequest.BodyPublishers.noBody())
             .build();
            
     
            response = HttpClient.newHttpClient().send(request, HttpResponse.BodyHandlers.ofString());
        }catch(IOException ex){
            System.out.println(" "+ex);
        }catch(InterruptedException ex){
             System.out.println(" "+ex);
        }
    }
    public void createModelsFish(){
        // System.out.println(response.body()); 
         JSONArray jsonArray=new JSONArray(response.body());

         //String sql="INSERT INTO specie_fish(name,cfa_url,vetstreet_url) VALUES\n";
         Path dirPath = Paths.get("images-list-fish");
         // Si no existe lo creamos
         if (Files.notExists(dirPath)) {
             File directory = new File("images-list-fish");
             directory.mkdir();
         }
         for(int i=0; i<jsonArray.length();i++){
             SpecieFish specieFish=new SpecieFish();
             JSONObject jsonObject = jsonArray.getJSONObject(i);
             String name=(jsonObject.has("name"))?jsonObject.getString("name"):"";
             name=stringManager.deleteComa(name);  
             name=stringManager.deleteSpaces(name);  
  
             specieFish.setName(name);
             specieFish.setName_es(name);
             Object meta=null;
             if(jsonObject.has("meta") ){
                 meta=jsonObject.get("meta");
                 if(meta instanceof JSONObject){
                     //Obtenemos solo el que tenga https
                     String description=meta.toString();
                     description=stringManager.deleteComa(description);
                     if(!description.isEmpty()){
                        specieFish.setDescription(description);
                        System.out.println(""+description);
                     }else{
                         System.out.println("La description esta vacia.");
                     }
                 }
                 //En este caso suee ser un string que pone not disponible
                 else{
                     specieFish.setDescription(""+meta);
                     System.out.println(""+meta);
                 }
             } 
            String urlWiki=(jsonObject.has("url"))?jsonObject.getString("url"):"";
            urlWiki=stringManager.deleteComa(urlWiki);
            specieFish.setUrlWiki(urlWiki);
             //grupo de raza
            Object img_src_set=null;
            if(jsonObject.has("img_src_set") ){
                 img_src_set=jsonObject.get("img_src_set");
                 if(img_src_set instanceof JSONObject){
                     //Obtenemos solo el que tenga https
                     String urlPath=getURL(img_src_set.toString());
                     if(!urlPath.isEmpty()){
                        urlPath=stringManager.deleteComa(urlPath);
                        specieFish.setURL_image(urlPath);
                        //specieFish.setURL_image(" ");
                     }
                 }
                 //Es este caso suele ser un string que pone not disponible
                 else{
                     specieFish.setURL_image(""+img_src_set);
                    // System.out.println(""+img_src_set);
                 }
            }
            String pathImage="media/images-list-fish/"+name+".jpg";
            specieFish.setPath_image(pathImage);
            arrayListFish.add(specieFish);
         }//Final del for que recorre el jsonArray
    }
    public void createFileSpeciesFishSQL(){
        ArrayList<String> arrayListSQL=new ArrayList();
        String sql="INSERT INTO specie_fish(name, name_es,description,url_wiki,url_image,path_image,date,creator_id) VALUES";
        arrayListSQL.add(sql);
        int count=0;
        for(SpecieFish specieFish:arrayListFish){
   
            if(count==arrayListFish.size()-1){
                sql="('"+
                specieFish.getName()+"','"+
                specieFish.getName_es()+"','"+
                specieFish.getDescription()+"','"+
                specieFish.getUrlWiki()+"','"+
                specieFish.getURL_image()+"','"+
                specieFish.getPath_image()+"','"+
                specieFish.getDate()+"',1)\n";  
            }else{
                sql="('"+
                specieFish.getName()+"','"+
                specieFish.getName_es()+"','"+
                specieFish.getDescription()+"','"+
                specieFish.getUrlWiki()+"','"+
                specieFish.getURL_image()+"','"+
                specieFish.getPath_image()+"','"+
                specieFish.getDate()+"',1),\n";  
            }
            arrayListSQL.add(sql);              
            count++;
        }
        File file=new File("specieFishAPI.sql");
        FileManager.writeFile(file, arrayListSQL);
    
    }
    
    private String getURL(String img_src_set){
       String url="";
       String array[]=img_src_set.split("\"");
       for(String value:array){
           if(value.contains("https")){
                url=value;
            }
       }
       return url;
    }
    
    public void dowloadListSpecieFishImages(){
        Path dirPath = Paths.get("images-list-fish");
        if (Files.notExists(dirPath)) {
            // Directory not exists
            File directory = new File("images-list-fish");
            directory.mkdir();
        }
        for(SpecieFish specieFish:arrayListFish){
            try {
                Thread.sleep(1000);
                if(!specieFish.getURL_image().contains("Not available")){
                    String name=stringManager.deleteSpaces(specieFish.getName());
                    String destinationFile="images-list-fish/"+name+".jpg";
                    try {
                        FileManager.saveImage(specieFish.getURL_image(), destinationFile);
                    } catch (IOException ex) {
                        System.err.println("IOException: "+ex);
                    }
                }
            } catch (InterruptedException ex) {  
                System.out.println("IOException: "+ex);
            }
        }
    }
    
    
    
    
   public void downloadImagesFishNotList(int repetitions){
        ArrayList<String> arrayListSQL=new ArrayList();
        String sql="INSERT INTO fish(name,name_es,specie_id,path_image,date,creator_id) VALUES";
        arrayListSQL.add(sql);
        Path dirPath = Paths.get("images-fish-list");
        // Si no existe lo creamos
        if (Files.notExists(dirPath)) {
            // Directory not exists
            File directory = new File("images-fish");
            directory.mkdir();
        }
       
        for(SpecieFish specieFish:arrayListFish){
            int count=0;
            try{
                for(int i=0; i<repetitions;i++){
                    Thread.sleep(1000);
                    String urlImage="https://fish-species.p.rapidapi.com/fish_api/fish/"+specieFish.getName()+"";
                    /*
                    Esta url nos devuelve este array de objetos
                        {
                            "id": 1,
                            "name": "Airbreathing catfish",
                            "url": "https://en.wikipedia.org/wiki/Airbreathing_catfish",
                            "img_src_set": {
                                "1.5x": "https://upload.wikimedia.org/wikipedia/commons/thumb/e/e8/Clarias_batrachus-ZOO.Brno.jpg/330px-Clarias_batrachus-ZOO.Brno.jpg",
                                "2x": "https://upload.wikimedia.org/wikipedia/commons/thumb/e/e8/Clarias_batrachus-ZOO.Brno.jpg/440px-Clarias_batrachus-ZOO.Brno.jpg"
                            },
                            "meta": {
                                "genera": "Bathyclarias, Channallabes, Clariallabes, Clarias, Dinotopterus, Dolichallabes, Encheloclarias, Gymnallabes, Heterobranchus, Horaglanis, Platyallabes, Platyclarias, Pseudotanganikallabes, Tanganikallabes, Uegitglanis, Xenoclarias",
                                "scientific_classification": {
                                    "domain": "eukaryota",
                                    "kingdom": "animalia",
                                    "phylum": "chordata",
                                    "class": "actinopterygii",
                                    "order": "siluriformes",
                                    "superfamily": "siluroidea",
                                    "family": "clariidaebonaparte,_1846"
                                }
                            }
                        }
                    */
                    String nameFile="images-fish/"+ specieFish.getName()+"-"+count+".jpg";
                    nameFile=stringManager.deleteComa(nameFile);
                    nameFile=stringManager.deleteSpaces(nameFile);
                    System.out.println("Descargando: "+nameFile);
                    if(urlImage!=null){
                        //saveImage(urlImage,specieFish.getName()+"-"+count+".jpg");
                        //downloadImageFishNotList(urlImage,nameFile);
                    }
                    //String nameFish = new String(stringManager.getNameFromArray(), StandardCharsets.UTF_8);
                    String nameFish = stringManager.getNameFromArray();
                    if(count==arrayListFish.size()*repetitions)
                        sql="('"+nameFish+"','"+nameFish+"','"+specieFish.getName()+"','"+nameFile+"','', 1)";
                    else
                        sql="('"+nameFish+"','"+nameFish+"','"+specieFish.getName()+"','"+nameFile+"','', 1),";
                    count++;
                    arrayListSQL.add(sql);
                }
            } catch (InterruptedException ex) {  
                 System.err.println("InterruptedException "+ex);
            } 
        }
        File file=new File("fishAPI.sql");
        FileManager.writeFile(file, arrayListSQL);
    }
   
   
   private void downloadImageFishNotList(String urlImage,String name) {
       Path dirPath = Paths.get("images-fish");
        if (Files.notExists(dirPath)) {
            // Directory not exists
            File directory = new File("images-list-fish");
            directory.mkdir();
        }
       //System.out.println(urlImage);
       urlImage=stringManager.subsSpacesURL(urlImage);
        try{
            HttpRequest request = HttpRequest.newBuilder()
             .uri(URI.create(urlImage))
             .header("X-RapidAPI-Key", "3a4e508e58mshc8f669e5eae0e18p1b6153jsn2bf8cb0f5d54")
             .header("X-RapidAPI-Host", "fish-species.p.rapidapi.com")
             .method("GET", HttpRequest.BodyPublishers.noBody())
             .build();
            response = HttpClient.newHttpClient().send(request, HttpResponse.BodyHandlers.ofString());
            JSONArray jsonArray=new JSONArray(response.body());
            JSONObject jsonObject = jsonArray.getJSONObject(0);
            //System.out.println(jsonObject.toString());
            Object img_src_set=null;
            if(jsonObject.has("img_src_set") ){
                 img_src_set=jsonObject.get("img_src_set");
                 if(img_src_set instanceof JSONObject){
                     //Obtenemos solo el que tenga https
                     String urlPath=getURL(img_src_set.toString());
                     if(!urlPath.isEmpty()){
                         System.out.println("path: "+urlPath);
                         saveImage(urlPath, name);
                     }
                 }else{
                      System.out.println("no es una instancia de JSNOOBject");
                 }
                
                 
             } 
           /* JSONArray jsonArray=new JSONArray(response.body());
            for(int i=0; i<jsonArray.length();i++){
                JSONObject jsonObject = jsonArray.getJSONObject(i);
                System.out.println(jsonObject.toString());
                URL url = new URL(urlImage);
                InputStream is = url.openStream();
                OutputStream os = new FileOutputStream(name);

                byte[] b = new byte[2048];
                int length;

                while ((length = is.read(b)) != -1) {
                        os.write(b, 0, length);
                }

                is.close();
                os.close();
            }     */    
        }catch(IOException ex){
            System.out.println("Excepcion cruel "+ex);
        }catch(InterruptedException ex){
             System.out.println("Excepcion cruel "+ex);
        }
    }
    

}
