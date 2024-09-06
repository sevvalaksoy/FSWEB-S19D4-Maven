package com.workintech.s19d1.service;

import com.workintech.s19d1.entity.Actor;
import com.workintech.s19d1.entity.Movie;

import java.util.List;

public interface MovieService {
    Movie save(Movie movie);
    Movie update(long id);
    Movie delete(Movie movie);
    Movie findById(long id);
    List<Movie> findAll();
}
