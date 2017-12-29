package menu.app.controller;

import menu.app.entity.Alcogol;
import menu.app.service.AlcoService;
import menu.app.entity.Cart;
import menu.app.service.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Modifying;
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

    @GetMapping("/cart")
    public String cart(Model model, HttpSession session) {
        model.addAttribute("listCart",cartService.findAllBySessionId(session.getId()));
//        model.addAttribute("listCart", (List<Cart>) session.getAttribute("cart"));
//        System.out.println(session.getId());

        return "cart";
    }

    @GetMapping("/add/{id}")
    @Transactional
    public String addCart(@PathVariable int id, HttpSession session, Model model) {
        boolean b= true;
//        Cart cart = new Cart();
        Alcogol alcogol = alcoService.find(id);
//        List<Cart> list = (List<Cart>) session.getAttribute("cart");
//
//        if (list == null) {
//            list = new ArrayList<Cart>();
//        }
//
//        if (alcogol != null) {
//            cart.toCart(alcogol);
//
//            session.setAttribute("cart", list);
//
//        }
        List<Cart> cartTab =cartService.findAllBySessionId(session.getId());
        for (Cart cart1 : cartTab) {
            if (cart1.getName().equals(alcogol.getName())){
                int quantity=cart1.getQuantity()+1;
                cartService.update(alcogol.getName(),quantity);
                b=false;
            }
        }
        if(b){
            Cart cart2= new Cart(session.getId(),alcogol.getName(),alcogol.getPrice(),1);
            double total = addToCart(cartTab,cart2 );
            model.addAttribute("total", total);
            cartService.save(cart2);
        }
        cartTab=cartService.findAllBySessionId(session.getId());

        session.setAttribute("cart",cartTab);
        model.addAttribute("listCart", cartTab);
        return "redirect:/";
    }

    @GetMapping("/remove/{id}")
    public String removeCart(@PathVariable int id, HttpSession session, Model model) {
//        List<Cart> list = (List<Cart>) session.getAttribute("cart");
//        if (list != null) {

//        }
        List<Cart> cartList = cartService.findAllBySessionId(session.getId());
        for (Cart cart : cartList) {
            if (cart.getId()==(id)){
                cartService.remove(id);
            }
        }
        double total = removeCartItem(cartList, id);
        model.addAttribute("total", total);
        cartList=cartService.findAllBySessionId(session.getId());
        model.addAttribute("listCart", cartList);
        session.setAttribute("cart", cartList);

        return "cart";
    }

    @GetMapping("/update/{name}/{}")
    public String updateCart(@PathVariable String name,
                             @RequestParam int quantity,
                             HttpSession session,
                             Model model) {

//        List<Cart> list = (List<Cart>) session.getAttribute("cart");
//        if (list != null) {
//
//        }
//
        List<Cart> cartList =cartService.findAllBySessionId(session.getId());
        for (Cart cart : cartList) {
            if (cart.getName().equals(name)){
                cartService.update(name, quantity);
            }
        }

        double total = updateCartItem(cartList, name, quantity);
        model.addAttribute("total", total);
        session.setAttribute("cart", cartList);
        model.addAttribute("listCart", cartList);
        return "cart";
    }
//
//     FUNCTIONS
//
    private double addToCart(List<Cart> list, Cart cart) {
        double total = 0;
        boolean isExit = false;
        for (Cart c : list) {
            if (c.getId() == cart.getId()) {
                c.setQuantity(c.getQuantity() + 1);
                isExit = true;
            }

            total = total + c.getPrice() * c.getQuantity();
        }
        if (isExit == false) {
            list.add(cart);
            total = total + cart.getPrice() * cart.getQuantity();
        }
        return total;
    }

    private double removeCartItem(List<Cart> list, int id) {

        double total = 0;

        Cart temp = null;
        for (Cart c : list) {
            if (c.getId() == (id)) {
                temp = c;
                continue;
            }
            total = total + c.getPrice() * c.getQuantity();

        }
        if (temp != null)
            list.remove(temp);

        return total;
    }


    private double updateCartItem(List<Cart> list, String name, int quantity) {
        double total = 0;
        for (Cart c : list) {
            if (c.getName() == (name)) {
                c.setQuantity(quantity);
            }

            total = total + c.getPrice() * c.getQuantity();
        }

        return total;
    }


}
