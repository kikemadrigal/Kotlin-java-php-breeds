
package com.mycompany.consumoapi.utils;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Calendar;
import java.util.Date;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author kikem
 */
public class StringManager {
    String[] names;
    String[] families;
    String[] descriptionsCats;
    String[] descriptionsDogs;
    int[] years_of_birth;
    String[] direcciones;
    
    String[] fishNames;
    
    public StringManager() {
        names=new String[301];
        families=new String[1001];
        descriptionsCats=new String[33];
        descriptionsDogs=new String[1598];
        years_of_birth=new int[20];
        direcciones=new String[599];
        
        fishNames=new String[1114];
        loadArrayNamesCats();
        loadDescriptionsDogs();
  
        loadDescriptionsCats();
        loadFamilies();
        loadYearsOfBirthCats();
        loadDirecciones();
        
        loadNamesFishesFromFile();
    }
    
    
    public String deleteComa(String cadena){
        String newString=cadena.replace(","," -");
        newString=newString.replace("("," -");
        newString=newString.replace(")","-");
        newString=newString.replace("'"," ");
        return newString;
    }
    public String deleteSpaces(String cadena){
        String newString=cadena.replace(" ","-");
        return newString;
    }
    
    public String subsSpacesURL(String value){
        String newString=value.replace(" ","%20");
        return newString;
    }
    
   public String getNameFromArray(){
        //https://www.elmueble.com/mascotas/nombres-para-perros-bonitos-y-originales-para-acertar-seguro_49805
        int random=(int) (Math.random() * names.length-1);
        //if(names[random]==null)getNameFromArray();
        // byte[] bytes = names[random].getBytes(StandardCharsets.ISO_8859_1);
        //if(bytes==null)getNameFromArray();
        return  names[random];
    }
   public String getFamilyFromFile(){
       int random=(int) (Math.random() * families.length-1);
       return  families[random];
   }
   public String getDescriptionCatsFromArray(){
       int random=(int) (Math.random() * descriptionsCats.length-1);
       return  descriptionsCats[random];
   }
   public String getDescriptionDogsFromArray(int countDog){
       //int random=(int) (Math.random() * descriptionsDogs.length-1);
       return  descriptionsDogs[countDog];
   }
   public String getFishNamesFromFile(int countFish){
       return  fishNames[countFish];
   }
   public int getYearsOfBirthFromArray(){
       int random=(int) (Math.random() * years_of_birth.length-1);
       return years_of_birth[random];
   }
   public int getSex(){
       // Crear un objeto Random
        Random random = new Random();
        // Generar un número aleatorio entre 0 y 1
        double numeroAleatorio = random.nextDouble();
        // Si el número aleatorio es menor que 0.5, devolver 0, sino devolver 1
        int resultado = (numeroAleatorio < 0.5) ? 0 : 1;
        //Si el resultado es 0 será hembra, si es 1 es varón
        return resultado;
   }
   public String getDireccionesFromArray(){
       int random=(int) (Math.random() * direcciones.length-1);
       return direcciones[random];
   }
   public Date getFecha(){
       // Establecer la fecha mínima y máxima
        Calendar fechaMinima = Calendar.getInstance();
        fechaMinima.set(2020, 0, 1); // Reemplazar con la fecha mínima deseada (año, mes, día)

        Calendar fechaMaxima = Calendar.getInstance();
        fechaMaxima.set(2024, 5, 31); // Reemplazar con la fecha máxima deseada (año, mes, día)

        // Generar una fecha aleatoria entre las fechas mínima y máxima
        Random random = new Random();
        long milisegundosAleatorios = fechaMinima.getTimeInMillis() + (long) (random.nextDouble() * (fechaMaxima.getTimeInMillis() - fechaMinima.getTimeInMillis()));
        Date fechaAleatoria = new Date(milisegundosAleatorios);
        return fechaAleatoria;
   }
   
   public String putTwoBars(String value){
       return value.replace("\\", "\\\\");
   }

