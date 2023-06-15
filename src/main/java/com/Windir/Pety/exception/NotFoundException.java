package com.Windir.Pety.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
@ResponseBody
public class NotFoundException extends RuntimeException {
	private String message;
	public <T> NotFoundException(Long id, Class<T> entityClass) {
		this.message = "No " + entityClass.getSimpleName() + " was found with this ID: " + id;
	}

	public String getMessage() {
		return message;
	}
}
