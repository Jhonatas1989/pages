package com.oliveira.pages.util;

import com.oliveira.pages.dto.PageDTO;
import com.oliveira.pages.model.*;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
@ExtendWith(MockitoExtension.class)
public class PageMapperTests {

    @Autowired
    private PageMapper mapper;

    private Page page;

    @BeforeEach
    void init() {
        page = new Page(
                "1",
                "New Page",
                new Content(
                        "Content Title",
                        "youtube.com",
                        new Style(
                                "#ab3ac9",
                                "20px",
                                "#514f4f",
                                "16px",
                                "#FFC509",
                                "#9b14bf",
                                "#FFFFFF",
                                "#FFC509"
                        ),
                        List.of(
                                new Timeline(
                                        "First Time Line",
                                        1
                                ),
                                new Timeline(
                                        "Second Time Line",
                                        2
                                )
                        ),
                        new Link(
                                "Can I help you? click on",
                                "for help",
                                "/clickon",
                                "here"
                        ),
                        new Link(
                                "Can I solve you problem? hit",
                                "for solution",
                                "/hithere",
                                "here"
                        )
                ),
                new ContentTop(
                        "ContentTop Title",
                        "rumble.com",
                        new Style(
                                "#ab3ac9",
                                "20px",
                                "#514f4f",
                                "16px",
                                "#FFC509",
                                "#9b14bf",
                                "#FFFFFF",
                                "#FFC509"
                        ),
                        "Content Top Description"
                )
        );
    }

    @Test
    public void givenPage_WhenConvert_ThenReturnPageDTO() {
        PageDTO result = mapper.convertFromPageToPageDTO(page);

        Assertions.assertThat(result).isNotNull();
        Assertions.assertThat(result.getId()).isNotNull();
        Assertions.assertThat(result.getName()).isNotNull();

        Assertions.assertThat(result.getContent()).isNotNull();
        Assertions.assertThat(result.getContent().getTitle()).isNotNull();
        Assertions.assertThat(result.getContent().getVideoUrl()).isNotNull();

        Assertions.assertThat(result.getContent().getStyle()).isNotNull();
        Assertions.assertThat(result.getContent().getStyle().getTitleColor()).isNotNull();
        Assertions.assertThat(result.getContent().getStyle().getTitleFontSize()).isNotNull();
        Assertions.assertThat(result.getContent().getStyle().getDescriptionColor()).isNotNull();
        Assertions.assertThat(result.getContent().getStyle().getDescriptionFontSize()).isNotNull();
        Assertions.assertThat(result.getContent().getStyle().getLinkColor()).isNotNull();
        Assertions.assertThat(result.getContent().getStyle().getBackgroundColor()).isNotNull();
        Assertions.assertThat(result.getContent().getStyle().getButtonColor()).isNotNull();
        Assertions.assertThat(result.getContent().getStyle().getButtonBackgroundColor()).isNotNull();

        Assertions.assertThat(result.getContent().getTimeline()).isNotEmpty();
        Assertions.assertThat(result.getContent().getTimeline().get(0).getSequence()).isNotNull();
        Assertions.assertThat(result.getContent().getTimeline().get(0).getText()).isNotNull();

        Assertions.assertThat(result.getContent().getLoginFooter()).isNotNull();
        Assertions.assertThat(result.getContent().getLoginFooter().getLink()).isNotNull();
        Assertions.assertThat(result.getContent().getLoginFooter().getLinkText()).isNotNull();
        Assertions.assertThat(result.getContent().getLoginFooter().getTextAfter()).isNotNull();
        Assertions.assertThat(result.getContent().getLoginFooter().getTextBefore()).isNotNull();

        Assertions.assertThat(result.getContent().getTimelineFooter()).isNotNull();
        Assertions.assertThat(result.getContent().getTimelineFooter().getLink()).isNotNull();
        Assertions.assertThat(result.getContent().getTimelineFooter().getLinkText()).isNotNull();
        Assertions.assertThat(result.getContent().getTimelineFooter().getTextAfter()).isNotNull();
        Assertions.assertThat(result.getContent().getTimelineFooter().getTextBefore()).isNotNull();

        Assertions.assertThat(result.getContentTop()).isNotNull();
        Assertions.assertThat(result.getContentTop().getTitle()).isNotNull();
        Assertions.assertThat(result.getContentTop().getVideoUrl()).isNotNull();
        Assertions.assertThat(result.getContentTop().getDescription()).isNotNull();

        Assertions.assertThat(result.getContentTop().getStyle()).isNotNull();
        Assertions.assertThat(result.getContentTop().getStyle().getTitleColor()).isNotNull();
        Assertions.assertThat(result.getContentTop().getStyle().getTitleFontSize()).isNotNull();
        Assertions.assertThat(result.getContentTop().getStyle().getDescriptionColor()).isNotNull();
        Assertions.assertThat(result.getContentTop().getStyle().getDescriptionFontSize()).isNotNull();
        Assertions.assertThat(result.getContentTop().getStyle().getLinkColor()).isNotNull();
        Assertions.assertThat(result.getContentTop().getStyle().getBackgroundColor()).isNotNull();
        Assertions.assertThat(result.getContentTop().getStyle().getButtonColor()).isNotNull();
        Assertions.assertThat(result.getContentTop().getStyle().getButtonBackgroundColor()).isNotNull();
    }

