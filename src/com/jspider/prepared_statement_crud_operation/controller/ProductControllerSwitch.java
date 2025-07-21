package com.jspider.prepared_statement_crud_operation.controller;

import java.util.List;
import java.util.Scanner;

import com.jspider.prepared_statement_crud_operation.dao.ProductDao;
import com.jspider.prepared_statement_crud_operation.dto.Product;

public class ProductControllerSwitch {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ProductDao dao = new ProductDao();

        while (true) {
            System.out.println("\n--- Product Menu ---");
            System.out.println("1. Insert Product");
            System.out.println("2. Display All Products");
            System.out.println("3. Update Product Price");
            System.out.println("4. Exit");
            System.out.print("Select your option: ");

            int option = sc.nextInt();

            switch (option) {
                case 1: {
                    System.out.print("Enter Product ID: ");
                    int id = sc.nextInt();
                    System.out.print("Enter Product Name: ");
                    String name = sc.next();
                    System.out.print("Enter Product Color: ");
                    String color = sc.next();
                    System.out.print("Enter Product Price: ");
                    double price = sc.nextDouble();

                    Product product = new Product(id, name, color, price);
                    dao.saveProductDao(product);
                    System.out.println("Product inserted successfully.");
                    break;
                }
                case 2: {
                    List<Product> products = dao.getAllProductDao();
                    if (products.isEmpty()) {
                        System.out.println(" No products found.");
                    } else {
                        for (Product product : products) {
                            System.out.println(product);
                        }
                    }
                    break;
                }
                case 3: {
                    System.out.print("Enter Product ID to update price: ");
                    int id = sc.nextInt();
                    System.out.print("Enter new Product Price: ");
                    double price = sc.nextDouble();

                    int result = dao.updateProductPriceById(price, id);
                    String msg = (result != 0) ? "Product price updated." : "Product not found or update failed.";
                    System.out.println(msg);
                    break;
                }
                case 4: {
                    System.out.println("Exiting the program. Goodbye!");
                    sc.close();
                    System.exit(0);
                }
                default: {
                    System.out.println("Invalid option. Please try again.");
                }
            }
        }
    }
}
