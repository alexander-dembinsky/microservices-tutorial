package com.movies.moviesfrontendservice.resources;

import java.util.List;

import com.movies.moviesfrontendservice.services.MovieDetailService;
import com.movies.moviesfrontendservice.services.MovieListService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MoviesResource {

    @Autowired
    MovieListService movieListService;

    @Autowired
    MovieDetailService movieDetailService;

    @RequestMapping(value = "/api/movies", produces = "application/json")
    public List<Movie> getMovies() {
        List<Movie> movieList = movieListService.getMovieList();

        for (Movie movie : movieList) {
            MovieDetail detail = movieDetailService.getMovieDetail(movie.getId());
            movie.setMovieDetail(detail);
        }

        return movieList;
    }
    
}