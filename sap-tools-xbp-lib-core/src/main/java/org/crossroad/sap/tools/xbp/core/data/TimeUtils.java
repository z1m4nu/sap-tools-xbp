package org.crossroad.sap.tools.xbp.core.data;

import java.util.concurrent.TimeUnit;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.springframework.lang.NonNull;

public class TimeUtils {

	public static String milliTohms(Long millis) {
		return String.format("%02d:%02d:%02d", TimeUnit.MILLISECONDS.toHours(millis),
				TimeUnit.MILLISECONDS.toMinutes(millis) % TimeUnit.HOURS.toMinutes(1),
				TimeUnit.MILLISECONDS.toSeconds(millis) % TimeUnit.MINUTES.toSeconds(1));
	}

	public static Long parseTime(String time) {
		final Pattern p = Pattern.compile("(\\d+)([hmsd])");
        final Matcher m = p.matcher(time);
        long totalMillis = 0;
        while (m.find())
        {
            final int duration = Integer.parseInt(m.group(1));
            final TimeUnit interval = toTimeUnit(m.group(2));
            final long l = interval.toMillis(duration);
            totalMillis = totalMillis + l;
        }
        
        return totalMillis;
	}
	
    private static TimeUnit toTimeUnit(@NonNull final String c)
    {
        switch (c)
        {
            case "s": return TimeUnit.SECONDS;
            case "m": return TimeUnit.MINUTES;
            case "h": return TimeUnit.HOURS;
            case "d": return TimeUnit.DAYS;
            default: throw new IllegalArgumentException(String.format("%s is not a valid code [smhd]", c));
        }
    }
}
