package org.example.model;

import org.example.enums.MusicStyle;

import java.util.List;

public class Album {
    private String name;
    private MusicStyle musicStyle;
    private List<Song>songs;

    public Album(String name, MusicStyle musicStyle, List<Song> songs) {
        this.name = name;
        this.musicStyle = musicStyle;
        this.songs = songs;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public MusicStyle getMusicStyle() {
        return musicStyle;
    }

    public void setMusicStyle(MusicStyle musicStyle) {
        this.musicStyle = musicStyle;
    }

    public List<Song> getSongs() {
        return songs;
    }

    public void setSongs(List<Song> songs) {
        this.songs = songs;
    }
}