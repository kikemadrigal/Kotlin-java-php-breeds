<?php
class FishController extends BaseController{
    
    function __construct()
    {
        parent::__construct();
    }


    public function index(){
        $fishs=FishRepository::getAll(0,2000);
        $this->view->fishs=$fishs;
        $this->view->render("fish/showAll"); 
    }
    public function showAllByUser(){
        $fishs=FishRepository::getAllByUser($_SESSION['idusuario'],0,2000);
        $this->view->fishs=$fishs;
        $this->view->render("fish/showAllByUser");
    }
    public function show($param=null){
        $fish=FishRepository::getById($param[0]);
        $this->view->fish=$fish;
        $this->view->render("fish/show");
    }
    public function showRandom(){
        $fish=FishRepository::getRandom();
        $specieFish=SpecieFishRepository::getById($fish->get_specie_id());
        $this->view->specieFish=$specieFish;
        $this->view->fish=$fish;
        $this->view->render("fish/showRandom");
    }
    //$games=FishRepository::getSearchGameByTitle($search);
    public function showAll($param=null){
        //$fishs=FishRepository::getAll(0,2000);
        $rowCount=FishRepository::getCountRows();
        $page=$param[0];
        $init=$page*10;
        $page+=1;
        $fishs=FishRepository::getAll($init);
        $this->view->fishs=$fishs;
        $this->view->page=$page;
        $this->view->rowCount=$rowCount;
        $this->view->render("fish/showAll");
    }
    public function showRanking($param=null){
        $rowCount=FishRepository::getCountRows();
        $page=$param[0];
        $init=$page*10;
        $page+=1;
        $fishs=FishRepository::getRanking($init);
        $this->view->fishs=$fishs;
        $this->view->page=$page;
        $this->view->rowCount=$rowCount;
        $this->view->render("fish/showRanking");
    }

    public function showUser($param = null){
        $this->view->param=$param;
        $this->view->render("fish/showUser");
    }
    public function search($search = null){
        $fishes=null;
        if (isset($_POST['submit'])){
            $fishes=FishRepository::getByName_es($_POST['search']);
        }else{
            $fishes=FishRepository::getByName_es($search[0]);
        }
        echo "obtenidos en fiscontroller: ".count($fishes);
        $this->view->fishes=$fishes;
        $this->view->render("fish/search");
    }
    public function searchUser($search = null){
        $this->view->param=$search[0];
        $this->view->render("fish/search");
    }



    public function insert(){
       $this->view->render("fish/insert");   
    }
    public function update($id=null){
        if (isset($_POST['submit'])){
            $fish=new Fish($_POST['id']);
            $fish->set_name($_POST['name']);
            $fish->set_name_es($_POST['name_es']);
            $fish->set_specie_id($_POST['specie_id']);
            $fish->set_points($_POST['points']);
            $fish->set_total_points($_POST['total_points']);
            $fish->set_path_image($_POST['path_image']);
            $fish->set_validate($_POST['validate']);
            $fish->set_date($_POST['date']);
            $fish->set_creator_id($_POST['creator_id']);
            if ($fish!=null){
                FishRepository::update($fish);
                header("location: ".PATHSERVER."Fish/update/".$_POST['id']."");
                if ( PRODUCTION==1 ) echo "<script type='text/javascript'>location.href='".PATHSERVER."Fish/update/".$_POST['id']."';</script>";
            }else{
                echo "Update could not be completed";  
            }
            echo " la imagen es ".$fish->getImage();
            die();
        }else{
            if(isset($_SESSION['idusuario']) && $_SESSION['nivelaccesousuario']==3){
                $fish=FishRepository::getById($id[0]);
                $this->view->fish=$fish;
                $this->view->render("fish/updateUser");   
            }else if(isset($_SESSION['idusuario']) && $_SESSION['nivelaccesousuario']==1){ 
                $fish=FishRepository::getById($id[0]);
                $this->view->fish=$fish;
                $this->view->render("fish/update"); 
            }else{
                echo "You are not logged in";
            }
        }
    }
    public function updateBeauty($param=null){
        $id_fish=$param[0];
        $points=$param[1];
        FishRepository::updateBeauty($id_fish, $points);
        header("location: ".PATHSERVER."Fish/showRanking");
        if ( PRODUCTION==1 ) echo "<script type='text/javascript'>location.href='".PATHSERVER."Fish/showRanking';</script>";    
    }
    public function delete($id=null){
        FishRepository::delete($id[0]);
        header("location: ".PATHSERVER."Game/showByCategoriesUsers");
        if ( PRODUCTION==1 ) echo "<script type='text/javascript'>location.href='".PATHSERVER."Game/showByCategoriesUsers';</script>";
    }
}