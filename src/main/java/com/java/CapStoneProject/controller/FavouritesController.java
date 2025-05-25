package com.java.CapStoneProject.controller;

import com.java.CapStoneProject.domain.Movie;
import com.java.CapStoneProject.service.FavouritesService;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController

public class FavouritesController {

    @Autowired
    private FavouritesService favouriteService;

    @PostMapping("/{userName}/add")
    public ResponseEntity<String> addMovieToFavourites(@RequestBody Movie movie,
                                                       @PathVariable String userName) {
        favouriteService.addMoviesToFavouriteMovies(movie, userName);
        return ResponseEntity.ok("Movie added to favourites for user: " + userName);
    }


    @GetMapping("/{userName}")
    public ResponseEntity<List<Movie>> getFavouriteMovies(@PathVariable String userName) {
        List<Movie> favouriteMovies = favouriteService.getFavouriteMoviesOfUser(userName);
        return ResponseEntity.ok(favouriteMovies);
    }

    @DeleteMapping("/{userName}/remove/{movieId}")
    public ResponseEntity<String> removeMovieFromFavourites(@PathVariable String userName,
                                                            @PathVariable String movieId) {
        favouriteService.removeMoviesFromFavouriteMovie(userName, movieId);
        return ResponseEntity.ok("Movie removed from favourites for user: " + userName);
    }


//    @PostMapping("/add")
//    public ResponseEntity<String> addMovieToFavourites(@RequestBody Movie movie,
//                                                       HttpServletRequest request) {
//        String userName = (String) request.getAttribute("username");
//        favouriteService.addMoviesToFavouriteMovies(movie, userName);
//        return ResponseEntity.ok("Movie added to favourites for user: " + userName);
//    }
//
//    @GetMapping
//    public ResponseEntity<List<Movie>> getFavouriteMovies(HttpServletRequest request) {
//        String userName = (String) request.getAttribute("username");
//        List<Movie> favouriteMovies = favouriteService.getFavouriteMoviesOfUser(userName);
//        return ResponseEntity.ok(favouriteMovies);
//    }
//
//    @DeleteMapping("/remove/{movieId}")
//    public ResponseEntity<String> removeMovieFromFavourites(@PathVariable String movieId,
//                                                            HttpServletRequest request) {
//        String userName = (String) request.getAttribute("username");
//        favouriteService.removeMoviesFromFavouriteMovie(userName, movieId);
//        return ResponseEntity.ok("Movie removed from favourites for user: " + userName);
//    }
}
