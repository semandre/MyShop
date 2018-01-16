package menu.app.controller;

import menu.app.dto.CartClientDTO;
import menu.app.entity.Cart;
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
        client.setCity(cityService.findByCityName());
//        client.setOrder(ordersService.findOne(session.getId()));
        clientService.save(client);
        ordersService.updateClient(session.getId(),clientService.findBySessionId(session.getId()));
        List<Cart> bySessionId = cartService.findAllBySessionId(session.getId());
        bySessionId.clear();
        session.setAttribute("cart",bySessionId);
//        System.out.println(bySessionId);
        return "redirect:/cart";
    }


    @GetMapping("/showOrders")
    public String showOrders(Model model)
    {
        Cart cart = new Cart();
        cart.setSessionId("asd");
        List<Cart> cartList = cartService.findAllCartsWithOrder();
        List<CartClientDTO> dtoList = new ArrayList<>();
        for (Cart order : cartList) {
            CartClientDTO dto = new CartClientDTO();
            if (!cart.getSessionId().equals(order.getSessionId())){
                dto.setSessionId(order.getSessionId());
                dto.setClientId(order.getOrder().getClient().getId());
                dto.setClientName(order.getOrder().getClient().getName());
                dto.setLastName(order.getOrder().getClient().getLastName());
                dto.setAddress(order.getOrder().getClient().getAddress());
                dto.setEmail(order.getOrder().getClient().getEmail());
                dto.setNumber(order.getOrder().getClient().getNumber());
                dto.setCityName(order.getOrder().getClient().getCity().getCityName().toLowerCase());
                dto.setCartList(cartService.findAllBySessionId(order.getSessionId()));
                dtoList.add(dto);
            }

            cart=order;
        }
        System.out.println(dtoList);
        model.addAttribute("orders",dtoList);


//        List<CartClientDTO> dtos = new ArrayList<>();
//        for (Cart cart : byClient) {
//            CartClientDTO dto = new CartClientDTO();
//            dto.setClientId(cart.getClient().getId());
//            dto.setClientName(cart.getClient().getName());
//            dto.setLastName(cart.getClient().getLastName());
//            dto.setAddress(cart.getClient().getAddress());
//            dto.setNumber(cart.getClient().getNumber());
//            dto.setPId(cart.getId());
//            dto.setPName(cart.getName());
//            dto.setPrice(cart.getPrice());
//            dto.setQuantity(cart.getQuantity());
//            dto.setSessionId(cart.getSessionId());
//            dtos.add(dto);
//
//        }
//        model.addAttribute("orders",dtos);
        return "showOrders";
    }
    
}
