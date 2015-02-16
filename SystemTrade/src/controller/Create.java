package controller;

import proparty.S;
import proparty.TBL_Name;
import sql.createTBL;

public class Create {
	String SQL;
	public void createCodeTBL(){

		createTBL a = new createTBL();

		a.createCodeList();

	}

	public void createTimeSereisTBL_DD(){
		long start = System.currentTimeMillis();
		createTBL a = new createTBL();
		S s = new S();
		s.getCon();
		TBL_Name.setCodeList_NoHauhun(s);

		for (int i = 0;i<TBL_Name.getCodeList_NoHauhun().size();i++){
			a.dayTable(TBL_Name.getCodeList_NoHauhun().get(i),s);
		}

		s.closeConection();
		 long stop = System.currentTimeMillis();
		    System.out.println("実行にかかった時間は " + (stop - start) + " ミリ秒です。");
	}

}
