package menu.app.service.impl;

import menu.app.dao.AlcoDao;
import menu.app.entity.Alcogol;
import menu.app.entity.Category;
import menu.app.service.AlcoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AlcoServiceImpl implements AlcoService {

    @Autowired
    AlcoDao alcoDao;

    @Override
    public void save(Alcogol alcogol) {
        alcoDao.save(alcogol);
    }

    @Override
    public List<Alcogol> findAll() {
        return alcoDao.findAll();
    }

    @Override
    public Alcogol find(int id) {
        return alcoDao.findOne(id);
    }

    @Override
    public List<Alcogol> findAlcogolByCategory(int id) {
        return alcoDao.findAlcogolByCategory(id);
    }

    @Override
    public Alcogol findWithCategory( int id) {
        return alcoDao.findWithCategory(id);
    }

    @Override
    public List<Alcogol> findAllWithCategories() {
        return alcoDao.findAllWithCathegories();
    }

    @Override
    public void removeItem(int id) {
        alcoDao.delete(id);
    }

    @Override
    public Alcogol findByName(String name) {
        return alcoDao.findByName(name);
    }

    @Override
    public void updateItem(int id, String name, double price, double stock, String status, String description, Category category,double packaging) {
        alcoDao.updateItem(id,name,price,stock,status,description,category,packaging);
    }

    @Override
    public void updateStockAndStatus(double stock, String status,double popularity, String name) {
        alcoDao.updateStockAndStatusAndPopularity(stock,status,popularity,name);
    }
}
