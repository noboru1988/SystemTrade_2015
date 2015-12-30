package constant;

public class COLUMN {


	//コードリストテーブルの列名
	//証券コード
	public static String CODE											= " code ";
	public static String CODE_KATA										= CODE + " varchar(30) ";
	//銘柄名
	public static String CODENAME										= " codeName ";
	public static String CODENAME_KATA									= CODENAME + " varchar(100) ";
	//取引市場
	public static String MARKET											= " market ";
	public static String MARKET_KATA									= MARKET + " varchar(30) ";

	//業種
	public static String CATEGORY										= " category ";
	public static String CATEGORY_KATA									= CATEGORY + " varchar(30) ";

	//銘柄かどうかを判断するフラグ。種類は以下
	//個別銘柄・・・1
	//統計・・・2
	//指数・・・3
	//ETF・・・4
	//通貨・・・5
	public static String CATE_FLG										= " cate_flg ";
	public static String CATE_FLG_KATA									= CATE_FLG + " tinyint ";

	//タイムスタンプ
	public static String STAMP											= " STAMP ";
	public static String STAMP_KATA										= STAMP + " TIMESTAMP ";



	//各種銘柄のテーブルの列名
	//日付
	public static String DAYTIME											= " dayTime  ";
	public static String DAYTIME_KATA										= DAYTIME + " DATETIME not null ";
	//始値
	public static String OPEN												= " open  ";
	public static String OPEN_KATA											= OPEN + " double unsigned  ";
	//最高値
	public static String MAX												= " max  ";
	public static String MAX_KATA											= MAX + " double unsigned  ";
	//最安値
	public static String MIN												= " min  ";
	public static String MIN_KATA											= MIN + " double unsigned  ";
	//終値
	public static String CLOSE												= " close  ";
	public static String CLOSE_KATA											= CLOSE + " double unsigned  ";
	//出来高
	public static String DEKI												= " DEKI  ";
	public static String DEKI_KATA											= DEKI + " BIGINT unsigned  ";
	//売買代金
	public static String BAYBAY												= " BAYBAY  ";
	public static String BAYBAY_KATA										= BAYBAY + " BIGINT unsigned  ";
	//調整後始値
	public static String AJUST_OPEN											= " ajust_open  ";
	public static String AJUST_OPEN_KATA									= AJUST_OPEN + " double unsigned  ";
	//調整後最高値
	public static String AJUST_MAX											= " ajust_max ";
	public static String AJUST_MAX_KATA										= AJUST_MAX + " double unsigned  ";
	//調整後最安値
	public static String AJUST_MIN											= " ajust_min ";
	public static String AJUST_MIN_KATA										= AJUST_MIN + " double unsigned  ";
	//調整後終値
	public static String AJUST_CLOSE										= " ajust_close  ";
	public static String AJUST_CLOSE_KATA									= AJUST_CLOSE + " double unsigned  ";
	//調整後出来高
	public static String AJUST_DEKI											= " ajust_DEKI ";
	public static String AJUST_DEKI_KATA									= AJUST_DEKI + " BIGINT unsigned  ";
	//調整後売買代金
	public static String AJUST_BAYBAY										= " ajust_BAYBAY ";
	public static String AJUST_BAYBAY_KATA									= AJUST_BAYBAY + " BIGINT unsigned  ";
	//調整レート。仕様はまだ決まっていないが、この値に株価を掛けることで調整したい。
	public static String AJUSTRATE											= " ajustRate  ";
	public static String AJUSTRATE_KATA										= AJUSTRATE + " double unsigned  ";
	//発行済み株式数
	public static String STOCK_NUM 											= " STOCK_NUM  ";
	public static String STOCK_NUM_KATA										= STOCK_NUM + " BIGINT unsigned  ";
	//時価総額
	public static String MARKET_CAP											= " Market_Cap  ";
	public static String MARKET_CAP_KATA									= MARKET_CAP + " BIGINT unsigned  ";
	//合併フラグ
	public static String M_AND_A_FLG										= " m_and_a_flg  ";
	public static String M_AND_A_FLG_KATA									= M_AND_A_FLG + " tinyint(1) ";
	//買いフラグ
	public static String LONG_FLG											= " Long_flg  ";
	public static String LONG_FLG_KATA										= LONG_FLG + " tinyint(1) ";
	//売りフラグ
	public static String SHORT_FLG											= " Short_flg  ";
	public static String SHORT_FLG_KATA 									= SHORT_FLG + " tinyint(1) ";
	//買いフラグ合計
	public static String L_TOTAL_FLG 										= " L_Total_flg  ";
	public static String L_TOTAL_FLG_KATA 									= L_TOTAL_FLG + " tinyint(2) ";
	//売りフラグ合計
	public static String S_TOTAL_A_FLG										= " S_Total_a_flg  ";
	public static String S_TOTAL_A_FLG_KATA									= S_TOTAL_A_FLG + " tinyint(2) ";
	//前日比
	public static String CHANGE_PRICE										= " change_Price  ";
	public static String CHANGE_PRICE_KATA 									= CHANGE_PRICE + " double ";
	//前日比率
	public static String CHANGERATE 										= " changeRate  ";
	public static String CHANGERATE_KATA 									= CHANGERATE + " double ";
	//株価短期間移動平均線
	public static String SHORTIDO 											= " shortIDO  ";
	public static String SHORTIDO_KATA 										= SHORTIDO + " double unsigned  ";
	//株価中期間移動平均線
	public static String MIDDLEIDO 											= " middleIDO  ";
	public static String MIDDLEIDO_KATA 									= MIDDLEIDO + " double unsigned  ";
	//株価長期間移動平均線
	public static String LONGIDO 											= " longIDO  ";
	public static String LONGIDO_KATA 										= LONGIDO + " double unsigned  ";
	//株価短期間移動平均線前日比
	public static String SHORTIDO_CHANGERATE 								= " shortIDO_ChangeRate  ";
	public static String SHORTIDO_CHANGERATE_KATA 							= SHORTIDO_CHANGERATE + " double ";
	//株価中期間移動平均線前日比
	public static String MIDDLEIDO_CHANGERATE 								= " middleIDO_ChangeRate  ";
	public static String MIDDLEIDO_CHANGERATE_KATA 							= MIDDLEIDO_CHANGERATE + " double ";
	//株価長期間移動平均線前日比
	public static String LONGIDO_CHANGERATE = " longIDO_ChangeRate  ";
	public static String LONGIDO_CHANGERATE_KATA = LONGIDO_CHANGERATE + " double ";
	//当日の最高値-最安値
	public static String MAXMIN = " maxmin  ";
	public static String MAXMIN_KATA = MAXMIN + " double unsigned  ";
	//（最高値-最安値)/1
	public static String MAXMINRATIO = " maxminRatio  ";
	public static String MAXMINRATIO_KATA = MAXMINRATIO + " double unsigned  ";
	//出来高前日比
	public static String DEKI_CHANGERATE = " DEKI_ChangeRate  ";
	public static String DEKI_CHANGERATE_KATA = DEKI_CHANGERATE + " float ";
	//売買代金前日比
	public static String BAYBAY_CHANGERATE = " BAYBAY_ChangeRate  ";
	public static String BAYBAY_CHANGERATE_KATA = BAYBAY_CHANGERATE + " float ";
	//出来高短期移動平均線
	public static String SHORTIDO_DEKI = " shortIDO_DEKI  ";
	public static String SHORTIDO_DEKI_KATA = SHORTIDO_DEKI + " double unsigned  ";
	//出来高中期移動平均線
	public static String MIDDLEIDO_DEKI = " middleIDO_DEKI  ";
	public static String MIDDLEIDO_DEKI_KATA = MIDDLEIDO_DEKI + " double unsigned  ";
	//出来高長期移動平均線
	public static String LONGIDO_DEKI = " longIDO_DEKI  ";
	public static String LONGIDO_DEKI_KATA = LONGIDO_DEKI + " double unsigned  ";
	//出来高短期間移動平均線前日比
	public static String SHORTIDO_DEKI_CHANGERATE = " shortIDO_DEKI_changeRate  ";
	public static String SHORTIDO_DEKI_CHANGERATE_KATA = SHORTIDO_DEKI_CHANGERATE + " double  ";
	//出来高中期移動平均線前日比
	public static String MIDDLEIDO_DEKI_CHANGERATE = " middleIDO_DEKI_changeRate  ";
	public static String MIDDLEIDO_DEKI_CHANGERATE_KATA = MIDDLEIDO_DEKI_CHANGERATE + " double  ";
	//出来高長期移動平均線前日比
	public static String LONGIDO_DEKI_CHANGERATE = " longIDO_DEKI_changeRate  ";
	public static String LONGIDO_DEKI_CHANGERATE_KATA = LONGIDO_DEKI_CHANGERATE + " double  ";
	//売買代金短期移動平均線
	public static String SHORTIDO_BAYBAY = " shortIDO_BAYBAY  ";
	public static String SHORTIDO_BAYBAY_KATA = SHORTIDO_BAYBAY + " double unsigned  ";
	//売買代金中期移動平均線
	public static String MIDDLEIDO_BAYBAY = " middleIDO_BAYBAY  ";
	public static String MIDDLEIDO_BAYBAY_KATA = MIDDLEIDO_BAYBAY + " double unsigned  ";
	//売買代金長期移動平均線
	public static String LONGIDO_BAYBAY = " longIDO_BAYBAY  ";
	public static String LONGIDO_BAYBAY_KATA = LONGIDO_BAYBAY + " double unsigned  ";
	//売買代金短期間移動平均線前日比
	public static String SHORTIDO_BAYBAY_CHANGERATE = " shortIDO_BAYBAY_changeRate  ";
	public static String SHORTIDO_BAYBAY_CHANGERATE_KATA = SHORTIDO_BAYBAY_CHANGERATE + " double  ";
	//売買代金中期間移動平均線前日比
	public static String MIDDLEIDO_BAYBAY_CHANGERATE = " middleIDO_BAYBAY_changeRate  ";
	public static String MIDDLEIDO_BAYBAY_CHANGERATE_KATA = MIDDLEIDO_BAYBAY_CHANGERATE + " double  ";
	//売買代金長期移動平均線前日比
	public static String LONGIDO_BAYBAY_CHANGERATE = " longIDO_BAYBAY_changeRate  ";
	public static String LONGIDO_BAYBAY_CHANGERATE_KATA = LONGIDO_BAYBAY_CHANGERATE + " double  ";
	//信用買い残
	public static String CREDIT_LONG = " Credit_Long  ";
	public static String CREDIT_LONG_KATA = CREDIT_LONG + " double ";
	//信用売り残
	public static String CREDIT_SHORT = " Credit_Short  ";
	public static String CREDIT_SHORT_KATA = CREDIT_SHORT + " double ";
	//信用倍率＝信用買い残÷信用売り残
	public static String CREDIT_RATIO = " Credit_Ratio  ";
	public static String CREDIT_RATIO_KATA = CREDIT_RATIO + " double ";
	//信用買い残前日比
	public static String CREDIT_LONG_CHANGERATE = " Credit_Long_ChangeRate  ";
	public static String CREDIT_LONG_CHANGERATE_KATA = CREDIT_LONG_CHANGERATE + " float ";
	//信用売り残前日比
	public static String CREDIT_SHORT_CHANGERATE = " Credit_Short_ChangeRate  ";
	public static String CREDIT_SHORT_CHANGERATE_KATA = CREDIT_SHORT_CHANGERATE + " float ";
	//信用倍率前日比
	public static String CREDIT_RATIO_CHANGERATE = " Credit_Ratio_ChangeRate  ";
	public static String CREDIT_RATIO_CHANGERATE_KATA = CREDIT_RATIO_CHANGERATE + " float ";
	//短期間の標準偏差（シグマ）
	public static String SHORT_DEV = " short_dev  ";
	public static String SHORT_DEV_KATA = SHORT_DEV + " double ";
	//短期間内で今日の終値が何シグマにいるか。（少ないほうが上）
	public static String SHORT_NOW_SIGMA = " short_now_sigma  ";
	public static String SHORT_NOW_SIGMA_KATA = SHORT_NOW_SIGMA + " float ";
	//短期間でのシグマ１
	public static String SHORT_1_H_SIGMA = " short_1_sigma_h  ";
	public static String SHORT_1_H_SIGMA_KATA = SHORT_1_H_SIGMA + " float ";
	//短期間でのマイナスシグマ１
	public static String SHORT_1_L_SIGMA = " short_1_sigma_l  ";
	public static String SHORT_1_L_SIGMA_KATA = SHORT_1_L_SIGMA + " float ";
	//短期間でのシグマ２
	public static String SHORT_2_H_SIGMA = " short_2_sigma_h  ";
	public static String SHORT_2_H_SIGMA_KATA = SHORT_2_H_SIGMA + " float ";
	//短期間でのマイナスシグマ２
	public static String SHORT_2_L_SIGMA = " short_2_sigma_l  ";
	public static String SHORT_2_L_SIGMA_KATA = SHORT_2_L_SIGMA + " float ";
	//短期間でのシグマ３
	public static String SHORT_3_H_SIGMA = " short_3_sigma_h  ";
	public static String SHORT_3_H_SIGMA_KATA = SHORT_3_H_SIGMA + " float ";
	//短期間でのマイナスシグマ３
	public static String SHORT_3_L_SIGMA = " short_3_sigma_l  ";
	public static String SHORT_3_L_SIGMA_KATA = SHORT_3_L_SIGMA + " float ";
	//中期間の標準偏差（シグマ）
	public static String MIDDLE_DEV = " middle_dev  ";
	public static String MIDDLE_DEV_KATA = MIDDLE_DEV + " double ";
	//中期間で今日の終値が何シグマにいるか。（少ないほうが上）
	public static String MIDDLE_NOW_SIGMA = " middle_now_sigma  ";
	public static String MIDDLE_NOW_SIGMA_KATA = MIDDLE_NOW_SIGMA + " float ";
	//中期間のシグマ１
	public static String MIDDLE_1_H_SIGMA = " middle_1_sigma_h  ";
	public static String MIDDLE_1_H_SIGMA_KATA = MIDDLE_1_H_SIGMA + " float ";
	//中期間のマイナスシグマ１
	public static String MIDDLE_1_L_SIGMA = " middle_1_sigma_l  ";
	public static String MIDDLE_1_L_SIGMA_KATA = MIDDLE_1_L_SIGMA + " float ";
	//中期間のシグマ２
	public static String MIDLLE_2_H_SIGMA = " midlle_2_sigma_h  ";
	public static String MIDLLE_2_H_SIGMA_KATA = MIDLLE_2_H_SIGMA + " float ";
	//中期間のマイナスシグマ２
	public static String MIDLLE_2_L_SIGMA = " midlle_2_sigma_l  ";
	public static String MIDLLE_2_L_SIGMA_KATA = MIDLLE_2_L_SIGMA + " float ";
	//中期間のシグマ３
	public static String MIDDLE_3_H_SIGMA = " middle_3_sigma_h  ";
	public static String MIDDLE_3_H_SIGMA_KATA = MIDDLE_3_H_SIGMA + " float ";
	//中期間のマイナスシグマ３
	public static String MIDDLE_3_L_SIGMA = " middle_3_sigma_l  ";
	public static String MIDDLE_3_L_SIGMA_KATA = MIDDLE_3_L_SIGMA + " float ";
	//長期間の標準偏差（シグマ）
	public static String LONG_DEV = " long_dev  ";
	public static String LONG_DEV_KATA = LONG_DEV + " double ";
	//長期間で今日の終値が何シグマにいるか。（少ないほうが上）
	public static String LONG_NOW_SIGMA = " long_now_sigma  ";
	public static String LONG_NOW_SIGMA_KATA = LONG_NOW_SIGMA + " float ";
	//長期間のシグマ１
	public static String LONG_1_H_SIGMA = " long_1_sigma_h  ";
	public static String LONG_1_H_SIGMA_KATA = LONG_1_H_SIGMA + " float ";
	//長期間のマイナスシグマ１
	public static String LONG_1_L_SIGMA = " long_1_sigma_l  ";
	public static String LONG_1_L_SIGMA_KATA = LONG_1_L_SIGMA + " float ";
	//長期間のシグマ２
	public static String LONG_2_H_SIGMA = " long_2_sigma_h  ";
	public static String LONG_2_H_SIGMA_KATA = LONG_2_H_SIGMA + " float ";
	//長期間のマイナスシグマ２
	public static String LONG_2_L_SIGMA = " long_2_sigma_l  ";
	public static String LONG_2_L_SIGMA_KATA = LONG_2_L_SIGMA + " float ";
	//長期間のシグマ３
	public static String LONG_3_H_SIGMA = " long_3_sigma_h  ";
	public static String LONG_3_H_SIGMA_KATA = LONG_3_H_SIGMA + " float ";
	//長期間のマイナスシグマ３
	public static String LONG_3_L_SIGMA = " long_3_sigma_l  ";
	public static String LONG_3_L_SIGMA_KATA = LONG_3_L_SIGMA + " float ";
	//短期MACD
	public static String SHORT_MACD = " short_MACD  ";
	public static String SHORT_MACD_KATA = SHORT_MACD + " double ";
	//短期MACDシグナル線
	public static String SHORT_MACD_SIGNAL = " short_MACD_signal  ";
	public static String SHORT_MACD_SIGNAL_KATA = SHORT_MACD_SIGNAL + " double ";
	//中期MACD
	public static String MIDDLE_MACD = " middle_MACD  ";
	public static String MIDDLE_MACD_KATA = MIDDLE_MACD + " double ";
	//中期MACDシグナル線
	public static String MIDDLE_MACD_SIGNAL = " middle_MACD_signal  ";
	public static String MIDDLE_MACD_SIGNAL_KATA = MIDDLE_MACD_SIGNAL + " double ";
	//長期MACD
	public static String LONG_MACD = " long_MACD  ";
	public static String LONG_MACD_KATA = LONG_MACD + " double ";
	//長期MACDシグナル線
	public static String LONGT_MACD_SIGNAL = " longt_MACD_signal  ";
	public static String LONGT_MACD_SIGNAL_KATA = LONGT_MACD_SIGNAL + " double ";


