package com.stackroute.movieApp.runner;

import com.stackroute.movieApp.domain.Movie;
import com.stackroute.movieApp.exceptions.MovieAlreadyExistsException;
import com.stackroute.movieApp.service.MovieService;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

@Component
public class SpringContextListener implements ApplicationListener<ContextRefreshedEvent> {
    private MovieService movieService;

    public SpringContextListener(MovieService movieService) {
        this.movieService = movieService;
    }

    @Override
    public void onApplicationEvent(ContextRefreshedEvent event) {
        Movie movie = new Movie("MovieB", 9, "mock overview", "20/11/2018");
        try {
            movieService.saveMovie(movie);
        } catch (MovieAlreadyExistsException e) {
            System.out.println(e.getMessage());
        }
    }
}
