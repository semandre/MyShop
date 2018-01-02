package menu.app.controller;

import menu.app.entity.Alcogol;
import menu.app.entity.Cart;
import menu.app.service.AlcoService;
import menu.app.service.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;


import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
public class MainController {
@Autowired
    AlcoService alcoService;
@Autowired
    CartService cartService;

//    @GetMapping("/")
//    public String startPage(){
//        return "header";
//    }
@GetMapping("/cart")
public String cart(Model model, HttpSession session) {
    double total =0;
    List<Cart> allBySessionId = cartService.findAllBySessionId(session.getId());
    for (Cart cart : allBySessionId) {
         total = total +(cart.getQuantity()*cart.getPrice());
    }
    model.addAttribute("total",total);
    model.addAttribute("listCart",allBySessionId);
    return "cart";
}

    @GetMapping("/")
    public String mainPage(Model model){
        List<Alcogol> alcogolList = alcoService.findAll();
        model.addAttribute("alcogol",alcogolList);
        return "main";
    }


    @GetMapping("/admin")
    public String admin(){
        return "admin";
    }

}
