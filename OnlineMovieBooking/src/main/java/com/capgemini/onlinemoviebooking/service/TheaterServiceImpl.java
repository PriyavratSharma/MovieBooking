package com.capgemini.onlinemoviebooking.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.capgemini.onlinemoviebooking.dao.TheaterDao;
import com.capgemini.onlinemoviebooking.entity.Theater;

/****************************
 * @author Priyavrat Sharma Description It is a service implementation class
 *         that provide business logic for searching theaters using theater Id
 *         and to search all the theaters
 * 
 *         Version 1.0 Created Date 14-MAY-2020
 ****************************/
@Service
@Transactional
public class TheaterServiceImpl implements TheaterService {

	@Autowired
	TheaterDao theaterDao;

	/*
	*//****************************
		 * Method addTheater Description To implement the method which adds the theater
		 * into the database Created By Priyavrat Sharma Created Date 14-MAY-2020
		 ****************************/
	/*
	 * @Override public Theater addTheater(Theater theater) { return
	 * theaterDao.save(theater);
	 * 
	 * }
	 * 
	 * 
	 *//****************************
		 * Method deleteTheater Description To implement the method which deletes a
		 * theater from the database using theater Id Created By Priyavrat Sharma
		 * Created Date 14-MAY-2020
		 ****************************//*
										 * @Override public Boolean deleteTheater(Integer theaterId) {
										 * theaterDao.deleteById(theaterId);
										 * 
										 * return true; }
										 */

	/****************************
	 * Method showAllTheater Description To implement the method which fetches all
	 * the theaters from the database Created By Priyavrat Sharma Created Date
	 * 14-MAY-2020
	 ****************************/
	@Override
	public List<Theater> showAllTheater() {
		return theaterDao.findAll();

	}

	/****************************
	 * Method showTheater Description To implement the method which fetches a
	 * theater from the database using theater Id Created By Priyavrat Sharma
	 * Created Date 14-MAY-2020
	 ****************************/
	@Override
	public Theater showTheater(int id) {
		Optional<Theater> theater = theaterDao.findById(id);
		if (theater.isPresent())
			return theater.get();

		else
			return null;
	}

}
