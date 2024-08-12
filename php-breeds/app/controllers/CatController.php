<?php
class CatController extends BaseController{
    
    function __construct()
    {
        parent::__construct();
    }


    public function index(){
        $cats=CatRepository::getAll(0,2000);
        $this->view->cats=$cats;
        $this->view->render("cat/showAll"); 
    }
    public function showAllByUser(){
        $cats=CatRepository::getAllByUser($_SESSION['idusuario'],0,2000);
        $this->view->cats=$cats;
        $this->view->render("cat/showAllByUser");
    }
    public function show($param=null){
        $cat=CatRepository::getById($param[0]);
        $this->view->cat=$cat;
        $breedCat=BreedCatRepository::getByIdName($cat->get_breed_id());    
        if($breedCat!=null)   
            $this->view->breedCatName=$breedCat->get_name();
        $this->view->render("cat/show");
    }
    public function showRandom(){
        $cat=CatRepository::getRandom();
        $breedCat=BreedCatRepository::getByIdName($cat->get_breed_id());
        $this->view->breedCat=$breedCat;
        $this->view->cat=$cat;
        $this->view->render("cat/showRandom");
    }
    //$games=CatRepository::getSearchGameByTitle($search);
    public function showAll($param=null){
        $rowCount=CatRepository::getCountRows();
        $page=(int)$param[0];
        $init=$page*10;
        $page+=1;
        $cats=CatRepository::getAll($init);
        $this->view->cats=$cats;
        $this->view->page=$page;
        $this->view->rowCount=$rowCount;
        $this->view->render("cat/showAll");
    }
    public function showRanking($param=null){
        $rowCount=CatRepository::getCountRows();
        $page=(int)$param[0];
        $init=$page*10;
        $page+=1;
        $cats=CatRepository::getRanking($init);
        $this->view->cats=$cats;
        $this->view->page=$page;
        $this->view->rowCount=$rowCount;
        $this->view->render("cat/showRanking");
    }


    public function showUser($param = null){
        $this->view->param=$param;
        $this->view->render("cat/showUser");
    }
    public function search($search = null){
        $cats=null;
        if (isset($_POST['submit'])){
            $cats=CatRepository::getByName($_POST['search']);
        }else{
            $cats=CatRepository::getByName($search[0]);
        }
        $this->view->cats=$cats;
        $this->view->render("cat/search");
    }
    public function searchUser($search = null){
        $this->view->param=$search[0];
        $this->view->render("cat/search");
    }



    public function insert(){
       $this->view->render("cat/insert");   
    }
    public function update($id=null){
        if (isset($_POST['submit'])){
            $cat=new Cat($_POST['id']);
            $cat->set_name($_POST['name']);
            $cat->set_name_es($_POST['name_es']);
            $cat->set_breed_id($_POST['breed_id']);
            $cat->set_family($_POST['family']);
            $cat->set_description($_POST['description']);
            $cat->set_description_es($_POST['description_es']);
            $cat->set_year_of_birth($_POST['year_of_birth']);
            $cat->set_sex($_POST['sex']);
            $cat->set_address($_POST['address']);
            //$cat->set_vaccines($_POST['vaccines']);
            $cat->set_points($_POST['points']);
            $cat->set_total_points($_POST['total_points']);
            $cat->set_path_image($_POST['path_image']);
            $cat->set_validate($_POST['validate']);
            $cat->set_date($_POST['date']);
            $cat->set_creator_id($_POST['creator_id']);
            echo "el valor de post es ".$_POST['name_es'];
            if ($cat!=null){
                CatRepository::update($cat);
                echo "el name_es es: ".$cat->get_name_es();
                header("location: ".PATHSERVER."Cat/update/".$_POST['id']."");
                if ( PRODUCTION==1 ) echo "<script type='text/javascript'>location.href='".PATHSERVER."Cat/update/".$_POST['id']."';</script>";
            }else{
                echo "Update could not be completed";  
            }    
            die();
        }else{
            //Si es un usuario normal
            if(isset($_SESSION['idusuario']) && $_SESSION['nivelaccesousuario']==3){
                $cat=CatRepository::getById($id[0]);
                $this->view->cat=$cat;
                $this->view->render("cat/updateUser");   
            //Si es un administrador
            }else if(isset($_SESSION['idusuario']) && $_SESSION['nivelaccesousuario']==1){ 
                $cat=CatRepository::getById($id[0]);
                $this->view->cat=$cat;
                $this->view->render("cat/update"); 
            }else{
                echo "You are not logged in";
            }
        }
    }
    public function updateBeauty($param=null){
        $id_cat=$param[0];
        $points=$param[1];
        CatRepository::updateBeauty($id_cat, $points);
        header("location: ".PATHSERVER."Cat/showRanking");
        if ( PRODUCTION==1 ) echo "<script type='text/javascript'>location.href='".PATHSERVER."Cat/showRanking';</script>";    
    }
    public function delete($id=null){
        CatRepository::delete($id[0]);
        header("location: ".PATHSERVER."Game/showByCategoriesUsers");
        if ( PRODUCTION==1 ) echo "<script type='text/javascript'>location.href='".PATHSERVER."Game/showByCategoriesUsers';</script>";
    }
}