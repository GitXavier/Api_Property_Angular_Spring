package com.myapp.property.controller;

import com.myapp.property.entity.Property;
import com.myapp.property.service.PropertyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@CrossOrigin
@RequestMapping("/properties")
public class PropertyController {

    @Autowired
    PropertyService propertyService;

    @GetMapping
    public List<Property> getPropertyAll() {
        return propertyService.getPropertyAll();
    }

    @GetMapping("/{id}")
    public Property getPropertyById(@PathVariable Long id) {
        return propertyService.getPropertyById(id);
    }

    @PostMapping
    public Property addProperty(@RequestBody Property property) {
        return propertyService.addProperty(property);
    }

    @PatchMapping("/{id}")
    public Property updateProperty(@PathVariable Long id, @RequestBody Property property) {
        return propertyService.updateProperty(id, property);
    }

    @DeleteMapping("{id}")
    public boolean deleteBook(@PathVariable Long id) {
        return propertyService.deleteProperty(id);
    }
}
