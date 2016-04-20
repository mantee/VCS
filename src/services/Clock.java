package services;

import javax.swing.*;
import java.text.DateFormat;
import java.text.Format;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class Clock extends Date {
    private DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    private Calendar cal = null;
    protected int ok = 1;

    public Clock() throws ParseException {
        String date = "2016-01-01 00:00:00";
        cal = Calendar.getInstance();
        String startingDate = date;
        cal.setTime(dateFormat.parse(startingDate));
    }

    public String calFormat(Calendar cal) {
        return dateFormat.format(cal.getTime());
    }

    public Calendar addOneDay() {
        cal.add(Calendar.DATE, 1);
        return cal;
    }

    public Calendar addOneSecond() {
        cal.add(Calendar.SECOND, 1);
        return cal;
    }

    public Calendar getCurrentDateCal() {
        cal.add(Calendar.DATE, 1);
        return cal;
    }

    public String getCurrentDateString() {
        return calFormat(cal);
    }

    public void displayDateTime(final Clock cl, final JLabel label)
    {
        ScheduledExecutorService exec = Executors.newSingleThreadScheduledExecutor();
        exec.scheduleAtFixedRate(new Runnable() {
            @Override
            public void run() {
                cl.addOneSecond();
                label.setText(cl.getCurrentDateString());
            }
        }, 0, 1, TimeUnit.SECONDS);
    }

}
