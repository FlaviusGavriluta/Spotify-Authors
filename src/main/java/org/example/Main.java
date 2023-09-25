package org.example;

public class Main {
    public static void main(String[] args) {
        Spotify spotify = new Spotify();
        System.out.println("search for a track (song or podcast) by name: " + spotify.searchForATrack("song2"));

        System.out.println("_________________________");

        System.out.println("list songs/podcast names from an author by name: " + spotify.searchByAuthorName("songAuthor1"));

        System.out.println("_________________________");

        System.out.println("find the top 3 most listened to tracks: " + spotify.top3MostListenedTracks());
    }
}