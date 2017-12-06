package menu.app.controller;

import menu.app.entity.Alcogol;
import menu.app.service.AlcoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class MainController {
@Autowired
    AlcoService alcoService;
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
