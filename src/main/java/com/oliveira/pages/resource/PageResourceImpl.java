package com.oliveira.pages.resource;

import com.oliveira.pages.dto.PageDTO;
import com.oliveira.pages.service.PageService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/v1/")
public class PageResourceImpl implements PageResource {

    private static final Logger logger = LogManager.getLogger(PageResourceImpl.class);

    private final PageService service;

    @Autowired
    public PageResourceImpl(PageService service) {
        this.service = service;
    }

    @GetMapping("/pages")
    @Override
    public List<PageDTO> findAll() {
        logger.info("Find all pages");

        return service.findAll();
    }

    @GetMapping("/pages/{id}")
    @Override
    public PageDTO findById(@PathVariable("id") String id) {
        logger.info("Find page by id: " + id);

        return service.findById(id);
    }

    @PostMapping("/pages")
    @Override
    public PageDTO save(@Valid @RequestBody PageDTO page) {
        logger.info("Save page");

        return service.save(page);
    }

    @PutMapping("/pages")
    @Override
    public PageDTO update(@Valid @RequestBody PageDTO page) {
        logger.info("Update page");

        return service.update(page);
    }

    @DeleteMapping("/pages/{id}")
    @Override
    public ResponseEntity<String> delete(@PathVariable("id") String id) {
        logger.info("Delete page with id: " + id);

        service.delete(id);

        return new ResponseEntity<String>("Page was deleted successfully", HttpStatus.OK);
    }
}
