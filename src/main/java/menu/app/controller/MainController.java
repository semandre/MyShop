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



@GetMapping("/")
public String mainPage(){

    return "main";
}


    @GetMapping("/admin")
    public String admin() {
        return "admin";
    }


}
