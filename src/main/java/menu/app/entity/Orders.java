package menu.app.entity;


import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@ToString
public class Orders {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String sessionId;

    @OneToOne(fetch = FetchType.LAZY)
    private Client client;
    @OneToMany(fetch = FetchType.LAZY,mappedBy = "order")
    private List<Cart> cartList;

    public Orders(String sessionId) {
        this.sessionId = sessionId;
    }

}
