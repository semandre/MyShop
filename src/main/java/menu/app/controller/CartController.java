package menu.app.controller;

import menu.app.dao.AlcoDao;
import menu.app.entity.Alcogol;
import menu.app.service.AlcoService;
import menu.model.Cart;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;

@Controller
public class CartController {


    @Autowired
    private AlcoService alcoService;

    @GetMapping("/cart")
    public String cart(Model model, HttpSession session) {
        model.addAttribute("listCart", (List<Cart>) session.getAttribute("cart"));
        System.out.println(session.getId());
        return "cart";
    }

    @GetMapping("/add/{id}")
    public String addCart(@PathVariable int id, HttpSession session, Model model) {
        Cart cart = new Cart();
        Alcogol alcogol = alcoService.find(id);
        List<Cart> list = (List<Cart>) session.getAttribute("cart");

        if (list == null) {
            list = new ArrayList<Cart>();
        }

        if (alcogol != null) {
            cart.toCart(alcogol);
            double total = addToCart(list, cart);
            model.addAttribute("total", total);
            session.setAttribute("cart", list);

        }



        model.addAttribute("listCart", list);
        return "redirect:/";
    }

    @GetMapping("/remove/{id}")
    public String removeCart(@PathVariable int id, HttpSession session, Model model) {
        List<Cart> list = (List<Cart>) session.getAttribute("cart");
        if (list != null) {
            double total = removeCartItem(list, id);
            model.addAttribute("total", total);
            session.setAttribute("cart", list);
        }

        model.addAttribute("listCart", list);

        return "cart";
    }

    @GetMapping("/update/{id}")
    public String updateCart(@PathVariable int id,
                             @RequestParam int quantity,
                             HttpSession session,
                             Model model) {

        List<Cart> list = (List<Cart>) session.getAttribute("cart");
        if (list != null) {
            double total = updateCartItem(list, id, quantity);
            model.addAttribute("total", total);
            session.setAttribute("cart", list);
        }
        model.addAttribute("listCart", list);
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


    private double updateCartItem(List<Cart> list, int id, int quantity) {
        double total = 0;
        for (Cart c : list) {
            if (c.getId() == (id)) {
                c.setQuantity(quantity);
            }

            total = total + c.getPrice() * c.getQuantity();
        }

        return total;
    }


}
