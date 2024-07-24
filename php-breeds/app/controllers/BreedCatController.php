<?php
class BreedCatController extends BaseController{
    
    function __construct()
    {
        parent::__construct();
    }


    public function index(){
        $breedCats=BreedCatRepository::getAll(0,2000);
        $this->view->breedCats=$breedCats;
        $this->view->render("breedCat/showAll"); 
    }
    public function showAllByUser(){
        $breedCats=BreedCatRepository::getAllByUser($_SESSION['idusuario'],0,2000);
        $this->view->breedCats=$breedCats;
        $this->view->render("breedCat/showAllByUser");
    }
    public function show($param=null){
        //echo "vamos a ver el breedcat con id: ".$param[0];
        $breedCat=BreedCatRepository::getById($param[0]);
        $this->view->breedCat=$breedCat;
        //echo "obtenido el breedCat: ".$breedCat->to_string();
        $this->view->render("breedCat/show");
    }
    public function showByBreedId($param=null){
        //echo "vamos a ver el breedcat con id: ".$param[0];
        $breedCat=BreedCatRepository::getByIdName($param[0]);
        $this->view->breedCat=$breedCat;
        //echo "obtenido el breedCat: ".$breedCat->to_string();
        $this->view->render("breedCat/show");
    }
    public function showAll($param=null){
        $rowCount=BreedCatRepository::getCountRows();
        $page=$param[0];
        $init=$page*10;
        $page+=1;
        $breedCats=BreedCatRepository::getAll($init);
        //echo "page ahora vale: ".$page;
        $this->view->breedCats=$breedCats;
        $this->view->page=$page;
        $this->view->rowCount=$rowCount;
        $this->view->render("breedCat/showAll");
    }


    public function showUser($param = null){
        $this->view->param=$param;
        $this->view->render("breedCat/showUser");
    }
    public function search($search = null){
        $breedCats=null;
        if (isset($_POST['submit'])){
            $breedCats=BreedCatRepository::getByName_es($_POST['search']);
        }else{
            $breedCats=BreedCatRepository::getByName_es($search[0]);
        }
        $this->view->breedCats=$breedCats;
        $this->view->render("breedCat/search");
    }
    public function searchUser($search = null){
        $this->view->param=$search[0];
        $this->view->render("breedCat/search");
    }
    public function mono(){
        echo "hOLA SOY UN MONO";
     }


    public function insert(){
       $this->view->render("breedCat/insert");   
    }
    public function update($id=null){
        if (isset($_POST['submit'])){
            $breedCat=new BreedCat($_POST['id']);
            $breedCat->set_id_name($_POST['id_name']);
            $breedCat->set_name($_POST['name']);
            $breedCat->set_name_es($_POST['name_es']);
            $breedCat->set_cfa_url($_POST['cfa_url']);
            $breedCat->set_vetstreet_url($_POST['vetstreet_url']);
            $breedCat->set_vcahospitals_url($_POST['vcahospitals_url']);
            $breedCat->set_temperament($_POST['temperament']);
            $breedCat->set_temperament_es($_POST['temperament_es']);
            $breedCat->set_origin($_POST['origin']);
            $breedCat->set_origin_es($_POST['origin_es']);
            $breedCat->set_country_codes($_POST['country_codes']);
            $breedCat->set_country_code($_POST['country_code']);
            $breedCat->set_description($_POST['description']);
            $breedCat->set_description_es($_POST['description_es']);
            $breedCat->set_morphology($_POST['morphology']);
            $breedCat->set_morphology_es($_POST['morphology_es']);
            $breedCat->set_life_span($_POST['life_span']);
            //interior
            $breedCat->set_indoor($_POST['indoor']);
            //regazo
            $breedCat->set_lap($_POST['lap']);
            //nombres alternativos
            $breedCat->set_alt_names($_POST['alt_names']);
            $breedCat->set_adaptability($_POST['adaptability']);
            $breedCat->set_affection_level($_POST['affection_level']);
            $breedCat->set_child_friendly($_POST['child_friendly']);
            $breedCat->set_cat_friendly($_POST['cat_friendly']);
            $breedCat->set_dog_friendly($_POST['dog_friendly']);
            $breedCat->set_energy_level($_POST['energy_level']);
             //aseo
            $breedCat->set_grooming($_POST['grooming']);
             //problemas de salud
            $breedCat->set_health_issues($_POST['health_issues']);
            $breedCat->set_intelligence($_POST['intelligence']);
            //nivel de muda
            $breedCat->set_shedding_level($_POST['shedding_level']);
             //necesidades sociales
            $breedCat->set_social_needs($_POST['social_needs']);
            $breedCat->set_stranger_friendly($_POST['stranger_friendly']);
            $breedCat->set_vocalisation($_POST['vocalisation']);
            $breedCat->set_experimental($_POST['experimental']);
            //sin pelo
            $breedCat->set_hairless($_POST['hairless']);
            $breedCat->set_natural($_POST['natural']);
            $breedCat->set_rare($_POST['rare']);
            $breedCat->set_rex($_POST['rex']);
            //cola suprimida
            $breedCat->set_suppressed_tail($_POST['suppressed_tail']);
            //patas cortas
            $breedCat->set_short_legs($_POST['short_legs']);
            $breedCat->set_wikipedia_url($_POST['wikipedia_url']);
            //hipoalergénica
            $breedCat->set_hypoallergenic($_POST['hypoallergenic']);
            //peso
            $breedCat->set_weight($_POST['weight']);
            $breedCat->set_date($_POST['date']);
            $breedCat->set_path_image($_POST['path_image']);
            $breedCat->set_reference_image_id($_POST['reference_image_id']);
            $breedCat->set_creator_id($_POST['creator_id']);

            if ($breedCat!=null){
                BreedCatRepository::update($breedCat);
                header("location: ".PATHSERVER."BreedCat/update/".$_POST['id']."");
                if ( PRODUCTION==1 ) echo "<script type='text/javascript'>location.href='".PATHSERVER."BreedCat/update/".$_POST['id']."';</script>";
            }else{
                echo "Update could not be completed";  
            }
            echo " la imagen es ".$breedCat->getImage();
            die();
        }else{
            if(isset($_SESSION['idusuario']) && $_SESSION['nivelaccesousuario']==3){
                $breedCat=BreedCatRepository::getById($id[0]);
                $this->view->breedCat=$breedCat;
                $this->view->render("breedCat/updateUser");   
            }else if(isset($_SESSION['idusuario']) && $_SESSION['nivelaccesousuario']==1){ 
                $breedCat=BreedCatRepository::getById($id[0]);
                $this->view->breedCat=$breedCat;
                $this->view->render("breedCat/update"); 
            }else{
                echo "You are not logged in";
            }
        }
    }
    public function delete($id=null){
        BreedCatRepository::delete($id[0]);
        header("location: ".PATHSERVER."Game/showByCategoriesUsers");
        if ( PRODUCTION==1 ) echo "<script type='text/javascript'>location.href='".PATHSERVER."Game/showByCategoriesUsers';</script>";
    }
}