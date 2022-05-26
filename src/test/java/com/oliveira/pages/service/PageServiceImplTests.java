package com.oliveira.pages.service;

import com.oliveira.pages.dto.PageDTO;
import com.oliveira.pages.exception.PageNotFoundException;
import com.oliveira.pages.model.Page;
import com.oliveira.pages.repository.PageRepository;
import com.oliveira.pages.util.PageMapper;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertThrows;

@SpringBootTest
@ExtendWith(MockitoExtension.class)
public class PageServiceImplTests {

    @Mock
    private PageRepository repository;

    private PageService service;

    @Autowired
    private PageMapper mapper;

    @BeforeEach
    void init() {
        service = new PageServiceImpl(repository, mapper);
    }

    @Test
    public void givenRequest_WhenSavePage_ThenSucceed() {
        Mockito.lenient().when(repository.save(Mockito.any())).thenReturn(new Page());

        PageDTO page = service.save(new PageDTO());

        Assertions.assertThat(page).isNotNull();
    }

    @Test
    public void givenRequest_WhenFindAll_ThenThrowNotFound() {
        Mockito.lenient().when(repository.findAll()).thenReturn(List.of());

        assertThrows(PageNotFoundException.class, () -> service.findAll());
    }

    @Test
    public void givenRequest_WhenFindById_ThenThrowNotFound() {
        Mockito.lenient().when(repository.findById(Mockito.any())).thenReturn(null);

        assertThrows(PageNotFoundException.class, () -> service.findAll());
    }

    @Test
    public void givenRequest_WhenFindById_ThenReturnPage() {
        Page page = new Page("1", null, null, null);

        Mockito.lenient().when(repository.findById(Mockito.any())).thenReturn(Optional.of(page));

        Assertions.assertThat(service.findById(page.getId())).isNotNull();
    }

    @Test
    public void givenRequest_WhenUpdatePage_ThenSucceed() {
        PageDTO pageDTO = new PageDTO("1", null, null, null);
        Page page = mapper.convertFromPageDTOToPage(pageDTO);

        Mockito
                .lenient()
                .when(repository.findById(Mockito.any()))
                .thenReturn(Optional.of(page));

        Mockito.lenient()
                .when(repository.save(Mockito.any()))
                .thenReturn(page);

        PageDTO result = service.update(pageDTO);

        Assertions.assertThat(result).isNotNull();
    }

    @Test
    public void givenRequest_WhenDeletePage_ThenSucceed() {
        Page page = new Page("1", null, null, null);

        Mockito.lenient().when(repository.findById(Mockito.any())).thenReturn(Optional.of(page));

        service.delete("1");
    }
}
