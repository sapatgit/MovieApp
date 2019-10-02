package com.stackroute.movieApp.controller;

import com.stackroute.movieApp.domain.Movie;
import com.stackroute.movieApp.errors.Errors;
import com.stackroute.movieApp.service.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value="api/v1")
public class MovieController {
    private MovieService movieService;

    @Autowired
    public MovieController(MovieService movieService) {
        this.movieService = movieService;
    }

    @PostMapping("/movie")
    public ResponseEntity<?> addMovie(@RequestBody Movie movie) {
        ResponseEntity responseEntity;
        try {
            responseEntity = new ResponseEntity<Movie> (movieService.saveMovie(movie), HttpStatus.CREATED);
        } catch (Exception e) {
            Errors errors = new Errors(HttpStatus.CONFLICT, e.getMessage());
            responseEntity = new ResponseEntity<Errors> (errors, HttpStatus.CONFLICT);
        }
        return responseEntity;
    }

    @DeleteMapping("/movie/{id}")
    public ResponseEntity<?> deleteMovie(@PathVariable("id") int id) {
        ResponseEntity responseEntity;
        try {
            responseEntity = new ResponseEntity<Movie> (movieService.deleteMovie(id), HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            Errors errors = new Errors(HttpStatus.NOT_FOUND, e.getMessage());
            responseEntity = new ResponseEntity<Errors> (errors, HttpStatus.NOT_FOUND);
        }
        return responseEntity;
    }

    @GetMapping("/movies")
    public ResponseEntity<?> getMovies() {
        ResponseEntity responseEntity;
        responseEntity = new ResponseEntity<List<Movie>> (movieService.getMovies(), HttpStatus.OK);
        return responseEntity;
    }

    @GetMapping("/movie/{id}")
    public ResponseEntity<?> getMovie(@PathVariable int id) {
        ResponseEntity responseEntity;
        try{
            responseEntity = new ResponseEntity<Movie> (movieService.getMovie(id), HttpStatus.OK);
        } catch (Exception e) {
            Errors errors = new Errors(HttpStatus.NOT_FOUND, e.getMessage());
            responseEntity = new ResponseEntity<Errors> (errors, HttpStatus.NOT_FOUND);
        }
        return responseEntity;
    }

    @PutMapping("/movie")
    public ResponseEntity<?> updateMovie(@RequestBody Movie movie) {
        ResponseEntity responseEntity;
        try{
            responseEntity = new ResponseEntity<Movie> (movieService.updateMovie(movie), HttpStatus.OK);
        } catch (Exception e) {
            Errors errors = new Errors(HttpStatus.NOT_FOUND, e.getMessage());
            responseEntity = new ResponseEntity<Errors> (errors, HttpStatus.NOT_FOUND);
        }
        return responseEntity;
    }
}
