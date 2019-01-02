package com.domain.movies;

import java.util.UUID;

import com.datastax.driver.mapping.annotations.Column;
import com.datastax.driver.mapping.annotations.PartitionKey;
import com.datastax.driver.mapping.annotations.Table;

@Table(name = "movies")
public class Movie {

	@Override
	public String toString() {
		return "Movie [movie_Id=" + movie_id + ", release_year=" + release_year + ", title=" + title + "]";
	}

	@PartitionKey
	@Column(name = "movie_id")
	private UUID movie_id;
	@Column(name = "release_year")
	private int release_year;
	@Column(name = "title")
	private String title;
	
	// Don't forget to add default constructor, without default constructor call to get will fail !!!! 
	public Movie() {}

	public Movie(UUID movie_Id, int release_year, String title) {
		this.movie_id = movie_Id;
		this.release_year = release_year;
		this.title = title;
	}

	public UUID getMovie_Id() {
		return movie_id;
	}

	public void setMovie_Id(UUID movie_Id) {
		this.movie_id = movie_Id;
	}

	public int getRelease_year() {
		return release_year;
	}

	public void setRelease_year(int release_year) {
		this.release_year = release_year;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

}
