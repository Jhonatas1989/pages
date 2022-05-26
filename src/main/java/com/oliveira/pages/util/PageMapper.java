package com.oliveira.pages.util;

import com.oliveira.pages.dto.PageDTO;
import com.oliveira.pages.model.Page;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class PageMapper {

    private final ModelMapper modelMapper;

    @Autowired
    public PageMapper(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
    }

    public Page convertFromPageDTOToPage(PageDTO product) {
        return modelMapper.map(product, Page.class);
    }

    public PageDTO convertFromPageToPageDTO(Page product) {
        return modelMapper.map(product, PageDTO.class);
    }
}
