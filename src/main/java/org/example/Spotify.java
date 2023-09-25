package org.example;

import org.example.enums.MusicStyle;
import org.example.model.*;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Spotify {
    private List<SongAuthor> songAuthors;
    private List<PodcastAuthor> podcastAuthors;

    public Spotify() {
        populateData();
    }

    public Track searchForATrack(String querry) {
        Song foundSong = songAuthors.stream()
                .flatMap(songAuthor -> songAuthor.getAlbums().stream()
                        .flatMap(album -> album.getSongs().stream()
                                .filter(song -> song.getName().equalsIgnoreCase(querry))))
                .findAny()
                .orElse(null);

        Podcast foundPodcast = podcastAuthors.stream()
                .flatMap(podcastAuthor -> podcastAuthor.getPodcasts().stream()
                        .filter(podcast -> podcast.getName().equalsIgnoreCase(querry)))
                .findAny()
                .orElse(null);

        return foundSong != null ? foundSong : foundPodcast;
    }

    public List<String> searchByAuthorName(String querry) {
        List<String> songsName = songAuthors.stream()
                .filter(songAuthor -> songAuthor.getName().equalsIgnoreCase(querry))
                .flatMap(songAuthor -> songAuthor.getAlbums().stream()
                        .flatMap(album -> album.getSongs().stream()))
                .map(Song::getName)
                .toList();

        List<String> podcastsName = podcastAuthors.stream()
                .filter(podcastAuthor -> podcastAuthor.getName().equalsIgnoreCase(querry))
                .flatMap(podcastAuthor -> podcastAuthor.getPodcasts().stream())
                .map(Podcast::getName)
                .toList();

        List<String> result = new ArrayList<>();
        result.addAll(songsName);
        result.addAll(podcastsName);
        return result;
    }

    public List<Track> top3MostListenedTracks() {
        List<Song> songs = songAuthors.stream()
                .flatMap(songAuthor -> songAuthor.getAlbums().stream()
                        .flatMap(album -> album.getSongs().stream()))
                .sorted(Comparator.comparingInt(Song::getNumberOfTimesPlayed)
                        .reversed())
                .limit(3)
                .toList();

        List<Podcast> podcasts = podcastAuthors.stream()
                .flatMap(podcastAuthor -> podcastAuthor.getPodcasts().stream())
                .sorted(Comparator.comparingInt(Podcast::getNumberOfTimesPlayed)
                        .reversed())
                .limit(3)
                .toList();

        List<Track> result = new ArrayList<>();
        result.addAll(songs);
        result.addAll(podcasts);

        return result.stream()
                .sorted(Comparator.comparingInt(Track::getNumberOfTimesPlayed)
                        .reversed())
                .limit(3)
                .toList();
    }

    private void populateData() {
        songAuthors = new ArrayList<>();
        podcastAuthors = new ArrayList<>();

        List<Song> songs = new ArrayList<>();

        int numberOfSongs = 10;
        for (int i = 1; i < numberOfSongs + 1; i++) {
            Song song = new Song("song" + i, 210, 5 + i, "Lyrics" + i);
            songs.add(song);
        }

        Album album1 = new Album("album1", MusicStyle.POP, songs);
        //Album album2 = new Album("album2", MusicStyle.JAZZ, songs);

        List<Album> albums = new ArrayList<>(List.of(album1));

        SongAuthor songAuthor = new SongAuthor("songAuthor1", albums);
        songAuthors.add(songAuthor);

        List<Podcast> podcasts = new ArrayList<>();
        int numberOfPodcasts = 10;
        for (int i = 1; i < numberOfPodcasts + 1; i++) {
            Podcast podcast = new Podcast("podcast" + i, 2100, 3 + i, i + 1);
            podcasts.add(podcast);
        }

        PodcastAuthor podcastAuthor = new PodcastAuthor("podcastAuthor1", podcasts);
        podcastAuthors.add(podcastAuthor);
    }

    public List<SongAuthor> getSongAuthors() {
        return songAuthors;
    }

    public void setSongAuthors(List<SongAuthor> songAuthors) {
        this.songAuthors = songAuthors;
    }

    public List<PodcastAuthor> getPodcastAuthors() {
        return podcastAuthors;
    }

    public void setPodcastAuthors(List<PodcastAuthor> podcastAuthors) {
        this.podcastAuthors = podcastAuthors;
    }

    @Override
    public String toString() {
        return "Spotify{" + "songAuthors=" + songAuthors + ", podcastAuthors=" + podcastAuthors + '}';
    }
}