package com.workintech.s19d1.service;

import com.workintech.s19d1.entity.Actor;
import com.workintech.s19d1.entity.Movie;
import com.workintech.s19d1.repository.ActorRepository;
import com.workintech.s19d1.repository.MovieRepository;
import com.workintech.s19d1.util.HollywoodValidation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MovieServiceImpl implements MovieService{

    private MovieRepository movieRepository;

    @Autowired
    public MovieServiceImpl(MovieRepository movieRepository){
        this.movieRepository = movieRepository;
    }

    @Override
    public Movie save(Movie movie) {
        return movieRepository.save(movie);
    }

    @Override
    public Movie update(long id) {
        Optional<Movie> optionalMovie = movieRepository.findById(id);
        if(optionalMovie.isPresent()){
            return movieRepository.save(optionalMovie.get());
        }
        return null;
    }

    @Override
    public Movie delete(Movie movie) {
        Movie movieToDelete = movie;
        movieRepository.delete(movie);
        return movie;
    }

    @Override
    public Movie findById(long id) {
        HollywoodValidation.existenceValidation(movieRepository, id, true);
        Optional<Movie> optionalMovie = movieRepository.findById(id);
        if(optionalMovie.isPresent()){
            return optionalMovie.get();
        }
        return null;
    }

    @Override
    public List<Movie> findAll() {
        return movieRepository.findAll();
    }
}
