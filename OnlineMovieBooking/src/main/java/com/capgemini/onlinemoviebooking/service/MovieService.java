package com.capgemini.onlinemoviebooking.service;

import java.util.List;
import com.capgemini.onlinemoviebooking.entity.Movie;

/****************************
 * @author Priyavrat Sharma Description It is a service interface that provide
 *         the methods for searching movie using movieId and to search all the
 *         movies
 * 
 *         Version 1.0 Created Date 11-MAY-2020
 ****************************/
public interface MovieService {
	
	/*	
		*//****************************
			 * Method addMovie Description define the method Created By Priyavrat Sharma
			 * Created Date 11-MAY-2020
			 ****************************/
	/*
	 * public Movie addMovie(Movie movie);
	 * 
	 *//****************************
		 * Method deleteMovie Description define the method Created By Priyavrat Sharma
		 * Created Date 11-MAY-2020
		 ****************************//*
										 * public Boolean deleteMovie(Integer movieId);
										 */

	/****************************
	 * Method showAllMovie Description define the method Created By Priyavrat Sharma
	 * Created Date 11-MAY-2020
	 ****************************/
	public List<Movie> showAllMovie();

	/****************************
	 * Method showMovie Description define the method Created By Priyavrat Sharma
	 * Created Date 11-MAY-2020
	 ****************************/
	public Movie showMovie(int id);

}
