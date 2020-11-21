package com.anmolahuja.bookstore.exception.handler;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class CustomApiErrorResponse {

	private String message;

	private String httpStatus;

	private int httpStatusCode;

	private boolean success;

	private boolean error;

	private Object cause;


}
