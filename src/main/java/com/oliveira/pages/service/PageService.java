package com.oliveira.pages.service;

import com.oliveira.pages.model.Page;

import java.util.List;

public interface PageService {
    List<Page> save(List<Page> pages);

    List<Page> update(List<Page> pages);

    List<Page> findAll();

    Page findById(String id);

    void delete(String id);
}
