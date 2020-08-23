package com.movies.moviesfrontendservice.services;

import com.movies.moviesfrontendservice.resources.MovieDetail;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class MovieDetailService {

    @Autowired
    RestTemplate restTemplate;

    @HystrixCommand(fallbackMethod = "getMovieDetailFallback",
        commandProperties = {
            @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = "2000"),
            @HystrixProperty(name = "circuitBreaker.requestVolumeThreshold", value = "5"),
            @HystrixProperty(name = "circuitBreaker.errorThresholdPercentage", value = "50"),
            @HystrixProperty(name = "circuitBreaker.sleepWindowInMilliseconds", value = "5000")
    }
    )
    public MovieDetail getMovieDetail(String movieId) {
        return restTemplate.getForObject("http://movies-detail-service/api/movies/" + movieId, MovieDetail.class);
    }

    public MovieDetail getMovieDetailFallback(String movieId) {
        return new MovieDetail();
    }
    
}