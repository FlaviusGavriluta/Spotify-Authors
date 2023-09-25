package org.example.model;

public class Podcast extends Track{
    private int seasonNumber;

    public Podcast(String name, int lengthInSeconds, int numberOfTimesPlayed, int seasonNumber) {
        super(name, lengthInSeconds, numberOfTimesPlayed);
        this.seasonNumber = seasonNumber;
    }

    public int getSeasonNumber() {
        return seasonNumber;
    }

    public void setSeasonNumber(int seasonNumber) {
        this.seasonNumber = seasonNumber;
    }
}