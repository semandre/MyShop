package menu.app.controller;

import menu.app.entity.Alcogol;
import menu.app.service.AlcoService;
import menu.app.entity.Cart;
import menu.app.service.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;

@Controller
public class CartController {


    @Autowired
    private AlcoService alcoService;
    @Autowired
    private CartService cartService;

    @GetMapping("/add/{id}")
    @Transactional
    public String addCart(@PathVariable int id, HttpSession session) {
        boolean b = true;
        Alcogol alcogol = alcoService.find(id);
        List<Cart> cartTab =cartService.findAllBySessionId(session.getId());
        for (Cart cart1 : cartTab) {
            if (cart1.getName().equals(alcogol.getName())){
                int quantity=cart1.getQuantity()+1;
                cartService.update(cart1.getSessionId(),alcogol.getName(),quantity);
                b=false;
            }
        }
        if(b){
            Cart cart2= new Cart(session.getId(),alcogol.getName(),alcogol.getPrice(),1);
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
                cartService.update(cart.getSessionId(), cart.getName(),quantity );
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
                cartService.update(cart.getSessionId(), cart.getName(), quantity);

            }
        }
        return "redirect:/cart";
    }

}
