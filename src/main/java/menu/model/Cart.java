package menu.model;


import menu.app.entity.Alcogol;

public class Cart {
    private int id;
    private String name;
    private double price;
    private int quantity;


    public Cart() {
    }

    public Cart(int id, String name, double price, int quantity) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.quantity = quantity;
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

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public void toCart(Alcogol alcogol){
        this.id=alcogol.getId();
        this.name=alcogol.getName();
        this.price=alcogol.getPrice();
        this.quantity=1;
    }
}
