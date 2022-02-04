package com.myoscorp.controlador;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.myoscorp.mapper.PageToPageDTOMapper;
import com.myoscorp.modelo.PageDTO;
import com.myoscorp.modelo.PageSettings;
import com.myoscorp.modelo.Planta;
import com.myoscorp.servicio.PlantaServicio;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequestMapping("/planta")
public class PlantaControlador {
	
	private PlantaServicio plantaServicio;
	
	private PageToPageDTOMapper<Planta> pageToPageDTOMapper;
	
	@Autowired
	public PlantaControlador(PlantaServicio plantaServicio,PageToPageDTOMapper<Planta> pageToPageDTOMapper) {
		this.plantaServicio=plantaServicio;
		this.pageToPageDTOMapper = pageToPageDTOMapper;
	}
	
	@GetMapping("/page")
	public PageDTO<Planta> getPlantaPage(PageSettings pageSettings) {
		
		log.info("Pedido recibido:"+pageSettings);
		return pageToPageDTOMapper.pageToPageDTO(plantaServicio.getPlantaPage(pageSettings));
	}
	
	//Testear http://localhost:9000/planta/page?direction=asc&key=nombre&page=0&elementPerPage=2
}
