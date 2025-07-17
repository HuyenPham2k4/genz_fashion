package com.example.back_end.Service;

import com.example.back_end.Model.ProductVariants;
import com.example.back_end.Repository.ProductVariantsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductVariantsService {

    @Autowired
    private ProductVariantsRepository productVariantsRepository;

    public List<ProductVariants> getAllProductVariants() {
        return productVariantsRepository.findAll();
    }

    public Optional<ProductVariants> getProductVariantById(Long id) {
        return productVariantsRepository.findById(id);
    }

    public ProductVariants createProductVariant(ProductVariants productVariant) {
        return productVariantsRepository.save(productVariant);
    }

    public ProductVariants updateProductVariant(Long id, ProductVariants productVariantDetails) {
        Optional<ProductVariants> productVariantOpt = productVariantsRepository.findById(id);
        if (productVariantOpt.isPresent()) {
            ProductVariants productVariant = productVariantOpt.get();
            productVariant.setProductId(productVariantDetails.getProductId());
            productVariant.setVariantSku(productVariantDetails.getVariantSku());
            productVariant.setVariantBarcode(productVariantDetails.getVariantBarcode());
            productVariant.setSizeId(productVariantDetails.getSizeId());
            productVariant.setColorId(productVariantDetails.getColorId());
            productVariant.setQuantityInStock(productVariantDetails.getQuantityInStock());
            productVariant.setAdditionalPrice(productVariantDetails.getAdditionalPrice());
            productVariant.setWeight(productVariantDetails.getWeight());
            productVariant.setIsActive(productVariantDetails.getIsActive());
            productVariant.setCreatedAt(productVariantDetails.getCreatedAt());
            productVariant.setUpdatedAt(productVariantDetails.getUpdatedAt());
            return productVariantsRepository.save(productVariant);
        } else {
            throw new RuntimeException("ProductVariant not found with id " + id);
        }
    }

    public void deleteProductVariant(Long id) {
        productVariantsRepository.deleteById(id);
    }
}

