package controller;
import insertPackage.InsertCodeList;

import java.util.ArrayList;
import java.util.List;

import netConnect.NetBean;
import proparty.S;
import bean.Bean_CodeList;

public class GetCodeList {

	//個別銘柄の証券コード一覧とETF一覧を取得する。
	public void controllGetStockList(){

		 long start = System.currentTimeMillis();

		 NetBean NB = new  NetBean();
		 InsertCodeList ICL = new InsertCodeList();
		 S s = new S();
		 List<Bean_CodeList> DTO_B_C_List = new ArrayList();
		 s.getCon();
		 //CSVをキャプチャ
		 NB.setCodeList_Stock(DTO_B_C_List);
		 //インポート開始！
		 ICL.c_InsertStockList(NB.getCodeList_Stock(),s);
		 s.closeConection();
		 long stop = System.currentTimeMillis();
		    System.out.println("実行にかかった時間は " + (stop - start) + " ミリ秒です。");


	}
}
