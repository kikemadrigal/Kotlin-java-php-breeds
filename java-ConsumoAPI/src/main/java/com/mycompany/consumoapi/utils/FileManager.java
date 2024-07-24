/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.consumoapi.utils;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.URL;
import java.util.ArrayList;
import org.asynchttpclient.AsyncCompletionHandler;
import org.asynchttpclient.AsyncHandler;
import org.asynchttpclient.AsyncHttpClient;
import org.asynchttpclient.Dsl;
import org.asynchttpclient.HttpResponseBodyPart;
import org.asynchttpclient.Response;

/**
 *
 * @author kikem
 */
public class FileManager {

    public FileManager() {
    }
    
    
    /**
     * Escribe el arrayList de strings pasado por par�mtero en un archivo de texto
     * @param fileDestiny
     * @param arrayList
     */
    public static void writeFile(File fileDestiny,ArrayList<String> arrayList) {
	FileWriter fileWriter = null;
        PrintWriter printWriter = null;
        try
        {
            fileWriter = new FileWriter(fileDestiny, false);
            printWriter = new PrintWriter(fileWriter);
            for(String cadena: arrayList) {
            	printWriter.println(cadena);
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
        } finally {
           try {
           // Nuevamente aprovechamos el finally para 
           // asegurarnos que se cierra el fichero.
           if (null != fileWriter)
        	  fileWriter.close();
           	  System.out.println("FileManager say: file created "+fileDestiny.getAbsolutePath());
           } catch (IOException e) {
               System.out.println("IOException:  "+e.toString());
           }
        }
    }
    public static void saveImage(String imageUrl, String destinationFile) throws IOException {
            URL url = new URL(imageUrl);
            InputStream is = url.openStream();
            OutputStream os = new FileOutputStream(destinationFile);

            byte[] b = new byte[2048];
            int length;

            while ((length = is.read(b)) != -1) {
                    os.write(b, 0, length);
            }

            is.close();
            os.close();

    }
    
    public static void saveIMageAsynchronous(String imageUrl, String destinationFile) throws IOException {
                    AsyncHttpClient client = Dsl.asyncHttpClient();
            FileOutputStream stream = new FileOutputStream(destinationFile);
            
            client.prepareGet(imageUrl).execute(new AsyncCompletionHandler<FileOutputStream>() {

                @Override
                public AsyncHandler.State onBodyPartReceived(HttpResponseBodyPart bodyPart) 
                  throws Exception {
                    stream.getChannel().write(bodyPart.getBodyByteBuffer());
                    return AsyncHandler.State.CONTINUE;
                }

                @Override
                public FileOutputStream onCompleted(Response response) 
                  throws Exception {
                    return stream;
                }
            });
    }
}