   private void loadArrayNamesCats(){
        //NOMBRES PARA PERROS MACHOS
        names[0]="Bambú";
        names[1]="Baxter";
        names[2]="Benji";
        names[3]="Benny";
        names[4]="Bobi";
        names[5]="Calvin";
        names[6]="Chester";
        names[7]="Elliot";
        names[8]="Enzo";
        names[9]="Fito";
        names[10]="Freddie";
        names[11]="Harry";
        names[12]="Hugo";
        names[13]="Klein";
        names[14]="Maxi";
        names[15]="Miki";
        names[16]="Nelson";
        names[17]="Ness";
        names[18]="Nessy";
        names[19]="Nicky";
        names[20]="Nico";
        names[21]="Oliver";
        names[22]="Ozzy";
        names[23]="Pavel";
        names[24]="Pipo";
        names[25]="Rayco";
        names[26]="Rocky";
        names[27]="Ronnie";
        names[28]="Rufo";
        names[29]="Rufus";
        names[20]="Russell";
        names[21]="Rusty";
        names[22]="Sito";
        names[23]="Truman";
        names[24]="Willy";
        //NOMBRES ORIGINALES PARA PERROS

        names[25]="Anakin";
        names[26]="Astérix";
        names[27]="Bart";
        names[28]="Batman";
        names[29]="Beethoven";
        names[30]="Chewbacca";
        names[31]="Conan";
        names[32]="Cooper";
        names[33]="Corsario";
        names[34]="Dalí";
        names[35]="Doraemon";
        names[36]="Duke";
        names[37]="Frodo";
        names[38]="Garfield";
        names[39]="Gizmo";
        names[40]="Godzilla";
        names[41]="Goku";
        names[42]="Hodor";
        names[43]="Holmes";
        names[44]="Homer";
        names[45]="Lannister";
        names[46]="Matisse";
        names[47]="Merlín";
        names[48]="Mickey";
        names[49]="Mozart";
        names[50]="Obélix";
        names[51]="Odín";
        names[52]="Pecas";
        names[53]="Picasso";
        names[54]="Pirata";
        names[55]="Sauron";
        names[56]="Scooby";
        names[57]="Sherlock";
        names[58]="Snoopy";
        names[59]="Thor";
        names[60]="Watson";
        names[61]="Yoda";
        //NOMBRES PARA PERROS PEQUEÑOS
        names[62]="Bizcocho";
        names[63]="Capi";
        names[64]="Chupito";
        names[65]="Curro";
        names[66]="Huesitos";
        names[67]="Hueso";
        names[68]="Peluchín";
        names[69]="Pitufín";
        names[70]="Pitufo";
        names[71]="Teddy";
        //NOMBRES CORTOS PARA PERROS
        names[72]="Bat";
        names[73]="Bill";
        names[74]="Blue";
        names[75]="Chip";
        names[76]="Fox";
        names[77]="Jazz";
        names[78]="Loki";
        names[79]="Max";
        names[80]="Toy";
        //NOMBRES BONITOS PARA PERROS
        names[81]="Aquiles";
        names[82]="Basil";
        names[83]="Claus";
        names[84]="Cody";
        names[85]="Damián";
        names[86]="Kairo";
        names[87]="Karim";
        names[88]="Lassie";
        names[89]="Lobo";
        names[90]="Lotus";
        names[91]="Remo";
        names[92]="Rómulo";
        names[93]="Wilde";
        names[94]="Zeus";
        //NOMBRES GRACIOSOS PARA PERROS
        names[95]="Bandido";
        names[96]="Bao";
        names[97]="Burrito";
        names[98]="Cachopo";
        names[100]="Carpaccio";
        names[101]="Choco";
        names[102]="Houdini";
        names[103]="Lacasito";
        names[104]="Meón";
        names[105]="Mr. Bean";
        names[106]="Taco";
        names[107]="Trasto";
        //NOMBRES PARA PERROS DE DISNEY
        names[108]="Aladdín";
        names[109]="Andrew";
        names[110]="Balto";
        names[111]="Bambi";
        names[112]="Bestia";
        names[113]="Bolívar";
        names[114]="Bolt";
        names[115]="Bruno";
        names[116]="Buddy";
        names[117]="Buster";
        names[118]="Butch";
        names[119]="Buzz";
        names[120]="Capitán";
        names[121]="Cheshire";
        names[122]="Clayton";
        names[123]="Coronel";
        names[124]="Dimitri";
        names[125]="Dodger";
        names[126]="Donald";
        names[127]="Dug";
        names[128]="Einstein";
        names[129]="Eric";
        names[130]="Felipe";
        names[131]="Fígaro";
        names[132]="Flipper";
        names[133]="Francis";
        names[134]="Garfio";
        names[135]="Gastón";
        names[136]="Genio";
        names[137]="Gilito";
        names[138]="Golfo";
        names[139]="Goofy";
        names[140]="Gus";
        names[141]="Hades";
        names[142]="Hans";
        names[143]="Hércules";
        names[144]="Jafar";
        names[145]="John";
        names[146]="Legend";
        names[147]="Lilo";
        names[148]="Max";
        names[149]="Miko";
        names[150]="Mushu";
        names[151]="Nemo";
        names[152]="Olaf";
        names[153]="Peter";
        names[154]="Piglet";
        names[155]="Pluto";
        names[156]="Pongo";
        names[157]="Pumba";
        names[158]="Rajah";
        names[159]="Robin";
        names[160]="Scar";
        names[161]="Simba";
        names[162]="Stich";
        names[163]="Sulley";
        names[164]="Tambor";
        names[165]="Timón";
        names[166]="Tarzán";
        names[167]="Toby";
        names[168]="Winnie";
        names[169]="Woody";
        //NOMBRES DE PERROS MACHOS DE CIUDADES
        names[170]="Bali";
        names[171]="Belfast";
        names[172]="Bergen";
        names[173]="Berlín";
        names[174]="Bilbao";
        names[175]="Bristol";
        names[176]="Cardiff";
        names[177]="Cork";
        names[178]="Dijon";
        names[179]="Dublín";
        names[180]="Glasglow";
        names[181]="Houston";
        names[182]="Juárez";
        names[183]="Kiev";
        names[184]="Kioto";
        names[185]="Milán";
        names[186]="Minsk";
        names[187]="Moscú";
        names[188]="Múnich";
        names[189]="Osaka";
        names[190]="Oslo";
        names[191]="París";
        names[192]="Phoenix";
        names[193]="Praga";
        names[194]="Tokio";
        names[195]="Turín";
        names[196]="Turku";
        names[197]="Varna";
        names[198]="Zúrich";
        //NOMBRES DE PERROS FAMOSOS
        names[199]="Milo";
        names[200]="Milú";
        names[201]="Nevado";
        names[202]="Marley";
        names[203]="Odie";
        names[204]="Rex";
        names[205]="Ran Tan Plan";
        names[206]="Seymour";
        names[207]="Ideafix";
        names[208]="Eddie";
        names[209]="Rin Tin Tin";
        names[210]="Hulk";
        //NOMBRES PARA PERROS EN FRANCÉS
        names[211]="Pierre";
        names[212]="Coco";
        names[213]="Éclair";
        names[214]="Gigi";
        names[215]="Louis";
        names[216]="Olivier";
        names[217]="Marcel";
        names[218]="Luc";
        names[219]="Pascal";
        names[220]="Antoine";
        names[221]="Étienne";
        names[222]="Jules";
        names[223]="François";
        names[224]="Lucien";
        names[225]="Marcel";
        names[226]="René";
        names[227]="Gabriel";
        names[228]="Raoul";
        names[229]="Vincent";
        names[230]="Rémy";
        names[231]="Baptiste";
        names[232]="Thierry";
        names[233]="Laurent";
        names[234]="Michel";
        names[235]="Anatole";
        //NOMBRES DE PERRO ITALIANOS 
        names[236]="Leonardo";
        names[237]="Dante";
        names[238]="Romeo";
        names[239]="Luigi";
        names[240]="Matteo";
        names[241]="Marco";
        names[242]="Paolo";
        names[243]="Francesco";
        names[244]="Vito";
        names[245]="Marcello";
        names[246]="Rocco";
        names[247]="Stefano";
        names[248]="Gino";
        names[249]="Cosimo";
        names[250]="Alberto";
        names[251]="Angelo";
        names[252]="Giovanni";
        names[253]="Fabio";
        names[254]="Vincenzo";
        names[255]="Aldo";
        names[256]="Giorgio";
        names[257]="Nino";
        names[258]="Roberto";
        names[259]="Emilio";
        names[260]="Massimo";
        names[261]="Fabrizio";
        names[262]="Tito";
        names[263]="Renzo";
        names[264]="Riccardo";
        names[265]="Davide";
        names[266]="Carlo";
        names[267]="Ettore";
        names[268]="Lupo";
        names[269]="Pietro";
        names[270]="Tommaso";
        //NOMBRES PARA PERROS MACHO DE DIOSES
        names[271]="Thor";
        names[272]="Zeus";
        names[273]="Apolo";
        names[274]="Odín";
        names[275]="Anubis";
        names[276]="Hércules";
        names[277]="Ares";
        names[278]="Ra";
        names[279]="Poseidón";
        names[280]="Loki";
        names[281]="Hades";
        names[282]="Hermes";
        names[283]="Frey";
        names[284]="Vishnu";
        names[285]="Atlas";
        names[286]="Osiris";
        names[287]="Cupido";
        names[288]="Horus";
        names[289]="Mars";
        names[290]="Bacchus";
        //NOMBRES PARA PERRO INSPIRADOS EN DISEÑADORES DE MODA
        names[281]="Armani";
        names[282]="Valentino";
        names[283]="Lagerfeld";
        names[284]="Versace";
        names[285]="Dolce";
        names[286]="Gabbana";
        names[287]="Gucci";
        names[288]="Ralph";
        names[289]="Jacobs";
        names[290]="Dior";
        names[291]="Tom";
        names[292]="Jean";
        names[293]="Yves";
        names[294]="Cardin";
        names[295]="Cavalli";
        names[296]="Alexander";
        names[297]="Oscar";
        names[298]="Hubert";
        names[299]="Karl";
        names[300]="Balenciaga";
   }
  
