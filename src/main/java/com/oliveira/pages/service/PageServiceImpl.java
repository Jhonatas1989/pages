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
    public Page save(Page page) {
        return repository.save(page);
    }

    @Override
    public Page update(Page page) {
        var pageOptional = repository.findById(page.getId());

        if (pageOptional.isEmpty())
            throw new PageNotFoundException("page.not.found");

        repository.delete(pageOptional.get());

        return repository.save(page);
    }

    @Override
    public List<Page> findAll() {
        List<Page> page = repository.findAll();

         if (page.isEmpty())
            throw new PageNotFoundException("page.not.found");

        return page;
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
