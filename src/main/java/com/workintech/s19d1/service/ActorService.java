package com.workintech.s19d1.service;

import com.workintech.s19d1.entity.Actor;
import com.workintech.s19d1.entity.Movie;

import java.util.List;

public interface ActorService {
    Actor save(Actor actor);
    Actor update(long id);
    Actor delete(Actor actor);
    Actor findById(long id);
    List<Actor> findAll();
}