   private void loadFamilies(){
       // Ruta del archivo de texto que contiene los apellidos
        String rutaArchivo = "families.txt";
        // Leer el archivo de texto línea por línea
        BufferedReader lector;
        try {
            lector = new BufferedReader(new FileReader(rutaArchivo));

            String linea;
            int i = 0;
            while ((linea = lector.readLine()) != null) {
                families[i] = linea;
                i++;
            }
            // Cerrar el archivo
            lector.close();
            // Procesar los apellidos (por ejemplo, mostrarlos en pantalla)
            /*for (String apellido : families) {
                System.out.println(apellido);
            }*/
        } catch (FileNotFoundException ex) {
            Logger.getLogger(StringManager.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(StringManager.class.getName()).log(Level.SEVERE, null, ex);
        }
   }
   private void loadDirecciones(){
       // Ruta del archivo de texto que contiene los apellidos
        String rutaArchivo = "direcciones.txt";
        // Leer el archivo de texto línea por línea
        BufferedReader lector;
        try {
            lector = new BufferedReader(new FileReader(rutaArchivo));

            String linea;
            int i = 0;
            while ((linea = lector.readLine()) != null) {
                direcciones[i] = linea;
                i++;
            }
            // Cerrar el archivo
            lector.close();
        } catch (FileNotFoundException ex) {
            Logger.getLogger(StringManager.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(StringManager.class.getName()).log(Level.SEVERE, null, ex);
        }
   }
   private void loadDescriptionsCats(){
       
        
        descriptionsCats[0]="Soy un felino peludo con un corazón de oro. Me encanta acurrucarme en regaños y ronronear de satisfacción.";

        descriptionsCats[1]="Soy un atigrado juguetón con una vena traviesa. Me encanta perseguir juguetes y trepar por las cortinas.";

        descriptionsCats[2]="Soy un gigante gentil con una gran personalidad. Me encanta acurrucarme y dar cabezazos.";

        descriptionsCats[3]="Soy un gato elegante y misterioso con ojos azules penetrantes y amor por los lugares altos.";

        descriptionsCats[4]="Soy un gato único e independiente con un pelaje de patchwork y amor por explorar.";

        descriptionsCats[5]="Soy un pelirrojo fogoso con una gran personalidad. Me encanta jugar a buscar y salir a pasear con correa.";

        descriptionsCats[6]="Soy un gato blanco esponjoso con un comportamiento gentil. Me encanta tomar largas siestas bajo los rayos del sol.";

        descriptionsCats[7]="Soy un gato negro con una sonrisa traviesa. Me encanta hacer bromas y tirar cosas de los estantes.";

        descriptionsCats[8]="Soy un gato perezoso amante de la lasaña. Me encanta dormir y comer, y no tengo miedo de pedir golosinas.";

        descriptionsCats[9]="Soy un gato viejo y gruñón al que le encanta que lo dejen solo. No soy fanático de los abrazos ni de los ruidos fuertes.";

        descriptionsCats[10]="Soy un gato descarado con actitud. Me encanta hablar de vuelta y exigir atención.";

        descriptionsCats[11]="Soy un gato digno con un comportamiento adecuado. Me encanta sentarme en mi sillón y observar mi reino.";

        descriptionsCats[12]="Soy un gato sin pelo con orejas grandes y amor por ser mimado y adorado.";

        descriptionsCats[13]="Soy un gato de aspecto permanentemente gruñón con una base de fans mundial. Me encanta difundir memes y hacer sonreír a las personas.";

        descriptionsCats[14]="Soy un gato enano con una gran personalidad y un corazón de oro. Me encanta inspirar a otros con mi historia y mostrarles que todo es posible.";

        descriptionsCats[15]="Soy un gato travieso al que le encanta robar comida, especialmente atún.";

        descriptionsCats[15]="Soy un gato de aspecto gruñón al que le encanta sentarse en cajas y juzgar a la gente. También soy un poco dictador.";

        descriptionsCats[16]="Soy un gato juguetón al que le encanta meterse en cajas. También soy un poco torpe, pero eso es lo que me hace tan adorable.";

        descriptionsCats[17]="Soy un gato gordito al que le encanta comer y dormir. También soy un poco tonto, pero eso es parte de mi encanto.";

        descriptionsCats[18]="Soy un icono de la cultura pop con un cuerpo Pop-Tart y un rastro de arcoíris. Soy conocido por mi música relajante y mis vibraciones positivas.";

        descriptionsCats[19]="Soy un gato perezoso amante de la lasaña de una tira cómica. Me encanta dormir y comer, y no tengo miedo de pedir golosinas.";

        descriptionsCats[20]="Soy un gato gruñón y travieso de una tira cómica. Me encanta causar problemas y meterme en líos.";

        descriptionsCats[21]="Soy un gato negro afortunado con una bolsa mágica de trucos. Me encanta ayudar a las personas a salir de problemas y siempre tengo una sonrisa en la cara.";

        descriptionsCats[22]="Soy un gato enamorado de las caricaturas de Looney Tunes. Siempre estoy persiguiendo a un pajarito, pero nunca parece que pueda atraparlo.";

        descriptionsCats[23]="Soy la mitad del dúo icónico de gato y ratón de las caricaturas de Tom y Jerry. Siempre estoy tratando de atrapar a un ratón inteligente, pero él siempre está un paso por delante de mí.";

        descriptionsCats[24]="Soy un felino rebelde de una película animada. No tengo miedo de romper las reglas y defender lo que creo.";

        descriptionsCats[25]="Soy un gato sonriente de una novela famosa. Soy conocido por mi capacidad para desaparecer y reaparecer a voluntad.";

        descriptionsCats[26]="Soy un gato espadachín de una franquicia popular. Soy conocido por mi astucia, encanto y habilidades con la espada.";

        descriptionsCats[27]="Soy un gato aventurero de una película animada de Disney. Me encanta explorar nuevos lugares y hacer nuevos amigos.";

        descriptionsCats[28]="Soy un gato bondadoso y cariñoso de una película de Disney. Siempre estoy listo para ayudar a aquellos en necesidad.";

        descriptionsCats[29]="Soy un gato travieso y juguetón de una serie de televisión. Me encanta comer, dormir y causar problemas.";

        descriptionsCats[30]="Soy un gato inteligente y astuto de una serie de televisión. Me encanta resolver puzzles y superar a mis compañeros humanos.";

        descriptionsCats[31]="Soy un gato curioso e inquisitivo de un libro infantil. Me encanta aprender cosas nuevas y explorar el mundo que me rodea.";

        descriptionsCats[32]="Soy un gato valiente y leal de una película de acción. Siempre estoy ahí para proteger a mis amigos y familiares.";

    }
   
    private void loadDescriptionsDogs(){
        String rutaArchivo = "descripciones-perros.txt";
        // Leer el archivo de texto línea por línea
        BufferedReader lector;
        try {
            lector = new BufferedReader(new FileReader(rutaArchivo));

            String linea;
            int i = 0;
            while ((linea = lector.readLine()) != null) {
                descriptionsDogs[i] = linea;
                i++;
            }
            // Cerrar el archivo
            lector.close();
        } catch (FileNotFoundException ex) {
            Logger.getLogger(StringManager.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(StringManager.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
      
   
   private void loadYearsOfBirthCats(){
        years_of_birth[0]=2010;
        years_of_birth[0]=2011;
        years_of_birth[0]=2012;
        years_of_birth[0]=2013;
        years_of_birth[0]=2014;
        years_of_birth[0]=2015;
        years_of_birth[0]=2016;
        years_of_birth[0]=2017;
        years_of_birth[0]=2018;
        years_of_birth[0]=2019;
        years_of_birth[0]=2020;
        years_of_birth[0]=2021;
        years_of_birth[0]=2022;
        years_of_birth[0]=2023;
        years_of_birth[0]=2024;        
    }
   
   
       private void loadNamesFishesFromFile(){
        String rutaArchivo = "nombres-de-pez.txt";
        // Leer el archivo de texto línea por línea
        BufferedReader lector;
        try {
            lector = new BufferedReader(new FileReader(rutaArchivo));

            String linea;
            int i = 0;
            while ((linea = lector.readLine()) != null) {
                fishNames[i] = linea;
                i++;
            }
            // Cerrar el archivo
            lector.close();
        } catch (FileNotFoundException ex) {
            Logger.getLogger(StringManager.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(StringManager.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
