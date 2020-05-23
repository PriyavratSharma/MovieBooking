package com.capgemini.onlinemoviebooking.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.capgemini.onlinemoviebooking.dao.MovieDao;
import com.capgemini.onlinemoviebooking.entity.Movie;

/****************************
 * @author Priyavrat Sharma Description It is a service implementation class
 *         that provide business logic for searching movies using movie Id and
 *         to search all the movies
 * 
 *         Version 1.0 Created Date 12-MAY-2020
 ****************************/
@Service
@Transactional
public class MovieServiceImpl implements MovieService {

	@Autowired
	MovieDao movieDao;

	/*
	*//****************************
		 * Method addMovie Description To implement the method which adds movie into the
		 * database Created By Priyavrat Sharma Created Date 12-MAY-2020
		 ****************************/
	/*
	 * @Override public Movie addMovie(Movie movie) { return movieDao.save(movie);
	 * 
	 * }
	 * 
	 * 
	 *//****************************
		 * Method deleteMovie Description To implement the method which deletes the
		 * movie from the database Created By Priyavrat Sharma Created Date 12-MAY-2020
		 ****************************//*
										 * @Override public Boolean deleteMovie(Integer movieId) {
										 * movieDao.deleteById(movieId);
										 * 
										 * return true; }
										 */

	/****************************
	 * Method showAllMovie Description To implement the method which fetches all the
	 * movies from the database Created By Priyavrat Sharma Created Date 12-MAY-2020
	 ****************************/
	@Override
	public List<Movie> showAllMovie() {
		return movieDao.findAll();
	}

	/****************************
	 * Method showMovie Description To implement the method which fetches the movie
	 * from the database using movie Id Created By Priyavrat Sharma Created Date
	 * 12-MAY-2020
	 ****************************/
	@Override
	public Movie showMovie(int id) {
		Optional<Movie> movie = movieDao.findById(id);
		if (movie.isPresent())
			return movie.get();

		else
			return null;
	}

}