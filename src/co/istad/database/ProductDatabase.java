package co.istad.database;
import co.istad.model.Product;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class ProductDatabase {
    private final List<Product> products;
    public ProductDatabase() {
        products = new ArrayList<>();
        products.add(new Product(1L, "MrBeast Choco", 100, 10000.0, LocalDate.now()));
        products.add(new Product(2L, "Prime", 200, 25000.0, LocalDate.now()));
        products.add(new Product(3L, "lay's", 150, 5000.0, LocalDate.now()));
        products.add(new Product(4L, "Coca Cola", 90, 2500.0, LocalDate.now()));
        products.add(new Product(5L, "Vigor", 100, 2500.0, LocalDate.now()));
    }

    public List<Product> getProducts() {
        return products;
    }
}
