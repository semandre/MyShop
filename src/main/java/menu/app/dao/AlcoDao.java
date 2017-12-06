package menu.app.dao;

import menu.app.entity.Alcogol;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AlcoDao extends JpaRepository<Alcogol,Integer> {

}
