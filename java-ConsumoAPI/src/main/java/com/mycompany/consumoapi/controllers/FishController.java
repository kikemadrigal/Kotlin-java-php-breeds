package com.mycompany.consumoapi.controllers;


import com.mycompany.consumoapi.ConsumoAPI;
import com.mycompany.consumoapi.models.BreedCat;
import com.mycompany.consumoapi.models.Fish;
import com.mycompany.consumoapi.models.SpecieFish;
import com.mycompany.consumoapi.utils.Constants;
import com.mycompany.consumoapi.utils.FileManager;
import static com.mycompany.consumoapi.utils.FileManager.saveImage;
import com.mycompany.consumoapi.utils.StringManager;

import java.io.File;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URL;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
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
import org.json.JSONException;
import org.json.JSONObject;




/**
 *
 * @author tipolisto
 */
public class FishController {
    ArrayList<Fish> arrayListFish;
    HttpResponse<String> response;
    StringManager stringManager;
    URL url=null;
    HttpURLConnection con=null;
    public FishController(StringManager stringManager){
        arrayListFish=new ArrayList();
        connectWithHttpURLConnection();
        this.stringManager=stringManager;
    }
    private void connectWithHttpURLConnection(){
        try{
            url=new URL(Constants.URL_BREEDS_TIPOLISTO);
            con=(HttpURLConnection) url.openConnection();
            con.setRequestMethod("GET");
            con.connect();
        } catch (org.json.JSONException ex) {
            Logger.getLogger(ConsumoAPI.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            System.err.println("Fallo al leer: "+ex);;
        } 
    }
    /*public void createModelsFish(){
        ArrayList<String> arrayListSQL=new ArrayList();
        String sql="INSERT INTO dog(name,name_es,specie_id,path_image,date,creator_id) VALUES";
       
        //JSONObject obj = new JSONObject(response);
        //System.out.println(response.body());
        try{
            JSONArray jsonArray=new JSONArray(response.body());
        
        
     
      
        for(int i=0; i<jsonArray.length();i++){
            JSONObject jsonObject = jsonArray.getJSONObject(i);
            //int specie_id=(jsonObject.has("id"))?jsonObject.getInt("id"):0;
            int specie_id=0;
            String name=stringManager.getFishNamesFromFile(i);
            String name_es=name;
            String fecha=stringManager.getFecha().toString();            
            String pathImage="media/images-fish/"+name+".jpg";
            if(i==jsonArray.length()-1){
                sql="('"+name+"','"+name_es+"','"+specie_id+"' , '"+pathImage+"' , '"+fecha+"' , 1)";
            }else
                sql="('"+name+"','"+name_es+"','"+specie_id+"' , '"+pathImage+"' , '"+fecha+"' , 1),";

            arrayListSQL.add(sql);
        }//Final del for que recorre el jsonArray
        File file=new File("fishApi.sql");
        FileManager.writeFile(file, arrayListSQL);
        }catch(JSONException ex){
            System.err.println("error: "+ex.getMessage());
        }
    }*/
    
    public void createModelsFish(){
        ArrayList<String> arrayListSQL=new ArrayList();
        String sql="INSERT INTO fish(name,name_es,specie_id,path_image,date,creator_id) VALUES";
        arrayListSQL.add(sql);
    
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
                //JSONObject jsonArray=new JSONObject(informationString.toString());
                String jsonArrayString=informationString.toString();
                String newString=jsonArrayString.substring(3, jsonArrayString.length());
             
                JSONArray jsonArray=new JSONArray(newString);


                //System.err.println("Valor: "+ newString);
                
                for(int i=0; i<jsonArray.length();i++){
                    JSONObject jsonObject = jsonArray.getJSONObject(i);
                    
                    int specie_id=(jsonObject.has("id"))?jsonObject.getInt("id"):0;
                    String specie_name=(jsonObject.has("name"))?jsonObject.getString("name"):"";
                    //String name=(jsonObject.has("name"))?jsonObject.getString("name"):""; 
                    String name=stringManager.getFishNamesFromFile(i);
                    String name_es=name;
                    String fecha=stringManager.getFecha().toString();            
                    String pathImage="media/images-fish/"+specie_name+".jpg";
                    if(i==jsonArray.length()-1)
                        sql="('"+name+"','"+name_es+"','"+specie_id+"' , '"+pathImage+"' , '"+fecha+"' , 1)";
                    else
                        sql="('"+name+"','"+name_es+"','"+specie_id+"' , '"+pathImage+"' , '"+fecha+"' , 1),";

                    arrayListSQL.add(sql);
                    con.disconnect();
                }
                File file=new File("fishApi.sql");
                FileManager.writeFile(file, arrayListSQL);
                  
            }
        } catch (MalformedURLException ex) {
            Logger.getLogger(ConsumoAPI.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(ConsumoAPI.class.getName()).log(Level.SEVERE, null, ex);
        }catch (org.json.JSONException ex) {
            Logger.getLogger(ConsumoAPI.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }

}
