package com.example.springRest;

import com.example.springRest.Entities.City;
import com.example.springRest.Entities.Region;
import com.example.springRest.Services.ServiceCity;
import com.example.springRest.Services.ServiceRegion;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

import javax.annotation.PostConstruct;

@SpringBootApplication
@EnableJpaAuditing
public class SpringRestApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringRestApplication.class, args);
	}

	@Autowired
	ServiceRegion serviceRegion;
	@Autowired
	ServiceCity serviceCity;
	@PostConstruct
	public void after(){
		serviceRegion.save(new Region(1,"Восточно-Казахстанская область"));
		serviceCity.save(new City(1,"Усть-Каменогорск",1));
	}

}
