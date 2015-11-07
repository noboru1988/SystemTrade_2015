package controller;

import insertPackage.InsertStock;

import java.util.List;

import netConnect.NetBean;
import proparty.S;
import bean.Bean_TBLRecord;

public class GetTimeSeries {

	//codelisttblをもとに時系列データを各テーブルに挿入する。
	public void getTimeSeries_DD(){
		long start = System.currentTimeMillis();
		List<Bean_TBLRecord> DTO_B_T_List;
		NetBean NB = new  NetBean();

		S s = new S();
		InsertStock IS = new InsertStock();
		s.getCon();
	}

//	//codelisttblをもとに時系列データを各テーブルに挿入する。
//	public void getTimeSeries_DD(){
//		long start = System.currentTimeMillis();
//		List<Bean_TBLRecord> DTO_B_T_List;
//		NetBean NB = new  NetBean();
//
//		S s = new S();
//		InsertStock IS = new InsertStock();
//		s.getCon();
//		TBL_Name.setAllCodeList(s);
//
//
//		//証券とETFのリストをコードリストTBLから拾う
//		TBL_Name.setCodeList_HauhunReplace(s);
//		int TBL_DD_num = TBL_Name.getCodeList_HauhunReplace().size();
//		MaxDay md = new MaxDay();
//
//		md.getMAX_DD_SLUSH();
//		for (int i = 0;i<TBL_DD_num;i++){
//
//			md.setMAX_DD_HAIHUN(TBL_Name.getCodeList_HauhunReplace().get(i),s);
//			DTO_B_T_List = new ArrayList<Bean_TBLRecord>();
//			//-を―に置き換えて挿入している。
//			NB.setCodeDD( DTO_B_T_List ,
//					TBL_Name.getCodeList_HauhunReplace().get(i),md.getMAX_DD_HAIHUN());
//			//-を―に置き換えて挿入している。
//			IS.c_InsertStock_DD(NB.getCodeDD(),
//					(TBL_Name.getCodeList_HauhunReplace().get(i)).replace("-","―"),s);
//		}
//		s.closeConection();
//
//		long stop = System.currentTimeMillis();
//		System.out.println("実行にかかった時間は " + (stop - start) + " ミリ秒です。");
//
//	}
}
