package com.example.springRest.Services;

import com.example.springRest.Entities.City;
import com.example.springRest.Repositories.RepositoryCity;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ServiceCity {
@Autowired
    private RepositoryCity repositoryCity;

    public List<City> findAll() {
        return repositoryCity.findAll();
    }

    public Optional<City> findById(Integer id) {
        return repositoryCity.findById(id);
    }

    public City save(City stock) {
        return repositoryCity.save(stock);
    }

    public City update(Integer id, City stock){
        City real = repositoryCity.findById(id).get();
        if (stock.getName()!=null)
            real.setName(stock.getName());
        if (stock.getId()!=null)
            real.setId(stock.getId());
        if (stock.getRegionId()!=null)
            real.setRegionId(stock.getRegionId());
        return repositoryCity.save(real);
    }


    public void deleteById(Integer id) {
        repositoryCity.deleteById(id);
    }
}
