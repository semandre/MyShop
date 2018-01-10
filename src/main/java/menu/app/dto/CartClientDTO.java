package menu.app.dto;


import lombok.*;

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
    private int number;
    private int pId;
    private String pName;
    private double price;
    private int quantity;

    public CartClientDTO(int clientId, String sessionId,
                         String clientName, String lastName,
                         String address, int number,
                         int pId, String pName,
                         double price, int quantity) {
        this.clientId = clientId;
        this.sessionId = sessionId;
        this.clientName = clientName;
        this.lastName = lastName;
        this.address = address;
        this.number = number;
        this.pId = pId;
        this.pName = pName;
        this.price = price;
        this.quantity = quantity;
    }
}
