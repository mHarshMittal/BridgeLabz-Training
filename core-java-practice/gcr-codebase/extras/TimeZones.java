// Time zone and Zone date 

import java.time.ZonedDateTime;
import java.time.ZoneId;


public class TimeZones {
    
    public static void main(String[] args) {
        System.out.println("Current time in different time zones:\n");
        
        ZonedDateTime gmtTime = ZonedDateTime.now(ZoneId.of("GMT"));
        ZonedDateTime istTime = ZonedDateTime.now(ZoneId.of("Asia/Kolkata"));
        ZonedDateTime pstTime = ZonedDateTime.now(ZoneId.of("America/Los_Angeles"));
        
        System.out.println("GMT: " + gmtTime);
        System.out.println("IST: " + istTime);
        System.out.println("PST: " + pstTime);
    }
}

