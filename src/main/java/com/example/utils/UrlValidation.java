package com.example.utils;

import java.util.regex.Pattern;

import org.springframework.stereotype.Component;

@Component
public class UrlValidation {

	//pattern matching the valid url
	private final static Pattern FILTERS = Pattern.compile("^(http://|https://)?(www.)?([a-zA-Z0-9]+).[a-zA-Z0-9]*.[a-z]{3}.?([a-z]+)?$");
	
	/**
	 * Validating the url is valid or nor
	 * @param link
	 * @return
	 */
	public boolean validateUrl(String link) {
		return FILTERS.matcher(link).matches();
	}

}
