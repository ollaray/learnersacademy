package com.simplilearn.util;

import java.text.SimpleDateFormat;
import java.time.Instant;
import java.util.Date;

public class Utility {
	 public static Long getUnixTimeStamp() {
		 long unixTime = Instant.now().getEpochSecond();
		 return unixTime;
	 }
	 
	 public static String convertUnixTimeStamp(Long unixTime) {
		 unixTime = unixTime * 1000;
		 String date = new SimpleDateFormat("yyyy-MM-dd").format(new Date(unixTime));
		 
		 return date;
	 }
}
