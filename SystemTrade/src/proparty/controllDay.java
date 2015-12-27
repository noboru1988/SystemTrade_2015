package proparty;

import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import common.commonAP;

import constant.COLUMN;
import constant.ReCord;

public class controllDay {

	static String SQL;
	static String MAXDAY;
	static String TBLName;



	public static String getAJUSTMAXDAY_STATISTICS(S s){
		Calendar calendar = Calendar.getInstance();
		SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy-MM-dd");
		//String"yyyy-mm-dd"できた日付を分割
		MAXDAY =  getMAX_DD_STATISTICS(s);
		String[] TODAYMAX_SPRIT = MAXDAY.split("-");
		String[] TODAY_SPRIT = getTODAY().split("-");

		int MAX_int = Integer.parseInt(TODAYMAX_SPRIT[0]);
		int TODAY_int = Integer.parseInt(TODAY_SPRIT[0]);

		//三年以上更新していない場合、MAX+730日を今日とする。
		if((TODAY_int-MAX_int)>PROPARTY.HISABISAYEAR){
			//今日の日付をカレンダーにいれまーす。
			//月だけ0 ＝ 1月
			calendar.set(Integer.parseInt(TODAYMAX_SPRIT[0]), Integer.parseInt(TODAYMAX_SPRIT[1]) - 1, Integer.parseInt(TODAYMAX_SPRIT[2]));

			calendar.add(Calendar.DAY_OF_MONTH, PROPARTY.HISABISADAY);
			MAXDAY = sdf1.format(calendar.getTime());
			return MAXDAY;
		}else{

			return MAXDAY;
		}


	}

	public static String getAJUSTMAXDAY_STOCK_INDEX(S s){
		Calendar calendar = Calendar.getInstance();
		SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy-MM-dd");
		//String"yyyy-mm-dd"できた日付を分割
		MAXDAY =  getMAX_DD_STOCK_INDEX(s);
		String[] TODAYMAX_SPRIT = MAXDAY.split("-");
		String[] TODAY_SPRIT = getTODAY().split("-");

		int MAX_int = Integer.parseInt(TODAYMAX_SPRIT[0]);
		int TODAY_int = Integer.parseInt(TODAY_SPRIT[0]);

		//三年以上更新していない場合、MAX+730日を今日とする。
		if((TODAY_int-MAX_int)>PROPARTY.HISABISAYEAR){
			//今日の日付をカレンダーにいれまーす。
			//月だけ0 ＝ 1月
			calendar.set(Integer.parseInt(TODAYMAX_SPRIT[0]), Integer.parseInt(TODAYMAX_SPRIT[1]) - 1, Integer.parseInt(TODAYMAX_SPRIT[2]));

			calendar.add(Calendar.DAY_OF_MONTH, PROPARTY.HISABISADAY);
			MAXDAY = sdf1.format(calendar.getTime());

			return MAXDAY;
		}else{

			return MAXDAY;
		}

	}

	public static void update_STOCK_INDEX(String updateDay,S s){
		SQL = "update " + TBL_Name.CODELISTTBL
				+ " set "
				+ COLUMN.CODENAME + " = '" + updateDay + "'"
				+ " where "
				+ COLUMN.CODE + " = '" + ReCord.KOSHINBI_STOCK_INDEX + "'";
		s.freeUpdateQuery(SQL);

	}

	public static void update_STATISTICS(String updateDay,S s){
		SQL = "update " + TBL_Name.CODELISTTBL
				+ " set "
				+ COLUMN.CODENAME + " = '" + updateDay + "'"
				+ " where "
				+ COLUMN.CODE + " = '" + ReCord.KOSHINBI_STATISTICS + "'";
		s.freeUpdateQuery(SQL);
	}

	//今日の日付をyyyy-mm-ddでとる
	public static String getTODAY(){
		Calendar calendar = Calendar.getInstance();
		SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy-MM-dd");

		calendar.add(Calendar.DAY_OF_MONTH, 0);
		return sdf1.format(calendar.getTime());

	}

	//YYYY-MM-DDでとってくる
	public static String getMAX_DD_STOCK_INDEX(S s){

		//-を―に変える。DBには―で入っている

		SQL = "select " + COLUMN.CODENAME + " from " + TBL_Name.CODELISTTBL + " where " + COLUMN.CODE + " ='" + ReCord.KOSHINBI_STOCK_INDEX + "'";

		s.setPstmt(SQL);

		try {

			s.p_rs = s.getPstmt().executeQuery(SQL);

			while (s.p_rs.next()) {

				MAXDAY = s.p_rs.getString(commonAP.cutBlank(COLUMN.CODENAME));

			}
//			System.out.println(TBLName + "のMAX(setMAX_DD_HAIHUN)：" + MAX_HAIHUN);
		} catch (SQLException e) {
			e.printStackTrace();
			// TODO 自動生成された catch ブロック
		} catch(NullPointerException e1){


		}

		return MAXDAY;
	}

	public static String getMAX_DD_STATISTICS(S s){

		//-を―に変える。DBには―で入っている

		SQL = "select " + COLUMN.CODENAME + " from " + TBL_Name.CODELISTTBL + " where " + COLUMN.CODE + " ='" + ReCord.KOSHINBI_STATISTICS + "'";

		s.setPstmt(SQL);

		try {

			s.p_rs = s.getPstmt().executeQuery(SQL);

			while (s.p_rs.next()) {

				MAXDAY = s.p_rs.getString(commonAP.cutBlank(COLUMN.CODENAME));

			}
//			System.out.println(TBLName + "のMAX(setMAX_DD_HAIHUN)：" + MAX_HAIHUN);
		} catch (SQLException e) {
			e.printStackTrace();
			// TODO 自動生成された catch ブロック
		} catch(NullPointerException e1){


		}

		return MAXDAY;
	}


}