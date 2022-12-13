package com.nicolo;

import java.beans.BeanProperty;
import java.util.ArrayList;
import java.util.List;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.nicolo.dal.*;
import com.nicolo.entities.*;

@SpringBootApplication
public class SpringBabbiNataleApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringBabbiNataleApplication.class, args);
	}

	@Bean
	public CommandLineRunner add(BimbiDAO bDao){
		
		List<Dono> d1 = new ArrayList<>();
		d1.add(new Dono());
		d1.get(0).setDisponibilita(3);
		d1.get(0).setNome("peluche");
		
		return a -> {
		Bimbo b = new Bimbo();
		b.setId(1);
		b.setNome("Niccolo");
		b.setIndirizzo("via Mar Cinese,122");
		b.setDoni(d1);	
		
		bDao.save(b);
		
		};
	}

}
