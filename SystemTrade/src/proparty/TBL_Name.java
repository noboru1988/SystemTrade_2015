package proparty;

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

	private static List<String> codeList = new ArrayList<String>();
	private static List<String> codeList_NoHaihun = new ArrayList<String>();
	static String SQL;


	public static void setCodeList(S s){

		SQL = "select code from " + CODELISTTBL;
		codeList = new ArrayList<String>();

		try {
//			s.p_rs = s.getPstmt().executeQuery(SQL);
			s.rs = s.sqlGetter().executeQuery(SQL);

			while (s.rs.next()) {
				codeList.add(s.rs.getString("code"));
				}

		} catch (SQLException e) {
			// TODO 自動生成された catch ブロック

			e.printStackTrace();
		}
	}

	public static List<String> getCodeList(){
		return codeList;
	}



	public static void setCodeList_NoHauhun(S s){

		SQL = "select code from " + CODELISTTBL;
		codeList_NoHaihun = new ArrayList<String>();

		try {
//			s.p_rs = s.getPstmt().executeQuery(SQL);
			s.rs = s.sqlGetter().executeQuery(SQL);

			while (s.rs.next()) {
				codeList_NoHaihun.add(s.rs.getString("code").replace("-", ""));
				}

		} catch (SQLException e) {
			// TODO 自動生成された catch ブロック

			e.printStackTrace();
		}



	}

	public static List<String> getCodeList_NoHauhun(){
		return codeList_NoHaihun;
	}

}
