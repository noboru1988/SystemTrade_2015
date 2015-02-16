package bean;

public class Bean_CodeList {
	private String code = null;
	private String codeName = null;//銘柄名

	private String market = null; //取引市場
	private String category = "0"; //業種
	private String company_flg= "0";//個別銘柄
	private String statistical_flg= "0";//統計
	private String index_flg= "0";//指数
	private String future_flg= "0";//先物
	private String etf_flg= "0";//ETF
	private String currency_flg = "0";//通貨

	public String getCodeName() {
		return codeName;
	}

	public void setCodeName(String codeName) {
		this.codeName = codeName;
	}

	public String getCode() {
		return code;
	}
	public void setCode(String code) {

		this.code = code;
	}
	public String getMarket() {
		return market;
	}
	public void setMarket(String market) {
		if (market.equals("東証")){
			this.company_flg = "0";
			this.etf_flg = "1";
		}
		this.market = market;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public String getCompany_flg() {
		return company_flg;
	}
	public void setCompany_flg() {
		this.company_flg = "1";
	}
	public String getStatistical_flg() {
		return statistical_flg;
	}
	public void setStatistical_flg() {
		this.statistical_flg = "1";
	}
	public String getIndex_flg() {
		return index_flg;
	}
	public void setIndex_flg() {
		this.index_flg = "1";
	}
	public String getFuture_flg() {
		return future_flg;
	}
	public void setFuture_flg() {
		this.future_flg = "1";
	}
	public String getEtf_flg() {
		return etf_flg;
	}
	public void setEtf_flg() {
		this.etf_flg = "1";
	}
	public String getCurrency_flg() {
		return currency_flg;
	}
	public void setCurrency_flg() {
		this.currency_flg = "1";
	}


}
