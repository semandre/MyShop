package menu.app.controller;

import menu.app.dto.AlcoDTO;
import menu.app.dto.CartClientDTO;
import menu.app.entity.*;
import menu.app.service.*;
import org.hibernate.criterion.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.IOException;
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
    @Autowired
    AlcoService alcoService;


    @PostMapping("/order")
    @Transactional
    public String createCl(@RequestParam String name,
                           @RequestParam String lastName,
                           @RequestParam String email,
                           @RequestParam String address,
                           @RequestParam int number, HttpSession session){
        List<Cart> cartList = cartService.findAllBySessionId(session.getId());
        String status="В наявності";
        Client client = new Client(session.getId(),name,lastName,email,address,number);
        System.out.println(client);
        client.setCity(cityService.findByCityName());
        clientService.save(client);
        ordersService.updateClient(session.getId(),clientService.findBySessionId(session.getId()));
        for (Cart cart : cartList) {
            Alcogol byName = alcoService.findByName(cart.getName());
            int rizn = (byName.getStock() - cart.getQuantity());
            if (rizn<=0){
                status="Закінчився";
            }

            alcoService.updateStockAndStatus(rizn,status,cart.getName());

        }
        return "redirect:/";
    }




    @PostMapping("/find")
    public String allCitiesWithCityName(@RequestParam String cityName,Model model){
        List<City> allByCityName = cityService.findAllByCityName(cityName);
        model.addAttribute("cityName",allByCityName);
        System.out.println(allByCityName);
        return "admin";
    }

//    @PostMapping("/editItem")
//    @Transactional
//    public String editItem(
//                           @RequestParam String name,
//                           @RequestParam double price,
//                           @RequestParam int stock,
//                           @RequestParam String status,
//                           @RequestParam String description,
//                           @RequestParam MultipartFile pic){
//        System.out.println("hi");
//        String path=System.getProperty("user.home")+ File.separator+"products\\";
//        try {
//            pic.transferTo(new File(path+pic.getOriginalFilename()));
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//        alcoService.updateItem(8, name, price, stock, status, description, "\\productPic\\"+pic.getOriginalFilename());
//        return "admin";
//    }


}
