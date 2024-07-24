<?php
class SpecieFishController extends BaseController{
    
    function __construct()
    {
        parent::__construct();
    }


    public function index(){
        $specieFishs=SpecieFishRepository::getAll(0,2000);
        $this->view->specieFishs=$specieFishs;
        $this->view->render("specieFish/showAll"); 
    }
    public function showAllByUser(){
        $specieFishs=SpecieFishRepository::getAllByUser($_SESSION['idusuario'],0,2000);
        $this->view->specieFishs=$specieFishs;
        $this->view->render("specieFish/showAllByUser");
    }
    public function show($param=null){
        $specieFish=SpecieFishRepository::getById($param[0]);
        $this->view->specieFish=$specieFish;
        $this->view->render("specieFish/show");
    }
    public function showRandom(){
        $specieFish=SpecieFishRepository::getRandom();
        $this->view->specieFish=$specieFish;
        $this->view->render("specieFish/showRandom");
    }
    //$games=SpecieFishRepository::getSearchGameByTitle($search);
    public function showAll($param=null){
        $rowCount=SpecieFishRepository::getCountRows();
        $page=$param[0];
        if(isset($_POST['page']))
            $page=$_POST['page'];
       
        $init=$page*10;
        $page+=1;
        $specieFishs=SpecieFishRepository::getAll($init);
        $this->view->specieFishs=$specieFishs;
        $this->view->page=$page;
        $this->view->rowCount=$rowCount;
        $this->view->render("specieFish/showAll");
    }


    public function showUser($param = null){
        $this->view->param=$param;
        $this->view->render("specieFish/showUser");
    }
    public function search($search = null){
        if (isset($_POST['submit'])){
            $specieFishs=SpecieFishRepository::getByName($_POST['search']);
        }else{
            $specieFishs=SpecieFishRepository::getByName($search[0]);
        }
        
        $this->view->specieFishs=$specieFishs;
        $this->view->render("specieFish/search");
    }
    public function searchUser($search = null){
        $this->view->param=$search[0];
        $this->view->render("specieFish/search");
    }



    public function insert(){
       $this->view->render("specieFish/insert");   
    }
    public function update($id=null){
        if (isset($_POST['submit'])){
            $specieFish=new SpecieFish($_POST['id']);
            $specieFish->set_name($_POST['name']);
            $specieFish->set_name_es($_POST['name_es']);
            $specieFish->set_description($_POST['description']);
            $specieFish->set_url_wiki($_POST['url_wiki']);
            $specieFish->set_url_image($_POST['url_image']);
            $specieFish->set_morphology($_POST['morphology']);
            $specieFish->set_habitat($_POST['habitat']);
            $specieFish->set_url_image($_POST['url_image']);
            $specieFish->set_feeding($_POST['feeding']);
            $specieFish->set_phylum($_POST['phylum']);
            $specieFish->set_class($_POST['class']);
            $specieFish->set_orden($_POST['orden']);
            $specieFish->set_family($_POST['family']);
            $specieFish->set_genus($_POST['genus']);
            $specieFish->set_path_image($_POST['path_image']);
            $specieFish->set_date($_POST['date']);
            $specieFish->set_creator_id($_POST['creator_id']);
            if ($specieFish!=null){
                SpecieFishRepository::update($specieFish);
                header("location: ".PATHSERVER."SpecieFish/update/".$_POST['id']."");
                if ( PRODUCTION==1 ) echo "<script type='text/javascript'>location.href='".PATHSERVER."SpecieFish/update/".$_POST['id']."';</script>";
            }else{
                echo "Update could not be completed";  
            }
            echo " la imagen es ".$specieFish->get_path_image();
            die();
        }else{
            if(isset($_SESSION['idusuario']) && $_SESSION['nivelaccesousuario']==3){
                $specieFish=SpecieFishRepository::getById($id[0]);
                $this->view->specieFish=$specieFish;
                $this->view->render("specieFish/updateUser");   
            }else if(isset($_SESSION['idusuario']) && $_SESSION['nivelaccesousuario']==1){ 
                $specieFish=SpecieFishRepository::getById($id[0]);
                $this->view->specieFish=$specieFish;
                $this->view->render("specieFish/update"); 
            }else{
                echo "You are not logged in";
            }
        }
    }
    public function delete($id=null){
        SpecieFishRepository::delete($id[0]);
        header("location: ".PATHSERVER."SpecieFish/showAll");
        if ( PRODUCTION==1 ) echo "<script type='text/javascript'>location.href='".PATHSERVER."SpecieFish/showAll';</script>";
    }
}