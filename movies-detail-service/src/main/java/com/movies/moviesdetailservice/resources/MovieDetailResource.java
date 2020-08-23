package com.movies.moviesdetailservice.resources;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MovieDetailResource {

    private static Map<String, MovieDetail> MOVIE_DETAILS = new HashMap<>();

    static {
        MOVIE_DETAILS.put("1", new MovieDetail("1", "Silent Hill", 5, "1990", "$40M"));
        MOVIE_DETAILS.put("2", new MovieDetail("2", "Billions", 5, "2020", "$135M"));
        MOVIE_DETAILS.put("3", new MovieDetail("3", "Lost", 4, "2007", "$55M"));
        MOVIE_DETAILS.put("4", new MovieDetail("4", "Game of thrones", 3, "2016", "$150M"));
    }
    
    @RequestMapping("/api/movies/{id}")
    public MovieDetail getMovieDetail(@PathVariable("id") String id) {
        return MOVIE_DETAILS.getOrDefault(id, new MovieDetail());
    }

}