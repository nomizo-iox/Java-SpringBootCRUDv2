package com.nomizo.service;

import com.nomizo.db.ProductRepository;
import com.nomizo.model.Product;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class ProductService {

    @Autowired
    ProductRepository productRepository;

    /* POST */
    // To save one product
    public Product saveProduct(Product product) { return productRepository.save(product); }

    // To save multiple products
    public List<Product> saveProducts(List<Product> productList) { return productRepository.saveAll(productList); }

    /* GET */
    // Get Product by Id
    public Product getProductById (int id) { return productRepository.findById(id).orElse(null); }

    // Get Product by Name
    public Product getProductByName (String name) { return productRepository.findByName(name); }

    // Get All Products
    public List<Product> getProducts () { return productRepository.findAll(); }

    /* DELETE */
    // Delete Product by Id
    public String deleteProductId (int id) { productRepository.deleteById(id);return "Product removed !!"+id; }

    /* PUT */
    // Update Product by Id
    public Product updateProduct (Product product) {
        Product productChange = productRepository.findById(product.getId()).orElse(null);
        productChange.setName(product.getName());
        productChange.setQuantity(product.getQuantity());
        productChange.setPrice(product.getPrice());
        return productRepository.save(productChange);
    }

}
