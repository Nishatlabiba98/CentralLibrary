package com.zipcodewilmington.centrallibrary;

public class Music extends LibraryItem {
    private String artist;
    private String album;
    private String genre;
    private String language;
    private String publicationDate;
    
    public Music (String id, String title, String location, String artist, String album, String genre, String language, String publicationDate) {
        super(id, title, location);
        this.artist = artist;
        this.album = album;
        this.genre = genre;
        this.language = language;
        this.publicationDate = publicationDate;
    }

    public String getArtist() {
        return artist;
    }
    public String getAlbum() {
        return album;
    }
    public String getGenre() {
        return genre;
    }
    public String getLanguage() {
        return language;
    }
    public String getPublicationDate() {
        return publicationDate;
    }

    public double calculateLateFee(int daysLate) {
        return daysLate * 1.00;
    }

    
    public int getMaxBorrowDays() {
        return 7;
    }

    
    public String getItemType() {
        return "Music";
    }

    @Override
    public String[] getSearchableFields() {
        return new String[]{getTitle(), artist, album, genre, publicationDate};
    }
}
