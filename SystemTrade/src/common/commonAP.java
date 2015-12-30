package common;

import java.text.SimpleDateFormat;
import java.util.Calendar;

import proparty.S;

public class commonAP {

	public boolean checkMAX(S s){
		return true;
	}

	//TODAYとMAXDAYを比較して、TODAYがMAX以後ならTRUE、以前ならfalse
	public boolean checkDay(String TODAY,String MAXDAY){

		if(TODAY.compareTo(MAXDAY)<=0){
			return false;
		}

		return true;
	}

	public static String cutBlank(String letter){
		letter = letter.replaceAll(" ", "");
		return letter;
	}

	//yyyy-mm-ddで返す
	public static String getTODAY(){

		Calendar calendar = Calendar.getInstance();
		SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy-MM-dd");

//		calendar.set(2006, 0, 14);
		calendar.add(Calendar.DAY_OF_MONTH, 0);
		return sdf1.format(calendar.getTime());


//		calendar.add(Calendar.DAY_OF_MONTH, 1);
//		System.out.println(sdf1.format(calendar.getTime()));
//		calendar.add(Calendar.DAY_OF_MONTH, 2);
//		System.out.println(sdf1.format(calendar.getTime()));
	}

	//yyyy-mm-ddで返す
	//引数で入力した分だけ過去をかえす。
	//(例)-1；一日前、-2：二日前、1：一日後、2：二日後
	public static String getTODAY(int agoDay){

		Calendar calendar = Calendar.getInstance();
		SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy-MM-dd");

//		calendar.set(2006, 0, 14);
		calendar.add(Calendar.DAY_OF_MONTH, agoDay);
		return sdf1.format(calendar.getTime());


//		calendar.add(Calendar.DAY_OF_MONTH, 1);
//		System.out.println(sdf1.format(calendar.getTime()));
//		calendar.add(Calendar.DAY_OF_MONTH, 2);
//		System.out.println(sdf1.format(calendar.getTime()));
	}

}
