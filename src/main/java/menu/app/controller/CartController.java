package menu.app.controller;

import menu.app.entity.Alcogol;

import menu.app.entity.Orders;
import menu.app.service.AlcoService;
import menu.app.entity.Cart;
import menu.app.service.CartService;
import menu.app.service.CityService;
import menu.app.service.OrdersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
public class CartController {


    @Autowired
    private AlcoService alcoService;
    @Autowired
    private CartService cartService;
    @Autowired
    private OrdersService ordersService;

    @GetMapping("/add/{id}")
    @Transactional
    public String addCart(@PathVariable int id, HttpSession session) {
        boolean b = true;
        Orders orders=saveOrder(session);
        ordersService.save(orders);
        Alcogol alcogol = alcoService.find(id);
        List<Cart> cartTab =cartService.findAllBySessionId(session.getId());
        for (Cart cart1 : cartTab) {
            if (cart1.getName().equals(alcogol.getName())){
                int quantity=cart1.getQuantity()+1;
                cartService.update(cart1.getSessionId(),alcogol.getName(),quantity,orders);
                b=false;
            }
        }
        if(b){
            Cart cart2= new Cart(session.getId(),alcogol.getName(),alcogol.getPrice(),1);
            cart2.setOrder(orders);
            cartService.save(cart2);
        }
        return "redirect:/" ;
    }

    @GetMapping("/remove/{id}")
    public String removeCart(@PathVariable int id, HttpSession session) {
        List<Cart> cartList = cartService.findAllBySessionId(session.getId());
        for (Cart cart : cartList) {
            if (cart.getId()==(id)){
                cartService.remove(id);
            }
        }
        return "redirect:/cart";
    }

    @GetMapping("/update/{id}")
    @Transactional
    public
    String updateCart(@PathVariable int id,
                      HttpSession session) {

        List<Cart> cartList =cartService.findAllBySessionId(session.getId());
        for (Cart cart : cartList) {
            if (cart.getId()==(id)){
                int quantity=cart.getQuantity()+1;
                System.out.println(cart.getSessionId());
                System.out.println(cart.getName());
                System.out.println(cart.getQuantity());
                cartService.updateQuantityByName(cart.getSessionId(), cart.getName(),quantity );
            }
        }
        return "redirect:/cart";
    }

    @GetMapping("/decrement/{id}")
    @Transactional
    public String decrementCart(@PathVariable int id,
                                HttpSession session) {
        List<Cart> cartList = cartService.findAllBySessionId(session.getId());
        for (Cart cart : cartList) {
            if (cart.getId() == (id)) {

                int quantity = cart.getQuantity() - 1;
                if (quantity==0){
                    quantity=1;
                }
                System.out.println(cart.getSessionId());
                System.out.println(cart.getName());
                System.out.println(cart.getQuantity());
                cartService.updateQuantityByName(cart.getSessionId(), cart.getName(), quantity);

            }
        }
        return "redirect:/cart";
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
