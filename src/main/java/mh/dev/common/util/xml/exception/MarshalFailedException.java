package mh.dev.common.util.xml.exception;

public class MarshalFailedException extends Exception {

	private static final long serialVersionUID = 1L;

	public MarshalFailedException() {
		super();
	}

	public MarshalFailedException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

	public MarshalFailedException(String message, Throwable cause) {
		super(message, cause);
	}

	public MarshalFailedException(String message) {
		super(message);
	}

	public MarshalFailedException(Throwable cause) {
		super(cause);
	}

}
