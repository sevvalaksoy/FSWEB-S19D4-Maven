package com.workintech.s19d1.util;

import com.workintech.s19d1.exceptions.ApiException;
import com.workintech.s19d1.repository.ActorRepository;
import com.workintech.s19d1.repository.MovieRepository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.http.HttpStatus;

public class HollywoodValidation {

    public static void isIdValid(Long id) {
        if(id == null || id < 0 ){
            throw new ApiException("Id is not valid", HttpStatus.BAD_REQUEST);
        }
    }

    public static void existenceValidation(JpaRepository jpaRepository, long id, boolean existence){
        if(existence){
            if(jpaRepository instanceof MovieRepository){
                if(jpaRepository.findById(id).isEmpty()){
                    throw new ApiException("Movie is not found with id: 2", HttpStatus.NOT_FOUND);
                }
            }
            if(jpaRepository instanceof ActorRepository){
                if(jpaRepository.findById(id).isEmpty()){
                    throw new ApiException("actor is not found with id: " + id, HttpStatus.NOT_FOUND);
                }
            }
        } else {
            if(jpaRepository instanceof MovieRepository){
                if(jpaRepository.findById(id).isPresent()){
                    throw new ApiException("Record already exists", HttpStatus.BAD_REQUEST);
                }
            }
            if(jpaRepository instanceof ActorRepository){
                if(jpaRepository.findById(id).isPresent()){
                    throw new ApiException("Record already exists", HttpStatus.BAD_REQUEST);
                }
            }
        }
    }
}
