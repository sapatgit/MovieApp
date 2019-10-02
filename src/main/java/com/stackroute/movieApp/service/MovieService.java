package com.stackroute.movieApp.service;

import com.stackroute.movieApp.domain.Movie;

import java.util.List;

public interface MovieService {
    public Movie saveMovie(Movie movie);
    public Movie updateMovie(Movie movie);
    public Movie deleteMovie(int id);
    public Movie getMovie(int id);
    public List<Movie> getMovies();
}
