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
    private double stock;
    private String status;
    private String pic;
    private int catId;
    private String category;
    private double packaging;
    private double popularity;

    public AlcoDTO(int id, String name, double price, String description, double stock, String status, String pic, int catId, String category, double packaging, double popularity) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.description = description;
        this.stock = stock;
        this.status = status;
        this.pic = pic;
        this.catId = catId;
        this.category = category;
        this.packaging = packaging;
        this.popularity = popularity;
    }
}
