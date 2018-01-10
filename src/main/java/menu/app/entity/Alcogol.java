package menu.app.entity;

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
    private int stock;
    private String status;
    private String pic;


    @ManyToOne(fetch = FetchType.LAZY)
    private Category category;

    public Alcogol() {
    }

    public Alcogol(String name, double price, String description, int stock, String status) {
        this.name = name;
        this.price = price;
        this.description = description;
        this.stock = stock;
        this.status = status;
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

    public int getStock() {
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

    @Override
    public String toString() {
        return "Alcogol{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", price=" + price +
                ", description='" + description + '\'' +
                ", stock=" + stock +
                ", status='" + status + '\'' +
                ", pic='" + pic + '\'' +
                '}';
    }
}