	//銘柄数
	public static String STOCK_NAME_NUM										= " stock_name_num ";
	public static String STOCK_NAME_NUM_KATA								= STOCK_NAME_NUM + " smallint unsigned ";
	//寝付き
	public static String STOCK_GETPRICE 									= " stock_getprice ";
	public static String STOCK_GETPRICE_KATA 								= STOCK_GETPRICE  + " smallint unsigned ";
	//値上がり
	public static String STOCK_UPSTOCK										= " stock_upstock ";
	public static String STOCK_UPSTOCK_KATA 								= STOCK_UPSTOCK + " smallint unsigned ";
	//変わらず
	public static String STOCK_NOCHANGE										= " stock_nochange ";
	public static String STOCK_NOCHANGE_KATA 								= STOCK_NOCHANGE + " smallint unsigned ";
	//値下がり
	public static String STOCK_DOWNSTOCK									= " stock_downstock ";
	public static String STOCK_DOWNSTOCK_KATA 								= STOCK_DOWNSTOCK + " smallint unsigned ";
	//比較不可
	public static String STOCK_NOCOMPARE									= " stock_nocompare ";
	public static String STOCK_NOCOMPARE_KATA 								= STOCK_NOCOMPARE + " smallint unsigned ";
	//値上がり短期移動平均線
	public static String STOCK_UPPRICE_IDO_SHORT							= " stock_upprice_ido_short ";
	public static String STOCK_UPPRICE_IDO_SHORT_KATA 						= STOCK_UPPRICE_IDO_SHORT + " float unsigned ";
	//値上がり中期移動平均線
	public static String STOCK_UPPRICE_IDO_MIDDLE							= " stock_upprice_ido_middle ";
	public static String STOCK_UPPRICE_IDO_MIDDLE_KATA 						= STOCK_UPPRICE_IDO_MIDDLE + " float unsigned ";
	//値上がり長期移動平均線
	public static String STOCK_UPPRICE_IDO_LONG								= " stock_upprice_ido_long ";
	public static String STOCK_UPPRICE_IDO_LONG_KATA 						= STOCK_UPPRICE_IDO_LONG + " float unsigned ";
	//変わらず短期移動平均線
	public static String STOCK_NOCOMPARE_IDO_SHORT								= " stock_nocompare_ido_short ";
	public static String STOCK_NOCOMPARE_IDO_SHORT_KATA 						= STOCK_NOCOMPARE_IDO_SHORT + " float unsigned ";
	//変わらず短期移動平均線
	public static String STOCK_NOCOMPARE_IDO_MIDDLE								= " stock_nocompare_ido_middle ";
	public static String STOCK_NOCOMPARE_IDO_MIDDLE_KATA 						= STOCK_NOCOMPARE_IDO_MIDDLE + " float unsigned ";
	//変わらず短期移動平均線
	public static String STOCK_NOCOMPARE_IDO_LONG								= " stock_nocompare_ido_long ";
	public static String STOCK_NOCOMPARE_IDO_LONG_KATA		 					= STOCK_NOCOMPARE_IDO_LONG + " float unsigned ";

	//更新内容
	public static String KOSIN													= " KOSIN ";
	public static String KOSIN_KATA	 											= KOSIN + " varchar(30) ";
	//更新内容
	public static String KOSIN_DAY												= " KOSIN_DAY ";
	public static String KOSIN_DAY_KATA	 										= KOSIN_DAY + " varchar(30) ";


}
