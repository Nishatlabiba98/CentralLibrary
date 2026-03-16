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
    JsonNode nodes = loadFile("books_data.json");
    if (nodes == null) return books;
    int count = 0;
    for (JsonNode node : nodes) {
        if (count >= 1000) break; // limit to 1000 for performance
        books.add(new Book(
            node.get("Text#").asText(),           
            node.get("Title").asText().replace("\r\n", " - "),           
            "General",                             
            node.get("Author(s)").asText(),        
            "N/A",                                 
            0,                                     
            node.get("Subjects").asText(),         
            node.get("Publication Date").asText()  
        ));
        count++;
    }
    return books;
}

    public List<Periodical> loadPeriodicals() {
        List<Periodical> periodicals = new ArrayList<>();
        JsonNode nodes = loadFile("periodicals_merged.json");
        if (nodes == null) return periodicals;
        int count = 0;
        for (JsonNode node : nodes) {
            if (count >= 1000) break;
            periodicals.add(new Periodical(
                node.get("id").asText(),
                node.get("title").asText(),
                "General",
                node.get("publisher").asText(),
                "N/A",
                "N/A",
                getIssueNumber(node),
                getPublicationDate(node)
            ));
            count++;
        }
        return periodicals;
    }

    private String getIssueNumber(JsonNode node) {
        JsonNode issueData = node.get("issue data");
        if (issueData != null && issueData.isArray() && issueData.size() > 0) {
            return issueData.get(0).get("issue_number").asText();
        }
        return "N/A";
    }

    private String getPublicationDate(JsonNode node) {
        JsonNode issueData = node.get("issue data");
        if (issueData != null && issueData.isArray() && issueData.size() > 0) {
            return issueData.get(0).get("date_published").asText();
        }
        return "N/A";
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
        JsonNode nodes = loadFile("music_data.json");
        if (nodes == null) return musicList;
        int count = 0;
        for (JsonNode node : nodes) {
            if (count >= 1000) break;
            musicList.add(new Music(
                node.get("unnamed:_0").asText(),
                node.get("track_name").asText(),
                "General",
                node.get("artist_name").asText(),
                node.get("track_name").asText(),
                node.get("genre").asText(),
                "Unknown",
                node.get("release_date").asText()
            ));
            count++;
        }
        return musicList;
    }

    public List<Movie> loadMovies() {
        List<Movie> movies = new ArrayList<>();
        JsonNode nodes = loadFile("movies_data.json");
        if (nodes == null) return movies;
        int count = 0;
        for (JsonNode node : nodes) {
    //if (count >= 10000) break;

    // skip records with null title
    if (node.get("title") == null || node.get("title").isNull()) {
        continue; // don't increment count, just skip
    }

    // skip records with null runtime
    if (node.get("runtime") == null || node.get("runtime").isNull()) {
        continue;
    }

    // skip records with null crew
    if (node.get("crew") == null || node.get("crew").isNull()) {
        continue;
    }

    movies.add(new Movie(
    node.get("tmdb_id").asText(),
    node.get("title").asText(),
    "General",
    extractDirector(node.get("crew").asText()),
    String.valueOf((int) node.get("runtime").asDouble()),
    String.valueOf(node.get("rating").asBoolean()),
    extractGenre(node.get("genres").asText())
    ));
    count++;
        }
        return movies;
    }
    private String extractGenre(String genresStr) {
    if (genresStr == null || genresStr.isEmpty()) return "Unknown";
    int nameIndex = genresStr.indexOf("'name': '");
    if (nameIndex == -1) return "Unknown";
    int start = nameIndex + 9;
    int end = genresStr.indexOf("'", start);
    return end > start ? genresStr.substring(start, end) : "Unknown";
}

    private String extractDirector(String crewStr) {
        if (crewStr == null || crewStr.isEmpty()) return "Unknown";
        int directorIndex = crewStr.indexOf("'job': 'Director'");
        if (directorIndex == -1) return "Unknown";
        int nameIndex = crewStr.lastIndexOf("'name': '", directorIndex);
        if (nameIndex == -1) return "Unknown";
        int start = nameIndex + 9;
        int end = crewStr.indexOf("'", start);
        return end > start ? crewStr.substring(start, end) : "Unknown";
    }
}