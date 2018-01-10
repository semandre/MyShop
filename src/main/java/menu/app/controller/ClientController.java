package menu.app.controller;

import menu.app.dto.CartClientDTO;
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
import java.util.ArrayList;
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
            cartService.updateAll(client,session.getId());

        }
        bySessionId.clear();
        session.setAttribute("cart",null);
//        System.out.println(bySessionId);
        return "redirect:/cart";
    }


    @GetMapping("/showOrders")
    public String showOrders(Model model)
    {
//        model.addAttribute("orders",cartService.findByClient());
        List<Cart> byClient = cartService.findByClient();
//        List<Client> clients = clientService.findAll();
//        List<Cart> cartList = new ArrayList<>();
//        for (Client client : clients) {
//            for (Cart cart : byClient) {
//                if (client.getId()==cart.getClient().getId()){
//                    cartList.add(cart);
//                }
//            }
//            client.setCartList(cartList);
//            System.out.println(client);
//        }


        List<CartClientDTO> dtos = new ArrayList<>();
        for (Cart cart : byClient) {
            CartClientDTO dto = new CartClientDTO();
            dto.setClientId(cart.getClient().getId());
            dto.setClientName(cart.getClient().getName());
            dto.setLastName(cart.getClient().getLastName());
            dto.setAddress(cart.getClient().getAddress());
            dto.setNumber(cart.getClient().getNumber());
            dto.setPId(cart.getId());
            dto.setPName(cart.getName());
            dto.setPrice(cart.getPrice());
            dto.setQuantity(cart.getQuantity());
            dto.setSessionId(cart.getSessionId());
            dtos.add(dto);

        }
        model.addAttribute("orders",dtos);
        return "showOrders";
    }




}
