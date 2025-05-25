package com.java.CapStoneProject.repository;

import com.java.CapStoneProject.domain.Movie;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

public interface MovieRepository extends MongoRepository<Movie, String> {
    Optional<Movie> findByMovieId(String movieId);

}

