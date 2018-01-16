package menu.app.dto;


import lombok.*;
import menu.app.entity.Cart;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
//@AllArgsConstructor
@ToString
public class CartClientDTO {
    private int clientId;
    private String sessionId;
    private String clientName;
    private String lastName;
    private String address;
    private String email;
    private String cityName;
    private int number;
    private List<Cart> cartList;

    public CartClientDTO(int clientId, String sessionId, String clientName, String lastName,
                         String address, String email, String cityName, int number) {
        this.clientId = clientId;
        this.sessionId = sessionId;
        this.clientName = clientName;
        this.lastName = lastName;
        this.address = address;
        this.email = email;
        this.cityName = cityName;
        this.number = number;

    }
}
