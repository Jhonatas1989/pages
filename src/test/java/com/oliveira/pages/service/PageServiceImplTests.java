package com.oliveira.pages.service;

import com.oliveira.pages.exception.PageNotFoundException;
import com.oliveira.pages.model.Page;
import com.oliveira.pages.repository.PageRepository;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertThrows;

@SpringBootTest
@ExtendWith(MockitoExtension.class)
public class PageServiceImplTests {

    @Mock
    PageRepository repository;

    private PageService service;

    @BeforeEach
    void init() {
        service = new PageServiceImpl(repository);
    }

    @Test
    public void givenRequest_WhenSavePage_ThenSucceed() {
        Mockito.lenient().when(repository.findAll()).thenReturn(List.of(new Page()));

        List<Page> page = service.save(List.of(new Page()));

        Assertions.assertThat(page).isNotEmpty();
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
        Page page = new Page("1", null, null, null);

        Mockito.lenient().when(repository.findById(Mockito.any())).thenReturn(Optional.of(page));
        Mockito.lenient().when(repository.findAll()).thenReturn(List.of(page));

        List<Page> pages = service.update(List.of(page));

        Assertions.assertThat(pages).isNotEmpty();
    }

    @Test
    public void givenRequest_WhenDeletePage_ThenSucceed() {
        Page page = new Page("1", null, null, null);

        Mockito.lenient().when(repository.findById(Mockito.any())).thenReturn(Optional.of(page));

        service.delete("1");
    }
}
