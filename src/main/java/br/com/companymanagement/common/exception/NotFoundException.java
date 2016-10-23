package br.com.companymanagement.common.exception;

public class NotFoundException extends RuntimeException{

	private static final long serialVersionUID = 1L;

	private Error error;

	private Integer code;

	public NotFoundException() {
	}

	public NotFoundException(String message) {
		super(message);
	}
	
	public NotFoundException(String message, int code) {
		super(message);
		this.code = code;
	}
	
	public NotFoundException(int code) {
		this.code = code;
	}

	public NotFoundException(Throwable th) {
		super(th);
	}

	public NotFoundException(String message, Throwable th) {
		super(message, th);
	}

	public NotFoundException(Error error) {
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
