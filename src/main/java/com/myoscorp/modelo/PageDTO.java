package com.myoscorp.modelo;

import java.util.List;

import org.springframework.data.domain.Page;

import lombok.Data;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PageDTO <T>{

	public PageDTO(Page<T> page) {
		this.content=page.getContent();
		this.totalElements=page.getTotalElements();
	}
	
	private List<T> content;
	
	private long totalElements;
}
