package com.compassouol.resources.exception;

import java.util.ArrayList;
import java.util.List;

import com.compassouol.exceptions.StandardError;

public class ViolationError extends StandardError  {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private List<FieldMessage> errors = new ArrayList<>();

	public ViolationError() {

	}

	public ViolationError(Integer status, String msg, Long timeStamp) {
		super(status, msg, timeStamp);
	}

	public List<FieldMessage> getErrors() {
		return errors;
	}

	public void addError(String fieldName, String menssagem) {

		errors.add(new FieldMessage(fieldName, menssagem));

	}
}
