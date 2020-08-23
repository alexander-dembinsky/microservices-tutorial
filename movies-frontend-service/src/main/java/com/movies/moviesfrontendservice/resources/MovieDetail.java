package com.movies.moviesfrontendservice.resources;

public class MovieDetail {

    private String budget;
    private int raiting;
    private String year;

    public MovieDetail() {

    }

    public String getBudget() {
        return this.budget;
    }

    public void setBudget(String budget) {
        this.budget = budget;
    }

    public int getRaiting() {
        return this.raiting;
    }

    public void setRaiting(int raiting) {
        this.raiting = raiting;
    }

    public String getYear() {
        return this.year;
    }

    public void setYear(String year) {
        this.year = year;
    }
    

}