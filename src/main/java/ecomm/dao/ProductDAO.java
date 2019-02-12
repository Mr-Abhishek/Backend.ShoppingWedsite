package ecomm.dao;

import java.util.List;

import ecomm.model.Product;

public interface ProductDAO 
{

	public Product getProduct(int productId);
	public boolean addProduct(Product product);
	public boolean deleteProduct(Product product);
	public boolean updateProduct(Product product);
	public List<Product> listProduct();
}
