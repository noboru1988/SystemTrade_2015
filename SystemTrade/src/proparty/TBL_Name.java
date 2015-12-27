package proparty;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class TBL_Name {

	public static String CODELISTTBL     = "codeListTBL";
	public static String TAIL_MONTH      = "_MM";
	public static String TAIL_WEEK       = "_WW";
	public static String TAIL_DAY        = "_DD";
	public static String TAIL_HOUR       = "_HH";
	public static String TAIL_5Minite    = "_5M";
	public static String TAIL_Accessories   = "_AC";

	private static List<String> codeNewList = new ArrayList<String>(); //コードリストテーブルのうち、日付の新しいものをとる。
	private static List<String> codeAllList = new ArrayList<String>();
	private static List<String> codeList_HaihunReplace = new ArrayList<String>();
	private static List<String> statisticalList_HaihunReplace = new ArrayList<String>();
	private static List<String> indexList_HaihunReplace = new ArrayList<String>();
	private static List<String> futureList_HaihunReplace = new ArrayList<String>();
	private static List<String> currency_HaihunReplace = new ArrayList<String>();
	static String SQL;

	private static ResultSet rs = null;



//	IDのMAXのレコードをとる
	public static void setMAXID(String TBLName,int MAXNUM,S s){
		//MAXNUMは最大N件とってくる
		SQL = "select * from " + TBLName + " where ID(MAX)";
		try {
			rs = s.sqlGetter().executeQuery(SQL);
		} catch (SQLException e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
		}
	}

//	IDのMAXのレコードをとる
	public static void setMAXID(String TBLName,S s){
		SQL = "select * from " + TBLName + " where ID(MAX)";

		try {
			rs = s.sqlGetter().executeQuery(SQL);
		} catch (SQLException e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
		}
	}

	public static ResultSet getMAXID(){
		return rs;
	}


//テーブルの名前がそのままとれる
	public static void setAllCodeList(S s){

		SQL = "select code from " + CODELISTTBL;
		codeAllList = new ArrayList<String>();

		try {
//			s.p_rs = s.getPstmt().executeQuery(SQL);
			s.rs = s.sqlGetter().executeQuery(SQL);

			while (s.rs.next()) {
				codeAllList.add(s.rs.getString("code"));
				}

		} catch (SQLException e) {
			// TODO 自動生成された catch ブロック

			e.printStackTrace();
		}
	}

	public static List<String> getAllCodeList(){
		return codeAllList;
	}

	public static void setNewCodeList(S s){

		SQL = "select code from " + CODELISTTBL;
		codeAllList = new ArrayList<String>();

		try {
//			s.p_rs = s.getPstmt().executeQuery(SQL);
			s.rs = s.sqlGetter().executeQuery(SQL);

			while (s.rs.next()) {
				codeNewList.add(s.rs.getString("code"));
				}

		} catch (SQLException e) {
			// TODO 自動生成された catch ブロック

			e.printStackTrace();
		}
	}

	public static List<String> getNewCodeList(){
		return codeNewList;
	}

//テーブルの名前のうち"-"を"―"に置換して取得
	public static void setCodeList_HauhunReplace(S s){

		SQL = "select code from " + CODELISTTBL + " where etf_flg = true or company_flg = true";
		codeList_HaihunReplace = new ArrayList<String>();

		try {
//			s.p_rs = s.getPstmt().executeQuery(SQL);
			s.rs = s.sqlGetter().executeQuery(SQL);

			while (s.rs.next()) {
				codeList_HaihunReplace.add(s.rs.getString("code").replace("―", "-"));
				}

		} catch (SQLException e) {
			// TODO 自動生成された catch ブロック

			e.printStackTrace();
		}



	}

	public static List<String> getCodeList_HauhunReplace(){

		return codeList_HaihunReplace;
	}


	public static void setStatisticalList_HauhunReplace(S s){
		SQL = "select code from " + CODELISTTBL + " where statistical_flg = true ";
		statisticalList_HaihunReplace = new ArrayList<String>();

		try {
//			s.p_rs = s.getPstmt().executeQuery(SQL);
			s.rs = s.sqlGetter().executeQuery(SQL);

			while (s.rs.next()) {
				statisticalList_HaihunReplace.add(s.rs.getString("code").replace("―", "-"));
				}

		} catch (SQLException e) {
			// TODO 自動生成された catch ブロック

			e.printStackTrace();
		}
	}

	public static List<String> getStatisticalList_HauhunReplace(){
		return statisticalList_HaihunReplace;
	}


	public static void setIndexList_HauhunReplace(S s){
		SQL = "select code from " + CODELISTTBL + " where index_flg = true ";
		indexList_HaihunReplace = new ArrayList<String>();

		try {
//			s.p_rs = s.getPstmt().executeQuery(SQL);
			s.rs = s.sqlGetter().executeQuery(SQL);

			while (s.rs.next()) {
				indexList_HaihunReplace.add(s.rs.getString("code").replace("―", "-"));
				}

		} catch (SQLException e) {
			// TODO 自動生成された catch ブロック

			e.printStackTrace();
		}
	}

	public static List<String> getIndexList_HauhunReplace(){
		return indexList_HaihunReplace;
	}

	public static void setFutureList_HauhunReplace(S s){
		SQL = "select code from " + CODELISTTBL + " where future_flg = true ";
		futureList_HaihunReplace = new ArrayList<String>();

		try {
//			s.p_rs = s.getPstmt().executeQuery(SQL);
			s.rs = s.sqlGetter().executeQuery(SQL);

			while (s.rs.next()) {
				futureList_HaihunReplace.add(s.rs.getString("code").replace("―", "-"));
				}

		} catch (SQLException e) {
			// TODO 自動生成された catch ブロック

			e.printStackTrace();
		}
	}

	public static List<String> getFutureList_HauhunReplace(){
		return futureList_HaihunReplace;
	}


	public static void setCurrecyList_HauhunReplace(S s){
		SQL = "select code from " + CODELISTTBL + " where currency_flg = true ";
		currency_HaihunReplace = new ArrayList<String>();

		try {
//			s.p_rs = s.getPstmt().executeQuery(SQL);
			s.rs = s.sqlGetter().executeQuery(SQL);

			while (s.rs.next()) {
				currency_HaihunReplace.add(s.rs.getString("code").replace("―", "-"));
				}

		} catch (SQLException e) {
			// TODO 自動生成された catch ブロック

			e.printStackTrace();
		}
	}

	public static List<String> getCurrencyList_HauhunReplace(){
		return currency_HaihunReplace;
	}

}
