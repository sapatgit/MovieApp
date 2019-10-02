package com.stackroute.movieApp.domain;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.*;

@Entity
public class Movie {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="id")
    private int id;
    @Column(name="title")
    private String title;
    @JsonProperty(value = "vote_average")
    private float voteAverage;
    @Column(name = "overview")
    private String overview;

    public Movie() {
    }

    public Movie(int id, String title, float voteAverage, String overview, String release_date) {
        this.id = id;
        this.title = title;
        this.voteAverage = voteAverage;
        this.overview = overview;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public float getVoteAverage() {
        return voteAverage;
    }

    public void setVoteAverage(float voteAverage) {
        this.voteAverage = voteAverage;
    }

    public String getOverview() {
        return overview;
    }

    public void setOverview(String overview) {
        this.overview = overview;
    }

    @Override
    public String toString() {
        return "Movie{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", vote_average=" + voteAverage +
                ", overview='" + overview + '\'' +
                '}';
    }
}
