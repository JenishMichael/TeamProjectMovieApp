package com.java.CapStoneProject.controller;

import com.java.CapStoneProject.domain.Movie;
import com.java.CapStoneProject.service.FavouritesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/favourites")
public class FavouritesController {

    @Autowired
    private FavouritesService favouriteService;

    @PostMapping("/{email}/add")
    public ResponseEntity<String> addMovieToFavourites(@RequestBody Movie movie,
                                                       @PathVariable String email) {
        favouriteService.addMoviesToFavouriteMovies(movie, email);
        return ResponseEntity.ok("Movie added to favourites for : " + email);
    }

    @GetMapping("/{email}")
    public ResponseEntity<List<Movie>> getFavouriteMovies(@PathVariable String email) {
        List<Movie> favouriteMovies = favouriteService.getFavouriteMoviesOfUser(email);
        return ResponseEntity.ok(favouriteMovies);
    }

    @DeleteMapping("/{email}/remove/{movieId}")
    public ResponseEntity<String> removeMovieFromFavourites(@PathVariable String email,
                                                            @PathVariable String movieId) {
        favouriteService.removeMoviesFromFavouriteMovie(email, movieId);
        return ResponseEntity.ok("Movie removed from favourites for : " + email);
    }
}
