package menu.app.controller;

import menu.app.additional.Message;
import menu.app.dto.AlcoDTO;
import menu.app.dto.CartClientDTO;
import menu.app.entity.*;
import menu.app.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@RestController
public class RestAPIController {
    @Autowired
    CityService cityService;
    @Autowired
   public AlcoService alcoService;
    @Autowired
    CategoryService categoryService;
    @Autowired
    CartService cartService;
    @Autowired
    OrdersService ordersService;
    @Autowired
    ClientService clientService;



    @GetMapping("/findCities")
    public @ResponseBody List<City> findCities(){
        return cityService.findAllBy();
    }


    @GetMapping("/showItems")
    public @ResponseBody List<AlcoDTO> showingPage(){
        List<Alcogol> alcogolList = alcoService.findAllWithCategories();
        Iterator<Alcogol> iterator = alcogolList.iterator();
        while (iterator.hasNext()){
            Alcogol alcogol = iterator.next();
            if (alcogol.getStatus().equals("Закінчився")){
                iterator.remove();
            }
        }
        System.out.println(alcogolList);

        return dtoAdding(alcogolList);

    }
    @GetMapping("/showAdminItems")
    public @ResponseBody List<AlcoDTO> showingAdminPage(){
        return dtoAdding(alcoService.findAllWithCategories());
    }


    @GetMapping("/addProduct")
    public List<Category> addProduct(){
        return categoryService.findAll();
    }

//    @GetMapping("/showItems")
//    public String showingPage(){
//        alcoService.findAll();
//        return "main";
//    }

    @GetMapping("/showOrders")
    public List<CartClientDTO> showOrders()
    {
        List<CartClientDTO> dtoList = cartDtoAdding(cartService.findAllCartsWithOrder());
        return dtoList;
    }

    @PostMapping("/checkout")
    @Transactional
    public void checkout(@RequestBody List<Cart> cartItems, HttpSession session){
        Orders orders=saveOrder(session);
        ordersService.save(orders);
        for (Cart cartItem : cartItems) {
            cartItem.setSessionId(session.getId());
            cartItem.setOrder(orders);
            cartService.save(cartItem);
        }


    }

    @PostMapping("/addCategory")
    public Message saveCategory(@RequestBody String category){
        Category category1= new Category(category);
        boolean b = true;
        String message="Категорія успішно додана";

        List<Category> all = categoryService.findAll();
        for (Category category2 : all) {
            if (category1.getName().toLowerCase().equals(category2.getName().toLowerCase())){
                b=false;
                message="Категорія з таким іменем уже добавлена";
            }
        }
        if (b){
            categoryService.save(category1);
        }
        return new Message(message);
    }

    @PostMapping("/addCity")
    public Message saveCity(@RequestBody String cityName){
        boolean b = true;
        String message="Місто успішно додане";
        City city1 = new City(cityName);
        List<City> all = cityService.findAllBy();
        for (City city2 : all) {
            if (city1.getCityName().toLowerCase().equals(city2.getCityName().toLowerCase())){
                b=false;
                message="Місто з таким іменем уже добавлене";
            }
        }
        if (b){
            cityService.save(city1);
        }
        return new Message(message);
    }

    @PostMapping("/deleteItem")
    @Transactional
    public List<AlcoDTO> deleteItem(@RequestBody int id){
        alcoService.removeItem(id);
        return dtoAdding(alcoService.findAllWithCategories());
    }




    @PostMapping("/sendOrder")
    @Transactional
    public List<CartClientDTO> sendOrder(@RequestBody String sessionId){
        cartService.deleteAllBySessionId(sessionId);
        ordersService.deleteAllBySessionId(sessionId);
        clientService.deleteAllBySessionId(sessionId);
        return cartDtoAdding(cartService.findAllCartsWithOrder());
    }



    public List<CartClientDTO> cartDtoAdding(List<Cart> cartList){
        Cart cart = new Cart();
        cart.setSessionId("asd");
        List<CartClientDTO> dtoList = new ArrayList<>();
        for (Cart order : cartList) {
            CartClientDTO dto = new CartClientDTO();
            if (!cart.getSessionId().equals(order.getSessionId())){
                dto.setSessionId(order.getSessionId());
                dto.setClientId(order.getOrder().getClient().getId());
                dto.setClientName(order.getOrder().getClient().getName());
                dto.setLastName(order.getOrder().getClient().getLastName());
                dto.setAddress(order.getOrder().getClient().getAddress());
                dto.setEmail(order.getOrder().getClient().getEmail());
                dto.setNumber(order.getOrder().getClient().getNumber());
                dto.setCityName(order.getOrder().getClient().getCity().getCityName().toLowerCase());
                dto.setCartList(cartService.findAllBySessionId(order.getSessionId()));
                dtoList.add(dto);
            }
            cart=order;

        }

        return dtoList;
    }


    public List<AlcoDTO> dtoAdding(List<Alcogol> alcogolList){
        List<AlcoDTO> alcoDTOList = new ArrayList<>();
        for (Alcogol alcogol : alcogolList) {
            AlcoDTO alcoDTO = new AlcoDTO();
            alcoDTO.setId(alcogol.getId());
            alcoDTO.setCategory(alcogol.getCategory().getName());
            alcoDTO.setCatId(alcogol.getCategory().getId());
            alcoDTO.setDescription(alcogol.getDescription());
            alcoDTO.setName(alcogol.getName());
            alcoDTO.setPic(alcogol.getPic());
            alcoDTO.setPrice(alcogol.getPrice());
            alcoDTO.setStatus(alcogol.getStatus());
            alcoDTO.setStock(alcogol.getStock());
            alcoDTO.setPackaging(alcogol.getPacking());
            alcoDTO.setPopularity(alcogol.getPopularity());
            alcoDTOList.add(alcoDTO);
        }
        return alcoDTOList;
    }




    public Orders saveOrder(HttpSession session){
        Orders order=new Orders();
        boolean b=true;
        List<Orders> orderList = ordersService.findAll();
        for (Orders orders1 : orderList) {
            if (orders1.getSessionId().equals(session.getId())){
                b=false;
                order=orders1;
            }
        }
        if (b){
            order = new Orders(session.getId());
        }
        return order;
    }

    //    @PostMapping("/editItem")
//    @Transactional
//    public List<AlcoDTO> editItem(@RequestBody AlcoDTO alcogol
//            ){
//        alcoService.updateItem(alcogol.getId(), alcogol.getName(), alcogol.getPrice(), alcogol.getStock(), alcogol.getStatus(), alcogol.getDescription());
//        return dtoAdding(alcoService.findAllWithCategories());
//    }

}
