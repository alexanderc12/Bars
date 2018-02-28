package models;

public class InvalidParameterException extends IllegalArgumentException{

	
	private static final String MESSAGE = "Parameters not aplicable to create a new graph, the numer of elements must be the same and the first array sum must be 1.";
	private static final long serialVersionUID = 1L;

	public InvalidParameterException() {
		super(MESSAGE);
	}
}
