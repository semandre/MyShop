package menu.app.service;

import menu.app.entity.Alcogol;

import java.util.List;

public interface AlcoService {

    void save(Alcogol alcogol);
    List<Alcogol> findAll();
    Alcogol find(int id);
     List<Alcogol> findAlcogolByCategory(int id);
    Alcogol findAllWithCategory(int id);

}
