package com.example.back_end.Service;

import com.example.back_end.Model.ProductImages;
import com.example.back_end.Repository.ProductImagesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductImagesService {

    @Autowired
    private ProductImagesRepository productImagesRepository;

    public List<ProductImages> getAllProductImages() {
        return productImagesRepository.findAll();
    }

    public Optional<ProductImages> getProductImageById(Long id) {
        return productImagesRepository.findById(id);
    }

    public ProductImages createProductImage(ProductImages productImage) {
        return productImagesRepository.save(productImage);
    }

    public ProductImages updateProductImage(Long id, ProductImages productImageDetails) {
        Optional<ProductImages> productImageOpt = productImagesRepository.findById(id);
        if (productImageOpt.isPresent()) {
            ProductImages productImage = productImageOpt.get();
            productImage.setProductId(productImageDetails.getProductId());
            productImage.setVariantId(productImageDetails.getVariantId());
            productImage.setImageUrl(productImageDetails.getImageUrl());
            productImage.setAltText(productImageDetails.getAltText());
            productImage.setImageType(productImageDetails.getImageType());
            productImage.setDisplayOrder(productImageDetails.getDisplayOrder());
            productImage.setIsActive(productImageDetails.getIsActive());
            productImage.setCreatedAt(productImageDetails.getCreatedAt());
            return productImagesRepository.save(productImage);
        } else {
            throw new RuntimeException("ProductImage not found with id " + id);
        }
    }

    public void deleteProductImage(Long id) {
        productImagesRepository.deleteById(id);
    }
}

