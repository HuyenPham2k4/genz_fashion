package com.example.back_end.Service;

import com.example.back_end.Model.Colors;
import com.example.back_end.Repository.ColorsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ColorsService {

    @Autowired
    private ColorsRepository colorsRepository;

    public List<Colors> getAllColors() {
        return colorsRepository.findAll();
    }

    public Optional<Colors> getColorById(Long id) {
        return colorsRepository.findById(id);
    }

    public Colors createColor(Colors color) {
        return colorsRepository.save(color);
    }

    public Colors updateColor(Long id, Colors colorDetails) {
        Optional<Colors> colorOpt = colorsRepository.findById(id);
        if (colorOpt.isPresent()) {
            Colors color = colorOpt.get();
            color.setColorName(colorDetails.getColorName());
            color.setColorCode(colorDetails.getColorCode());
            color.setIsActive(colorDetails.getIsActive());
            color.setCreatedAt(colorDetails.getCreatedAt());
            return colorsRepository.save(color);
        } else {
            throw new RuntimeException("Color not found with id " + id);
        }
    }

    public void deleteColor(Long id) {
        colorsRepository.deleteById(id);
    }
}

