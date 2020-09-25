package com.example.flixster.models;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Movie {
    private int id;
    private String posterPath;
    private String originalTitle;
    private double voteAverage;
    private String overview;
    private String releaseDate;

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
        movie.setId(jsonObject.getInt("id"));
        movie.setOriginalTitle(jsonObject.getString("original_title"));
        movie.setPosterPath(jsonObject.getString("poster_path"));
        movie.setVoteAverage(jsonObject.getDouble("vote_average"));
        movie.setOverview(jsonObject.getString("overview"));
        movie.setReleaseDate(jsonObject.getString("release_date"));
        return movie;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    @Override
    public String toString() {
        return "Movie{" +
                "id=" + id +
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
        return getId() == movie.getId();
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId());
    }
}
