package menu.app.service;

import menu.app.entity.Cart;
import menu.app.entity.Client;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


public interface ClientService {

     void save(Client client);
     List<Client> findByClient();

}
