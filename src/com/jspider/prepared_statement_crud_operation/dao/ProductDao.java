package com.jspider.prepared_statement_crud_operation.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.jspider.prepared_statement_crud_operation.connection.ProductConnection;
import com.jspider.prepared_statement_crud_operation.dto.Product;


public class ProductDao {
	Connection connection = ProductConnection.getProductConnection();
	
      public void saveProductDao(Product p) {
    	  String insertProductQuery = "insert into product(id,name,color,price) values(?,?,?,?)";
    	  try {
    		  PreparedStatement ps= connection.prepareStatement(insertProductQuery);
    	  ps.setInt(1,p.getId());
    	  ps.setString(2, p.getName());
    	  ps.setString(3, p.getColor());
    	  ps.setDouble(4, p.getPrice());
    	  
    	  int a=ps.executeUpdate();
    	  String msg = a!=0 ?"data stored" : "something wrong";
    	  System.out.println(msg);
    	  }catch(SQLException e) {
    		  e.printStackTrace();
    	  }
    	  
      }
//      public Product getProductByIdDao(int productId) {
    	  public List<Product> getAllProductDao(){
    	  String displayAllProduct = "Select * from product";
		try {
			PreparedStatement ps = connection.prepareStatement(displayAllProduct);
			ResultSet set = ps.executeQuery();
			List<Product> products = new ArrayList<Product>();
			if(set.next()) {
				int id = set.getInt("Id");
				String name = set.getString("name");
				String color = set.getString("color");
				Double price = set.getDouble("price");
				
				Product product = new Product(id,name,color,price);
				products.add(product);
			}
				return products;
			
		}catch(SQLException e) {
			e.printStackTrace();
			return null;
		} 
      }
    	  public int updateProductPriceById(double price , int id){
    		  String updateProductPrice = "Update product set price =? where id=?";
    		  try {
    			  PreparedStatement ps = connection.prepareStatement(updateProductPrice);  
    	    	  ps.setDouble(1,price);
    	    	  ps.setInt(2,id);
    	    	  return ps.executeUpdate();
    			  
    		  }catch(SQLException e) {
    				e.printStackTrace();
    				return 0;
    			} 
    		  
    	  }
      
}

