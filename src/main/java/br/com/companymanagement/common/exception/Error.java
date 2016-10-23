package br.com.companymanagement.common.exception;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

@JsonInclude(Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class Error {

	private long id = System.currentTimeMillis();
	private String message;
	private String statusDescription;
	private Integer statusCode;
	private Integer errorCode;
	private String stacktrace;

	public Error() {
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getStatusDescription() {
		return statusDescription;
	}

	public void setStatusDescription(String statusDescription) {
		this.statusDescription = statusDescription;
	}

	public Integer getStatusCode() {
		return statusCode;
	}

	public void setStatusCode(Integer statusCode) {
		this.statusCode = statusCode;
	}

	public Integer getErrorCode() {
		return errorCode;
	}

	public void setErrorCode(Integer errorCode) {
		this.errorCode = errorCode;
	}

	public String getStacktrace() {
		return stacktrace;
	}

	public void setStacktrace(String stacktrace) {
		this.stacktrace = stacktrace;
	}

	@Override
	public String toString() {

		StringBuilder builder = new StringBuilder();

		builder.append("Error [id=");
		builder.append(id);

		builder.append(", ");
		if (message != null) {
			builder.append("message=");
			builder.append(message);
			builder.append(", ");
		}

		if (statusDescription != null) {
			builder.append("statusDescription=");
			builder.append(statusDescription);
			builder.append(", ");
		}

		if (statusCode != null) {
			builder.append("statusCode=");
			builder.append(statusCode);
			builder.append(", ");
		}

		if (errorCode != null) {
			builder.append("errorCode=");
			builder.append(errorCode);
			builder.append(", ");
		}

		if (stacktrace != null) {
			builder.append("stacktrace=");
			builder.append(stacktrace);
		}

		builder.append("]");
		return builder.toString();
	}

}
