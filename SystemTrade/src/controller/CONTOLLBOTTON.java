package controller;

import insertPackage.InsertDay;
import insertPackage.InsertList;

import java.util.List;

import netConnect.NC_Controller;
import netConnect.NetBean;
import proparty.Net_Adress;
import proparty.S;
import bean.Bean_Bean;
import bean.Bean_CodeList;

import common.commonAP;

import createTBL.GetCodeTBL;

public class CONTOLLBOTTON {

	public void everyDayBottonContoroll_STATISTICS(String MAXDAY ,String TODAY,S s){

		if(commonAP.getTODAY(-1).equals(MAXDAY)){

			System.out.println(commonAP.getTODAY(-1));
			everyDayBotton_STATISTICS(s);
			System.out.println("こことおる");

		}else if(commonAP.getTODAY().equals(MAXDAY)){
			//更新日とボタン実行日が同じならここ
			System.out.println("統計更新なし");
		}else{

			hisabisaDayBottonContoroll_STATISTICS(MAXDAY,TODAY,s);

		}
		s.resetConnection();
	}

	public void everyDayBottonContoroll_STOCK_INDEX(String MAXDAY ,String TODAY,S s){


		//更新日が昨日と同じ場合、今日の分だけ更新する。月曜日の場合はあきらめる。
		if(commonAP.getTODAY(-1).equals(MAXDAY)){

			System.out.println(commonAP.getTODAY(-1));
			everyDayBotton_STOCK_INDEX(s);
			System.out.println("こことおる");

		}else if(commonAP.getTODAY().equals(MAXDAY)){
			System.out.println("株更新梨");
		}else{

			hisabisaDayBottonContoroll_STOCK_INDEX(MAXDAY,TODAY,s);

		}


		s.resetConnection();


	}

	private void everyDayBotton_STATISTICS(S s){
		NetBean NB = new NetBean();

		//統計指標
		Bean_Bean bbb = new Bean_Bean();


//		CSVを取得
		try{
			NB.setUrlCsv(Net_Adress.STATISTICS_LIST, 0);
		}catch(Exception o){
			System.out.println("たぶん何かのえらー");
			o.printStackTrace();
			return;
		}


		try{
			//CSVをDTOにする
			bbb.setList_CSVtoDTO_STATISTICA(NB.getUrlCsv(),2);
		}catch(NullPointerException nu){
			System.out.println("なんかヌルポ");
			return;
		}catch(Exception e){
			System.out.println("原因不明");
			e.printStackTrace();
			return;
		}


		//取得したDTOをリストTBLに挿入する。
		//取得したDTOをもとに日々テーブルを作る
		//取得したDTOをもとに時系列テーブルにデータを挿入。ただし今日の文だけ
		InsertList_CreateTBL_DD_InsertDD_TODAY(bbb.getList_CSVtoDTO_STATISTICA(), s);

	}

	//リストTBLに挿入し、テーブルを作り、日々データも入れる。毎日動かすイメージ
	//ただし、リストテーブルの更新日が昨日であるときのみ実行する。
	private void everyDayBotton_STOCK_INDEX(S s){

		NetBean NB = new NetBean();

		//統計指標
		Bean_Bean bbb = new Bean_Bean();


//		CSVを取得
		try{
			NB.setUrlCsv(Net_Adress.STOCK_INDEX_LIST, 0);
		}catch(Exception o){
			System.out.println("たぶん何かのえらー");
			o.printStackTrace();
			return;
		}

		try{
			//CSVをDTOにする
			bbb.setList_CSVtoDTO_STOCK_INDEX(NB.getUrlCsv(),2);
		}catch(NullPointerException nu){
			System.out.println("なんかヌルポ");
			return;
		}catch(Exception e){
			System.out.println("原因不明");
			e.printStackTrace();
			return;
		}

		//取得したDTOをリストTBLに挿入する。
		//取得したDTOをもとに日々テーブルを作る
		//取得したDTOをもとに時系列テーブルにデータを挿入。ただし今日の文だけ
		InsertList_CreateTBL_DD_InsertDD_TODAY(bbb.getList_CSVtoDTO_STOCK_INDEX(), s);


	}


	private void insertDD_STATISTICS(String MAXDAY,String TODAY,S s){
		NC_Controller NC = new NC_Controller();
		Bean_Bean B_B = new Bean_Bean();
		InsertDay ID = new InsertDay();
		NC.setNC_ConUrlCsvS_STATISTICS(TODAY, MAXDAY, 0);
		B_B.setList_CsvStoDTOS_STATISTICA(NC.getNC_ConUrlCsvS_STATISTICS(),2,true);

		ID.InsertDDs_STATISTICS(B_B.getList_CsvStoDTOS_STATISTICA(), s);

	}

