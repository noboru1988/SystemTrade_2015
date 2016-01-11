package bean;

public class Bean_CodeList {
	private String code = null;
	private String codeName = null;//銘柄名

	private String market = "-"; //取引市場
	private String category = "0"; //業種
	private String company_flg= "0";//個別銘柄
	private String statistical_flg= "0";//統計
	private String index_flg= "0";//指数
	private String future_flg= "0";//先物
	private String etf_flg= "0";//ETF
	private String currency_flg = "0";//通貨
	private String cate_flg = "0";
	//個別銘柄・・・1
	//統計・・・2
	//指数・・・3
	//ETF・・・4
	//先物・・・5
	//通貨・・・6

	private String zenRasio = "0";



	//	日付
	private String day = null;
////	業種
//	private String category = null;
////	市場
//	private String market = null;
//	時刻
	private String nowTime = null;
//	始値
	private String open = "0";
//	高値
	private String max = "0";
//	安値
	private String min = "0";
//	終値
	private String close = "0";
//	出来高
	private String deki = "0";
//	売買高
	private String baybay = "0";
//	銘柄数
	private String stockCount = "0";
//	値付
	private String takePrice = "0";
//	値上げ
	private String upPrice ="0";
//	値下げ
	private String downPrice ="0";
//	変わらず
	private String noChange = "0";
//	比較不可
	private String noCompare = "0";


	public String getCodeName() {
		return codeName;
	}
	//この中に指標とかの場合、値に合わせてsetCodeする。
	public void setCodeName(String codeName) {

		this.codeName = codeName.replaceAll("-","―").replace(" ", "").replace("・", "_").replace("(", "_").replace(")", "_").replace("（", "_").replace("）", "_");
	}

	public String getCode() {
		return code;
	}
	public void setCode(String code) {
//		this.code = code.replaceAll("-T","").replaceAll("-t","").replaceAll("-","―");
		this.code = code.replaceAll("-","―");
	}
	public String getMarket() {
		return market;
	}

	public void setCatelfg(String CATE){
		cate_flg = CATE;
	}

	public String getCateflg(){
		return cate_flg;
	}

	public String getCategory() {
		return category;
	}




//	YYYY年MM月DD日はYYYYMMDDに変換されて保持される。
	public void setDay(String x){
		x = ( ( x.replaceFirst("年", "-") ).replaceFirst("月", "-") ).replaceFirst("日", "");
		day = x;
	}

	public String getDay(){
		return day;
	}

	public void setMarket(String x){
		market = x;
	}



	public void setCategory(String x){
		category = x;
	}

	public String getCategory(String x){
		return category;
	}

	public void setNowTime(String x){

		x = x.equals("午前") ? "12:00:00":x;
		x = x.equals("日中") ? "12:00:00":x;
		x = x.equals("午後") ? "15:00:00":x;
		x = x.equals("夜間") ? "18:00:00":x;
		nowTime = x;
	}

	public String getNowTime(){
		return nowTime;
	}

	public void setOpen(String x){
		x = (x.equals("-")) ? "0" : x;
		open = x;
	}

	public String getOpen(){
		return open;
	}

	public void setMax(String x){
		x = (x.equals("-")) ? "0" : x;
		max = x;
	}

	public String getMax(){
		return max;
	}

	public void setMin(String x){
		x = (x.equals("-")) ? "0" : x;
		min = x;
	}

	public String getMin(){
		return min;
	}

	public void setClose(String x){
		x = (x.equals("-")) ? "0" : x;
		close = x;
	}

	public String getClose(){
		return close;
	}

	public void setDeki(String x){
		x = (x.equals("-")) ? "0" : x;
		deki = x;
	}

	public String getDeki(){
		return deki;
	}

	public void setBaybay(String x){
		x = (x.equals("-")) ? "0" : x;
		baybay = x;
	}

	public String getBayBay(){
		return baybay;
	}

	public void setStockCount(String x){
		x = (x.equals("-")) ? "0" : x;
		stockCount = x;
	}

	public String getStockCount(){
		return stockCount;
	}

	public void setTakePrice(String x){
		x = (x.equals("-")) ? "0" : x;
		takePrice = x;
	}

	public String getTakePrice(){
		return takePrice;
	}


	public void setUpPrice(String x){
		x = (x.equals("-")) ? "0" : x;
		upPrice = x;
	}

	public String getUpPrice(){
		return upPrice;
	}

	public void setDownPrice(String x){
		x = (x.equals("-")) ? "0" : x;
		downPrice = x;
	}

	public String getDownPrice(){
		return downPrice;
	}

	public void setNoChange(String x){
		x = (x.equals("-")) ? "0" : x;
		noChange = x;
	}

	public String getNoChange(){
		return noChange;
	}

	public void setNoCompare(String x){
		x = (x.equals("-")) ? "0" : x;
		noCompare = x;
	}

	public String getNoCompare(){
		return noCompare;
	}


//	public String getCompany_flg() {
//		return company_flg;
//	}
//	public void setCompany_flg() {
//		this.company_flg = "1";
//	}
//	public String getStatistical_flg() {
//		return statistical_flg;
//	}
//	public void setStatistical_flg() {
//		this.statistical_flg = "1";
//	}
//	public String getIndex_flg() {
//		return index_flg;
//	}
//	public void setIndex_flg() {
//		this.index_flg = "1";
//	}
//	public String getFuture_flg() {
//		return future_flg;
//	}
//	public void setFuture_flg() {
//		this.future_flg = "1";
//	}
//	public String getEtf_flg() {
//		return etf_flg;
//	}
//	public void setEtf_flg() {
//		this.etf_flg = "1";
//	}
//	public String getCurrency_flg() {
//		return currency_flg;
//	}
//	public void setCurrency_flg() {
//		this.currency_flg = "1";
//	}


}
