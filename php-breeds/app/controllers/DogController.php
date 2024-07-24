<?php
class DogController extends BaseController{
    
    function __construct()
    {
        parent::__construct();
    }


    public function index(){
        $dogs=DogRepository::getAll(0,2000);
        $this->view->dogs=$dogs;
        $this->view->render("dog/showAll"); 
    }
    public function showAllByUser(){
        $dogs=DogRepository::getAllByUser($_SESSION['idusuario'],0,2000);
        $this->view->dogs=$dogs;
        $this->view->render("dog/showAllByUser");
    }
    public function show($param=null){
        $dog=DogRepository::getById($param[0]);
        $breedDog=BreedDogRepository::getById($dog->get_breed_id());
        
        $this->view->dog=$dog;
        $this->view->breedDog=$breedDog;
        $this->view->render("dog/show");
    }
    public function showRandom(){
        $dog=DogRepository::getRandom();
        $breedDog=BreedDogRepository::getByBreedId($dog->get_breed_id());
        $this->view->breedDog=$breedDog;
        $this->view->dog=$dog;
        $this->view->render("dog/showRandom");
    }
    //$games=DogRepository::getSearchGameByTitle($search);
    public function showAll($param=null){
        $rowCount=DogRepository::getCountRows();
        $page=$param[0];
        $init=$page*10;
        $page+=1;
        $dogs=DogRepository::getAll($init);
        $this->view->dogs=$dogs;
        $this->view->page=$page;
        $this->view->rowCount=$rowCount;
        $this->view->render("dog/showAll");
    }


    public function showUser($param = null){
        $this->view->param=$param;
        $this->view->render("dog/showUser");
    }
    public function search($search = null){
        $dogs=null;
        if (isset($_POST['submit'])){
            $dogs=DogRepository::getByName($_POST['search']);
        }else{
            $dogs=DogRepository::getByName($search[0]);
        }
        $this->view->dogs=$dogs;
        $this->view->render("dog/search");
    }
    public function searchUser($search = null){
        $this->view->param=$search[0];
        $this->view->render("dog/search");
    }



    public function insert(){
       $this->view->render("dog/insert");   
    }
    public function update($id=null){
        if (isset($_POST['submit'])){
            $dog=new Dog($_POST['id']);
            $dog->set_name($_POST['name']);
            $dog->set_name_es($_POST['name_es']);
            $dog->set_breed_id($_POST['breed_id']);
            $dog->set_family($_POST['family']);
            $dog->set_description($_POST['description']);
            $dog->set_description_es($_POST['description_es']);
            $dog->set_year_of_birth($_POST['year_of_birth']);
            $dog->set_sex($_POST['sex']);
            $dog->set_address($_POST['address']);
            $dog->set_vaccines($_POST['vaccines']);
            $dog->set_path_image($_POST['path_image']);
            $dog->set_date($_POST['date']);
            $dog->set_creator_id($_POST['creator_id']);
            if ($dog!=null){
                DogRepository::update($dog);
                header("location: ".PATHSERVER."Dog/update/".$_POST['id']."");
                if ( PRODUCTION==1 ) echo "<script type='text/javascript'>location.href='".PATHSERVER."Dog/update/".$_POST['id']."';</script>";
            }else{
                echo "Update could not be completed";  
            }
            echo " la imagen es ".$dog->getImage();
            die();
        }else{
            if(isset($_SESSION['idusuario']) && $_SESSION['nivelaccesousuario']==3){
                $dog=DogRepository::getById($id[0]);
                $this->view->dog=$dog;
                $this->view->render("dog/updateUser");   
            }else if(isset($_SESSION['idusuario']) && $_SESSION['nivelaccesousuario']==1){ 
                $dog=DogRepository::getById($id[0]);
                $this->view->dog=$dog;
                $this->view->render("dog/update"); 
            }else{
                echo "You are not logged in";
            }
        }
    }
    public function delete($id=null){
        DogRepository::delete($id[0]);
        header("location: ".PATHSERVER."Game/showByCategoriesUsers");
        if ( PRODUCTION==1 ) echo "<script type='text/javascript'>location.href='".PATHSERVER."Game/showByCategoriesUsers';</script>";
    }
}