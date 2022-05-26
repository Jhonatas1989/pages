package com.oliveira.pages.service;

import com.oliveira.pages.dto.PageDTO;
import com.oliveira.pages.exception.PageNotFoundException;
import com.oliveira.pages.model.Page;
import com.oliveira.pages.repository.PageRepository;
import com.oliveira.pages.util.PageMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PageServiceImpl implements PageService {

    private final PageRepository repository;
    private final PageMapper mapper;

    @Autowired
    public PageServiceImpl(PageRepository repository, PageMapper mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

    @Override
    public PageDTO save(PageDTO page) {
        return mapper.convertFromPageToPageDTO(
                repository.save(
                        mapper.convertFromPageDTOToPage(page)
                )
        );
    }

    @Override
    public PageDTO update(PageDTO page) {
        Page pageExisted = repository
                .findById(page.getId())
                .orElseThrow(() -> new PageNotFoundException("page.not.found"));

        repository.delete(pageExisted);

        return mapper.convertFromPageToPageDTO(
                repository.save(
                        mapper.convertFromPageDTOToPage(page)
                )
        );
    }

    @Override
    public List<PageDTO> findAll() {
        List<PageDTO> pages = repository
                .findAll()
                .stream()
                .map(mapper::convertFromPageToPageDTO)
                .collect(Collectors.toList());

        if (pages.isEmpty())
            throw new PageNotFoundException("page.not.found");

        return pages;
    }

    @Override
    public PageDTO findById(String id) {
        Page page = repository
                .findById(id)
                .orElseThrow(() -> new PageNotFoundException("page.not.found"));

        return mapper.convertFromPageToPageDTO(page);
    }

    @Override
    public void delete(String id) {
        Page page = repository
                .findById(id)
                .orElseThrow(() -> new PageNotFoundException("page.not.found"));

        repository.delete(page);
    }
}
