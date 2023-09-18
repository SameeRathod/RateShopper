package com.axisrooms.rateShopper.utils;

import com.axisrooms.rateShopper.pages.LoginPage;

public class LoginUtils {
	
	public  void loginUtils(String userName, String password) {
		new LoginPage().getEmailIdTextField(userName).getPasswordTextField(password).getLoginButton();
	}

}
