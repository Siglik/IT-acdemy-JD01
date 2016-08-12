/**
 * 
 */
package org.qqq175.it_academy.jd1.airline;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * singleton logger
 * @author qqq175
 *
 */
public class Logger {
	private static final String USER_ACTIONS_LOG_PATH = "resources/log/user_action.log";
	private static final String ERROR_LOG_PATH = "resources/log/error.log";
	
	private static volatile Logger instance;
	
	private BufferedWriter actionLog;
	
	private BufferedWriter errorLog;
	
	private SimpleDateFormat dateFormat;
	/* logger clossed flag */
	private boolean closed = false;
	
	/**
	 * private constructor
	 */
	private Logger(){
		File errorLogFile = new File(ERROR_LOG_PATH);
		File actionLogFile = new File(USER_ACTIONS_LOG_PATH);
		
		//create fies if not exist
		//dir resources/log/ is must be exist
		try {
			errorLogFile.createNewFile();
			actionLogFile.createNewFile();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		/*create log writers */
		try {
			errorLog = new BufferedWriter(new FileWriter(errorLogFile, true));
			actionLog = new BufferedWriter(new FileWriter(actionLogFile, true));
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		/*specify logging date-time format*/
		dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	}
	
	/**
	 * Create and returns logger instance
	 * @return logger instance
	 */
	public static Logger getInstance(){
		if (instance == null){
			synchronized(Logger.class){
				if (instance == null){
					instance = new Logger();
				}
			}
		}
		return instance;
	}
	
	/**
	 * write message to error log
	 * @param message
	 */
	public void logErr(String message){
		if (!closed) {
			try {
				errorLog.append("[" + dateFormat.format(new Date()) + "] - " + message + "\n");
			} catch (IOException e) {
				try {
					errorLog.close();
				} catch (IOException eInner) {
					eInner.printStackTrace();
				}
				e.printStackTrace();
			}
			
			// duplicate errors in user actions log
			logAction("ERROR: " + message);
		}
	}

	/**
	 * write message to user actions log
	 * @param message
	 */
	public void logAction(String message) {
		if (!closed) {
			try {
				actionLog.append("[" + dateFormat.format(new Date()) + "] - " + message + "\n");
			} catch (IOException e) {
				try {
					actionLog.close();
				} catch (IOException eInner) {
					eInner.printStackTrace();
				}
				e.printStackTrace();
			}
		}
	}
	
	/**
	 * close current logger and log writers
	 */
	public void close(){
		try {
			errorLog.close();
			actionLog.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		closed = true;
		instance = null;
	}
}
