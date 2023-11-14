package co.istad.view;

import co.istad.model.Product;


import java.util.List;

import static java.lang.System.out;

public class ProductView {
    public static void printProductList(List<Product> products) {
        out.println("Product List");
        products.forEach(product -> {
            out.println("=".repeat(20));
            out.println("ID : " + product.getId());
            out.println("NAME : " + product.getName());
            out.println("QTY : " + product.getQty());
            out.println("PRICE : " + product.getPrice());
            out.println("IMPORTED DATE : " + product.getImportDate());
            out.println("=".repeat(20));
        });
    }
    public static void updatedProduct(Product product) {
        out.println("=".repeat(20));
        out.println("ID : " + product.getId());
        out.println("NAME : " + product.getName());
        out.println("QTY : " + product.getQty());
        out.println("PRICE : " + product.getPrice());
        out.println("IMPORTED DATE : " + product.getImportDate());
    }
}
