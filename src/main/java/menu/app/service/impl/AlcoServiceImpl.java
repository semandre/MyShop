package menu.app.service.impl;

import menu.app.dao.AlcoDao;
import menu.app.entity.Alcogol;
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
}
