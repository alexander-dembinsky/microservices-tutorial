package com.movies.moviesdetailservice.resources;

public class MovieDetail {

    private String id;
    private String title;
    private int raiting;
    private String year;
    private String budget;

    public MovieDetail() {

    }

    public MovieDetail(String id, String title, int raiting, String year, String budget) {
        this.id = id;
        this.title = title;
        this.raiting = raiting;
        this.year = year;
        this.budget = budget;
    }


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

	public String getBudget() {
		return this.budget;
	}

	public void setBudget(String budget) {
		this.budget = budget;
	}


    
}