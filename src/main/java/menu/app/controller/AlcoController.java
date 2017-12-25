package menu.app.controller;

import menu.app.entity.Alcogol;
import menu.app.service.AlcoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.List;

@Controller
public class AlcoController {

    @Autowired
    AlcoService alcoService;

    @PostMapping("/createAlc")
    public String createAlc(@RequestParam String name,
                            @RequestParam String category,
                            @RequestParam double price,
                            @RequestParam String description,
                            @RequestParam int stock,
                            @RequestParam String status,
                            @RequestParam MultipartFile pic){
        String path=System.getProperty("user.home")+File.separator+"products\\";
        try {
            pic.transferTo(new File(path+pic.getOriginalFilename()));
        } catch (IOException e) {
            e.printStackTrace();
        }
        Alcogol alcogol = new Alcogol(name,category,price,description,stock,status);
        alcogol.setPic("\\productPic\\"+pic.getOriginalFilename());
        alcoService.save(alcogol);
        return "redirect:/";
    }
    @GetMapping("/viewProduct/{id}")
    public String viewProduct(@PathVariable int id,Model model){
        Alcogol alcogol = alcoService.find(id);
        model.addAttribute("alcogol", alcogol);
        return "viewProduct";
    }

    @GetMapping("/beer")
    public String findBeer(Model model){
        List<Alcogol> alcogolList = alcoService.findAlcogolByCategory("beer");
        model.addAttribute("alcogol", alcogolList);
        return "main";
    }
    @GetMapping("/vodka")
    public String findVodka(Model model){
        List<Alcogol> alcogolList = alcoService.findAlcogolByCategory("vodka");
        model.addAttribute("alcogol", alcogolList);
        return "main";
    }
    @GetMapping("/wine")
    public String findWine(Model model){
        List<Alcogol> alcogolList = alcoService.findAlcogolByCategory("vine");
        model.addAttribute("alcogol", alcogolList);
        return "main";
    }

}
