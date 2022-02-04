package com.myoscorp.servicio;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.myoscorp.modelo.PageSettings;
import com.myoscorp.modelo.Planta;
import com.myoscorp.repositorio.PlantaRepositorio;

import lombok.NonNull;

@Transactional
@Service
public class PlantaServicio {

	private PlantaRepositorio plantaRepositorio;
	
	@Autowired
	public PlantaServicio(PlantaRepositorio plantaRepositorio) {
		this.plantaRepositorio= plantaRepositorio;
	}
	
	public Page<Planta> getPlantaPage(@NonNull PageSettings pageSetting){
		Sort plantaSort = pageSetting.buildSort();
		Pageable plantaPage = PageRequest.of(pageSetting.getPage(), pageSetting.getElementPerPage());
		
		return plantaRepositorio.findAll(plantaPage);
	}
}
