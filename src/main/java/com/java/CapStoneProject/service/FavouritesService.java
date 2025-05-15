package com.java.CapStoneProject.service;

import com.java.CapStoneProject.domain.Movie;

import java.util.List;

public interface FavouritesService {

    public void addMoviesToFavouriteMovies(Movie movie, String userName);
    public List<Movie> getFavouriteMoviesOfUser(String userName);
    public void removeMoviesFromFavouriteMovie(String userName, String movieId);
}
