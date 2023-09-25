package org.example.model;

import java.util.List;

public class PodcastAuthor extends Author{
    private List<Podcast>podcasts;

    public PodcastAuthor(String name, List<Podcast> podcasts) {
        super(name);
        this.podcasts = podcasts;
    }

    public List<Podcast> getPodcasts() {
        return podcasts;
    }

    public void setPodcasts(List<Podcast> podcasts) {
        this.podcasts = podcasts;
    }
}