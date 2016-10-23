package br.com.companymanagement.common.exception;

public class InternalServerErrorException extends RuntimeException{

	private static final long serialVersionUID = 1L;

	private Error error;

	public InternalServerErrorException() {
	}

	public InternalServerErrorException(String message) {
		super(message);
	}

	public InternalServerErrorException(Throwable th) {
		super(th);
	}

	public InternalServerErrorException(String message, Throwable th) {
		super(message, th);
	}

	public InternalServerErrorException(Error error) {
		super(error.getMessage());
		this.error = error;
	}

	public Error getError() {
		return error;
	}
}
