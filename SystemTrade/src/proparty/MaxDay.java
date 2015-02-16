package proparty;

import java.sql.SQLException;
import java.text.SimpleDateFormat;

public class MaxDay {
	static String MAX_HAIHUN;
	static String MAX_SLUSH;
	static String SQL;


	public static void preparedSetMaX_DD(){

	}


	//YYYY/MM/DDでとってくる
	public static void setMAX_DD_SLUSH(String TBLName,S s){
		MAX_SLUSH = null;
		TBLName = TBLName + TBL_Name.TAIL_DAY;
		SQL = "select max(dayTime) from " + TBLName;
		s.setPstmt(SQL);
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");
		try {
			s.p_rs = s.getPstmt().executeQuery(SQL);

			while (s.p_rs.next()) {
				MAX_SLUSH = sdf.format(s.p_rs.getDate("dayTime")).toString();
			}

		} catch (SQLException e) {
			// TODO 自動生成された catch ブロック
		}

		if (MAX_SLUSH==null){
			MAX_SLUSH = "1900/01/01";
		}

	}

	//YYYY-MM-DDでとってくる
	public static void setMAX_DD_HAIHUN(String TBLName,S s){
		MAX_HAIHUN = null;
		TBLName = TBLName + TBL_Name.TAIL_DAY;
		SQL = "select max(dayTime) from " + TBLName;
		s.setPstmt(SQL);

		try {

			s.p_rs = s.getPstmt().executeQuery(SQL);

			while (s.p_rs.next()) {
				MAX_HAIHUN = s.p_rs.getDate(1).toString();

			}
			System.out.println(TBLName + "のMAX：" + MAX_HAIHUN);
		} catch (SQLException e) {
			e.printStackTrace();
			// TODO 自動生成された catch ブロック
		} catch(NullPointerException e1){
			MAX_HAIHUN = "1900-01-01";
		}

		if (MAX_HAIHUN==null){
			MAX_HAIHUN = "1900-01-01";
		}

	}

	public String getMAX_DD_HAIHUN(){
		return MAX_HAIHUN;
	}

	public String getMAX_DD_SLUSH(){
		return MAX_SLUSH;
	}
}
