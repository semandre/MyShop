package menu.app.service;

import menu.app.entity.Client;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


public interface ClientService {

     void save(Client client);

}
