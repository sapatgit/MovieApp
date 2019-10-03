package com.stackroute.movieApp.runner;

import com.stackroute.movieApp.controller.MovieController;
import com.stackroute.movieApp.domain.Movie;
import com.stackroute.movieApp.exceptions.MovieAlreadyExistsException;
import com.stackroute.movieApp.service.MovieService;
import com.stackroute.movieApp.service.MovieServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

@Component
public class ApplicationListenerConfig {
    private MovieService movieService;

    @Autowired
    public ApplicationListenerConfig(MovieService movieService) {
        this.movieService = movieService;
    }

    @EventListener
    public void handleContextRefresh(ContextRefreshedEvent event) throws MovieAlreadyExistsException {
        Movie movie = new Movie("MovieA",  7.8, "random overview", "20/11/2019");
        movieService.saveMovie(movie);
    }
}
