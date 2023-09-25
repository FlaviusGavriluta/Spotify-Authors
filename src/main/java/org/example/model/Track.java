package org.example.model;

public abstract class Track {
    private final int id;
    private int lengthInSeconds, numberOfTimesPlayed;
    private static int count = 0;
    private String name;

    public Track(String name, int lengthInSeconds, int numberOfTimesPlayed) {
        this.id = ++count;
        this.name = name;
        this.lengthInSeconds = lengthInSeconds;
        this.numberOfTimesPlayed = numberOfTimesPlayed;
    }

    public void playTrack(int times) {
        numberOfTimesPlayed += times;
    }

    public int getId() {
        return id;
    }

    public int getLengthInSeconds() {
        return lengthInSeconds;
    }

    public void setLengthInSeconds(int lengthInSeconds) {
        this.lengthInSeconds = lengthInSeconds;
    }

    public int getNumberOfTimesPlayed() {
        return numberOfTimesPlayed;
    }

    public void setNumberOfTimesPlayed(int numberOfTimesPlayed) {
        this.numberOfTimesPlayed = numberOfTimesPlayed;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Track{" +
                "id=" + id +
                ", lengthInSeconds=" + lengthInSeconds +
                ", numberOfTimesPlayed=" + numberOfTimesPlayed +
                ", name='" + name + '\'' +
                '}';
    }
}