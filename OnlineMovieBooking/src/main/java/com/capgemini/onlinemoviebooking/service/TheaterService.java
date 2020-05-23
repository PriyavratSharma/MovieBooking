package com.capgemini.onlinemoviebooking.service;

import java.util.List;

import com.capgemini.onlinemoviebooking.entity.Theater;

/****************************
 * @author Priyavrat Sharma Description It is a service interface that provide
 *         the methods for searching theaters using theaterId and to search all
 *         the theaters
 * 
 *         Version 1.0 Created Date 11-MAY-2020
 ****************************/
public interface TheaterService {
	
	/*
	*//****************************
		 * Method addTheater Description define the method Created By Priyavrat Sharma
		 * Created Date 12-MAY-2020
		 ****************************/
	/*
	 * public Theater addTheater(Theater theater);
	 * 
	 * 
	 * 
	 *//****************************
		 * Method deleteTheater Description define the method Created By Priyavrat
		 * Sharma Created Date 11-MAY-2020
		 ****************************//*
										 * public Boolean deleteTheater(Integer theaterId);
										 */

	/****************************
	 * Method showAllTheater Description define the method Created By Priyavrat
	 * Sharma Created Date 11-MAY-2020
	 ****************************/
	public List<Theater> showAllTheater();

	/****************************
	 * Method showTheater Description define the method Created By Priyavrat Sharma
	 * Created Date 11-MAY-2020
	 ****************************/
	public Theater showTheater(int id);

}
