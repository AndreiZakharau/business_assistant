package servise.date;

import java.text.ParseException;
import java.text.SimpleDateFormat;

public class DateExpiration extends DateLine {
    SimpleDateFormat fromUser = new SimpleDateFormat("dd.MM.yyyy");
  private static final SimpleDateFormat myFormat = new SimpleDateFormat("yyyy-MM-dd");

        String reformattedString = myFormat.format(fromUser.parse(getDateLine()));

    public DateExpiration(String dateLine) throws ParseException {
        super(dateLine);
    }

    public static SimpleDateFormat getMyFormat() {
        return myFormat;
    }

    public String getReformattedString() {
        return reformattedString;
    }

    @Override
    public String toString() {
        return " reformattedString = " + reformattedString;
    }
}
