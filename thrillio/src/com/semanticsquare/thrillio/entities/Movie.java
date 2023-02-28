package com.semanticsquare.thrillio.entities;

import java.util.Arrays;

import com.semanticsquare.thrillio.constants.MovieGenre;

public class Movie extends Bookmark {
    private int releaseYear;
    private double imdbRating;
    private String[] directors;
    private String[] cast;

    private MovieGenre genre;

    public int getReleaseYear() {
        return releaseYear;
    }

    public void setReleaseYear(int releaseYear) {
        this.releaseYear = releaseYear;
    }

    public double getImdbRating() {
        return imdbRating;
    }

    public void setImdbRating(double imdbRating) {
        this.imdbRating = imdbRating;
    }

    public String[] getDirectors() {
        return directors;
    }

    public void setDirectors(String[] directors) {
        this.directors = directors;
    }

    public String[] getCast() {
        return cast;
    }

    public void setCast(String[] cast) {
        this.cast = cast;
    }

    public MovieGenre getGenre() {
        return genre;
    }

    public void setGenre(MovieGenre genre) {
        this.genre = genre;
    }

    @Override
    public String toString() {
        return "Movie{" +
                "releaseYear=" + releaseYear +
                ", imdbRating=" + imdbRating +
                ", directors=" + Arrays.toString(directors) +
                ", cast=" + Arrays.toString(cast) +
                ", genre='" + genre + '\'' +
                '}';
    }

    @Override
    public boolean isKidFriendlyEligible() {
        if(genre==MovieGenre.HORROR || genre==MovieGenre.THRILLERS) return  false;
        return true;
    }
}