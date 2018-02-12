package menu.app.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;

@Entity
public class Alcogol {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String name;
    private double price;
    @Column(columnDefinition="TEXT")
    private String description;
    private double packing;
    private double stock;
    private String status;
    private double popularity;
    private String pic;

    @JsonIgnore
    @ManyToOne(fetch = FetchType.LAZY)
    private Category category;

    public Alcogol() {
    }

    public Alcogol(String name, double price, String description, double packing, int stock, String status, int popularity) {
        this.name = name;
        this.price = price;
        this.description = description;
        this.packing = packing;
        this.stock = stock;
        this.status = status;
        this.popularity = popularity;

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getPic() {
        return pic;
    }

    public void setPic(String pic) {
        this.pic = pic;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public double getPacking() {
        return packing;
    }

    public void setPacking(double packing) {
        this.packing = packing;
    }

    public double getPopularity() {
        return popularity;
    }

    public void setPopularity(int popularity) {
        this.popularity = popularity;
    }

    @Override
    public String toString() {
        return "Alcogol{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", price=" + price +
                ", description='" + description + '\'' +
                ", packing=" + packing +
                ", stock=" + stock +
                ", status='" + status + '\'' +
                ", popularity=" + popularity +
                ", pic='" + pic + '\'' +
                ", category=" + category +
                '}';
    }
}
