package com.movies.model;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Movie {

	@JsonProperty("Metascore")
	private String metascore;
	@JsonProperty("BoxOffice")
	private String boxOffice;
	@JsonProperty("Website")
	private String website;
	private String imdbRating;
	private String imdbVotes;
	@JsonProperty("Ratings")
	private List<Rating> ratings;
	@JsonProperty("Runtime")
	private String runtime;
	@JsonProperty("Language")
	private String language;
	@JsonProperty("Rated")
	private String rated;
	@JsonProperty("Production")
	private String production;
	@JsonProperty("Released")
	private String released;
	@JsonProperty("imdbID")
	private String imdbId;
	@JsonProperty("Plot")
	private String plot;
	@JsonProperty("Director")
	private String director;
	@JsonProperty("Title")
	private String title;
	@JsonProperty("Actors")
	private String actors;
	@JsonProperty("Response")
	private String response;
	@JsonProperty("Type")
	private String type;
	@JsonProperty("Awards")
	private String awards;
	@JsonProperty("DVD")
	private String dvd;
	@JsonProperty("Year")
	private String year;
	@JsonProperty("Poster")
	private String poster;
	@JsonProperty("Country")
	private String country;
	@JsonProperty("Genre")
	private String genre;
	@JsonProperty("Writer")
	private String writer;

	public Movie() {
	}

	public Movie(String metascore, String boxOffice, String website, String imdbRating, String imdbVotes,
			List<Rating> ratings, String runtime, String language, String rated, String production, String released,
			String imdbId, String plot, String director, String title, String actors, String response, String type,
			String awards, String dvd, String year, String poster, String country, String genre, String writer) {
		super();
		this.metascore = metascore;
		this.boxOffice = boxOffice;
		this.website = website;
		this.imdbRating = imdbRating;
		this.imdbVotes = imdbVotes;
		this.ratings = ratings;
		this.runtime = runtime;
		this.language = language;
		this.rated = rated;
		this.production = production;
		this.released = released;
		this.imdbId = imdbId;
		this.plot = plot;
		this.director = director;
		this.title = title;
		this.actors = actors;
		this.response = response;
		this.type = type;
		this.awards = awards;
		this.dvd = dvd;
		this.year = year;
		this.poster = poster;
		this.country = country;
		this.genre = genre;
		this.writer = writer;
	}

	public String getMetascore() {
		return metascore;
	}

	public String getBoxOffice() {
		return boxOffice;
	}

	public String getWebsite() {
		return website;
	}

	public String getImdbRating() {
		return imdbRating;
	}

	public String getImdbVotes() {
		return imdbVotes;
	}

	public List<Rating> getRatings() {
		return ratings;
	}

	public String getRuntime() {
		return runtime;
	}

	public String getLanguage() {
		return language;
	}

	public String getRated() {
		return rated;
	}

	public String getProduction() {
		return production;
	}

	public String getReleased() {
		return released;
	}

	public String getImdbId() {
		return imdbId;
	}

	public String getPlot() {
		return plot;
	}

	public String getDirector() {
		return director;
	}

	public String getTitle() {
		return title;
	}

	public String getActors() {
		return actors;
	}

	public String getResponse() {
		return response;
	}

	public String getType() {
		return type;
	}

	public String getAwards() {
		return awards;
	}

	public String getDvd() {
		return dvd;
	}

	public String getYear() {
		return year;
	}

	public String getPoster() {
		return poster;
	}

	public String getCountry() {
		return country;
	}

	public String getGenre() {
		return genre;
	}

	public String getWriter() {
		return writer;
	}

	public void setMetascore(String metascore) {
		this.metascore = metascore;
	}

	public void setBoxOffice(String boxOffice) {
		this.boxOffice = boxOffice;
	}

	public void setWebsite(String website) {
		this.website = website;
	}

	public void setImdbRating(String imdbRating) {
		this.imdbRating = imdbRating;
	}

	public void setImdbVotes(String imdbVotes) {
		this.imdbVotes = imdbVotes;
	}

	public void setRatings(List<Rating> ratings) {
		this.ratings = ratings;
	}

	public void setRuntime(String runtime) {
		this.runtime = runtime;
	}

	public void setLanguage(String language) {
		this.language = language;
	}

	public void setRated(String rated) {
		this.rated = rated;
	}

	public void setProduction(String production) {
		this.production = production;
	}

	public void setReleased(String released) {
		this.released = released;
	}

	public void setImdbId(String imdbId) {
		this.imdbId = imdbId;
	}

	public void setPlot(String plot) {
		this.plot = plot;
	}

	public void setDirector(String director) {
		this.director = director;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public void setActors(String actors) {
		this.actors = actors;
	}

	public void setResponse(String response) {
		this.response = response;
	}

	public void setType(String type) {
		this.type = type;
	}

	public void setAwards(String awards) {
		this.awards = awards;
	}

	public void setDvd(String dvd) {
		this.dvd = dvd;
	}

	public void setYear(String year) {
		this.year = year;
	}

	public void setPoster(String poster) {
		this.poster = poster;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public void setGenre(String genre) {
		this.genre = genre;
	}

	public void setWriter(String writer) {
		this.writer = writer;
	}

}
