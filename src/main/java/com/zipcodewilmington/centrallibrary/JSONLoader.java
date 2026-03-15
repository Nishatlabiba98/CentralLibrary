package com.zipcodewilmington.centrallibrary;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

public class JSONLoader {
    private ObjectMapper mapper = new ObjectMapper();

    private JsonNode loadFile(String filename) {
        try {
            InputStream is = getClass().getClassLoader()
                .getResourceAsStream(filename);
            if (is == null) {
                System.out.println("File not found: " + filename);
                return null;
            }
            return mapper.readTree(is);
        } catch (Exception e) {
            System.out.println("Error loading " + filename + ": " + e.getMessage());
            return null;
        }
    }

    public List<Book> loadBooks() {
        List<Book> books = new ArrayList<>();
        JsonNode nodes = loadFile("books.json");
        if (nodes == null) return books;
        for (JsonNode node : nodes) {
            books.add(new Book(
                node.get("id").asText(),
                node.get("title").asText(),
                node.get("location").asText(),
                node.get("author").asText(),
                node.get("isbn").asText(),
                node.get("pages").asInt(),
                node.get("genre").asText(),
                node.get("publicationDate").asText()
            ));
        }
        return books;
    }

    public List<Periodical> loadPeriodicals() {
        List<Periodical> periodicals = new ArrayList<>();
        JsonNode nodes = loadFile("periodicals.json");
        if (nodes == null) return periodicals;
        for (JsonNode node : nodes) {
            periodicals.add(new Periodical(
                node.get("id").asText(),
                node.get("title").asText(),
                node.get("location").asText(),
                node.get("publisher").asText(),
                node.get("issn").asText(),
                node.get("volume").asText(),
                node.get("issueNumber").asText(),
                node.get("publicationDate").asText()
            ));
        }
        return periodicals;
    }

    public List<DVD> loadDVDs() {
        List<DVD> dvds = new ArrayList<>();
        JsonNode nodes = loadFile("dvds.json");
        if (nodes == null) return dvds;
        for (JsonNode node : nodes) {
            dvds.add(new DVD(
                node.get("id").asText(),
                node.get("title").asText(),
                node.get("location").asText(),
                node.get("director").asText(),
                node.get("duration").asText(),
                node.get("rating").asText(),
                node.get("genre").asText()
            ));
        }
        return dvds;
    }

    public List<Music> loadMusic() {
        List<Music> musicList = new ArrayList<>();
        JsonNode nodes = loadFile("music.json");
        if (nodes == null) return musicList;
        for (JsonNode node : nodes) {
            musicList.add(new Music(
                node.get("id").asText(),
                node.get("title").asText(),
                node.get("location").asText(),
                node.get("artist_name").asText(),
                node.get("album_name").asText(),
                node.get("genre").asText(),
                node.get("language").asText(),
                node.get("publicationDate").asText()
            ));
        }
        return musicList;
    }

    public List<Movie> loadMovies() {
        List<Movie> movies = new ArrayList<>();
        JsonNode nodes = loadFile("movies.json");
        if (nodes == null) return movies;
        for (JsonNode node : nodes) {
            movies.add(new Movie(
                node.get("id").asText(),
                node.get("title").asText(),
                node.get("location").asText(),
                node.get("director").asText(),
                node.get("duration").asText(),
                node.get("rating").asText(),
                node.get("genre").asText()
            ));
        }
        return movies;
    }
}