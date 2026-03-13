package com.zipcodewilmington.centrallibrary;

public class Periodical extends LibraryItem {
    private String publisher;
    private String issn;
    private String volume;
    private String issueNumber;
    private String publicationDate;
    
    public Periodical(String id, String title, String location, String publisher, String issn, String volume, String issueNumber, String publicationDate) {
        super(id, title, location);
        this.publisher = publisher;
        this.issn = issn;
        this.volume = volume;
        this.issueNumber = issueNumber;
        this.publicationDate = publicationDate;
    }

    public String getPublisher() {return publisher;}
    public String getIssn() {return issn;}
    public String getVolume() {return volume;}
    public String getIssueNumber() {return issueNumber;}
    public String getPublicationDate() {return publicationDate;}

    @Override
    public double calculateLateFee(int daysLate) {
        return daysLate * 0.25;
    }

    @Override
    public int getMaxBorrowDays() {
        return 7;
    }

    @Override
    public String getItemType() {
        return "Periodical";
    }

    
    
    public String[] getSearchableFields() {
        return new String[]{getTitle(), publisher, issn, volume, publicationDate};
    }

    
}
