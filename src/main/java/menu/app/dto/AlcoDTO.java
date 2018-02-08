package menu.app.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@ToString
public class AlcoDTO {
    private int id;
    private String name;
    private double price;
    private String description;
    private int stock;
    private String status;
    private String pic;
    private int catId;
    private String category;

    public AlcoDTO(int id, String name, double price, String description, int stock, String status, String pic, int catId, String category) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.description = description;
        this.stock = stock;
        this.status = status;
        this.pic = pic;
        this.catId = catId;
        this.category = category;
    }
}
