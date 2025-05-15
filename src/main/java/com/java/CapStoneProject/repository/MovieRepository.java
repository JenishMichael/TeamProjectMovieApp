package com.java.CapStoneProject.repository;

import com.java.CapStoneProject.domain.Movie;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface MovieRepository extends MongoRepository<Movie, String> {

}

