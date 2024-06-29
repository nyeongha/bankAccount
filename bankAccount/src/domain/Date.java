package domain;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class Date {
    private static final DateTimeFormatter DATE_FORMAT = DateTimeFormatter.ofPattern("yyyy년 MM월 dd일");
    private static final DateTimeFormatter TIME_FORMAT = DateTimeFormatter.ofPattern("HH시 mm분 ss초");
    private LocalDate date;
    private LocalTime time;

    public Date() {
        this.date = LocalDate.now();
        this.time = LocalTime.now();
    }

    public String getDate(){
        return date.format(DATE_FORMAT);
    }

    public String getTime(){
        return time.format(TIME_FORMAT);
    }
}
