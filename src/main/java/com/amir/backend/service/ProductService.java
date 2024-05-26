package com.amir.backend.service;

import java.util.List;

import com.amir.backend.model.CategoryEnum;
import com.amir.backend.model.Product;
import com.amir.backend.model.ProductStatus;
import com.amir.backend.repository.ProductDTO;

public interface ProductService {
    public Product addProductToCatalog(String token, Product product);

	public Product getProductFromCatalogById(Integer id);

	public String deleteProductFromCatalog(Integer id);

	public Product updateProductIncatalog(Product product);
	
	public List<Product> getAllProductsIncatalog();
	
	public List<ProductDTO> getAllProductsOfSeller(Integer id);
	
	public List<ProductDTO> getProductsOfCategory(CategoryEnum catenum);
	
	public List<ProductDTO> getProductsOfStatus(ProductStatus status);
	
	
	
	public Product updateProductQuantityWithId(Integer id,ProductDTO prodDTO);
}