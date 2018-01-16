package menu.app.controller;


import menu.app.entity.City;
import menu.app.service.CityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@Controller
public class RestController {


    @Autowired
    CityService cityService;

//    @PostMapping("/findByCityName")
//    public List<City> findByCityName(@RequestBody City city){
//        return cityService.findByCityName(city.getCityName());
//    }

}
