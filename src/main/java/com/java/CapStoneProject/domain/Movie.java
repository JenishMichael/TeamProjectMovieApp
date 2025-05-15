package com.java.CapStoneProject.domain;

public class Movie {

    private String movieId;
    private String title;
    private String posterUrl;
    private String overview;
    private String releaseDate;
    private double rating;

    public Movie() {
    }

    public Movie(String movieId, String title, String posterUrl, String overview, String releaseDate, double rating) {
        this.movieId = movieId;
        this.title = title;
        this.posterUrl = posterUrl;
        this.overview = overview;
        this.releaseDate = releaseDate;
        this.rating = rating;
    }

    public String getMovieId() {
        return movieId;
    }

    public void setMovieId(String movieId) {
        this.movieId = movieId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getPosterUrl() {
        return posterUrl;
    }

    public void setPosterUrl(String posterUrl) {
        this.posterUrl = posterUrl;
    }

    public String getOverview() {
        return overview;
    }

    public void setOverview(String overview) {
        this.overview = overview;
    }

    public String getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(String releaseDate) {
        this.releaseDate = releaseDate;
    }

    public double getRating() {
        return rating;
    }

    public void setRating(double rating) {
        this.rating = rating;
    }

    @Override
    public String toString() {
        return "Movie{" +
                "movieId='" + movieId + '\'' +
                ", title='" + title + '\'' +
                ", posterUrl='" + posterUrl + '\'' +
                ", overview='" + overview + '\'' +
                ", releaseDate='" + releaseDate + '\'' +
                ", rating=" + rating +
                '}';
    }
}
