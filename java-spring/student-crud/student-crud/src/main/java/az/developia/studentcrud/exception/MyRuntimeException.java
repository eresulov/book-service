package az.developia.studentcrud.exception;

import org.springframework.validation.BindingResult;
//binding result injection edirik getter setter yaradiriq,contructor yarat
public class MyRuntimeException extends RuntimeException {

	private static final long serialVersionUID = 1L;
	private BindingResult result;

	public BindingResult getResult() {
		return result;
	}

	public void setResult(BindingResult result) {
		this.result = result;
	}

	public MyRuntimeException(BindingResult result) {
		super();
		this.result = result;
	}

}
