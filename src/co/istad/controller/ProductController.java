package co.istad.controller;

import co.istad.exception.ProductIdNotFoundException;
import co.istad.model.Product;
import co.istad.service.ProductService;
import co.istad.service.ProductServiceImpl;
import co.istad.util.Singleton;
import co.istad.view.ProductView;

import java.time.LocalDate;
import java.util.List;
import java.util.Scanner;

public class ProductController {

    private final Scanner scanner;
    private static Product product;
    private final ProductService productService;
    public ProductController() {
        product = new Product();
        productService = new ProductServiceImpl();
        scanner = Singleton.scanner();
    }


    public void index() {
        List<Product> products = productService.select();
        ProductView.printProductList(products);
    }
    public void delete() {
        try {
            System.out.print("Enter id you want to delete : ");
            long proID = Long.parseLong(scanner.nextLine());
            product = productService.deleteById(proID);
        } catch (ProductIdNotFoundException e) {
            System.out.println(e.getMessage());
        }
    }
    public void create() {
        try {
            System.out.print("Enter product id : ");
            long proID = Integer.parseInt(scanner.nextLine());
            System.out.print("Enter product name : ");
            String proName = scanner.nextLine();
            System.out.print("Enter product qty : ");
            int proQty = Integer.parseInt(scanner.nextLine());
            System.out.print("Enter product price : ");
            double proPrice = Double.parseDouble(scanner.nextLine());
            Product addProduct = new Product(proID, proName, proQty, proPrice, LocalDate.now());
            product = productService.insert(addProduct);
        } catch (ProductIdNotFoundException e) {
            System.out.println(e.getMessage());
        }
    }
    public void update() {
        try {
            System.out.print("Enter product id : ");
            long proID = Long.parseLong(scanner.nextLine());
            product = productService.selectById(proID);
            System.out.print("Enter new product name : ");
            String proName = scanner.nextLine();
            System.out.print("Enter new product qty : ");
            int proQty = Integer.parseInt(scanner.nextLine());
            System.out.print("Enter new product price : ");
            double proPrice = Double.parseDouble(scanner.nextLine());
            product.setName(proName);
            product.setQty(proQty);
            product.setPrice(proPrice);
            product.setImportDate(LocalDate.now());
            ProductView.updatedProduct(productService.updateById(product));
        } catch (ProductIdNotFoundException e) {
            System.out.println(e.getMessage());
        }
    }

}
