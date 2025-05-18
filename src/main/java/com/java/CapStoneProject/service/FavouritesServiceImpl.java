package com.java.CapStoneProject.service;


import com.java.CapStoneProject.domain.Movie;
import com.java.CapStoneProject.domain.User;
import com.java.CapStoneProject.repository.MovieRepository;
import com.java.CapStoneProject.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class FavouritesServiceImpl implements FavouritesService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private MovieRepository movieRepository;

    @Override
    public void addMoviesToFavouriteMovies(Movie movie, String userName) {
        //1. Check if User Already Exist
        Optional<User> optionalUser = userRepository.findById(userName);
        if(optionalUser.isEmpty()){
            throw new RuntimeException("User Not Found in addMoviesToFavouriteMovies");
        }
        User currentUser = optionalUser.get();

        //2. Get favouriteIds of that particular User
        List<String> favouriteMoviesIdsOfUser = currentUser.getFavoriteMoviesIds();
        if(favouriteMoviesIdsOfUser == null){
            favouriteMoviesIdsOfUser = new ArrayList<>();
        }

        //3. Check if the current movieId is present in the favouriteIds list
        //4. If not add movieId else throw error
        if(favouriteMoviesIdsOfUser.contains(movie.getMovieId())){
           throw new RuntimeException("Movie Id Already Present in addMoviesToFavouriteMovies");

        }
        favouriteMoviesIdsOfUser.add(movie.getMovieId());

        //5. Update the users array of FavouriteMoviesId
        currentUser.setFavoriteMoviesIds(favouriteMoviesIdsOfUser);

        //5. Save user in MySQL
        userRepository.save(currentUser);

        //6. Check if the movie obj is present in MongoDB, if not present add Movie Obj
        Optional<Movie> optionalMovie = movieRepository.findById(movie.getMovieId());
        if(optionalMovie.isEmpty()){
            movieRepository.save(movie);
        }

    }

    @Override
    public List<Movie> getFavouriteMoviesOfUser(String userName) {
        //1. Check if User Already Exist
        Optional<User> optionalUser = userRepository.findById(userName);
        if(optionalUser.isEmpty()){
            throw new RuntimeException("User Not Found in getFavouriteMoviesOfUser");
        }
        User currentUser = optionalUser.get();

        //2. Get favouriteIds of that particular User
        List<String> favouriteMoviesIdsOfUser = currentUser.getFavoriteMoviesIds();

        //3. Check if it is not null
        //4. If not null, using movieRespository layer fetchBymovieId() method in a loop and store it in list and return
        List<Movie> movieList = new ArrayList<>();
        if(favouriteMoviesIdsOfUser != null){
            for (String movieId : favouriteMoviesIdsOfUser) {
                movieRepository.findById(movieId).ifPresent(movieList::add);
            }
        }
    return movieList;
    }

    @Override
    public void removeMoviesFromFavouriteMovie(String userName, String movieId) {
        //1. Check if User Already Exist
        Optional<User> optionalUser = userRepository.findById(userName);
        if(optionalUser.isEmpty()){
            throw new RuntimeException("User Not Found in addMoviesToFavouriteMovies");
        }
        User currentUser = optionalUser.get();

        //2. If Exists, get favouriteIds of that particular User
        List<String> favouriteMoviesIdsOfUser = currentUser.getFavoriteMoviesIds();

        //3. Just remove that id and set the List
        favouriteMoviesIdsOfUser.remove(movieId);
        currentUser.setFavoriteMoviesIds(favouriteMoviesIdsOfUser);

        //4 Save in MySQl
        userRepository.save(currentUser);


    }
}
