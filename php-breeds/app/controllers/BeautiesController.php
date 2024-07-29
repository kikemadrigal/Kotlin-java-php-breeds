<?php
class BeautiesController extends BaseController{
    function __construct()
    {
        parent::__construct(); 
    }

    public function index(){
        $this->view->render("beauties/showAll");    
    }

    public function showAll(){
        $this->view->render("beauties/showAll");    
    }
    public function showRandom(){
       /* $cat=CatRepository::getRandom();
        $breedCat=BreedCatRepository::getByIdName($cat->get_breed_id());
        $this->view->breedCat=$breedCat;
        $this->view->cat=$cat;*/
        $this->view->render("beauties/showRandom");
    }
}