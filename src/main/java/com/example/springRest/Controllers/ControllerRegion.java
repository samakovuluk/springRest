package com.example.springRest.Controllers;

import com.example.springRest.Entities.Region;
import com.example.springRest.Services.ServiceRegion;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/region")
@Slf4j
@RequiredArgsConstructor
public class ControllerRegion {
    @Autowired
    private ServiceRegion serviceRegion;

    @GetMapping
    public ResponseEntity<List<Region>> findAll() {
        return ResponseEntity.ok(serviceRegion.findAll());
    }

    @PostMapping
    public ResponseEntity create(@Valid @RequestBody Region region) {
        return ResponseEntity.ok(serviceRegion.save(region));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Region> findById(@PathVariable Integer id) {
        Optional<Region> stock = serviceRegion.findById(id);
        if (!stock.isPresent()) {
            ResponseEntity.badRequest().build();
        }
        return ResponseEntity.ok(stock.get());
    }

    @PutMapping("/{id}")
    public ResponseEntity<Region> update(@PathVariable Integer id, @Valid @RequestBody Region region) {
        if (!serviceRegion.findById(id).isPresent()) {

            ResponseEntity.badRequest().build();
        }
        return ResponseEntity.ok(serviceRegion.update(id,region));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity delete(@PathVariable Integer id) {
        if (!serviceRegion.findById(id).isPresent()) {

            ResponseEntity.badRequest().build();
        }
        serviceRegion.deleteById(id);
        return ResponseEntity.ok().build();
    }

}
