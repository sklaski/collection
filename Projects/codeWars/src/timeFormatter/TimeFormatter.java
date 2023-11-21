package timeFormatter;

public class TimeFormatter {

	public static String formatDuration(int seconds) {
		if (seconds == 0) {
			return "now";
		}
		String humanReadable = "";
		int minute = 60;
		int minutes = 0;
		int hour = 60 * minute;
		int hours = 0;
		int day = 24 * hour;
		int days = 0;
		int year = 365 * day;
		int years = 0;
		while (seconds >= year) {
			years++;
			seconds -= year;
		}
		while (seconds >= day) {
			days++;
			seconds -= day;
		}
		while (seconds >= hour) {
			hours++;
			seconds -= hour;
		}
		while (seconds >= minute) {
			minutes++;
			seconds -= minute;
		}
		if (years > 0) {
			humanReadable = addString(humanReadable, "year", years);
		}
		if (days > 0) {
			humanReadable = addString(humanReadable, "day", days);
		}
		if (hours > 0) {
			humanReadable = addString(humanReadable, "hour", hours);
		}
		if (minutes > 0) {
			humanReadable = addString(humanReadable, "minute", minutes);
		}
		if (seconds > 0) {
			humanReadable = addString(humanReadable, "second", seconds);
		}
		int latest = humanReadable.lastIndexOf(", ");
		if (latest != -1) {
			StringBuilder replaced = new StringBuilder(humanReadable);
			replaced.setCharAt(latest, '!');
			humanReadable = replaced.toString();
			humanReadable = humanReadable.replace("!", " and");
		}
		return humanReadable;
	}

	private static String addString(String returnString, String timeFormat, int number) {
		if (!returnString.isEmpty()) {
			returnString += ", ";
		}
		returnString += number + " " + timeFormat;
		if (number > 1) {
			returnString += "s";
		}
		return returnString;
	}
}
