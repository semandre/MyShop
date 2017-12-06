package menu.app.service;

import menu.app.entity.Alcogol;

import java.util.List;

public interface AlcoService {

    void save(Alcogol alcogol);
    List<Alcogol> findAll();

}
