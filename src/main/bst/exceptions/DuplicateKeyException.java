package main.bst.exceptions;

public class DuplicateKeyException extends IllegalArgumentException {

	private static final long serialVersionUID = 1L;

	public DuplicateKeyException() {
		super();
	}

	public DuplicateKeyException(String message) {
		super(message);
	}
}