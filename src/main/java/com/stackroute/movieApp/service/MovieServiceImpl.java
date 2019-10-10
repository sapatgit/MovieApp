package com.stackroute.movieApp.service;

import com.stackroute.movieApp.domain.Movie;
import com.stackroute.movieApp.repository.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MovieServiceImpl implements MovieService {
    private MovieRepository movieRepository;

    @Autowired
    public MovieServiceImpl(MovieRepository movieRepository) {
        this.movieRepository = movieRepository;
    }

    @Override
    public Movie saveMovie(Movie movie) {
        movieRepository.save(movie);
        return movie;
    }

    @Override
    public Movie updateMovie(Movie movie) {
        Movie toUpdate = movieRepository.findById(movie.getId()).get();
        if(movie.getTitle()!=null)
            toUpdate.setTitle(movie.getTitle());
        if(movie.getOverview()!=null)
            toUpdate.setOverview(movie.getOverview());
        if(movie.getVoteAverage()!= 0)
            toUpdate.setVoteAverage(movie.getVoteAverage());
        movieRepository.save(toUpdate);
        return toUpdate;
    }

    @Override
    public Movie deleteMovie(int id) {
        Movie movie = getMovie(id);
        movieRepository.deleteById(id);
        return movie;
    }

    @Override
    public List<Movie> getMovies() {
        return movieRepository.findAll();
    }

    @Override
    public Movie getMovie(int id) {
        Movie movie = movieRepository.findById(id).get();
        return movie;
    }
}
