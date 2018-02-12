package menu.app.service;

import menu.app.entity.Alcogol;
import menu.app.entity.Category;

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
    void updateItem(int id, String name, double price, double stock, String status, String description, Category category,double packaging);
    void updateStockAndStatus(double stock,String status,double popularity,String name);

}
