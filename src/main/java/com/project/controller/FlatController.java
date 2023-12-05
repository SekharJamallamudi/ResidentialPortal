package com.project.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.project.entity.Flat;
import com.project.service.FlatService;

@RestController
@RequestMapping("/flats")
public class FlatController {
    @Autowired
    private FlatService flatService;

    @GetMapping("/all")
    public ResponseEntity<List<Flat>> getAllFlats() {
        List<Flat> flats = flatService.getAllFlats();
        return ResponseEntity.ok(flats);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Flat> getFlatById(@PathVariable Long id) {
        Flat flat = flatService.getFlatById(id);
        if (flat != null) {
            return ResponseEntity.ok(flat);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping("/add")
    public ResponseEntity<Flat> addFlat(@RequestBody Flat flat) {
        Flat savedFlat = flatService.addFlat(flat);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedFlat);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<Flat> updateFlat(@PathVariable Long id, @RequestBody Flat updatedFlat) {
        Flat flat = flatService.getFlatById(id);
        if (flat != null) {
            updatedFlat.setId(id); // Ensure ID consistency
            Flat savedFlat = flatService.updateFlat(updatedFlat);
            return ResponseEntity.ok(savedFlat);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/delete/{id}")
    public void deleteFlat(@PathVariable Long id) {
        flatService.deleteFlat(id);
    }
    @PutMapping("/update-date/{id}")
    public void updateDate(@PathVariable Long id, @RequestBody String newDate) {
        flatService.updateDateColumn(id, newDate);
    }
}