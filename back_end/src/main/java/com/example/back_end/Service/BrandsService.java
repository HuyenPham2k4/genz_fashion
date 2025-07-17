package com.example.back_end.Service;

import com.example.back_end.Model.Brands;
import com.example.back_end.Repository.BrandsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BrandsService {

    @Autowired
    private BrandsRepository brandsRepository;

    public List<Brands> getAllBrands() {
        return brandsRepository.findAll();
    }

    public Optional<Brands> getBrandById(Long id) {
        return brandsRepository.findById(id);
    }

    public Brands createBrand(Brands brand) {
        return brandsRepository.save(brand);
    }

    public Brands updateBrand(Long id, Brands brandDetails) {
        Optional<Brands> brandOpt = brandsRepository.findById(id);
        if (brandOpt.isPresent()) {
            Brands brand = brandOpt.get();
            brand.setBrandName(brandDetails.getBrandName());
            brand.setDescription(brandDetails.getDescription());
            brand.setLogoUrl(brandDetails.getLogoUrl());
            brand.setWebsite(brandDetails.getWebsite());
            brand.setContactEmail(brandDetails.getContactEmail());
            brand.setContactPhone(brandDetails.getContactPhone());
            brand.setIsActive(brandDetails.getIsActive());
            brand.setCreatedAt(brandDetails.getCreatedAt());
            brand.setUpdatedAt(brandDetails.getUpdatedAt());
            return brandsRepository.save(brand);
        } else {
            throw new RuntimeException("Brand not found with id " + id);
        }
    }

    public void deleteBrand(Long id) {
        brandsRepository.deleteById(id);
    }
}

