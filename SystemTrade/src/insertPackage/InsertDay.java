package insertPackage;

import java.sql.SQLException;
import java.util.List;

import proparty.S;
import proparty.TBL_Name;
import proparty.ZenzituEnd;
import proparty.controllDay;
import accesarrySQL.ConAccessary;
import bean.Bean_CodeList;
import constant.COLUMN;
import constant.ReCord;

public class InsertDay {
	String SQL;

	//CSVsファイルを入れたら各テーブルにインサート開始
	//Sを使いすぎるとやばくなるのでときどき、クローズして新たにCONする。
	public void InsertDD_STOCK_ETF(List<Bean_CodeList> DTO ,String DAY, S s){

		InsertDD(DTO,s);

		controllDay.update_STOCK_ETF(DAY, s);
		System.out.println("株更新日：" + DAY);


	}

	public void InsertDD_INDEX(List<Bean_CodeList> DTO ,String DAY, S s){

		InsertDD(DTO,s);

		controllDay.update_INDEX(DAY, s);
		System.out.println("指数更新日：" + DAY);


	}

	public void InsertDD_STATISTICS(List<Bean_CodeList> DTO ,String UPDATEDAY, S s){

			InsertDD(DTO,s);

			controllDay.update_STATISTICS(UPDATEDAY, s);
			System.out.println("統計更新日：" + UPDATEDAY);

	}

	//CSVsファイルを入れたら各テーブルにインサート開始
	//Sを使いすぎるとやばくなるのでときどき、クローズして新たにCONする。
	public void InsertDDs_STOCK_INDEX(List<List<Bean_CodeList>> DTOs , S s){

		for (int i = 0 ; i < DTOs.size() ; i++){

			InsertDD(DTOs.get(i),s);
			controllDay.update_STOCK_ETF(DTOs.get(i).get(0).getDay(), s);
			System.out.println("株更新日：" + DTOs.get(i).get(0).getDay());

//			if(i%100==0){
//				s.resetConnection();
//			}
		}
	}

	public void InsertDDs_STATISTICS(List<List<Bean_CodeList>> DTOs , S s){
		for (int i = 0 ; i < DTOs.size() ; i++){
			InsertDD(DTOs.get(i),s);
			controllDay.update_STATISTICS(DTOs.get(i).get(0).getDay(), s);
			System.out.println("統計更新日：" + DTOs.get(i).get(0).getDay());
		}
	}

	//CSVファイルを入れたら各テーブルにインサート開始
	public void InsertDD(List<Bean_CodeList> DTO , S s){
		//アクセサリ
//		ConAccessary CA = new ConAccessary();
		//個別銘柄・・・1
		//統計・・・2
		//指数・・・3
		//ETF・・・4
		//先物・・・5
		//通貨・・・6


		for(int i = DTO.size() - 1; i>=0; i-- ){

			switch(DTO.get(i).getCateflg()){
			case ReCord.CODE_01_STOCK:

				//値が存在しない場合、前日の価格を挿入する。
				if(DTO.get(i).getMax().equals("0")){

					String price = ZenzituEnd.getZenzituClose_Stock(DTO.get(i).getCode(),s);
					if (!price.equals("0")){
						//0ではないとき、前日のpriceを全ての値にsetする。
						DTO.get(i).setOpen (price);
						DTO.get(i).setMax  (price);
						DTO.get(i).setMin  (price);
						DTO.get(i).setClose(price);
						InsertDD_case1(DTO.get(i),s);
						ConAccessary.setConAccessary(DTO.get(i).getCode(), DTO.get(i).getCateflg(), DTO.get(i).getDay(), s);
//						System.out.println(DTO.get(i).getCode() + ":" + DTO.get(i).getDay());
						//0のとき＝前日の価格が存在しない。レコードが存在しない。
						//0の時は何もしない。
					}

				}else{
					InsertDD_case1(DTO.get(i),s);
					ConAccessary.setConAccessary(DTO.get(i).getCode(), DTO.get(i).getCateflg(), DTO.get(i).getDay(), s);
				}

				break;
			case ReCord.CODE_02_SATISTICS:
				InsertDD_case2(DTO.get(i),s);
				ConAccessary.setConAccessary(DTO.get(i).getCode(), DTO.get(i).getCateflg(), DTO.get(i).getDay(), s);
				break;
			case ReCord.CODE_03_INDEX:
				InsertDD_case3(DTO.get(i),s);
				ConAccessary.setConAccessary(DTO.get(i).getCode(), DTO.get(i).getCateflg(), DTO.get(i).getDay(), s);
				break;
			case ReCord.CODE_04_ETF:
				InsertDD_case4(DTO.get(i),s);
				ConAccessary.setConAccessary(DTO.get(i).getCode(), DTO.get(i).getCateflg(), DTO.get(i).getDay(), s);
				break;
			case ReCord.CODE_05_SAKIMONO:
				InsertDD_case5(DTO.get(i),s);
				ConAccessary.setConAccessary(DTO.get(i).getCode(), DTO.get(i).getCateflg(), DTO.get(i).getDay(), s);
				break;
			case ReCord.CODE_06_CURRENCY:
				InsertDD_case6(DTO.get(i),s);
				ConAccessary.setConAccessary(DTO.get(i).getCode(), DTO.get(i).getCateflg(), DTO.get(i).getDay(), s);
				break;
			default:
				System.out.println("なんかよくわからないの来た：" + DTO.get(i).getCode() + ":" + DTO.get(i).getCodeName());
				break;
			}



			//基本テーブルにインサート

			//アクセサリテーブルにインサート

		}

	}


