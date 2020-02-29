package com.nomizo.controller;


import com.nomizo.model.Product;
import com.nomizo.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ProductController {

    @Autowired
    ProductService productService;

    /* POST METHOD */
    @PostMapping("/addProduct")
    public Product addProduct (@RequestBody Product product) { return productService.saveProduct(product); }

    @PostMapping("/addProducts")
    public List<Product> addProducts(@RequestBody List<Product> productList) { return productService.saveProducts(productList); }

    /* GET METHOD */
    @GetMapping("/getProducts")
    public List<Product> findAllProducts() {return productService.getProducts(); }

    @GetMapping("/product/{id}")
    public Product findProductById (@PathVariable int id) { return productService.getProductById(id); }

    @GetMapping("/product/{name}")
    public Product findProductByName (@PathVariable String name) { return productService.getProductByName(name); }

    /* PUT METHOD */
    @PutMapping("/update")
    public Product updateProduct(@RequestBody Product product) {return productService.updateProduct(product); }

    /* DELETE METHOD */
    @DeleteMapping("/delete/{id}")
    public String deleteProduct(@PathVariable int id) { return productService.deleteProductId(id); }
}
