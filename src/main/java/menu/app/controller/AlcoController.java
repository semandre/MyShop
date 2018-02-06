package menu.app.controller;

import menu.app.entity.Alcogol;
import menu.app.entity.Category;
import menu.app.service.AlcoService;
import menu.app.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.IOException;
import java.util.List;

@Controller
public class AlcoController {

    @Autowired
    AlcoService alcoService;
    @Autowired
    CategoryService categoryService;


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
        Alcogol alcogol = new Alcogol(name,price,description,stock,status);
        Category one = categoryService.findOne(category);
        System.out.println(one);
        alcogol.setPic("\\productPic\\"+pic.getOriginalFilename());
        alcogol.setCategory(one);
        alcoService.save(alcogol);
        return "redirect:/";
    }
    @GetMapping("/viewProduct/{id}")
    public String viewProduct(@PathVariable int id, Model model){
        Alcogol alcogol = alcoService.findAllWithCategory(id);
        model.addAttribute("alcogol", alcogol);
        System.out.println(alcogol);
        return "viewProduct";
    }

    @GetMapping("/{id}")
    public String findBeer(@PathVariable int id, Model model){
        List<Alcogol> alcogolList = alcoService.findAlcogolByCategory(id);
        model.addAttribute("category",categoryService.findAll());
        model.addAttribute("alcogol", alcogolList);
        return "main";
    }


    @PostMapping("/saveCategory")
    public String saveCategory(@RequestBody Category category){
        System.out.println(category);
        categoryService.save(category);
        return "redirect:/admin";
    }

}