	private void insertDD_STOCK_INDEX(String MAXDAY,String TODAY,S s){
		NC_Controller NC = new NC_Controller();
		Bean_Bean B_B = new Bean_Bean();
		InsertDay ID = new InsertDay();
		NC.setNC_ConUrlCsvS_STOCK_INDEX(Net_Adress.STOCK_INDEX_LIST_DATE, TODAY, MAXDAY, 0);
		B_B.setList_CsvStoDTOS_STOCK_INDEX(NC.getNC_ConUrlCsvS_STOCK_INDEX(),2,true);

		ID.InsertDDs_STOCK_INDEX(B_B.getList_CsvStoDTOS_STOCK_INDEX(), s);


	}


//	リストTBLに挿入し、テーブルを作り、日々データも入れる。毎日動かすイメージ
	//ただし、リストテーブルの更新日が昨日ではないときのみ実行する。
	private void hisabisaDayBottonContoroll_STATISTICS(String MAXDAY , String TODAY , S s){
		NetBean NB = new NetBean();

		//統計指標
		Bean_Bean bbb = new Bean_Bean();

//		CSVを取得
		try{
			NB.setUrlCsv(Net_Adress.STATISTICS_LIST, 0);
		}catch(Exception o){
			System.out.println("たぶん何かのえらー");
			o.printStackTrace();
			return;
		}


		try{
			//CSVをDTOにする
			bbb.setList_CSVtoDTO_STATISTICA(NB.getUrlCsv(),2);
		}catch(NullPointerException nu){
			System.out.println("なんかヌルポ");
			return;
		}catch(Exception e){
			System.out.println("原因不明");
			e.printStackTrace();
			return;
		}

		//取得したDTOをリストTBLに挿入する。
		//取得したDTOをもとに日々テーブルを作る
		InsertList_CreateTBL_DD_hisabisa(bbb.getList_CSVtoDTO_STATISTICA(), s);

		insertDD_STATISTICS(MAXDAY,TODAY,s);

	}
	//リストTBLに挿入し、テーブルを作り、日々データも入れる。毎日動かすイメージ
	//ただし、リストテーブルの更新日が昨日ではないときのみ実行する。
	private void hisabisaDayBottonContoroll_STOCK_INDEX(String MAXDAY , String TODAY , S s){

		NetBean NB = new NetBean();

		//株と指数
		Bean_Bean bbb = new Bean_Bean();


//		CSVを取得
		try{
			NB.setUrlCsv(Net_Adress.STOCK_INDEX_LIST, 0);
		}catch(Exception o){
			System.out.println("たぶん何かのえらー");
			o.printStackTrace();
			return;
		}

		try{
			//CSVをDTOにする
			bbb.setList_CSVtoDTO_STOCK_INDEX(NB.getUrlCsv(),2);
		}catch(NullPointerException nu){
			System.out.println("なんかヌルポ");
			return;
		}catch(Exception e){
			System.out.println("原因不明");
			e.printStackTrace();
			return;
		}


		//取得したDTOをリストTBLに挿入する。
		//取得したDTOをもとに日々テーブルを作る
		InsertList_CreateTBL_DD_hisabisa(bbb.getList_CSVtoDTO_STOCK_INDEX(), s);


		//MAXDAYから今日までのデータをインサート開始。ストック、インデックス、統計も全部

		insertDD_STOCK_INDEX(MAXDAY,TODAY,s);
	}

	private void InsertList_CreateTBL_DD(List<Bean_CodeList> DTO ,S s){
		InsertList BBB = new InsertList();
		GetCodeTBL GCL = new GetCodeTBL();

		//取得したDTOをリストTBLに挿入する。
		BBB.InsertList_Day(DTO, s);

		//取得したDTOをもとに日々テーブルを作る
//		GCL.controll_CreateTBL_DD(DTO, s);
	}

	private void InsertList_CreateTBL_DD_InsertDD_TODAY(List<Bean_CodeList> DTO ,S s){
		InsertDay ID = new InsertDay();
		//取得したDTOをリストTBLに挿入する。
		//取得したDTOをもとに日々テーブルを作る
		InsertList_CreateTBL_DD(DTO, s);
		//取得したDTOをもとに時系列テーブルにデータを挿入
		ID.InsertDD(DTO, s);

	}

	private void InsertList_CreateTBL_DD_hisabisa(List<Bean_CodeList> DTO ,S s){
		//取得したDTOをリストTBLに挿入する。
		//取得したDTOをもとに日々テーブルを作る
		InsertList_CreateTBL_DD(DTO, s);

		//取得したDTOをもとに時系列テーブルにデータを挿入

	}

}
