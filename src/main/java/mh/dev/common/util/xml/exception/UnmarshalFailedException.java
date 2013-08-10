package mh.dev.common.util.xml.exception;

public class UnmarshalFailedException extends Exception {

	private static final long serialVersionUID = 1L;

	public UnmarshalFailedException() {
		super();
	}

	public UnmarshalFailedException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

	public UnmarshalFailedException(String message, Throwable cause) {
		super(message, cause);
	}

	public UnmarshalFailedException(String message) {
		super(message);
	}

	public UnmarshalFailedException(Throwable cause) {
		super(cause);
	}

}
