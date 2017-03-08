package com.example.Controller.Domain;

import com.example.Domain.City;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.servlet.ModelAndView;

import javax.sql.DataSource;

@Controller
public class Gamecontroller {
    @Autowired
    private Repository repository;

    @GetMapping("/Sida2")
    public ModelAndView listBlogs() {
        double longitud = 17.946824;
        double latitud = 59.407363;
        int raaaa = 1;
        City stad = repository.getcity(raaaa);
        return new ModelAndView("Sida2")
                .addObject("longitud", stad.longitud)
                .addObject("latitud", stad.latitud);
    }
}
