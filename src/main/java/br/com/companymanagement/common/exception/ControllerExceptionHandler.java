package br.com.companymanagement.common.exception;

import java.io.PrintWriter;
import java.io.StringWriter;

import javax.servlet.http.HttpServletRequest;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

//@EnableWebMvc
//@ControllerAdvice
public class ControllerExceptionHandler {

	private static final Logger LOG = LogManager.getLogger(ControllerExceptionHandler.class);

	@ExceptionHandler(BadRequestException.class)
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	@ResponseBody
	public ResponseEntity<Error> handleBadRequestException(HttpServletRequest request, BadRequestException ex) {

		Error error = null;

		if (ex.getError() != null) {
			error = ex.getError();
		} else {
			error = new Error();
			error.setMessage(ex.getMessage());
			error.setStatusDescription(HttpStatus.BAD_REQUEST.getReasonPhrase());
			error.setStatusCode(HttpStatus.BAD_REQUEST.value());
			error.setErrorCode(ex.getCode());
		}

		LOG.warn("Bad Request Error: " + error.toString());
		LOG.debug("Bad Request Error: " + error.toString(), ex);

		return new ResponseEntity<Error>(error, HttpStatus.BAD_REQUEST);
	}

//	@ExceptionHandler(MethodArgumentNotValidException.class)
//	@ResponseStatus(HttpStatus.BAD_REQUEST)
//	@ResponseBody
//	public ResponseEntity<Error> handleMethodArgumentNotValidException(HttpServletRequest request, MethodArgumentNotValidException ex) {
//
//		Error error = new Error();
//		error.setMessage(ex.getBindingResult().getAllErrors().stream().findFirst().get().getDefaultMessage());
//		error.setStatusDescription(HttpStatus.BAD_REQUEST.getReasonPhrase());
//		error.setStatusCode(HttpStatus.BAD_REQUEST.value());
//
//		LOG.warn("Bean Validation Error: " + error.toString());
//		LOG.debug("Bean Validation Error: " + error.toString(), ex);
//
//		return new ResponseEntity<Error>(error, HttpStatus.BAD_REQUEST);
//	}

	@ExceptionHandler(NotFoundException.class)
	@ResponseStatus(HttpStatus.NOT_FOUND)
	@ResponseBody
	public ResponseEntity<Error> handleNotFoundException(HttpServletRequest request, NotFoundException ex) {

		Error error = null;

		if (ex.getError() != null) {
			error = ex.getError();
		} else {
			error = new Error();
			error.setMessage(ex.getMessage());
			error.setStatusDescription(HttpStatus.NOT_FOUND.getReasonPhrase());
			error.setStatusCode(HttpStatus.NOT_FOUND.value());
		}

		LOG.warn("Not Found Error: " + error.toString());
		LOG.debug("Not Found Error: " + error.toString(), ex);

		return new ResponseEntity<Error>(error, HttpStatus.NOT_FOUND);
	}

	@ExceptionHandler({
		InternalServerErrorException.class,
		Exception.class,
	})
	@ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
	@ResponseBody
	public ResponseEntity<Error> handleExceptionInternal(Exception ex) {

		Error error = null;

		if (ex instanceof InternalServerErrorException && ((InternalServerErrorException)ex).getError() != null) {
			error = ((InternalServerErrorException)ex).getError();
		} else {

			StringWriter stacktrace = new StringWriter();
			ex.printStackTrace(new PrintWriter(stacktrace));

			error = new Error();
			error.setMessage(ex.getMessage());
			error.setStatusDescription(HttpStatus.INTERNAL_SERVER_ERROR.getReasonPhrase());
			error.setStatusCode(HttpStatus.INTERNAL_SERVER_ERROR.value());
			error.setStacktrace(stacktrace.toString());
		}

		LOG.error("Internal Server Error: " + error.toString(), ex);

		return new ResponseEntity<Error>(error, HttpStatus.INTERNAL_SERVER_ERROR);
	}

}
