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

	//テーブルリストTBLから一覧テーブルを作る。証券とETF
	public void createTimeSereisTBL_DD(){
		long start = System.currentTimeMillis();
		createTBL a = new createTBL();
		S s = new S();
		s.getCon();
		TBL_Name.setCodeList_HauhunReplace(s);

		for (int i = 0;i<TBL_Name.getCodeList_HauhunReplace().size();i++){
			//DBをつくるので-を―に変換
			a.dayTable_Stock((TBL_Name.getCodeList_HauhunReplace().get(i)).replace("-", "―"),s);
		}
		
		s.closeConection();
		 long stop = System.currentTimeMillis();
		    System.out.println("実行にかかった時間は " + (stop - start) + " ミリ秒です。");
	}

}
