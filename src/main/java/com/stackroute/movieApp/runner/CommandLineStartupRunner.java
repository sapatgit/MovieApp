package com.stackroute.movieApp.runner;

import com.stackroute.movieApp.domain.Movie;
import com.stackroute.movieApp.service.MovieService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class CommandLineStartupRunner implements CommandLineRunner {
    private MovieService movieService;

    public CommandLineStartupRunner(MovieService movieService) {
        this.movieService = movieService;
    }

    @Override
    public void run(String... args) throws Exception {
        Movie movie = new Movie("MovieA", 8, "mock overview", "22/11/2018");
        movieService.saveMovie(movie);
    }
}
