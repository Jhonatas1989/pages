package com.oliveira.pages.service;

import com.oliveira.pages.dto.PageDTO;
import com.oliveira.pages.model.Page;

import java.util.List;

public interface PageService {
    PageDTO save(PageDTO page);

    PageDTO update(PageDTO page);

    List<PageDTO> findAll();

    PageDTO findById(String id);

    void delete(String id);
}
