package com.oliveira.pages.service;

import com.oliveira.pages.model.Page;

import java.util.List;

public interface PageService {
    Page save(Page page);

    Page update(Page page);

    List<Page> findAll();

    Page findById(String id);

    void delete(String id);
}
