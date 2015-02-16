package controller;

import insertPackage.InsertStock;

import java.util.ArrayList;
import java.util.List;

import netConnect.NetBean;
import proparty.MaxDay;
import proparty.S;
import proparty.TBL_Name;
import bean.Bean_TBLRecord;

public class GetTimeSeries {

	public void getTimeSeries_DD(){
		long start = System.currentTimeMillis();
		List<Bean_TBLRecord> DTO_B_T_List;
		NetBean NB = new  NetBean();

		S s = new S();
		InsertStock IS = new InsertStock();
		s.getCon();
		TBL_Name.setCodeList(s);
		int TBL_DD_num = TBL_Name.getCodeList().size();

		TBL_Name.setCodeList_NoHauhun(s);

		MaxDay md = new MaxDay();

		md.getMAX_DD_SLUSH();
		for (int i = 0;i<TBL_DD_num;i++){
			md.setMAX_DD_SLUSH(TBL_Name.getCodeList().get(i),s);

			DTO_B_T_List = new ArrayList<Bean_TBLRecord>();
			NB.setCodeDD( DTO_B_T_List ,TBL_Name.getCodeList().get(i),md.getMAX_DD_SLUSH());
			IS.c_InsertStock_DD(NB.getCodeDD(), TBL_Name.getCodeList_NoHauhun().get(i),s);
		}
		s.closeConection();

		 long stop = System.currentTimeMillis();
		    System.out.println("実行にかかった時間は " + (stop - start) + " ミリ秒です。");

	}
}
