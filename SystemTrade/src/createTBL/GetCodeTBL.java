package createTBL;

import java.util.List;

import proparty.S;
import sql.createTBL;
import bean.Bean_CodeList;

public class GetCodeTBL {
	createTBL CTBL = new createTBL();
	public void controll_CreateTBL_DD(List<Bean_CodeList> DTO ,S s){
		//個別銘柄・・・1
		//統計・・・2
		//指数・・・3
		//ETF・・・4
		//先物・・・5
		//通貨・・・6
		for(int i = 0;i<DTO.size();i++){
			switch(DTO.get(i).getCateflg()){
			case "1":
				createTBL_DD_STOCK(DTO.get(i),s);
				break;
			case "2":
				createTBL_DD_STATISTICS(DTO.get(i),s);
				break;
			case "3":
				createTBL_DD_INDEX(DTO.get(i),s);
				break;
			case "4":
				createTBL_DD_STOCK(DTO.get(i),s);
				break;
			case "5":
				break;
			case "6":
				break;
			default:
			}
		}
		
		
		
		
	}

	private void createTBL_DD_INDEX(Bean_CodeList DTO ,S s){
		
			CTBL.dayTable_INDEX(DTO.getCode(), s);
		
	}

	private void createTBL_DD_STOCK(Bean_CodeList DTO ,S s){
		
			CTBL.dayTable_Stock(DTO.getCode(), s);
		
	}

	private void createTBL_DD_STATISTICS(Bean_CodeList DTO ,S s){
		
			CTBL.dayTable_Statistical(DTO.getCode(), s);
		
	}
}
