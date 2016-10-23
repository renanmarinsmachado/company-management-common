package br.com.companymanagement.common.exception;

public class BadRequestException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	private Error error;

	private Integer code;

	public BadRequestException() {
	}

	public BadRequestException(String message) {
		super(message);
	}
	
	public BadRequestException(String message, int code) {
		super(message);
		this.code = code;
	}
	
	public BadRequestException(int code) {
		this.code = code;
	}

	public BadRequestException(Throwable th) {
		super(th);
	}

	public BadRequestException(String message, Throwable th) {
		super(message, th);
	}

	public BadRequestException(Error error) {
		super(error.getMessage());
		this.error = error;
		this.code = error.getErrorCode();
	}

	public Error getError() {
		return error;
	}

	public Integer getCode(){
		return code;
	}

}
