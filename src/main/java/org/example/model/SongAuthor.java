package org.example.model;

import java.util.List;

public class SongAuthor extends Author{
    private List<Album>albums;

    public SongAuthor(String name, List<Album> albums) {
        super(name);
        this.albums = albums;
    }

    public List<Album> getAlbums() {
        return albums;
    }

    public void setAlbums(List<Album> albums) {
        this.albums = albums;
    }
}