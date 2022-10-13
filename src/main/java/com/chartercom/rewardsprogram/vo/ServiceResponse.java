package com.chartercom.rewardsprogram.vo;

import com.fasterxml.jackson.annotation.JsonInclude;

public class ServiceResponse<T> {
	@JsonInclude(JsonInclude.Include.NON_EMPTY)
	private T data;
	@JsonInclude(JsonInclude.Include.NON_EMPTY)
	private ErrorInfo errorInfo;
		
	public ServiceResponse(T data, ErrorInfo errorInfo) {
		super();
		this.data = data;
		this.errorInfo = errorInfo;
	}
	
	public T getData() {
		return data;
	}
	public void setData(T data) {
		this.data = data;
	}
	public ErrorInfo getErrorInfo() {
		return errorInfo;
	}
	public void setErrorInfo(ErrorInfo errorInfo) {
		this.errorInfo = errorInfo;
	}	
}
