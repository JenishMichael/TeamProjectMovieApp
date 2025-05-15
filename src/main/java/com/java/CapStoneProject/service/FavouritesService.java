package com.java.CapStoneProject.service;

import com.java.CapStoneProject.domain.Movie;

import java.util.List;

public interface FavouritesService {

    public void addMoviesToFavouriteMovies(Movie movie, String email);
    public List<Movie> getFavouriteMoviesOfUser(String email);
    public void removeMoviesFromFavouriteMovie(String email, String movieId);
}
