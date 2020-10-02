package com.example.flixster.models;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.parceler.Parcel;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Parcel
public class Movie {
    private int movieId;
    private String posterPath;
    private String originalTitle;
    private double voteAverage;
    private String overview;
    private String releaseDate;
    private double rating;

    // empty constructor needed by the Parceler library
    public Movie() {
    }

    public static List<Movie> fromJsonArray(JSONArray jsonArray) throws JSONException {
        List<Movie> movies = new ArrayList<>(jsonArray.length());
        for (int i=0; i<jsonArray.length(); i++) {
            JSONObject movieJson = jsonArray.getJSONObject(i);
            movies.add(fromJson(movieJson));
        }
        return movies;
    }

    public static Movie fromJson(JSONObject jsonObject) throws JSONException {
        Movie movie = new Movie();
        movie.setMovieId(jsonObject.getInt("id"));
        movie.setOriginalTitle(jsonObject.getString("original_title"));
        movie.setPosterPath(jsonObject.getString("poster_path"));
        movie.setVoteAverage(jsonObject.getDouble("vote_average"));
        movie.setOverview(jsonObject.getString("overview"));
        movie.setReleaseDate(jsonObject.getString("release_date"));
        movie.setRating(jsonObject.getDouble("vote_average"));

        return movie;
    }

    public int getMovieId() {
        return movieId;
    }

    public void setMovieId(int movieId) {
        this.movieId = movieId;
    }

    public String getPosterPath() {
        return posterPath;
    }

    public void setPosterPath(String posterPath) {
        this.posterPath = posterPath;
    }

    public String getOriginalTitle() {
        return originalTitle;
    }

    public void setOriginalTitle(String originalTitle) {
        this.originalTitle = originalTitle;
    }

    public double getVoteAverage() {
        return voteAverage;
    }

    public void setVoteAverage(double voteAverage) {
        this.voteAverage = voteAverage;
    }

    public String getOverview() {
        return overview;
    }

    public void setOverview(String overview) {
        this.overview = overview;
    }

    public String getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(String releaseDate) {
        this.releaseDate = releaseDate;
    }

    public String getPosterUrl() {
        return String.format("https://image.tmdb.org/t/p/w342/%s",getPosterPath());
    }

    public double getRating() {
        return rating;
    }

    public void setRating(double rating) {
        this.rating = rating;
    }

    @Override
    public String toString() {
        return "Movie{" +
                "id=" + movieId +
                ", posterPath='" + posterPath + '\'' +
                ", originalTitle='" + originalTitle + '\'' +
                ", voteAverage=" + voteAverage +
                ", overview='" + overview + '\'' +
                ", releaseDate='" + releaseDate + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Movie)) return false;
        Movie movie = (Movie) o;
        return getMovieId() == movie.getMovieId();
    }

    @Override
    public int hashCode() {
        return Objects.hash(getMovieId());
    }
}
