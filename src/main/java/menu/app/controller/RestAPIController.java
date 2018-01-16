package menu.app.controller;

import menu.app.service.CityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class RestAPIController {
    @Autowired
    CityService cityService;

    @PostMapping("/find")
    @Transactional
    public String allCitiesWithName(@RequestParam String cityName){

        System.out.println(cityService.allCitiesWithName(cityName));
        return "admin";
    }
}