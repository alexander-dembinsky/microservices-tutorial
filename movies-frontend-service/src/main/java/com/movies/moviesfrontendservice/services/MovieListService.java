package com.movies.moviesfrontendservice.services;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import com.movies.moviesfrontendservice.resources.Movie;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class MovieListService {

    @Autowired
    RestTemplate restTemplate;
    
    @HystrixCommand(fallbackMethod = "getMovieListFallback",
        commandProperties = {
            @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = "2000"),
            @HystrixProperty(name = "circuitBreaker.requestVolumeThreshold", value = "5"),
            @HystrixProperty(name = "circuitBreaker.errorThresholdPercentage", value = "50"),
            @HystrixProperty(name = "circuitBreaker.sleepWindowInMilliseconds", value = "5000")
        }
    )
    public List<Movie> getMovieList() {
        ResponseEntity<Movie[]> movies = restTemplate.getForEntity("http://movies-list-service/api/movies", Movie[].class);
        return Arrays.asList(movies.getBody());
    }

    public List<Movie> getMovieListFallback() {
        return Collections.emptyList();
    }

}