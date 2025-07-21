package com.jspider.prepared_statement_crud_operation.controller;

import java.util.List;

import com.jspider.prepared_statement_crud_operation.dao.ProductDao;
import com.jspider.prepared_statement_crud_operation.dto.Product;

public class AllProductController {
    public static void main(String[] args) {
		ProductDao dao = new ProductDao();
		List<Product> products = dao.getAllProductDao();
		for(Product product :products)
		{
			System.out.println(product);
		}
	}
}
