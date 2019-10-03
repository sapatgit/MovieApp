package com.stackroute.movieApp.runner;

import com.stackroute.movieApp.domain.Movie;
import com.stackroute.movieApp.service.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class CommandLineStartupRunner implements CommandLineRunner {
    private MovieService movieService;

    @Autowired
    public CommandLineStartupRunner(MovieService movieService) {
        this.movieService = movieService;
    }
    @Override
    public void run(String...args) throws Exception {
        Movie movie = new Movie("MovieB",  8, "random overview", "02/12/2019");
        movieService.saveMovie(movie);
    }
}
