package sql;

import proparty.S;
import proparty.TBL_Name;
import constant.COLUMN;
import constant.ReCord;

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


			//個別銘柄・・・1
			//統計・・・2
			//指数・・・3
			//ETF・・・4
			//通貨・・・5
			colum = " ( " + COLUMN.CODE_KATA		 + " , "//証券コード
					+ COLUMN.CODENAME_KATA			 + " , "//銘柄名
					+ COLUMN.MARKET_KATA			 + " , "//取引市場
					+ COLUMN.CATEGORY_KATA			 + " , "//業種
					+ COLUMN.CATE_FLG_KATA			 + " , "//個別銘柄か統計か指数かとか
					+ COLUMN.STAMP_KATA				 + " , "//タイムスタンプ
					+ " PRIMARY KEY ( " + COLUMN.CODE + ")); ";
			//
			//証券市場
			//財閥フラグ、業界トップフラグ、業界トップフラグ

			SQL = create + TBL_Name.CODELISTTBL + colum;

			s.freeUpdateQuery(SQL);
			SQL = "insert into "
					+ TBL_Name.CODELISTTBL
					+ " ( " + COLUMN.CODE
					+ " , "
					+ COLUMN.CODENAME
					+ ") values ('" + ReCord.KOSHINBI_STOCK_INDEX + "' , '"+ ReCord.KOSHINBI_SHOKI + "' )  " ;

			s.freeUpdateQuery(SQL);

			SQL = "insert into "
					+ TBL_Name.CODELISTTBL
					+ " ( " + COLUMN.CODE
					+ " , "
					+ COLUMN.CODENAME
					+ ") values ('" + ReCord.KOSHINBI_STATISTICS + "' , '"+ ReCord.KOSHINBI_SHOKI + "' )  " ;

			s.freeUpdateQuery(SQL);

			s.closeConection();
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

			colum = "(id MEDIUMINT AUTO_INCREMENT," //ID
					+ COLUMN.DAYTIME_KATA								 + " , " //日付
					+ COLUMN.OPEN_KATA									 + " , " //始値
					+ COLUMN.MAX_KATA									 + " , " //最高値
					+ COLUMN.MIN_KATA									 + " , " //最安値
					+ COLUMN.CLOSE_KATA									 + " , " //終値
					+ COLUMN.DEKI_KATA									 + " , " //出来高
					+ COLUMN.BAYBAY_KATA								 + " , " //売買代金
					+ COLUMN.AJUST_OPEN_KATA							 + " , " //調整後始値
					+ COLUMN.AJUST_MAX_KATA								 + " , " //調整後最高値
					+ COLUMN.AJUST_MIN_KATA								 + " , " //調整後最安値
					+ COLUMN.AJUST_CLOSE_KATA							 + " , " //調整後終値
					+ COLUMN.AJUST_DEKI_KATA							 + " , " //調整後出来高
					+ COLUMN.AJUST_BAYBAY_KATA							 + " , " //調整後売買代金
					+ COLUMN.AJUSTRATE_KATA								 + " , " //調整レート。仕様はまだ決まっていないが、この値に株価を掛けることで調整したい。
					+ COLUMN.STOCK_NUM_KATA								 + " , " //発行済み株式数
					+ COLUMN.MARKET_CAP_KATA							 + " , " //時価総額
					+ COLUMN.M_AND_A_FLG_KATA							 + " , " //合併フラグ
					+ COLUMN.LONG_FLG_KATA								 + " , " //買いフラグ
					+ COLUMN.SHORT_FLG_KATA								 + " , " //売りフラグ
					+ COLUMN.L_TOTAL_FLG_KATA							 + " , " //買いフラグ合計
					+ COLUMN.S_TOTAL_A_FLG_KATA							 + " , " //売りフラグ合計
					+ COLUMN.CHANGE_PRICE_KATA							 + " , " //前日比
					+ COLUMN.CHANGERATE_KATA							 + " , " //前日比率
					+ COLUMN.SHORTIDO_KATA								 + " , " //株価短期間移動平均線
					+ COLUMN.MIDDLEIDO_KATA								 + " , " //株価中期間移動平均線
					+ COLUMN.LONGIDO_KATA								 + " , " //株価長期間移動平均線
					+ COLUMN.SHORTIDO_CHANGERATE_KATA					 + " , " //株価短期間移動平均線前日比
					+ COLUMN.MIDDLEIDO_CHANGERATE_KATA					 + " , " //株価中期間移動平均線前日比
					+ COLUMN.LONGIDO_CHANGERATE_KATA					 + " , " //株価長期間移動平均線前日比
					+ COLUMN.MAXMIN_KATA								 + " , " //当日の最高値-最安値
					+ COLUMN.MAXMINRATIO_KATA							 + " , " //（最高値-最安値)/1
					+ COLUMN.DEKI_CHANGERATE_KATA						 + " , " //出来高前日比
					+ COLUMN.BAYBAY_CHANGERATE_KATA						 + " , " //売買代金前日比
					+ COLUMN.SHORTIDO_DEKI_KATA							 + " , " //出来高短期移動平均線
					+ COLUMN.MIDDLEIDO_DEKI_KATA						 + " , " //出来高中期移動平均線
					+ COLUMN.LONGIDO_DEKI_KATA							 + " , " //出来高長期移動平均線
					+ COLUMN.SHORTIDO_DEKI_CHANGERATE_KATA				 + " , " //出来高短期間移動平均線前日比
					+ COLUMN.MIDDLEIDO_DEKI_CHANGERATE_KATA				 + " , " //出来高中期移動平均線前日比
					+ COLUMN.LONGIDO_DEKI_CHANGERATE_KATA				 + " , " //出来高長期移動平均線前日比
					+ COLUMN.SHORTIDO_BAYBAY_KATA						 + " , " //売買代金短期移動平均線
					+ COLUMN.MIDDLEIDO_BAYBAY_KATA						 + " , " //売買代金中期移動平均線
					+ COLUMN.LONGIDO_BAYBAY_KATA						 + " , " //売買代金長期移動平均線
					+ COLUMN.SHORTIDO_BAYBAY_CHANGERATE_KATA			 + " , " //売買代金短期間移動平均線前日比
					+ COLUMN.MIDDLEIDO_BAYBAY_CHANGERATE_KATA			 + " , " //売買代金中期間移動平均線前日比
					+ COLUMN.LONGIDO_BAYBAY_CHANGERATE_KATA				 + " , " //売買代金長期移動平均線前日比
					+ COLUMN.CREDIT_LONG_KATA							 + " , " //信用買い残
					+ COLUMN.CREDIT_SHORT_KATA							 + " , " //信用売り残
					+ COLUMN.CREDIT_RATIO_KATA							 + " , " //信用倍率＝信用買い残÷信用売り残
					+ COLUMN.CREDIT_LONG_CHANGERATE_KATA				 + " , " //信用買い残前日比
					+ COLUMN.CREDIT_SHORT_CHANGERATE_KATA				 + " , " //信用売り残前日比
					+ COLUMN.CREDIT_RATIO_CHANGERATE_KATA				 + " , " //信用倍率前日比
					+ COLUMN.SHORT_DEV_KATA								 + " , " //短期間の標準偏差（シグマ）
					+ COLUMN.SHORT_NOW_SIGMA_KATA						 + " , " //短期間内で今日の終値が何シグマにいるか。（少ないほうが上）
					+ COLUMN.SHORT_1_H_SIGMA_KATA						 + " , " //短期間でのシグマ１
					+ COLUMN.SHORT_1_L_SIGMA_KATA						 + " , " //短期間でのマイナスシグマ１
					+ COLUMN.SHORT_2_H_SIGMA_KATA						 + " , " //短期間でのシグマ２
					+ COLUMN.SHORT_2_L_SIGMA_KATA						 + " , " //短期間でのマイナスシグマ２
					+ COLUMN.SHORT_3_H_SIGMA_KATA						 + " , " //短期間でのシグマ３
					+ COLUMN.SHORT_3_L_SIGMA_KATA						 + " , " //短期間でのマイナスシグマ３
					+ COLUMN.MIDDLE_DEV_KATA							 + " , " //中期間の標準偏差（シグマ）
					+ COLUMN.MIDDLE_NOW_SIGMA_KATA						 + " , " //中期間で今日の終値が何シグマにいるか。（少ないほうが上）
					+ COLUMN.MIDDLE_1_H_SIGMA_KATA						 + " , " //中期間のシグマ１
					+ COLUMN.MIDDLE_1_L_SIGMA_KATA						 + " , " //中期間のマイナスシグマ１
					+ COLUMN.MIDLLE_2_H_SIGMA_KATA						 + " , " //中期間のシグマ２
					+ COLUMN.MIDLLE_2_L_SIGMA_KATA						 + " , " //中期間のマイナスシグマ２
					+ COLUMN.MIDDLE_3_H_SIGMA_KATA						 + " , " //中期間のシグマ３
					+ COLUMN.MIDDLE_3_L_SIGMA_KATA						 + " , " //中期間のマイナスシグマ３
					+ COLUMN.LONG_DEV_KATA								 + " , " //長期間の標準偏差（シグマ）
					+ COLUMN.LONG_NOW_SIGMA_KATA						 + " , " //長期間で今日の終値が何シグマにいるか。（少ないほうが上）
					+ COLUMN.LONG_1_H_SIGMA_KATA						 + " , " //長期間のシグマ１
					+ COLUMN.LONG_1_L_SIGMA_KATA						 + " , " //長期間のマイナスシグマ１
					+ COLUMN.LONG_2_H_SIGMA_KATA						 + " , " //長期間のシグマ２
					+ COLUMN.LONG_2_L_SIGMA_KATA						 + " , " //長期間のマイナスシグマ２
					+ COLUMN.LONG_3_H_SIGMA_KATA						 + " , " //長期間のシグマ３
					+ COLUMN.LONG_3_L_SIGMA_KATA						 + " , " //長期間のマイナスシグマ３
					+ COLUMN.SHORT_MACD_KATA							 + " , " //短期MACD
					+ COLUMN.SHORT_MACD_SIGNAL_KATA						 + " , " //短期MACDシグナル線
					+ COLUMN.MIDDLE_MACD_KATA							 + " , " //中期MACD
					+ COLUMN.MIDDLE_MACD_SIGNAL_KATA					 + " , " //中期MACDシグナル線
					+ COLUMN.LONG_MACD_KATA								 + " , " //長期MACD
					+ COLUMN.LONGT_MACD_SIGNAL_KATA						 + " , " //長期MACDシグナル線
					+ "INDEX idx_day( " + COLUMN.DAYTIME				 + "), " //インデックスを日付に貼る
					+ "unique (" + COLUMN.DAYTIME + "),primary key(id)) ";






			//残り、インデックス
			//ぱらぼりっく、信用、標準偏差、MACD、抵抗線、外人比率
			//週足、月足、週足、５分足、財務諸表

			SQL = create + TBLNAME + colum;

			s.freeUpdateQuery(SQL);

		}


		public void dayTable_INDEX(String TBLNAME,S s){
			//SQL全文
			String SQL;
			//列名の取得
			String colum;
			//作成するテーブルの名前

			TBLNAME = TBLNAME + TBL_Name.TAIL_DAY;
			//SQL文の取得
			String create = "create table ";

			colum = "(id MEDIUMINT AUTO_INCREMENT," //ID
					+ COLUMN.DAYTIME_KATA								 + " , " //日付
					+ COLUMN.OPEN_KATA									 + " , " //始値
					+ COLUMN.MAX_KATA									 + " , " //最高値
					+ COLUMN.MIN_KATA									 + " , " //最安値
					+ COLUMN.CLOSE_KATA									 + " , " //終値
					+ COLUMN.LONG_FLG_KATA								 + " , " //買いフラグ
					+ COLUMN.SHORT_FLG_KATA								 + " , " //売りフラグ
					+ COLUMN.L_TOTAL_FLG_KATA							 + " , " //買いフラグ合計
					+ COLUMN.S_TOTAL_A_FLG_KATA							 + " , " //売りフラグ合計
					+ COLUMN.CHANGE_PRICE_KATA							 + " , " //前日比
					+ COLUMN.CHANGERATE_KATA							 + " , " //前日比率
					+ COLUMN.SHORTIDO_KATA								 + " , " //株価短期間移動平均線
					+ COLUMN.MIDDLEIDO_KATA								 + " , " //株価中期間移動平均線
					+ COLUMN.LONGIDO_KATA								 + " , " //株価長期間移動平均線
					+ COLUMN.SHORTIDO_CHANGERATE_KATA					 + " , " //株価短期間移動平均線前日比
					+ COLUMN.MIDDLEIDO_CHANGERATE_KATA					 + " , " //株価中期間移動平均線前日比
					+ COLUMN.LONGIDO_CHANGERATE_KATA					 + " , " //株価長期間移動平均線前日比
					+ COLUMN.MAXMIN_KATA								 + " , " //当日の最高値-最安値
					+ COLUMN.MAXMINRATIO_KATA							 + " , " //（最高値-最安値)/1
					+ COLUMN.SHORT_DEV_KATA								 + " , " //短期間の標準偏差（シグマ）
					+ COLUMN.SHORT_NOW_SIGMA_KATA						 + " , " //短期間内で今日の終値が何シグマにいるか。（少ないほうが上）
					+ COLUMN.SHORT_1_H_SIGMA_KATA						 + " , " //短期間でのシグマ１
					+ COLUMN.SHORT_1_L_SIGMA_KATA						 + " , " //短期間でのマイナスシグマ１
					+ COLUMN.SHORT_2_H_SIGMA_KATA						 + " , " //短期間でのシグマ２
					+ COLUMN.SHORT_2_L_SIGMA_KATA						 + " , " //短期間でのマイナスシグマ２
					+ COLUMN.SHORT_3_H_SIGMA_KATA						 + " , " //短期間でのシグマ３
					+ COLUMN.SHORT_3_L_SIGMA_KATA						 + " , " //短期間でのマイナスシグマ３
					+ COLUMN.MIDDLE_DEV_KATA							 + " , " //中期間の標準偏差（シグマ）
					+ COLUMN.MIDDLE_NOW_SIGMA_KATA						 + " , " //中期間で今日の終値が何シグマにいるか。（少ないほうが上）
					+ COLUMN.MIDDLE_1_H_SIGMA_KATA						 + " , " //中期間のシグマ１
					+ COLUMN.MIDDLE_1_L_SIGMA_KATA						 + " , " //中期間のマイナスシグマ１
					+ COLUMN.MIDLLE_2_H_SIGMA_KATA						 + " , " //中期間のシグマ２
					+ COLUMN.MIDLLE_2_L_SIGMA_KATA						 + " , " //中期間のマイナスシグマ２
					+ COLUMN.MIDDLE_3_H_SIGMA_KATA						 + " , " //中期間のシグマ３
					+ COLUMN.MIDDLE_3_L_SIGMA_KATA						 + " , " //中期間のマイナスシグマ３
					+ COLUMN.LONG_DEV_KATA								 + " , " //長期間の標準偏差（シグマ）
					+ COLUMN.LONG_NOW_SIGMA_KATA						 + " , " //長期間で今日の終値が何シグマにいるか。（少ないほうが上）
					+ COLUMN.LONG_1_H_SIGMA_KATA						 + " , " //長期間のシグマ１
					+ COLUMN.LONG_1_L_SIGMA_KATA						 + " , " //長期間のマイナスシグマ１
					+ COLUMN.LONG_2_H_SIGMA_KATA						 + " , " //長期間のシグマ２
					+ COLUMN.LONG_2_L_SIGMA_KATA						 + " , " //長期間のマイナスシグマ２
					+ COLUMN.LONG_3_H_SIGMA_KATA						 + " , " //長期間のシグマ３
					+ COLUMN.LONG_3_L_SIGMA_KATA						 + " , " //長期間のマイナスシグマ３
					+ COLUMN.SHORT_MACD_KATA							 + " , " //短期MACD
					+ COLUMN.SHORT_MACD_SIGNAL_KATA						 + " , " //短期MACDシグナル線
					+ COLUMN.MIDDLE_MACD_KATA							 + " , " //中期MACD
					+ COLUMN.MIDDLE_MACD_SIGNAL_KATA					 + " , " //中期MACDシグナル線
					+ COLUMN.LONG_MACD_KATA								 + " , " //長期MACD
					+ COLUMN.LONGT_MACD_SIGNAL_KATA						 + " , " //長期MACDシグナル線
					+ "INDEX idx_day( " + COLUMN.DAYTIME				 + "), " //インデックスを日付に貼る
					+ "unique (" + COLUMN.DAYTIME + "),primary key(id)) ";

			SQL = create + TBLNAME + colum;

			s.freeUpdateQuery(SQL);
		}


		public void dayTable_Statistical(String TBLNAME,S s){
			//SQL全文
			String SQL;
			//列名の取得
			String colum;
			//作成するテーブルの名前

			TBLNAME = TBLNAME + TBL_Name.TAIL_DAY ;
			//SQL文の取得
			String create = "create table ";

			colum = "(id MEDIUMINT AUTO_INCREMENT," //ID
					+ COLUMN.DAYTIME_KATA								 + " , " //日付
					+ COLUMN.DEKI_KATA									 + " , " //出来高
					+ COLUMN.BAYBAY_KATA								 + " , " //売買代金
					+ COLUMN.STOCK_NAME_NUM_KATA						 + " , " //全銘柄数
					+ COLUMN.STOCK_GETPRICE_KATA						 + " , " //寝付き
					+ COLUMN.STOCK_UPSTOCK_KATA							 + " , " //値上がり
					+ COLUMN.STOCK_NOCHANGE_KATA						 + " , " //変わらず
					+ COLUMN.STOCK_DOWNSTOCK_KATA						 + " , " //値下がり
					+ COLUMN.STOCK_NOCOMPARE_KATA						 + " , " //比較不可

					+ COLUMN.STOCK_UPPRICE_IDO_SHORT_KATA				 + " , " //値上がり短期移動平均線
					+ COLUMN.STOCK_UPPRICE_IDO_MIDDLE_KATA				 + " , " //値上がり中期移動平均線
					+ COLUMN.STOCK_UPPRICE_IDO_LONG_KATA				 + " , " //値上がり長期移動平均線

					+ COLUMN.STOCK_NOCOMPARE_IDO_SHORT_KATA				 + " , " //変わらず短期移動平均線
					+ COLUMN.STOCK_NOCOMPARE_IDO_MIDDLE_KATA			 + " , " //変わらず中期移動平均線
					+ COLUMN.STOCK_NOCOMPARE_IDO_LONG_KATA				 + " , " //変わらず長期移動平均線
					+ "INDEX idx_day( " + COLUMN.DAYTIME				 + "), " //インデックスを日付に貼る
					+ "unique (" + COLUMN.DAYTIME + "),primary key(id)) ";

			SQL = create + TBLNAME + colum;

			s.freeUpdateQuery(SQL);
		}



}
