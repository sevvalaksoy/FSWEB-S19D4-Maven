package com.workintech.s19d1.controller;

import com.workintech.s19d1.entity.Actor;
import com.workintech.s19d1.entity.Movie;
import com.workintech.s19d1.service.ActorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/actor")
public class ActorController {

    private ActorService actorService;

    @Autowired
    public ActorController(ActorService actorService){
        this.actorService = actorService;
    }

    @GetMapping
    public List<Actor> getAll(){
        return actorService.findAll();
    }
    @GetMapping("/{id}")
    public Actor getActor(@PathVariable long id){
        return actorService.findById(id);
    }
    @PostMapping
    public Actor post(@RequestBody Actor actor){
        return actorService.save(actor);
    }
    @PutMapping("/{id}")
    public Actor update(@PathVariable long id, @RequestBody Actor actor){
        Actor actorToUpdate = actorService.findById(id);
        actorToUpdate.setFirstName(actor.getFirstName());
        actorToUpdate.setLastName(actor.getLastName());
        actorToUpdate.setGender(actor.getGender());
        actorToUpdate.setBirthDate(actor.getBirthDate());
        actorToUpdate.setMovies(actor.getMovies());
        return actorService.save(actorToUpdate);
    }
    @DeleteMapping("/{id}")
    public Actor delete(@PathVariable long id){
        Actor actorToDelete = actorService.findById(id);
        actorService.delete(actorToDelete);
        return actorToDelete;
    }
}
