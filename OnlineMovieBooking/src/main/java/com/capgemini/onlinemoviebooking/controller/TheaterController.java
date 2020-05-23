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

import com.capgemini.onlinemoviebooking.entity.Theater;
import com.capgemini.onlinemoviebooking.exception.TheaterException;
import com.capgemini.onlinemoviebooking.service.TheaterService;

/****************************
 * @author Priyavrat Sharma Description It is a controller class typically used
 *         in combination with annotated handler methods based on the mapping
 *         annotation Version 1.0 Created Date 14-MAY-2020
 ****************************/
@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class TheaterController {
	@Autowired
	TheaterService theaterService;

	/*
	*//****************************
		 * Method addTheater Description To add theater into the database
		 * 
		 * @throws UserException- It is raised if i'd present already in the database
		 *                        Created By Priyavrat Sharma Created Date 14-MAY-2020
		 ****************************/
	/*
	 * @CrossOrigin
	 * 
	 * @PostMapping("/addThater") public ResponseEntity<String>
	 * addTheater(@Valid @RequestBody Theater theater, BindingResult br)throws
	 * TheaterException{ String err=""; if(br.hasErrors()) { List<FieldError>
	 * errors= br.getFieldErrors(); for(FieldError error:errors) err
	 * +=error.getDefaultMessage() +"<br/>"; throw new TheaterException(err); } try
	 * { theaterService.addTheater(theater); return new
	 * ResponseEntity<String>("Theater added", HttpStatus.OK); }
	 * catch(DataIntegrityViolationException ex) { throw new
	 * TheaterException("ID already exists"); } }
	 * 
	 * 
	 * 
	 *//****************************
		 * Method deleteTheater Description To delete theater from the database Created
		 * By Priyavrat Sharma Created Date 14-MAY-2020
		 ****************************//*
										 * @CrossOrigin
										 * 
										 * @DeleteMapping("/deleteTheater/{id}") public ResponseEntity<Boolean>
										 * deleteTheater(@PathVariable int id) { theaterService.deleteTheater(id);
										 * return new ResponseEntity<Boolean>(true, HttpStatus.OK); }
										 */

	/****************************
	 * Method viewAllTheater Description To fetch all the theaters present in the
	 * database
	 * 
	 * Created By Priyavrat Sharma Created Date 14-MAY-2020
	 ****************************/
	@CrossOrigin
	@GetMapping("/viewAllTheater")
	public ResponseEntity<List<Theater>> viewAllTheatre() {
		List<Theater> listOfTheater = theaterService.showAllTheater();
		return new ResponseEntity<List<Theater>>(listOfTheater, HttpStatus.OK);

	}

	/****************************
	 * Method viewTheater Description To fetch a theater present in the database
	 * using theater Id
	 * 
	 * @throws UserException- It is raised if i'd not present in the database
	 *                        Created By Priyavrat Sharma Created Date 14-MAY-2020
	 ****************************/
	@GetMapping("/viewTheater/{id}")
	public ResponseEntity<Theater> viewTheater(@PathVariable int id) throws TheaterException {
		Theater theater = theaterService.showTheater(id);
		if (theater != null)
			return new ResponseEntity<Theater>(theater, HttpStatus.OK);
		else
			throw new TheaterException("ID doesn't exists");
	}

}
