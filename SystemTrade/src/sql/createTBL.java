package sql;

import proparty.S;
import proparty.TBL_Name;

public class createTBL {

	//証券コード一覧を作成する.
		//列は、コード、業種、更新時刻
		public void createCodeList(){
			S s = new S();
			s.getCon();
			//SQL全文
			String SQL;
			//列名の取得
			String colum;
			//作成するテーブルの名前

			//SQL文の取得
			String create = "create table ";

			colum = " ( code varchar(30), " //証券コード
					+ " codeName varchar(100) ," //銘柄名
					+ " market varchar(30)," //取引市場
					+ " category varchar(30) ," //業種
					+ " company_flg tinyint(1)," //個別銘柄
					+ " statistical_flg tinyint(1)," //統計
					+ " index_flg tinyint(1),"  //指数
					+ " future_flg tinyint(1)," //先物
					+ " etf_flg tinyint(1)," //ETF
					+ " currency_flg tinyint(1)," //通貨
					+ " STAMP TIMESTAMP,"
					+ " PRIMARY KEY (code)); ";
			//
			//証券市場
			//財閥フラグ、業界トップフラグ、業界トップフラグ

			SQL = create + TBL_Name.CODELISTTBL + colum;

				s.freeUpdateQuery(SQL);
				s.closeConection();
		}


		//証券コードを引数にすると5m足テーブルを作る
		//証券コードの末尾に_5mが付与される。例：9999_5m
		public void minuteTable_Stock(String TBLNAME,S s){

			//SQL全文
			String SQL;
			//列名の取得
			String colum;
			//作成するテーブルの名前

			TBLNAME = TBLNAME + TBL_Name.TAIL_5Minite;
			//SQL文の取得
			String create = "create table ";
			//順調に上がっているかどうかをみたいときー！！！
			colum = "(id MEDIUMINT unsigned AUTO_INCREMENT,"
					+ "dayTime DATETIME not null, "
					+ "open double unsigned ,"
					+ "max double unsigned ,"
					+ "min double unsigned ,"
					+ "close double unsigned ,"
					+ "ajust_open double unsigned ,"
					+ "ajust_max double unsigned ,"
					+ "ajust_min double unsigned ,"
					+ "ajust_close double unsigned ," //調整後終値
					+ "Long_flg tinyint(1)," //買いフラグ
					+ "Short_flg tinyint(1),"//売りフラグ
					+ "L_Total_flg tinyint(2)," //買いフラグ合計
					+ "S_Total_a_flg tinyint(2)," //売りフラグ合計
					+ "change_Price double,"
					+ "changeRate double,"
					+ "maxmin double unsigned ,"//最大値-最少値
					+ "m_and_a_flg tinyint(1)," //合併フラグ
					+ "DEKI BIGINT unsigned ,"
					+ "ajust_DEKI BIGINT unsigned ,"
					+ "DEKI_ChangeRate float,"
					+ "BAYBAY BIGINT unsigned ,"
					+ "BAYBAY_ChangeRate float,"
					+ "Credit_Long double,"
					+ "Credit_Short double,"
					+ "Credit_Ratio double,"
					+ "Credit_Long_ChangeRate float,"
					+ "Credit_Short_ChangeRate float,"
					+ "Credit_Ratio_ChangeRate float,"
					+ "shortIDO double unsigned ,"
					+ "middleIDO double unsigned ,"
					+ "longIDO double unsigned ,"
					+ "shortIDO_ChangeRate double,"
					+ "middleIDO_ChangeRate double,"
					+ "longIDO_ChangeRate double,"
					+ "short_dev double,"
					+ "short_now_sigma float,"
					+ "short_1_sigma float,"
					+ "short_2_sigma float,"
					+ "short_3_sigma float,"
					+ "middle_dev double,"
					+ "middle_now_sigma float,"
					+ "middle_1_sigma float,"
					+ "midlle_2_sigma float,"
					+ "middle_3_sigma float,"
					+ "long_dev double,"
					+ "long_now_sigma float,"
					+ "long_1_sigma float,"
					+ "long_2_sigma float,"
					+ "long_3_sigma float,"
					+ "short_MACD double,"
					+ "short_MACD_signal double,"

					+ "unique (dayTime),primary key(id)) ";


			//残り、インデックス
			//ぱらぼりっく、信用、標準偏差、MACD、抵抗線、外人比率
			//週足、月足、週足、５分足、財務諸表

			SQL = create + TBLNAME + colum;

			s.freeUpdateQuery(SQL);

		}



