package com.clientname.projectname.generic.webdriverutility;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Random;

public class JavaUtilty {
public int getRandomNum()
{
	Random random= new Random();
	int randomnumber = random.nextInt(1000);
	return randomnumber;
}
public String getSystemDateYYYYDDMM() {
	Date dateobj=new Date();
	SimpleDateFormat sdf =new SimpleDateFormat("yyyy-MM-DD");
	String date= sdf.format(dateobj);
	return date;
	
}
public String getRequiredDateYYYYMMDD(int days) {
	
	SimpleDateFormat sim= new SimpleDateFormat("yyyy-MM-dd");
	Calendar cal = sim.getCalendar();	
	cal.add( Calendar.DAY_OF_MONTH,days);
	String requireddate = sim.format(cal.getTime());
	return requireddate;
}
}
