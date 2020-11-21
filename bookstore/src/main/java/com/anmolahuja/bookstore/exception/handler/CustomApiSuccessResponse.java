package com.anmolahuja.bookstore.exception.handler;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class CustomApiSuccessResponse {

	private String message;

	private String httpStatus;

	private int httpStatusCode;

	private Object body;

	private boolean success;

	private boolean error;

}
