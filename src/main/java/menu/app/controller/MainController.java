package menu.app.controller;

import menu.app.entity.Alcogol;
import menu.app.entity.Cart;
import menu.app.entity.Category;
import menu.app.service.AlcoService;
import menu.app.service.CartService;
import menu.app.service.CategoryService;
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
@Autowired
    CategoryService categoryService;

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
    session.setAttribute("cart",allBySessionId);

    model.addAttribute("total",total);
    model.addAttribute("listCart",session.getAttribute("cart"));
    return "cart";
}

    @GetMapping("/")
    public String mainPage(Model model){
        List<Alcogol> alcogolList = alcoService.findAll();
        List <Category> categoryList=categoryService.findAll();
        model.addAttribute("category",categoryList);
        model.addAttribute("alcogol",alcogolList);
        return "main";
    }


    @GetMapping("/admin")
    public String admin() {
        return "admin";
    }
    @GetMapping("/addProduct")
    public String addProduct(Model model){
        model.addAttribute("category",categoryService.findAll());
        return "addProduct";
        }

}