		//証券コードを引数にすると日足テーブルを作る
		//証券コードの末尾に_DDが付与される。例：9999_DD
		public void dayTable_Stock(String TBLNAME,S s){

			//SQL全文
			String SQL;
			//列名の取得
			String colum;
			//作成するテーブルの名前

			TBLNAME = TBLNAME + TBL_Name.TAIL_DAY;
			//SQL文の取得
			String create = "create table ";

			colum = "(id MEDIUMINT AUTO_INCREMENT,"
					+ "dayTime DATETIME not null, "
					+ "open double unsigned ,"
					+ "max double unsigned ,"
					+ "min double unsigned ,"
					+ "close double unsigned ,"
					+ "ajust_open double unsigned ,"
					+ "ajust_max double unsigned ,"
					+ "ajust_min double unsigned ,"
					+ "ajust_close double unsigned ," //調整後終値
					+ "STOCK_NUM BIGINT unsigned , " //発行済み株式数
					+ "Market_Cap BIGINT unsigned , " //時価総額
					+ "Long_flg tinyint(1)," //買いフラグ
					+ "Short_flg tinyint(1),"//売りフラグ
					+ "L_Total_flg tinyint(2)," //買いフラグ合計
					+ "S_Total_a_flg tinyint(2)," //売りフラグ合計
					+ "change_Price double,"
					+ "changeRate double,"
					+ "maxmin double unsigned ,"
					+ "m_and_a_flg tinyint(1),"//合併フラグ
					+ "DEKI BIGINT unsigned ," //出来高
					+ "ajust_DEKI BIGINT unsigned ,"
					+ "DEKI_ChangeRate float," //出来高前日比
					+ "BAYBAY BIGINT unsigned ,"
					+ "BAYBAY_ChangeRate float,"
					+ "Credit_Long double,"
					+ "Credit_Short double,"
					+ "Credit_Ratio double,"
					+ "Credit_Long_ChangeRate float,"
					+ "Credit_Short_ChangeRate float,"
					+ "Credit_Ratio_ChangeRate float,"
					+ "shortIDO double unsigned ,"
					+ "middleIDO double unsigned ,"
					+ "longIDO double unsigned ,"
					+ "shortIDO_ChangeRate double,"
					+ "middleIDO_ChangeRate double,"
					+ "longIDO_ChangeRate double,"
					+ "short_dev double,"
					+ "short_now_sigma float,"
					+ "short_1_sigma float,"
					+ "short_2_sigma float,"
					+ "short_3_sigma float,"
					+ "middle_dev double,"
					+ "middle_now_sigma float,"
					+ "middle_1_sigma float,"
					+ "midlle_2_sigma float,"
					+ "middle_3_sigma float,"
					+ "long_dev double,"
					+ "long_now_sigma float,"
					+ "long_1_sigma float,"
					+ "long_2_sigma float,"
					+ "long_3_sigma float,"
					+ "short_MACD double,"
					+ "short_MACD_signal double,"
					+ "INDEX idx_day(dayTime),"
					+ "unique (dayTime),primary key(id)) ";


			//残り、インデックス
			//ぱらぼりっく、信用、標準偏差、MACD、抵抗線、外人比率
			//週足、月足、週足、５分足、財務諸表

			SQL = create + TBLNAME + colum;

			s.freeUpdateQuery(SQL);

		}


