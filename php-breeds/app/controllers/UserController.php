<?php
class UserController extends BaseController{
    function __construct()
    {
        parent::__construct();
    }

    public function update(){
        $this->view->render("user/update");    
    }
    public function showAll(){
        if(!isset($_SESSION['idusuario'])){
            $message="No has iniciado sesión.";
        }else{
            $cats=CatRepository::getAllByUser($_SESSION['idusuario'],0);
            $this->view->cats=$cats;
            $dogs=DogRepository::getAllByUser($_SESSION['idusuario'],0);
            $this->view->dogs=$dogs;
            $fishs=FishRepository::getAllByUser($_SESSION['idusuario'],0);
            $this->view->fishs=$fishs;
        }
        $this->view->message=$message;
        $this->view->render("user/showAll");    
    }
    
}