	//個別銘柄・・・1
	private void InsertDD_case1(Bean_CodeList DTO , S s){

		SQL = "insert into ";
		SQL = SQL	+ TBL_Name.STOCK_DD
					+ " ("
					+ COLUMN.CODE			+ " , "
					+ COLUMN.DAYTIME	 	+ " , "
					+ COLUMN.AJUST_OPEN	 	+ " , "
					+ COLUMN.AJUST_MAX	 	+ " , "
					+ COLUMN.AJUST_MIN	 	+ " , "
					+ COLUMN.AJUST_CLOSE 	+ " , "
					+ COLUMN.AJUST_DEKI  	+ " , "
					+ COLUMN.AJUST_BAYBAY	+ " , "
					+ COLUMN.OPEN	 	 	+ " , "
					+ COLUMN.MAX	 	 	+ " , "
					+ COLUMN.MIN		 	+ " , "
					+ COLUMN.CLOSE		 	+ " , "
					+ COLUMN.DEKI 		 	+ " , "
					+ COLUMN.BAYBAY 	 	+ "   "


					+ " ) "
					+ "values (?,?,?,?,?,?,?,?,?,?,?,?,?,?)";

		s.setPstmt(SQL);

		try {
			int i = 1;
			s.getPstmt().setString(  i++,  DTO.getCode()		);
			s.getPstmt().setString(  i++,  DTO.getDay()			);
			s.getPstmt().setString(  i++,  DTO.getOpen()		);
//			s.getPstmt().setString(  i++,  null		);
			s.getPstmt().setString(  i++,  DTO.getMax()			);
			s.getPstmt().setString(  i++,  DTO.getMin()			);
			s.getPstmt().setString(  i++,  DTO.getClose()		);
			s.getPstmt().setString(  i++,  DTO.getDeki()		);
			s.getPstmt().setString(  i++,  DTO.getBayBay()		);
			s.getPstmt().setString(  i++,  DTO.getOpen()		);
			s.getPstmt().setString(  i++,  DTO.getMax()			);
			s.getPstmt().setString(  i++,  DTO.getMin()			);
			s.getPstmt().setString(  i++,  DTO.getClose()		);
			s.getPstmt().setString(  i++,  DTO.getDeki()		);
			s.getPstmt().setString(  i++,  DTO.getBayBay()		);
//			s.getPstmt().setString(  i++,  DTO.getMAXMIN()		);
//			s.getPstmt().setString(  i++,  DTO.getMAXMINRatio()	);
		} catch (SQLException e1) {
			// TODO 自動生成された catch ブロック
			e1.printStackTrace();
		}


		try {
			s.getPstmt().executeUpdate();

		} catch (SQLException e) {
			// TODO ミスった時の処理
			//							テーブル重複時の処理

			if(e.getErrorCode()!=1062){
				System.out.println("ミスったのは：" + DTO.getCode() + ":" + DTO.getCodeName() + ":" + DTO.getDay() + ":" + DTO.getCateflg());
				e.printStackTrace();

			}
		}
	}

