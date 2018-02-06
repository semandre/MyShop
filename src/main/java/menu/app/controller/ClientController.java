package menu.app.controller;

import menu.app.dto.CartClientDTO;
import menu.app.entity.Cart;
import menu.app.entity.City;
import menu.app.entity.Client;
import menu.app.entity.Orders;
import menu.app.service.CartService;
import menu.app.service.CityService;
import menu.app.service.ClientService;
import menu.app.service.OrdersService;
import org.hibernate.criterion.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Controller
public class ClientController {
    @Autowired
    ClientService clientService;
    @Autowired
    CartService cartService;
    @Autowired
    CityService cityService;
    @Autowired
    OrdersService ordersService;


    @PostMapping("/order")
    @Transactional
    public String createCl(@RequestParam String name,
                           @RequestParam String lastName,
                           @RequestParam String email,
                           @RequestParam String address,
                           @RequestParam int number, HttpSession session){
        Client client = new Client(session.getId(),name,lastName,email,address,number);
        System.out.println(client);
        client.setCity(cityService.findByCityName());
        clientService.save(client);
        ordersService.updateClient(session.getId(),clientService.findBySessionId(session.getId()));

        return "redirect:/";
    }




    @PostMapping("/find")
    public String allCitiesWithCityName(@RequestParam String cityName,Model model){
        List<City> allByCityName = cityService.findAllByCityName(cityName);
        model.addAttribute("cityName",allByCityName);
        System.out.println(allByCityName);
        return "admin";
    }
    
}
