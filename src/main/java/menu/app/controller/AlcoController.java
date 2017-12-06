package menu.app.controller;

import menu.app.entity.Alcogol;
import menu.app.service.AlcoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class AlcoController {

    @Autowired
    AlcoService alcoService;

    @PostMapping("/createAlc")
    public String createAlc(@RequestParam String name,
                            @RequestParam String category,
                            @RequestParam int price){

        Alcogol alcogol = new Alcogol(name,category,price);
        alcoService.save(alcogol);
        return "redirect:/main";
    }

    @GetMapping("/main")
    public String getAlc(){
        return "main";
    }

}
