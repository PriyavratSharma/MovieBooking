package com.capgemini.onlinemoviebooking.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.capgemini.onlinemoviebooking.entity.Movie;

/****************************
 *          @author          Priyavrat Sharma
 *          Description      It is a Dao interface class typically used in combination 
 *                           with annotated handler methods based on the mapping annotation  
 *          Version          1.0
 *          Created Date     11-MAY-2020
 ****************************/
@Repository
public interface MovieDao extends JpaRepository<Movie, Integer>{

}
