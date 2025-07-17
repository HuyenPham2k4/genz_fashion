package com.example.back_end.Service;

import com.example.back_end.Model.ProductImages;
import com.example.back_end.Model.Products;
import com.example.back_end.Repository.ProductImagesRepository;
import com.example.back_end.Repository.ProductsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService {

    @Autowired
    private ProductsRepository productsRepository;

    @Autowired
    private ProductImagesRepository productImagesRepository;

    public List<Products> getAllProduct() {
        List<Products> products = productsRepository.findAll();
        for (Products product : products) {
            List<ProductImages> images = productImagesRepository.findByProductId(product.getProductId());
            product.setProductImages(images); // Make sure Products.java has setProductImages(List<ProductImages>) and a field for images
        }
        return products;
    }

    public Optional<Products> getProductById(Long id) {
        Optional<Products> productOpt = productsRepository.findById(id);
        productOpt.ifPresent(product -> {
            List<ProductImages> images = productImagesRepository.findByProductId(product.getProductId());
            product.setProductImages(images);
        });
        return productOpt;
    }

    public Products createProduct(Products product) {
        Products savedProduct = productsRepository.save(product);
        // Optionally handle images here if needed
        return savedProduct;
    }

    public Products updateProduct(Long id, Products productDetails) {
        Optional<Products> productOpt = productsRepository.findById(id);
        if (productOpt.isPresent()) {
            Products product = productOpt.get();
            product.setSku(productDetails.getSku());
            product.setBarcode(productDetails.getBarcode());
            product.setName(productDetails.getName());
            product.setDescription(productDetails.getDescription());
            product.setBasePrice(productDetails.getBasePrice());
            product.setCategoryId(productDetails.getCategoryId());
            product.setBrandId(productDetails.getBrandId());
            product.setIsActive(productDetails.getIsActive());
            product.setCreatedAt(productDetails.getCreatedAt());
            product.setUpdatedAt(productDetails.getUpdatedAt());
            product.setDeletedAt(productDetails.getDeletedAt());
            // Optionally update images here
            return productsRepository.save(product);
        } else {
            throw new RuntimeException("Product not found with id " + id);
        }
    }

    public void deleteProduct(Long id) {
        productsRepository.deleteById(id);
    }
}
