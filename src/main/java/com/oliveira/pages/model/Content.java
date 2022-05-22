package com.oliveira.pages.model;

import java.util.List;

public class Content extends ContentBase {

    private List<Timeline> timeline;
    private Link timelineFooter;
    private Link loginFooter;

    public Content(
            String title,
            String videoUrl,
            Style style,
            List<Timeline> timeline,
            Link timelineFooter,
            Link loginFooter) {
        super(title, videoUrl, style);

        this.timeline = timeline;
        this.timelineFooter = timelineFooter;
        this.loginFooter = loginFooter;
    }

    public List<Timeline> getTimeline() {
        return timeline;
    }

    public void setTimeline(List<Timeline> timeline) {
        this.timeline = timeline;
    }

    public Link getTimelineFooter() {
        return timelineFooter;
    }

    public void setTimelineFooter(Link timelineFooter) {
        this.timelineFooter = timelineFooter;
    }

    public Link getLoginFooter() {
        return loginFooter;
    }

    public void setLoginFooter(Link loginFooter) {
        this.loginFooter = loginFooter;
    }
}
