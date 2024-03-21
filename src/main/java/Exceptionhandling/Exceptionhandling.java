package Exceptionhandling;


	public class Exceptionhandling extends RuntimeException {

		public Exceptionhandling(String message) {
			super(message);
		}

		public Exceptionhandling(String message, Throwable cause) {
			super(message, cause);
		}
	}
