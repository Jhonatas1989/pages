package com.oliveira.pages.dto;

import java.util.List;

public class ContentDTO extends ContentBaseDTO {

    private List<TimelineDTO> timeline;
    private LinkDTO timelineFooter;
    private LinkDTO loginFooter;

    public ContentDTO(
            String title,
            String videoUrl,
            StyleDTO style,
            List<TimelineDTO> timeline,
            LinkDTO timelineFooter,
            LinkDTO loginFooter) {
        super(title, videoUrl, style);

        this.timeline = timeline;
        this.timelineFooter = timelineFooter;
        this.loginFooter = loginFooter;
    }

    public ContentDTO() {
    }

    public List<TimelineDTO> getTimeline() {
        return timeline;
    }

    public void setTimeline(List<TimelineDTO> timeline) {
        this.timeline = timeline;
    }

    public LinkDTO getTimelineFooter() {
        return timelineFooter;
    }

    public void setTimelineFooter(LinkDTO timelineFooter) {
        this.timelineFooter = timelineFooter;
    }

    public LinkDTO getLoginFooter() {
        return loginFooter;
    }

    public void setLoginFooter(LinkDTO loginFooter) {
        this.loginFooter = loginFooter;
    }
}
