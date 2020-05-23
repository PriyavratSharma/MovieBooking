package com.capgemini.onlinemoviebooking.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.capgemini.onlinemoviebooking.entity.Movie;
import com.capgemini.onlinemoviebooking.exception.MovieException;
import com.capgemini.onlinemoviebooking.service.MovieService;

/****************************
 * @author Priyavrat Sharma Description It is a controller class typically used
 *         in combination with annotated handler methods based on the mapping
 *         annotation Version 1.0 Created Date 13-MAY-2020
 ****************************/
@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class MovieController {
	@Autowired
	MovieService movieService;

	/****************************
	 * Method addMovie Description To add movie into the database
	 * 
	 * @throws UserException- It is raised if i'd present already in the database
	 *                        Created By Priyavrat Sharma Created Date 13-MAY-2020
	 ****************************/
	/*
	 * @CrossOrigin
	 * 
	 * @PostMapping("/addMovie") public ResponseEntity<String>
	 * addMovie(@Valid @RequestBody Movie movie, BindingResult br)throws
	 * MovieException{ String err=""; if(br.hasErrors()) { List<FieldError> errors=
	 * br.getFieldErrors(); for(FieldError error:errors) err
	 * +=error.getDefaultMessage() +"<br/>"; throw new MovieException(err); } try {
	 * 
	 * movieService.addMovie(movie); return new
	 * ResponseEntity<String>("movie added", HttpStatus.OK); }
	 * catch(DataIntegrityViolationException ex) { throw new
	 * MovieException("ID already exists"); } }
	 * 
	 * 
	 *//****************************
		 * Method deleteMovie Description To delete movie from the database Created By
		 * Priyavrat Sharma Created Date 13-MAY-2020
		 ****************************//*
										 * @CrossOrigin
										 * 
										 * @DeleteMapping("/deleteMovie/{id}") public ResponseEntity<String>
										 * deleteMovie(@PathVariable int id) { movieService.deleteMovie(id); return new
										 * ResponseEntity<String>("Movie Deleted", HttpStatus.OK); }
										 */

	/****************************
	 * Method viewAllMovie Description To fetch all the movies present in the
	 * database
	 * 
	 * Created By Priyavrat Sharma Created Date 13-MAY-2020
	 ****************************/
	@CrossOrigin
	@GetMapping("/viewAllMovie")
	public ResponseEntity<List<Movie>> viewAllMovie() {
		List<Movie> listOfMovie = movieService.showAllMovie();
		return new ResponseEntity<List<Movie>>(listOfMovie, HttpStatus.OK);

	}

	/****************************
	 * Method viewMovie Description To fetch a movie present in the database using
	 * movie Id
	 * 
	 * @throws UserException- It is raised if i'd not present in the database
	 *                        Created By Priyavrat Sharma Created Date 13-MAY-2020
	 ****************************/
	@GetMapping("/viewMovie/{id}")
	public ResponseEntity<Movie> viewMovie(@PathVariable int id) throws MovieException {
		Movie movie = movieService.showMovie(id);
		if (movie != null)
			return new ResponseEntity<Movie>(movie, HttpStatus.OK);
		else
			throw new MovieException("ID doesn't exists");
	}

}
