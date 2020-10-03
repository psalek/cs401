package lesson10.lecture.logging.defaultlogging;

import java.util.logging.LogRecord;
import java.util.logging.SimpleFormatter;

public class CustomerSimpleFormatter extends SimpleFormatter {
	@Override
	public String format(LogRecord record) {
		String retVal = record.getLevel().toString()+": " +
			record.getMessage() + "\r\n";
		return retVal;
	}
}
