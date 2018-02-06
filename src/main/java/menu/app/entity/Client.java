package menu.app.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@ToString(exclude = {"city","order"})
public class Client {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String sessionId;
    private String name;
    private String lastName;
    private String email;
    private String address;
    private int number;
    @JsonIgnore
    @ManyToOne(fetch = FetchType.LAZY)
    private City city;

//    @OneToMany(cascade = CascadeType.ALL,fetch = FetchType.LAZY,mappedBy = "client")
//    private List <Cart> cartList=new ArrayList<>();
    @JsonIgnore
    @OneToOne(fetch = FetchType.LAZY ,mappedBy = "client")
    private Orders order;


    public Client(String sessionId, String name, String lastName, String email, String address, int number) {
        this.sessionId = sessionId;
        this.name = name;
        this.lastName = lastName;
        this.email = email;
        this.address = address;
        this.number = number;
    }
}