		public void dayTable_Statistical(String TBLNAME,S s){
			//SQL全文
			String SQL;
			//列名の取得
			String colum;
			//作成するテーブルの名前

			TBLNAME = TBLNAME + TBL_Name.TAIL_DAY;
			//SQL文の取得
			String create = "create table ";

			colum = "(id MEDIUMINT AUTO_INCREMENT,"
					+ "dayTime DATETIME not null, "
					+ "DEKI BIGINT unsigned ,"
					+ "DEKI_ChangeRate float,"
					+ "BAYBAY BIGINT unsigned ,"
					+ "BAYBAY_ChangeRate float,"
					+ "listNum MEDIUMINT, "//銘柄数
					+ "getPriceNum MEDIUMINT, "//値付き数
					+ "upPriceNum MEDIUMINT, "//値上がり数
					+ "noChangeNum MEDIUMINT, "//変わらず
					+ "downPriceNum MEDIUMINT, "//値下がり数
					+ "noComparison MEDIUMINT, "//比較不可
					+ "upRatio float,"//値上がり率の割合 （値上がり数/全銘柄）
					+ "downRatio float,"//値下がり率の割合 （値下がり数/全銘柄）
					+ "Long_flg tinyint(1)," //買いフラグ
					+ "Short_flg tinyint(1),"//売りフラグ
					+ "L_Total_flg tinyint(2)," //買いフラグ合計
					+ "S_Total_a_flg tinyint(2)," //売りフラグ合計
					+ "shortIDO double unsigned ,"
					+ "middleIDO double unsigned ,"
					+ "longIDO double unsigned ,"
					+ "shortIDO_ChangeRate double,"
					+ "middleIDO_ChangeRate double,"
					+ "longIDO_ChangeRate double,"
					+ "short_dev double,"
					+ "short_now_sigma float,"
					+ "short_1_sigma float,"
					+ "short_2_sigma float,"
					+ "short_3_sigma float,"
					+ "middle_dev double,"
					+ "middle_now_sigma float,"
					+ "middle_1_sigma float,"
					+ "midlle_2_sigma float,"
					+ "middle_3_sigma float,"
					+ "long_dev double,"
					+ "long_now_sigma float,"
					+ "long_1_sigma float,"
					+ "long_2_sigma float,"
					+ "long_3_sigma float,"
					+ "short_MACD double,"
					+ "short_MACD_signal double,"
					+ "INDEX idx_day(dayTime),"
					+ "unique (dayTime),primary key(id)) ";


			//残り、インデックス
			//ぱらぼりっく、信用、標準偏差、MACD、抵抗線、外人比率
			//週足、月足、週足、５分足、財務諸表

			SQL = create + TBLNAME + colum;

			s.freeUpdateQuery(SQL);



		}

		public void minuteTable_Statistical(String TBLNAME,S s){

		}


		public void dayTable_Futures(String TBLNAME,S s){

		}

		public void minuteTable_Futures(String TBLNAME,S s){

		}

		public void dayTable_Index(String TBLNAME,S s){
			//SQL全文
			String SQL;
			//列名の取得
			String colum;
			//作成するテーブルの名前

			TBLNAME = TBLNAME + TBL_Name.TAIL_DAY;
			//SQL文の取得
			String create = "create table ";

			colum = "(id MEDIUMINT AUTO_INCREMENT,"
					+ "dayTime DATETIME not null, "
					+ "open double unsigned ,"
					+ "max double unsigned ,"
					+ "min double unsigned ,"
					+ "close double unsigned ,"
					+ "Long_flg tinyint(1)," //買いフラグ
					+ "Short_flg tinyint(1),"//売りフラグ
					+ "L_Total_flg tinyint(2)," //買いフラグ合計
					+ "S_Total_a_flg tinyint(2)," //売りフラグ合計
					+ "change_Price double,"
					+ "changeRate double,"
					+ "maxmin double unsigned ,"
					+ "Credit_Long double,"
					+ "Credit_Short double,"
					+ "Credit_Ratio double,"
					+ "Credit_Long_ChangeRate float,"
					+ "Credit_Short_ChangeRate float,"
					+ "Credit_Ratio_ChangeRate float,"
					+ "shortIDO double unsigned ,"
					+ "middleIDO double unsigned ,"
					+ "longIDO double unsigned ,"
					+ "shortIDO_ChangeRate double,"
					+ "middleIDO_ChangeRate double,"
					+ "longIDO_ChangeRate double,"
					+ "short_dev double,"
					+ "short_now_sigma float,"
					+ "short_1_sigma float,"
					+ "short_2_sigma float,"
					+ "short_3_sigma float,"
					+ "middle_dev double,"
					+ "middle_now_sigma float,"
					+ "middle_1_sigma float,"
					+ "midlle_2_sigma float,"
					+ "middle_3_sigma float,"
					+ "long_dev double,"
					+ "long_now_sigma float,"
					+ "long_1_sigma float,"
					+ "long_2_sigma float,"
					+ "long_3_sigma float,"
					+ "short_MACD double,"
					+ "short_MACD_signal double,"
					+ "INDEX idx_day(dayTime),"
					+ "unique (dayTime),primary key(id)) ";


			//残り、インデックス
			//ぱらぼりっく、信用、標準偏差、MACD、抵抗線、外人比率
			//週足、月足、週足、５分足、財務諸表

			SQL = create + TBLNAME + colum;

			s.freeUpdateQuery(SQL);
		}

		public void minuteIndexTable(String TBLNAME,S s){

		}

		public void dayTable_Currency(String TBLNAME,S s){

		}

		public void minuteTable_Currency(String TBLNAME,S s){

		}
}
