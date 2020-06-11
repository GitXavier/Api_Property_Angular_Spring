package com.myapp.property.service;

import com.myapp.property.entity.Property;
import com.myapp.property.repository.PropertyRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@Service
public class PropertyService {

    @Autowired
    PropertyRepository propertyRepository;

    @Autowired
    protected ModelMapper modelMapper;

    public List<Property> getPropertyAll() { return this.propertyRepository.findAll(); }

    public Property getPropertyById( Long id ) { return this.propertyRepository.findById(id).get(); }

    public Property addProperty( Property property) { return this.propertyRepository.save(property); }

    public Property updateProperty( Long id, Property newProperty) {

        if (newProperty.getId() != id) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Inconsistent parameter");
        }

        Optional<Property> property = this.propertyRepository.findById(newProperty.getId());
        Property updateProperty = property.get();

        this.modelMapper.map(newProperty, updateProperty);

        return propertyRepository.save(updateProperty);
    }

    public boolean deleteProperty( Long id ) {

        propertyRepository.deleteById(id);
        return true;
    }
}
