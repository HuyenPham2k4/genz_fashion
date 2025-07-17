package com.example.back_end.Controller;

import com.example.back_end.Model.Colors;
import com.example.back_end.Service.ColorsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("colors")
public class ColorsController {

    @Autowired
    private ColorsService colorsService;

    @GetMapping("/findAll")
    public List<Colors> getAllColors() {
        return colorsService.getAllColors();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Colors> getColorById(@PathVariable Long id) {
        return colorsService.getColorById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping("/create")
    public Colors createColor(@RequestBody Colors color) {
        return colorsService.createColor(color);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<Colors> updateColor(@PathVariable Long id, @RequestBody Colors colorDetails) {
        try {
            Colors updatedColor = colorsService.updateColor(id, colorDetails);
            return ResponseEntity.ok(updatedColor);
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deleteColor(@PathVariable Long id) {
        colorsService.deleteColor(id);
        return ResponseEntity.noContent().build();
    }
}

