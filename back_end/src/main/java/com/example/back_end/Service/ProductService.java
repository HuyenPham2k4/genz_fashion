package com.example.back_end.Service;

import com.example.back_end.Model.ProductImages;
import com.example.back_end.Model.Products;
import com.example.back_end.Repository.ProductImagesRepository;
import com.example.back_end.Repository.ProductsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

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
}
