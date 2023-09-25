package org.example.model;

public class Song extends Track{
    private String lyrics;

    public Song(String name, int lengthInSeconds, int numberOfTimesPlayed, String lyrics) {
        super(name, lengthInSeconds, numberOfTimesPlayed);
        this.lyrics = lyrics;
    }

    public String getLyrics() {
        return lyrics;
    }

    public void setLyrics(String lyrics) {
        this.lyrics = lyrics;
    }
}