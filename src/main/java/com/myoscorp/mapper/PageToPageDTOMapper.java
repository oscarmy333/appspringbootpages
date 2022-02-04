package com.myoscorp.mapper;

import org.springframework.data.domain.Page;
import org.springframework.stereotype.Component;

import com.myoscorp.modelo.PageDTO;

@Component
public class PageToPageDTOMapper<T> {

	public PageDTO<T> pageToPageDTO(Page<T> page) {
        PageDTO<T> pageDTO = new PageDTO<>();
        pageDTO.setContent(page.getContent());
        pageDTO.setTotalElements(page.getTotalElements());

        return pageDTO;
    }
}
