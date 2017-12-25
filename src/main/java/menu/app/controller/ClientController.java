package menu.app.controller;

import menu.app.entity.Client;
import menu.app.service.ClientService;
import menu.model.Cart;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.List;

@RestController
public class ClientController {
    @Autowired
    ClientService clientService;


    @PostMapping("/createClient")
    public String createCl(@RequestParam String name,
                           @RequestParam String lastName,
                           @RequestParam String address,
                           @RequestParam int number){
        Client client = new Client(name,lastName,address,number);
        clientService.save(client);


        return "cart";
    }





}
