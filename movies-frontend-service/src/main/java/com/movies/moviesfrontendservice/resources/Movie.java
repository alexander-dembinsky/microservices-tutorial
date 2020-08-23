package com.movies.moviesfrontendservice.resources;

public class Movie {
    private String id;
    private String title;
    private MovieDetail movieDetail;

    public String getId() {
        return this.id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitle() {
        return this.title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public MovieDetail getMovieDetail() {
        return this.movieDetail;
    }

    public void setMovieDetail(MovieDetail movieDetail) {
        this.movieDetail = movieDetail;
    }


}