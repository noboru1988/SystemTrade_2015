package proparty;


public class Net_Adress {
	private static String URL;
	/**
	 * 株価データのコードリスト一覧
	 */
	public static String CODELIST_STOCK = "http://k-db.com/stocks/2015-02-03a?download=csv";

	/**
	 * 株価データの個別リストの日足取得
	 * @param stockName
	 * @param year
	 * @return
	 */
	public static String getTimeSeriesCSV_URL_DD(String stockName,int year){
		URL = "http://k-db.com/stocks/" + stockName + "?year=" + year + "&download=csv";
		return URL;
	}

	/**
	 * 株価データの個別リストの時間足取得
	 * @param stockName
	 * @param year
	 * @return
	 * @TODO どっから取得しようか
	 */
	public static String getTimeSeriesCSV_URL_HH(String stockName,int year){
		URL = "http://k-db.com/stocks/" + stockName + "?year=" + year + "&download=csv";
		return URL;
	}

}
