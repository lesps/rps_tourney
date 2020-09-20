package com.str.simulation.rpstourney;

/**
 * @author Spencer Lee
 * Implements a logger that logs to the system output.
 */
public class ConsoleLogger implements ILogger {

	/**
	 * Logs input to the console.
	 * @param message The message to log
	 */
	@Override
	public void log(String message) {
		System.out.println(message);
	}

}
