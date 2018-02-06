package menu.app.controller;

import menu.app.dto.CartClientDTO;
import menu.app.entity.Alcogol;
import menu.app.entity.Cart;
import menu.app.entity.Category;
import menu.app.entity.Orders;
import menu.app.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;

@RestController
public class RestAPIController {
    @Autowired
    CityService cityService;
    @Autowired
   public AlcoService alcoService;
    @Autowired
    CategoryService categoryService;
    @Autowired
    CartService cartService;
    @Autowired
    OrdersService ordersService;




    @GetMapping("/showItems")
    public @ResponseBody List<Alcogol> showingPage(){
        return alcoService.findAll();
    }

    @GetMapping("/addProduct")
    public List<Category> addProduct(){
        return categoryService.findAll();
    }

//    @GetMapping("/showItems")
//    public String showingPage(){
//        alcoService.findAll();
//        return "main";
//    }

    @GetMapping("/showOrders")
    public List<CartClientDTO> showOrders(Model model)
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

        return dtoList;
    }

    @PostMapping("/checkout")
    @Transactional
    public void checkout(@RequestBody List<Cart> cartItems, HttpSession session){
        Orders orders=saveOrder(session);
        ordersService.save(orders);
        for (Cart cartItem : cartItems) {
            cartItem.setSessionId(session.getId());
            cartItem.setOrder(orders);
            cartService.save(cartItem);
        }


    }











    public Orders saveOrder(HttpSession session){
        Orders order=new Orders();
        boolean b=true;
        List<Orders> orderList = ordersService.findAll();
        for (Orders orders1 : orderList) {
            if (orders1.getSessionId().equals(session.getId())){
                b=false;
                order=orders1;
            }
        }
        if (b){
            order = new Orders(session.getId());
        }
        return order;
    }
}