	//統計・・・2
	private void InsertDD_case2(Bean_CodeList DTO , S s){

		SQL = "insert into ";
		SQL = SQL	+ TBL_Name.STATISTICS_DD
					+ " ("
					+ COLUMN.CODE				+ " , "
					+ COLUMN.DAYTIME		 	+ " , "
					+ COLUMN.DEKI	 	 		+ " , "
					+ COLUMN.BAYBAY	 	 		+ " , "
					+ COLUMN.STOCK_NAME_NUM		+ " , "
					+ COLUMN.STOCK_GETPRICE		+ " , "
					+ COLUMN.STOCK_UPSTOCK 		+ " , "
					+ COLUMN.STOCK_NOCHANGE	 	+ " , "
					+ COLUMN.STOCK_DOWNSTOCK	+ " , "
					+ COLUMN.STOCK_NOCOMPARE	+ "   "
					+ " ) "
					+ "values (?,?,?,?,?,?,?,?,?,?)";

		s.setPstmt(SQL);

		try {
			int i = 1;
			s.getPstmt().setString( i++,  DTO.getCode()			);
			s.getPstmt().setString( i++,  DTO.getDay()			);
			s.getPstmt().setString( i++,  DTO.getDeki()			);
			s.getPstmt().setString( i++,  DTO.getBayBay()		);
			s.getPstmt().setString( i++,  DTO.getStockCount()	);
			s.getPstmt().setString( i++,  DTO.getTakePrice()	);
			s.getPstmt().setString( i++,  DTO.getUpPrice()		);
			s.getPstmt().setString( i++,  DTO.getNoChange()		);
			s.getPstmt().setString( i++,  DTO.getDownPrice()	);
			s.getPstmt().setString( i++,  DTO.getNoCompare()	);

		} catch (SQLException e1) {
			// TODO 自動生成された catch ブロック
			e1.printStackTrace();
		}


		try {
			s.getPstmt().executeUpdate();

		} catch (SQLException e) {
			// TODO ミスった時の処理
			//							テーブル重複時の処理

			if(e.getErrorCode()!=1062){

				System.out.println("ミスったのは：" + DTO.getCode() + ":" + DTO.getCodeName());
				e.printStackTrace();
			}
		}

	}

	//指数・・・3
	private void InsertDD_case3(Bean_CodeList DTO , S s){
		SQL = "insert into ";
		SQL = SQL	+ TBL_Name.INDEX_DD
					+ " ("
					+ COLUMN.CODE			+ " , "
					+ COLUMN.DAYTIME	 	+ " , "
					+ COLUMN.OPEN	 	 	+ " , "
					+ COLUMN.MAX	 	 	+ " , "
					+ COLUMN.MIN		 	+ " , "
					+ COLUMN.CLOSE		 	+ "  "
					+ " ) "
					+ "values (?,?,?,?,?,?)";

		s.setPstmt(SQL);

		try {
			int i = 1;
			s.getPstmt().setString(  i++,  DTO.getCode()		);
			s.getPstmt().setString(  i++,  DTO.getDay()			);
			s.getPstmt().setString(  i++,  DTO.getOpen()		);
			s.getPstmt().setString(  i++,  DTO.getMax()			);
			s.getPstmt().setString(  i++,  DTO.getMin()			);
			s.getPstmt().setString(  i++,  DTO.getClose()		);
		} catch (SQLException e1) {
			// TODO 自動生成された catch ブロック

			e1.printStackTrace();
		}


		try {
			s.getPstmt().executeUpdate();

		} catch (SQLException e) {
			// TODO ミスった時の処理
			//							テーブル重複時の処理
			if(e.getErrorCode()!=1062){
				System.out.println("ミスったのは：" + DTO.getCode() + ":" + DTO.getCodeName() + ":" + DTO.getDay());

				e.printStackTrace();

			}
		}
	}

	//ETF・・・4
	private void InsertDD_case4(Bean_CodeList DTO , S s){
		SQL = "insert into ";
		SQL = SQL	+ TBL_Name.ETF_DD
					+ " ("
					+ COLUMN.CODE			+ " , "
					+ COLUMN.DAYTIME	 	+ " , "
					+ COLUMN.OPEN	 	 	+ " , "
					+ COLUMN.MAX	 	 	+ " , "
					+ COLUMN.MIN		 	+ " , "
					+ COLUMN.CLOSE		 	+ " , "
					+ COLUMN.DEKI 		 	+ " , "
					+ COLUMN.BAYBAY 	 	+ "  "
					+ " ) "
					+ "values (?,?,?,?,?,?,?,?)";

		s.setPstmt(SQL);

		try {
			int i = 1;
			s.getPstmt().setString(  i++,  DTO.getCode()		);
			s.getPstmt().setString(  i++,  DTO.getDay()			);
			s.getPstmt().setString(  i++,  DTO.getOpen()		);
			s.getPstmt().setString(  i++,  DTO.getMax()			);
			s.getPstmt().setString(  i++,  DTO.getMin()			);
			s.getPstmt().setString(  i++,  DTO.getClose()		);
			s.getPstmt().setString(  i++,  DTO.getDeki()		);
			s.getPstmt().setString(  i++,  DTO.getBayBay()		);

		} catch (SQLException e1) {
			// TODO 自動生成された catch ブロック
			e1.printStackTrace();
		}


		try {
			s.getPstmt().executeUpdate();

		} catch (SQLException e) {
			// TODO ミスった時の処理
			//							テーブル重複時の処理
			if(e.getErrorCode()!=1062){
				System.out.println("ミスったのは：" + DTO.getCode() + ":" + DTO.getCodeName() + ":" + DTO.getDay());
				e.printStackTrace();

			}
		}
	}

	//先物・・・5
	private void InsertDD_case5(Bean_CodeList DTO , S s){

	}

	//通貨・・・6
	private void InsertDD_case6(Bean_CodeList DTO , S s){

	}
}
