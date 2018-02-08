package menu.app.service;

import menu.app.entity.Alcogol;

import java.util.List;

public interface AlcoService {

    void save(Alcogol alcogol);
    List<Alcogol> findAll();
    Alcogol find(int id);
     List<Alcogol> findAlcogolByCategory(int id);
    Alcogol findWithCategory(int id);
    List<Alcogol> findAllWithCategories();
    void removeItem(int id);
    Alcogol findByName(String name);
    void updateItem(int id,String name,double price,int stock,String status, String description);
    void updateStockAndStatus(int stock,String status,String name);

}
