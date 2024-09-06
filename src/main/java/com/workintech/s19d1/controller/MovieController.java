package com.workintech.s19d1.controller;

import com.workintech.s19d1.entity.Actor;
import com.workintech.s19d1.entity.Movie;
import com.workintech.s19d1.service.ActorService;
import com.workintech.s19d1.service.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/movie")
public class MovieController {

    private MovieService movieService;

    @Autowired
    public MovieController(MovieService movieService){
        this.movieService = movieService;
    }

    @GetMapping
    public List<Movie> getAll(){
        return movieService.findAll();
    }
    @GetMapping("/{id}")
    public Movie getMovie(@PathVariable long id){
        return movieService.findById(id);
    }
    @PostMapping
    public Movie post(@RequestBody Movie movie){
        return movieService.save(movie);
    }
    @PutMapping("/{id}")
    public Movie update(@PathVariable long id, @RequestBody Movie movie){
        Movie movieToUpdate = movieService.findById(id);
        movieToUpdate.setId(movie.getId());
        return movieService.update(movie.getId());
    }
    @DeleteMapping("/{id}")
    public Movie delete(@PathVariable long id){
        Movie movieToDelete = movieService.findById(id);
        movieService.delete(movieToDelete);
        return movieToDelete;
    }
}
