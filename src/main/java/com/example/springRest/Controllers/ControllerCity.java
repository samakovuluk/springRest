package com.example.springRest.Controllers;

import com.example.springRest.Entities.City;
import com.example.springRest.Services.ServiceCity;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/city")
@Slf4j
@RequiredArgsConstructor
public class ControllerCity {
    @Autowired
    private ServiceCity serviceCity;

    @GetMapping
    public ResponseEntity<List<City>> findAll() {

        return ResponseEntity.ok(serviceCity.findAll());
    }

    @PostMapping
    public ResponseEntity create(@Valid @RequestBody City city) {
        return ResponseEntity.ok(serviceCity.save(city));
    }

    @GetMapping("/{id}")
    public ResponseEntity<City> findById(@PathVariable Integer id) {
        Optional<City> stock = serviceCity.findById(id);
        if (!stock.isPresent()) {
            ResponseEntity.badRequest().build();
        }
        return ResponseEntity.ok(stock.get());
    }

    @PutMapping("/{id}")
    public ResponseEntity<City> update(@PathVariable Integer id, @Valid @RequestBody City city) {
        if (!serviceCity.findById(id).isPresent()) {
            ResponseEntity.badRequest().build();
        }
        return ResponseEntity.ok(serviceCity.update(id,city));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity delete(@PathVariable Integer id) {
        if (!serviceCity.findById(id).isPresent()) {
            ResponseEntity.badRequest().build();
        }
        serviceCity.deleteById(id);
        return ResponseEntity.ok().build();
    }

}
