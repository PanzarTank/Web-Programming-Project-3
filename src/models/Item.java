package models;

public class Item {

    private int id;
    private String name;
    private double price;
    private int quantity; // Do we want to hold quantity in item?

    public Item(int id, String name, double price, int quantity) {

    }

    public int getItemId() {
        return id;
    }

    public void setItemId(int id) {
        this.id = id;
    }

    public String getItemName() {
        return name;
    }

    public void setItemName(String name) {
        this.name = name;
    }

    public double getItemPrice() {
        return price;
    }

    public void setItemPrice(double price) {
        this.price = price;
    }

}
