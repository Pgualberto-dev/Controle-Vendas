package entities;

public class Product {
    private final int id;
    String name;
    double price;
    private int qtd;

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public int getQtd() {
        return qtd;
    }

    public void setQtd(int qtd) {
        this.qtd = qtd;
    }

    public Product(int id, String name, double price, int qtd) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.qtd = qtd;
    }

    @Override
    public String toString() {
        return "ID: " + id + " | " + name + " | Preço: R$" + price + " | Estoque: " + qtd;
    }
}
