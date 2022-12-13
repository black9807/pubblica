package com.nicolo;

import java.beans.BeanProperty;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import com.nicolo.dal.*;
import com.nicolo.entities.*;

@SpringBootApplication
public class SpringBabbiNataleApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringBabbiNataleApplication.class, args);
	}

	@Bean
	public static void add(BimbiDAO bDao, DoniDAO dDAO){
		return a->{
		Bimbo b = new Bimbo();
		b.setId(1);
		b.setNome("Niccolo");
		b.setIndirizzo("via Mar Cinese,122");
		b.setDoni() 	
		}
	}

}
