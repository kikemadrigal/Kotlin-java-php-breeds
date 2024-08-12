<?php

class HomeController extends BaseController{
    function __construct()
    {
        parent::__construct();
    }

    public function index(){
        $lastFiveCatsUploads=CatRepository::getLastFive();
        $this->view->lastFiveCatsUploads=$lastFiveCatsUploads;
        $lastFiveDogsUploads=DogRepository::getLastFive();
        $this->view->lastFiveDogsUploads=$lastFiveDogsUploads;
        $lastFiveFishUploads=FishRepository::getLastFive();
        $this->view->lastFiveFishUploads=$lastFiveFishUploads;
        $this->view->render("home");
    }
    public function beauties(){
        $cats=CatRepository::getMax3Beauties();
        $this->view->cats=$cats;
        $dogs=DogRepository::getMax3Beauties();
        $this->view->dogs=$dogs;
        $fishs=FishRepository::getMax3Beauties();
        $this->view->fishs=$fishs;
        $this->view->render("beauties");
    }
    public function about(){
        $this->view->render("about");
    }
    public function whatis(){
        $this->view->render("whatis");
    }
    public function license(){
        $this->view->render("license");
    }
    public function error(){
        $this->view->render("error");
    }

}