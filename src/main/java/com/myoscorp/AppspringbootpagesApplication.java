package com.myoscorp;

import java.util.Arrays;
import java.util.List;

import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.myoscorp.modelo.Planta;
import com.myoscorp.repositorio.PlantaRepositorio;

@SpringBootApplication
public class AppspringbootpagesApplication {

	public static void main(String[] args) {
		SpringApplication.run(AppspringbootpagesApplication.class, args);
	}

	@Bean
	public ApplicationRunner run(PlantaRepositorio plantRepository) throws Exception {
		return (ApplicationArguments args) -> {
			List<Planta> plants = Arrays.asList(
					new Planta("subalpine fir", "abies lasiocarpa", "pinaceae"),
					new Planta("sour cherry", "prunus cerasus", "rosaceae"),
					new Planta("asian pear", "pyrus pyrifolia", "rosaceae")
			);
			plantRepository.saveAll(plants);
		};

	}
}
