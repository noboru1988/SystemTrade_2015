package timeSeriesDTO;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import proparty.S;
import proparty.TBL_Name;
import bean.Bean_CodeList;
import constant.COLUMN;

public class DayTimeSeries {
	static String SQL;
	private List<List<Bean_CodeList>> B_Css  = new ArrayList<List<Bean_CodeList>>();
	private List<Bean_CodeList> B_Cs  = new ArrayList<Bean_CodeList>();
	
	static public void setListCode(S s){
		SQL = "select " + COLUMN.CODE + " from " + TBL_Name.CODELISTTBL;
		
		
		try {
			s.rs = s.sqlGetter().executeQuery(SQL);
			while (s.rs.next()) {
				Bean_CodeList B_C = new Bean_CodeList();
				//MAXDAY = s.p_rs.getString(commonAP.cutBlank(COLUMN.CODENAME));
//				B_Cs.add(B_C);
			}
		} catch (SQLException e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
		}
		
		
	}


	static public void setListCode(String cate,S s){
		SQL = "select " + COLUMN.CODE + " from " + TBL_Name.CODELISTTBL + " where " + COLUMN.CATE_FLG + " = '" + cate + "'";

	}


	static public void getListCode(S s){

	}
}
