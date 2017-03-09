package com.example.Controller.Domain;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class Gamecontroller {

    @Autowired
    private Repository repository;

    @GetMapping("/Sida2")
    public ModelAndView listBlogs() {

        List<City> citys = repository.getcitys();

        return new ModelAndView("Sida2")
                .addObject("citys", citys);

}}
