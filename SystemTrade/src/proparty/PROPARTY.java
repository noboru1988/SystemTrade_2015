package proparty;

public class PROPARTY {

//	DBのID
	public static String DBUSER = "";
//	DBのパス。
	public static String DBPASS = "";
//  集計する年数
	public static int COLLECTYEAR = 100;
	//連続アクセスを防ぐﾐﾘ秒数
	public static int SLEEPTIME = 150000;
	//ちょっと間をおいてアクセスする。その間の時間
	public static int INTERVALTIME = 600;
	//最終更新日が1年前なら分割する。
	public static int HISABISADAY_STOCK_INDEX = 1000;
	public static int HISABISADAY_STATISTICS  = 1000;


	//503エラー？たまに出るへんなやつ
	public static String NAZO = "<!DOCTYPE HTML PUBLIC \"-//W3C//DTD HTML 4.01//EN\"\"http://www.w3.org/TR/html4/strict.dtd\">";

}
