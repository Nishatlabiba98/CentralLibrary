package com.zipcodewilmington.centrallibrary;

import org.junit.Assert;
import org.junit.Test;

public class MusicTest {

    @Test
    public void testMusicConstructorAndGetters() {
        // given
        String id = "M001";
        String title = "Thriller";
        String location = "M1";
        String artist = "Michael Jackson";
        String album = "Thriller";
        String genre = "Pop";
        String language = "English";
        String publicationDate = "11/30/1982";

        // when
        Music music = new Music(id, title, location, artist, album, genre, language, publicationDate);

        // then
        Assert.assertEquals(artist, music.getArtist());
        Assert.assertEquals(album, music.getAlbum());
        Assert.assertEquals(genre, music.getGenre());
        Assert.assertEquals(language, music.getLanguage());
        Assert.assertEquals(publicationDate, music.getPublicationDate());
    }

    @Test
    public void testMusicLateFee() {
        // given
        Music music = new Music("M001", "Thriller", "M1", "Michael Jackson", "Thriller", "Pop", "English", "11/30/1982");

        // then
        Assert.assertEquals(7.00, music.calculateLateFee(7), 0.001);
    }

    @Test
    public void testMusicMaxBorrowDays() {
        // given
        Music music = new Music("M001", "Thriller", "M1", "Michael Jackson", "Thriller", "Pop", "English", "11/30/1982");

        // then
        Assert.assertEquals(7, music.getMaxBorrowDays());
    }

    @Test
    public void testMusicItemType() {
        // given
        Music music = new Music("M001", "Thriller", "M1", "Michael Jackson", "Thriller", "Pop", "English", "11/30/1982");

        // then
        Assert.assertEquals("Music", music.getItemType());
    }

    @Test
    public void testMusicCheckOutAndCheckIn() {
        // given
        Music music = new Music("M001", "Thriller", "M1", "Michael Jackson", "Thriller", "Pop", "English", "11/30/1982");

        // when
        music.checkOut();

        // then
        Assert.assertFalse(music.isAvailable());

        // when checked back in
        music.checkIn();

        // then
        Assert.assertTrue(music.isAvailable());
    }

    @Test
    public void testMusicSearchableFields() {
        // given
        Music music = new Music("M001", "Thriller", "M1", "Michael Jackson", "Thriller", "Pop", "English", "11/30/1982");

        // then
        Assert.assertTrue(music.matchesKeyword("Michael Jackson"));
        Assert.assertTrue(music.matchesKeyword("Pop"));
        Assert.assertFalse(music.matchesKeyword("Classical"));
    }
}