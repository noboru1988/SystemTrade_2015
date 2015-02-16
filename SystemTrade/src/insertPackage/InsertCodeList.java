package insertPackage;

import java.sql.SQLException;
import java.util.List;

import proparty.Insert_Pstmt;
import proparty.S;
import proparty.TBL_Name;
import bean.Bean_CodeList;

public class InsertCodeList extends InsertSuper  {
//	頭文字がCならまとめてインポート、Sなら単発
	String SQL;
	S s = new S();

	public void c_Controller(String methodName,List<Bean_CodeList> beanList ,S s){
		superCODEList("InsertCodeList",methodName,beanList,s);
	}

	public void c_InsertStockList(List<Bean_CodeList> B_C_List,S s){
		int Num = B_C_List.size();
		if (Num == 0){
			return;
		}

		SQL = "insert into " + TBL_Name.CODELISTTBL + " (code,codeName,market,category,company_flg,etf_flg) values " + Insert_Pstmt.insertFooder(6,Num);

		s.setPstmt(SQL);
		for (int i = 0;i<Num;i++){

			try {

				s.getPstmt().setString( i*6+ 1, B_C_List.get(i).getCode());
				s.getPstmt().setString( i*6+ 2, B_C_List.get(i).getCodeName());
				s.getPstmt().setString( i*6+ 3, B_C_List.get(i).getMarket());
				s.getPstmt().setString( i*6+ 4, B_C_List.get(i).getCategory());
				s.getPstmt().setString( i*6+ 5, B_C_List.get(i).getCompany_flg());
				s.getPstmt().setString( i*6+ 6, B_C_List.get(i).getEtf_flg());



			} catch (SQLException e) {
				// TODO 自動生成された catch ブロック
//				System.out.println("いっぱい");
//				e.printStackTrace();
			}
		}
		try {
			s.getPstmt().executeUpdate();
		} catch (SQLException e) {
			// TODO 自動生成された catch ブロック
						c_Controller("s_InsertClassList",B_C_List,s);

//			e.printStackTrace();
		}finally{

		}
	}

	public void s_InsertClassList(Bean_CodeList B_C,S s){

		SQL = "insert into " + TBL_Name.CODELISTTBL + " (code,codeName,market,category,company_flg,etf_flg) values (?,?,?,?,?,?)";

		s.setPstmt(SQL);

				try {
					s.getPstmt().setString(  1, B_C.getCode());
					s.getPstmt().setString(  2, B_C.getCodeName());
					s.getPstmt().setString(  3, B_C.getMarket());
					s.getPstmt().setString(  4, B_C.getCategory());
					s.getPstmt().setString(  5, B_C.getCompany_flg());
					s.getPstmt().setString(  6, B_C.getEtf_flg());

					s.getPstmt().executeUpdate();
				} catch (SQLException e) {
					// TODO 自動生成された catch ブロック
					e.printStackTrace();

					System.out.println("ミスったのは：" + B_C.getCode());

				}
	}
}
