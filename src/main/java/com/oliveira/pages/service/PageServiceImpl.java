package com.oliveira.pages.service;

import com.oliveira.pages.exception.PageNotFoundException;
import com.oliveira.pages.model.Page;
import com.oliveira.pages.repository.PageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PageServiceImpl implements PageService {

    private final PageRepository repository;

    @Autowired
    public PageServiceImpl(PageRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<Page> save(List<Page> pages) {
        pages.forEach(repository::save);

        return findAll();
    }

    @Override
    public List<Page> update(List<Page> pages) {
        pages.forEach(item -> {
            var page = repository.findById(item.getId());

            if (page.isPresent()) {
                repository.delete(page.get());

                repository.save(item);
            }
        });

        return findAll();
    }

    @Override
    public List<Page> findAll() {
        List<Page> pages = repository.findAll();

         if (pages.isEmpty())
            throw new PageNotFoundException("page.not.found");

        return pages;
    }

    @Override
    public Page findById(String id) {
        Optional<Page> pageOptional = repository.findById(id);

        return pageOptional
                .orElseThrow(() -> new PageNotFoundException("page.not.found"));
    }

    @Override
    public void delete(String id) {
        Page page = repository
                .findById(id)
                .orElseThrow(() -> new PageNotFoundException("page.not.found"));

        repository.delete(page);
    }
}
