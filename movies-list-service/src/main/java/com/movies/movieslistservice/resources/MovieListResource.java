package com.movies.movieslistservice.resources;

import java.util.Arrays;
import java.util.List;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MovieListResource {

    @RequestMapping("/api/movies")
    public List<Movie> getMovies() {
        return Arrays.asList(
            new Movie("1", "Silent Hill"),
            new Movie("2", "Billions"),
            new Movie("3", "Lost"),
            new Movie("4", "Game of thrones")
        );
    }
    
}