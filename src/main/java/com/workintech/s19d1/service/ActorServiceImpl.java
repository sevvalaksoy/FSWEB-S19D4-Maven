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
public class ActorServiceImpl implements ActorService{

    private ActorRepository actorRepository;

    @Autowired
    public ActorServiceImpl(ActorRepository actorRepository){
        this.actorRepository = actorRepository;
    }

    @Override
    public Actor save(Actor actor) {
        return actorRepository.save(actor);
    }

    @Override
    public Actor update(long id) {
        Optional<Actor> optionalActor = actorRepository.findById(id);
        if(optionalActor.isPresent()){
            return actorRepository.save(optionalActor.get());
        }
        return null;
    }

    @Override
    public Actor delete(Actor actor) {
        Actor actorToDelete = actor;
        actorRepository.delete(actor);
        return actorToDelete;
    }

    @Override
    public Actor findById(long id) {
        HollywoodValidation.existenceValidation(actorRepository, id, true);
        Optional<Actor> optionalActor = actorRepository.findById(id);
        if(optionalActor.isPresent()){
            return optionalActor.get();
        }
        return null;
    }

    @Override
    public List<Actor> findAll() {
        return actorRepository.findAll();
    }
}
