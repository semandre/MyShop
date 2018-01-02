package menu.app.controller;

import menu.app.entity.Cart;
import menu.app.entity.Client;
import menu.app.service.CartService;
import menu.app.service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.List;
import java.util.Random;

@Controller
public class ClientController {
    @Autowired
    ClientService clientService;
    @Autowired
    CartService cartService;


    @PostMapping("/order")
    @Transactional
    public String createCl(@RequestParam String name,
                           @RequestParam String lastName,
                           @RequestParam String address,
                           @RequestParam int number, HttpSession session){
        Client client = new Client(session.getId(),name,lastName,address,number);
        clientService.save(client);
        List<Cart> bySessionId = cartService.findAllBySessionId(session.getId());
        for (Cart cart : bySessionId) {
            cart.setClient(client);
            System.out.println(cart);
            cartService.updateAll(client,session.getId());

        }
        String changeSessionId = clientChangeSessionId(client.getId(), client.getName());
        cartService.updateSessionId(changeSessionId,client);
        bySessionId.clear();
        session.setAttribute("cart",bySessionId);

        return "redirect:/cart";
    }


    @GetMapping("/showOrders")
    public String showOrders(Model model)
    {
        model.addAttribute("orders",clientService.findByClient());
        return "redirect:/admin";
    }


    public String clientChangeSessionId(int id,String name){
        Random random = new Random();
        String changedId=id+name+random.nextInt(1000);
        return changedId;
    }

}
