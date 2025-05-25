package com.java.CapStoneProject.service;

import com.java.CapStoneProject.domain.Movie;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface FavouritesService {

    public void addMoviesToFavouriteMovies(Movie movie, String userName);
    public List<Movie> getFavouriteMoviesOfUser(String userName);
    public void removeMoviesFromFavouriteMovie(String userName, String movieId);
}
