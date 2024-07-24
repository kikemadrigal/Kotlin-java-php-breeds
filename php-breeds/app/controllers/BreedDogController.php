<?php
class BreedDogController extends BaseController{
    
    function __construct()
    {
        parent::__construct();
    }


    public function index(){
        $breedDogs=BreedDogRepository::getAll(0,2000);
        $this->view->breedDogs=$breedDogs;
        $this->view->render("breedDog/showAll"); 
    }
    public function showAllByUser(){
        $breedDogs=BreedDogRepository::getAllByUser($_SESSION['idusuario'],0,2000);
        $this->view->breedDogs=$breedDogs;
        $this->view->render("breedDog/showAllByUser");
    }
    public function show($param=null){
        $breedDog=BreedDogRepository::getById($param[0]);
        $this->view->breedDog=$breedDog;
        $this->view->render("breedDog/show");
    }
    public function showAll($param=null){
        $rowCount=BreedDogRepository::getCountRows();
        $page=$param[0];
        $init=$page*10;
        $page+=1;
        $breedDogs=BreedDogRepository::getAll($init);
        $this->view->breedDogs=$breedDogs;
        $this->view->page=$page;
        $this->view->rowCount=$rowCount;
        $this->view->render("breedDog/showAll");
    }


    public function showUser($param = null){
        $this->view->param=$param;
        $this->view->render("breedDog/showUser");
    }
    public function search($search = null){
        $breedDogs=null;
        if (isset($_POST['submit'])){
            $breedDogs=BreedDogRepository::getByName_es($_POST['search']);
        }else{
            $breedDogs=BreedDogRepository::getByName_es($search[0]);
        }
        
        $this->view->breedDogs=$breedDogs;
        $this->view->render("breedDog/search");
    }
    public function searchUser($search = null){
        $this->view->param=$search[0];
        $this->view->render("breedDog/search");
    }



    public function insert(){
       $this->view->render("breedDog/insert");   
    }
    public function update($id=null){
        if (isset($_POST['submit'])){
            $breedDog=new BreedDog($_POST['id']);
            $breedDog->set_breed_id($_POST['breed_id']);
            $breedDog->set_name($_POST['name']);
            $breedDog->set_name_es($_POST['name_es']);
            $breedDog->set_description($_POST['description']);
            $breedDog->set_description_es($_POST['description_es']);
            $breedDog->set_wiki_url($_POST['wiki_url']);
            $breedDog->set_bred_for($_POST['bred_for']);
            $breedDog->set_bred_for_es($_POST['bred_for_es']);
            $breedDog->set_breed_group($_POST['breed_group']);
            $breedDog->set_breed_group_es($_POST['breed_group_es']);
            $breedDog->set_life_span($_POST['life_span']);
            $breedDog->set_temperament($_POST['temperament']);
            $breedDog->set_temperament_es($_POST['temperament_es']);
            $breedDog->set_origin($_POST['origin']);
            $breedDog->set_origin_es($_POST['origin_es']);
            $breedDog->set_morphology($_POST['morphology']);
            $breedDog->set_morphology_es($_POST['morphology_es']);
            $breedDog->set_weight($_POST['weight']);
            $breedDog->set_height($_POST['height']);
            $breedDog->set_date($_POST['date']);
            $breedDog->set_reference_image_id($_POST['reference_image_id']);
            $breedDog->set_path_image($_POST['path_image']);
            $breedDog->set_creator_id($_POST['creator_id']);

            if ($breedDog!=null){
                BreedDogRepository::update($breedDog);
                header("location: ".PATHSERVER."BreedDog/update/".$_POST['id']."");
                if ( PRODUCTION==1 ) echo "<script type='text/javascript'>location.href='".PATHSERVER."BreedDog/update/".$_POST['id']."';</script>";
            }else{
                echo "Update could not be completed";  
            }
            die();
        }else{
            if(isset($_SESSION['idusuario']) && $_SESSION['nivelaccesousuario']==3){
                $breedDog=BreedDogRepository::getById($id[0]);
                $this->view->breedDog=$breedDog;
                $this->view->render("breedDog/updateUser");   
            }else if(isset($_SESSION['idusuario']) && $_SESSION['nivelaccesousuario']==1){ 
                $breedDog=BreedDogRepository::getById($id[0]);
                $this->view->breedDog=$breedDog;
                $this->view->render("breedDog/update"); 
            }else{
                echo "You are not logged in";
            }
        }
    }
    public function delete($id=null){
        BreedDogRepository::delete($id[0]);
        header("location: ".PATHSERVER."Game/showByCategoriesUsers");
        if ( PRODUCTION==1 ) echo "<script type='text/javascript'>location.href='".PATHSERVER."Game/showByCategoriesUsers';</script>";
    }
}