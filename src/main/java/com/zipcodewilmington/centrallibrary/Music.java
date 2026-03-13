package com.zipcodewilmington.centrallibrary;

public class Music extends LibraryItem implements Reservable {
    private String artist;
    private String album;
    private String genre;
    private String language;
    private String publicationDate;
    private boolean isReserved;
    private LibraryMember reservedBy;
    
    public Music (String id, String title, String location, String artist, String album, String genre, String language, String publicationDate) {
        super(id, title, location);
        this.artist = artist;
        this.album = album;
        this.genre = genre;
        this.language = language;
        this.publicationDate = publicationDate;
        this.isReserved = false;
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
    public LibraryMember getReservedBy()
    { return reservedBy; }
    @Override
    public double calculateLateFee(int daysLate) {
        return daysLate * 1.00;
    }

    @Override
    public int getMaxBorrowDays() {
        return 7;
    }

    @Override
    public String getItemType() {
        return "Music";
    }

    @Override
    public String[] getSearchableFields() {
        return new String[]{getTitle(), artist, album, genre, publicationDate};
    }
    @Override
    public void reserve(LibraryMember member) {
        if (isReserved) throw new IllegalStateException(getTitle() + " is already reserved.");
        isReserved = true;
        reservedBy = member;
    }

    @Override
    public void cancelReserve(LibraryMember member) {
    isReserved = false;
    reservedBy = null;
    }
    
    @Override
    public boolean isReserved()
    {return isReserved;}
}
