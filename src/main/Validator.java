package main;

import java.util.regex.Pattern;

public class Validator {
	
	public static boolean isValidUserId(String userId){
		return Pattern.compile("^ST[0-9]{4}$").matcher(userId).find();
	}
	public static boolean isValidBookId(String bookId){
		return Pattern.compile("^BK[0-9]{4}$").matcher(bookId).find();
	}
	public static boolean isValidYear(String year){
		return Pattern.compile("FE|BE|TE|SE").matcher(year).find();
	}
	public static boolean isValidDivision(String division){
		return Pattern.compile("A|B|C").matcher(division).find();
	}
	public static boolean isValidDepartment(String department){
		return Pattern.compile("COMP|IT|E&TC|MECH|CIVIL|comp|it|e&tc|mech|civil").matcher(department).find();
	}
	public static boolean isValidContactNo(String contactNo){
		return Pattern.compile("^[0-9]{10}$").matcher(contactNo).find();
	}
	public static boolean isValidDate(String date){
		return Pattern.compile("^[0-9]{4}-[0-9]{2}-[0-9]{2}$").matcher(date).find();
	}
	public static String isValidUser(String userId, String department, String year, String division, String contactNo){
		String invalidFields = "";
		invalidFields = invalidFields.concat(isValidUserId(userId) ?  "" : "UserId ").concat(isValidDepartment(department) ? "" : "department ").concat(isValidYear(year)?"":"year ").concat(isValidDivision(division) ? "" : "division ").concat(isValidContactNo(contactNo)? "" :"contactNo");
		return invalidFields;
	}
	
}