    @Test
    public void givenPageDTO_WhenConvert_ThenReturnPage() {
        PageDTO pageDTO = mapper.convertFromPageToPageDTO(page);
        Page result = mapper.convertFromPageDTOToPage(pageDTO);

        Assertions.assertThat(result).isNotNull();
        Assertions.assertThat(result.getId()).isNotNull();
        Assertions.assertThat(result.getName()).isNotNull();

        Assertions.assertThat(result.getContent()).isNotNull();
        Assertions.assertThat(result.getContent().getTitle()).isNotNull();
        Assertions.assertThat(result.getContent().getVideoUrl()).isNotNull();

        Assertions.assertThat(result.getContent().getStyle()).isNotNull();
        Assertions.assertThat(result.getContent().getStyle().getTitleColor()).isNotNull();
        Assertions.assertThat(result.getContent().getStyle().getTitleFontSize()).isNotNull();
        Assertions.assertThat(result.getContent().getStyle().getDescriptionColor()).isNotNull();
        Assertions.assertThat(result.getContent().getStyle().getDescriptionFontSize()).isNotNull();
        Assertions.assertThat(result.getContent().getStyle().getLinkColor()).isNotNull();
        Assertions.assertThat(result.getContent().getStyle().getBackgroundColor()).isNotNull();
        Assertions.assertThat(result.getContent().getStyle().getButtonColor()).isNotNull();
        Assertions.assertThat(result.getContent().getStyle().getButtonBackgroundColor()).isNotNull();

        Assertions.assertThat(result.getContent().getTimeline()).isNotEmpty();
        Assertions.assertThat(result.getContent().getTimeline().get(0).getSequence()).isNotNull();
        Assertions.assertThat(result.getContent().getTimeline().get(0).getText()).isNotNull();

        Assertions.assertThat(result.getContent().getLoginFooter()).isNotNull();
        Assertions.assertThat(result.getContent().getLoginFooter().getLink()).isNotNull();
        Assertions.assertThat(result.getContent().getLoginFooter().getLinkText()).isNotNull();
        Assertions.assertThat(result.getContent().getLoginFooter().getTextAfter()).isNotNull();
        Assertions.assertThat(result.getContent().getLoginFooter().getTextBefore()).isNotNull();

        Assertions.assertThat(result.getContent().getTimelineFooter()).isNotNull();
        Assertions.assertThat(result.getContent().getTimelineFooter().getLink()).isNotNull();
        Assertions.assertThat(result.getContent().getTimelineFooter().getLinkText()).isNotNull();
        Assertions.assertThat(result.getContent().getTimelineFooter().getTextAfter()).isNotNull();
        Assertions.assertThat(result.getContent().getTimelineFooter().getTextBefore()).isNotNull();

        Assertions.assertThat(result.getContentTop()).isNotNull();
        Assertions.assertThat(result.getContentTop().getTitle()).isNotNull();
        Assertions.assertThat(result.getContentTop().getVideoUrl()).isNotNull();
        Assertions.assertThat(result.getContentTop().getDescription()).isNotNull();

        Assertions.assertThat(result.getContentTop().getStyle()).isNotNull();
        Assertions.assertThat(result.getContentTop().getStyle().getTitleColor()).isNotNull();
        Assertions.assertThat(result.getContentTop().getStyle().getTitleFontSize()).isNotNull();
        Assertions.assertThat(result.getContentTop().getStyle().getDescriptionColor()).isNotNull();
        Assertions.assertThat(result.getContentTop().getStyle().getDescriptionFontSize()).isNotNull();
        Assertions.assertThat(result.getContentTop().getStyle().getLinkColor()).isNotNull();
        Assertions.assertThat(result.getContentTop().getStyle().getBackgroundColor()).isNotNull();
        Assertions.assertThat(result.getContentTop().getStyle().getButtonColor()).isNotNull();
        Assertions.assertThat(result.getContentTop().getStyle().getButtonBackgroundColor()).isNotNull();
    }
}
