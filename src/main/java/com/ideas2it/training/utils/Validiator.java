package com.ideas2it.training.utils;

import com.ideas2it.training.model.Employee;
import com.ideas2it.training.model.LeaveRecords;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.time.format.DateTimeParseException;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.regex.Pattern;
@Component
public class Validiator {


    private final static int MAX_AGE = 80;
    private final static int MIN_AGE = 18;

    public boolean isValidName(String inputString) {
	String regexPattern = "[A-Z][a-z]*([ ]{0,1}[a-z])*";
	boolean matches = Pattern.matches(regexPattern,inputString);
	return matches;
    }

    public boolean isValidContact(String inputString) {
	String regexPattern = "^[6-9](\\d{9})$";//"[0-9]{10}";
	boolean matches = Pattern.matches(regexPattern,inputString);
	return matches;
    }

    public boolean isValidEmail(String inputString) {
	String regexPattern = "^[a-zA-Z]{1,20}[[0-9]{0,5}[a-zA-Z]{0,20}]*[_]{0,2}([.]{0,1}[a-zA-Z0-9])*[@][a-z]{0,7}([.][a-z]{1,5})+$";
	boolean matches = Pattern.matches(regexPattern,inputString);
	return matches;
    }

	boolean isValidString(String inputString) {
//		String regexPattern = "[a-zA-Z0-9]{3,20}";
//		boolean matches = Pattern.matches(regexPattern,inputString);
		if(inputString.length()<20)
			return true;
		else
			return false;
	}

    public boolean isValidBirthdate(String inputString) {
		LocalDate curDate = LocalDate.now();
		LocalDate dob = LocalDate.parse(inputString);
		if (curDate.compareTo(dob) > MIN_AGE && curDate.compareTo(dob) < MAX_AGE && dob.isBefore(curDate))
			return true;
		else
			return false;
	}

    public boolean isValidDate(String dateStr) {
	try {
	    LocalDate date = LocalDate.parse(dateStr);
	    return true;
	} catch (DateTimeParseException e) {
	    return false;
        }
    }

    public LocalDate stringToDate(String date) {

		return LocalDate.parse(date);
    }

    public boolean isValidlLeaveDates(String fromDate,String toDate,int leaveCount) {

	final int MAX_LEAVES_ALLOWED = 10;
	int leavesLeft = MAX_LEAVES_ALLOWED - leaveCount;
	LocalDate sDate = stringToDate(fromDate);
	LocalDate tDate = stringToDate(toDate);
	long noOfDaysBetween = ChronoUnit.DAYS.between(sDate, tDate);
	if (noOfDaysBetween > leavesLeft) 
	    return false;
	else
	    return true; 
    }

	public List<String> checkEmployeeRegisterInputs(Employee employee) {
		List<String> errors = new ArrayList<>();
		String gender = employee.getGender();
		if(!isValidName(employee.getName()))
			errors.add("Given Name is not Valid");
		if(!isValidContact(employee.getContact()))
			errors.add("Given Contact number is not Valid");
		if(!(employee.getEmployeeType().equals("Trainer") || employee.getEmployeeType().equals("Trainee")))
			errors.add("EmployeeType is not Valid");
		if(!isValidEmail(employee.getEmail()))
			errors.add("Email pattern not valid");
		if(!isValidBirthdate(employee.getBirthdate()))
			errors.add("Birthdate is not valid");
		if(!(gender.equals("Male") || gender.equals("Female") || gender.equals("Other")))
			errors.add("Gender not Valid");
		if (!isValidString(employee.getProbationTime()))
			errors.add("Probation Time not valid");
		if (!isValidString(employee.getDesignation()))
			errors.add("designation not valid");
		return errors;
	}

	public List<String> checkLeaveInputErrors(LeaveRecords leave) {
		List<String> errors = new ArrayList<>();
		String leaveType = leave.getLeaveType();
		LocalDate fromDate;
		LocalDate toDate;
		try {
			fromDate = LocalDate.parse(leave.getFromDate());
			toDate = LocalDate.parse(leave.getToDate());
			if(!fromDate.isBefore(toDate)) {
				errors.add("Leave Dates not valid ! start date after end date");
			}
			if((leaveType.equals("Casual") || leaveType.equals("Sick") || leaveType.equals("Medical")) == false){
				errors.add("Given Leave type is not valid");
			}
		} catch (InputMismatchException e){
			errors.add("dates entered are not valid");
		}

		return errors;
	}
}