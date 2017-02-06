package com.raja.validation;

import com.raja.exception.ValidationException;
import com.raja.model.UserDetails;
import com.raja.util.ValidationUtil;

public class UserDetailsValidation {

	public void userDetailValidation(UserDetails userDetail)throws ValidationException{
		 ValidationUtil.isInvalidObject(userDetail, "empty object");
	 }
	 public void idValidation(Integer id) throws ValidationException{
		 ValidationUtil.isInvalidNumber(id, "invalid id");
	 }
	 public void nameValidation(String name)throws ValidationException{
		 ValidationUtil.isInvalidString(name, "invalid name");
	 }
	 public void emailValidation(String email)throws ValidationException{
		 ValidationUtil.isValidEmail(email, "invalid email");
	 }
	 public void passwordValidation(String pass)throws ValidationException{
		 ValidationUtil.isValidPassword(pass, "invalid password");
	 }
	 public void statusValidation(boolean id)throws ValidationException{
		 ValidationUtil.isValidBoolean(id, "invalid status");
	 }
	 public void saveValidation(UserDetails userDetail)throws ValidationException{
		 userDetailValidation(userDetail);
		 idValidation(userDetail.getUserId());
		 nameValidation(userDetail.getUserName());
		 emailValidation(userDetail.getUserMail());
		 passwordValidation(userDetail.getPass());
		 statusValidation(userDetail.isActive());
		 }
	 public void deleteValidation(UserDetails userDetail)throws ValidationException{
		 userDetailValidation(userDetail);
		 idValidation(userDetail.getUserId());
	 }
	 public void updateValidation(UserDetails userDetail)throws ValidationException{
		 userDetailValidation(userDetail);
		 idValidation(userDetail.getUserId());
		 passwordValidation(userDetail.getPass());
	 }
	 public String loginValidation(String Temail,String Tpassword,String email,String password)throws ValidationException{
		 String str1=Temail;
		 String str2=Tpassword;
		 if( str1.equals(email) && str2.equals(password)){
			 return "successfull";
			 
		 }else 
		 {
			 throw new ValidationException("login fail");
		 }
		
	 }
}
