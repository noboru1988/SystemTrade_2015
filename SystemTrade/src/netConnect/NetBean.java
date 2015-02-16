package netConnect;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.List;

import proparty.Net_Adress;
import proparty.PROPARTY;
import bean.Bean_CodeList;
import bean.Bean_TBLRecord;

public class NetBean extends NetSuper{

	private List<String> codeList_Stock = new ArrayList<String>();
	private List<String[]> codeList_Stock2 = new ArrayList<String[]>();
	private String[] codeList_Stock_Arary;
	private String[] codeList_Stock_Sprit;
	private Bean_CodeList DTO_B_C;
	private Bean_TBLRecord DTO_B_T;
	private List<Bean_CodeList> DTO_B_C_LIST = new ArrayList<Bean_CodeList>();
	private List<Bean_TBLRecord> DTO_B_T_LIST = new ArrayList<Bean_TBLRecord>();
	private int x =0;
	int year;
	private String[][] codeList_Stock_Array2;

	public void setCodeDD(List<Bean_TBLRecord> DTO,String stockName,String MAX_DAY_HAIHUN){

		//重複データを入れないような工夫をしている
		Calendar calendar = Calendar.getInstance();
		int thisYear = calendar.get(Calendar.YEAR);
			setNetCSV(Net_Adress.getTimeSeriesCSV_URL_DD(stockName,thisYear),2,MAX_DAY_HAIHUN);
			System.out.println(Net_Adress.getTimeSeriesCSV_URL_DD(stockName,thisYear));
			System.out.println("1:" + getFlg());
//		int j = 1;
//
//		while(getFlg()==false){
//			setPlusNetCSV(Net_Adress.getTimeSeriesCSV_URL_DD(stockName,thisYear - j),2);
//			j++;
//			System.out.println(j);
//			System.out.println("whie:" + getFlg());
//		}
//		System.out.println("外:" + getFlg());
		for (int k = 1;k<PROPARTY.COLLECTYEAR;k++){
			setPlusNetCSV(Net_Adress.getTimeSeriesCSV_URL_DD(stockName,thisYear - k),2,MAX_DAY_HAIHUN);
			if (getFlg()==false){
				break;
			}
			System.out.println(k);
		}


		codeList_Stock = getNetCSV();
		//MAX_Dの取得
		Collections.sort(codeList_Stock);
		System.out.println(codeList_Stock.size());
		for(int i = 0;i<codeList_Stock.size();i++){
			codeList_Stock_Sprit = codeList_Stock.get(i).split(",") ;
			DTO_B_T = new Bean_TBLRecord();
			DTO_B_T.setDay    (codeList_Stock_Sprit[0]);
			DTO_B_T.setOpen   (codeList_Stock_Sprit[1]);
			DTO_B_T.setMax    (codeList_Stock_Sprit[2]);
			DTO_B_T.setMin    (codeList_Stock_Sprit[3]);
			DTO_B_T.setClose  (codeList_Stock_Sprit[4]);
			DTO_B_T.setDeki   (codeList_Stock_Sprit[5]);
			DTO_B_T.setBaybay (codeList_Stock_Sprit[6]);
			DTO.add(DTO_B_T);
		}

		DTO_B_T_LIST = DTO;
	}

	public List<Bean_TBLRecord> getCodeDD(){
		return DTO_B_T_LIST;
	}

	public void setCodeList_Stock(List<Bean_CodeList> DTO){
		setNetCSV(Net_Adress.CODELIST_STOCK,2);
		codeList_Stock = getNetCSV();
//		codeList_Stockを配列に変換
//		codeList_Stock_Arary =  (String[])codeList_Stock.toArray(new String[0]);
		//ソートする
//		Arrays.sort(codeList_Stock_Arary);
		Collections.sort(codeList_Stock);
		//スプリットする
//		codeList_Stock_Array2 = new String[codeList_Stock_Arary.length][];
		 for(int i=0;i<codeList_Stock.size();i++){
			 DTO_B_C = new Bean_CodeList();

			 codeList_Stock_Sprit = codeList_Stock.get(i).split(",") ;

			 DTO_B_C.setCompany_flg ();
			 DTO_B_C.setCode        (codeList_Stock_Sprit[0]);
			 DTO_B_C.setMarket      (codeList_Stock_Sprit[1]);
			 DTO_B_C.setCodeName    (codeList_Stock_Sprit[2]);
			 DTO_B_C.setCategory    (codeList_Stock_Sprit[3]);
			 DTO.add(DTO_B_C);

		 }

		 DTO_B_C_LIST = DTO;
	}

	//二次元配列で証券コードリストが取得できる。
	public List<Bean_CodeList> getCodeList_Stock(){
		return DTO_B_C_LIST;
	}


}
