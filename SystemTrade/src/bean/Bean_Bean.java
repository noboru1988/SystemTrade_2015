package bean;

import java.util.ArrayList;
import java.util.List;

public class Bean_Bean {


	private List<Bean_CodeList> B_Cs = new ArrayList<Bean_CodeList>();
	private List<List<Bean_CodeList>> B_Css  = new ArrayList<List<Bean_CodeList>>();

	private List<Bean_FinancialStatement> B_F = null;
	private List<Bean_Oneline> B_O = null;
	private List<Bean_TBLRecord> B_T = null;

	private List<String> netFile = new ArrayList<String>();
	private List<List<String>> netFileS = new ArrayList<List <String>>();
	private List<List<List<String>>> netFileSS = new ArrayList<List<List <String>>>();


	public void setList_CsvStoDTOS_STATISTICA(List<List<String>> CsvS,int skipLine){
		for(int i=0;i<CsvS.size();i++){

				B_Cs = new ArrayList<Bean_CodeList>();

			setList_CSVtoDTO_STATISTICA(CsvS.get(i),skipLine);

			B_Css.add(getList_CSVtoDTO_STATISTICA());

		}

	}

	public void setList_CsvStoDTOS_STATISTICA(List<List<String>> CsvS,int skipLine,boolean judge){
		int p = CsvS.size()-1;
		for(int i = p ; i >= 0 ; i--){

			B_Cs = new ArrayList<Bean_CodeList>();

			setList_CSVtoDTO_STATISTICA(CsvS.get(i),skipLine);

			B_Css.add(getList_CSVtoDTO_STATISTICA());

		}
	}

	public List<List<Bean_CodeList>> getList_CsvStoDTOS_STATISTICA(){
		return B_Css;
	}


	public void setList_CsvStoDTOS_STOCK_INDEX(List<List<String>> CsvS,int skipLine){
		for(int i=0;i<CsvS.size();i++){
			B_Cs = new ArrayList<Bean_CodeList>();
			setList_CSVtoDTO_STOCK_INDEX(CsvS.get(i),skipLine);
			B_Css.add(getList_CSVtoDTO_STOCK_INDEX());
		}
	}

	public void setList_CsvStoDTOS_STOCK_INDEX(List<List<String>> CsvS,int skipLine,boolean judge){
		int p = CsvS.size()-1;
		for(int i = p ; i >= 0 ; i--){

			B_Cs = new ArrayList<Bean_CodeList>();
			setList_CSVtoDTO_STOCK_INDEX(CsvS.get(i),skipLine);
			B_Css.add(getList_CSVtoDTO_STOCK_INDEX());
		}
	}

	public List<List<Bean_CodeList>> getList_CsvStoDTOS_STOCK_INDEX(){
		return B_Css;
	}

	public void setList_CSVtoDTO_STATISTICA(List<String> listCSV,int skipLine){
		//2015年12月04日 一行目にこんな感じで日付が入っている。

		String DAY = listCSV.get(0);
		for(int i = skipLine;i<listCSV.size();i++){
			Bean_CodeList B_C = new Bean_CodeList();
			String[] listCSV_SPRIT = listCSV.get(i).split(",");


			B_C.setDay					(DAY);
			B_C.setCode					(listCSV_SPRIT[0]);
			B_C.setCodeName				(listCSV_SPRIT[0]);
			B_C.setDeki					(listCSV_SPRIT[1]);
			B_C.setBaybay				(listCSV_SPRIT[2]);
			B_C.setStockCount			(listCSV_SPRIT[3]);
			B_C.setTakePrice			(listCSV_SPRIT[4]);
			B_C.setUpPrice				(listCSV_SPRIT[5]);
			B_C.setNoChange				(listCSV_SPRIT[6]);
			B_C.setDownPrice			(listCSV_SPRIT[7]);
			B_C.setNoCompare			(listCSV_SPRIT[8]);
			B_C.setCatelfg("2");
			B_Cs.add(B_C);

		}

	}

	public List<Bean_CodeList> getList_CSVtoDTO_STATISTICA(){
		return B_Cs;
	}

	public void setList_CSVtoDTO_STOCK_INDEX(List<String> listCSV,int skipLine){
		//一行目に2015-12-04,全銘柄日足,http://k-db.com/ ←こんな感じではいっているので分割する。
		String[] DAY_SPRIT = listCSV.get(0).split(",");
		String DAY = DAY_SPRIT[0];

		for(int i = skipLine;i<listCSV.size();i++){
			Bean_CodeList B_C = new Bean_CodeList();

			String[] listCSV_SPRIT = listCSV.get(i).split(",");
			B_C.setDay			(DAY);
			B_C.setCode			(listCSV_SPRIT[0]);
			B_C.setCodeName		(listCSV_SPRIT[1]);
			B_C.setMarket		(listCSV_SPRIT[2]);
			B_C.setOpen			(listCSV_SPRIT[4]);
			B_C.setMax			(listCSV_SPRIT[5]);
			B_C.setMin			(listCSV_SPRIT[6]);
			B_C.setClose		(listCSV_SPRIT[7]);
			B_C.setDeki			(listCSV_SPRIT[8]);
			B_C.setBaybay		(listCSV_SPRIT[9]);


			switch(listCSV_SPRIT[3]){

			case "先物":
				B_C.setCatelfg("5");
				break;

			case "指数":
				B_C.setCatelfg("3");
				break;

			case "その他":
				B_C.setCatelfg("4");
				break;

			case "統計":
				B_C.setCatelfg("2");
				break;

			default:
				B_C.setCategory(listCSV_SPRIT[3]);
				B_C.setCatelfg("1");
			}

			//9468―Oで末尾２文字が"―T"出ない場合のみ、ADDする。
			//-Tなら―は存在しないようになっている。
			if(B_C.getCode().lastIndexOf("―") + 2 != B_C.getCode().length() ){
				B_Cs.add(B_C);
			}

		}

	}

	public List<Bean_CodeList> getList_CSVtoDTO_STOCK_INDEX(){
		return B_Cs;
	}



	public void setB_C(List<Bean_CodeList> x){
		B_Cs = x;
	}

	public List<Bean_CodeList> getB_C(){
		return B_Cs;
	}

	public void setB_F(List<Bean_FinancialStatement> x){
		B_F = x;
	}

	public List<Bean_FinancialStatement> getB_F(){
		return B_F;
	}

	public void setB_O(List<Bean_Oneline> x){
		B_O = x;
	}

	public List<Bean_Oneline> getB_O(){
		return B_O;
	}

	public void setB_T(List<Bean_TBLRecord> x){
		B_T = x;
	}

	public List<Bean_TBLRecord> getB_T(){
		return B_T;
	}
}
