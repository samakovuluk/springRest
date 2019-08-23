package com.example.springRest.Services;

import com.example.springRest.Entities.Region;
import com.example.springRest.Repositories.RepositoryRegion;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ServiceRegion {
    @Autowired
    private RepositoryRegion repositoryRegion;

    public List<Region> findAll() {
        return repositoryRegion.findAll();
    }

    public Optional<Region> findById(Integer id) {
        return repositoryRegion.findById(id);
    }

    public Region save(Region stock) {
        return repositoryRegion.save(stock);
    }

    public Region update(Integer id,Region stock){
        Region real=repositoryRegion.findById(id).get();
        if (stock.getName()!=null)
            real.setName(stock.getName());
        if (stock.getId()!=null)
            real.setId(stock.getId());

        return repositoryRegion.save(real);
    }

    public void deleteById(Integer id) {
        repositoryRegion.deleteById(id);
    }
}
