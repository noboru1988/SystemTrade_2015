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

	public String getCodeName() {
		return codeName;
	}
	//この中に指標とかの場合、値に合わせてsetCodeする。
	public void setCodeName(String codeName) {

		//この中に先物の場合の処理を書く
		switch(codeName){
			case "日経平均先物":
				this.code = "F101-0001";
				break;
			case "日経225mini先物":
				this.code ="F102-0001";
				break;
			case "JPX日経400先物":
				this.code ="F103-0000";
				break;
			case "TOPIX先物":
				this.code ="F104-0000";
				break;
			case "ミニTOPIX先物":
				this.code ="F105-0000";
				break;
			case "日経平均VI先物":
				this.code ="F106-0000";
				break;
			case "東証REIT指数先物":
				this.code ="F108-0000";
				break;
			case "大証NYダウ先物":
				this.code ="F109-0000";
				break;
		}

		//この中に統計の場合の処理を書く
		switch(codeName){
		case "東証1部":
			this.code = "T1";
			break;
		case "JQスタンダード":
			this.code = "JQS";
			break;
		case "東証1部_鉱業":
			this.code = "T1-I202";
			break;
		case "東証1部_繊維製品":
			this.code = "T1-I205";
			break;
		case "東証1部_医薬品":
			this.code = "T1-I208";
			break;
		case "東証1部_ガラス土石製品":
			this.code = "T1-I211";
			break;
		case "東証1部_金属製品":
			this.code = "T1-I214";
			break;
		case "東証1部_輸送用機器":
			this.code = "T1-I217";
			break;
		case "東証1部_電気・ガス業":
			this.code = "T1-I220";
			break;
		case "東証1部_空運業":
			this.code = "T1-I223";
			break;
		case "東証1部_卸売業":
			this.code = "T1-I226";
			break;
		case "東証1部_証券商品先物":
			this.code = "T1-I229";
			break;
		case "東証1部_不動産業":
			this.code = "T1-I232";
			break;
		case "東証2部":
			this.code = "T2";
			break;
		case "JQグロース":
			this.code = "JQG";
			break;
		case "東証1部_建設業":
			this.code = "T1-I203";
			break;
		case "東証1部_パルプ・紙":
			this.code = "T1-I206";
			break;
		case "東証1部_石油石炭製品":
			this.code = "T1-I209";
			break;
		case "東証1部_鉄鋼":
			this.code = "T1-I212";
			break;
		case "東証1部_機械":
			this.code = "T1-I215";
			break;
		case "東証1部_精密機器":
			this.code = "T1-I218";
			break;
		case "東証1部_陸運業":
			this.code = "T1-I221";
			break;
		case "東証1部_倉庫運輸関連":
			this.code = "T1-I224";
			break;
		case "東証1部_小売業":
			this.code = "T1-I227";
			break;
		case "東証1部_保険業":
			this.code = "T1-I230";
			break;
		case "東証1部_サービス業":
			this.code = "T1-I233";
			break;
		case "東証マザーズ":
			this.code = "TM";
			break;
		case "東証1部_水産・農林業":
			this.code = "T1-I201";
			break;
		case "東証1部_食料品":
			this.code = "T1-I204";
			break;
		case "東証1部_化学":
			this.code = "T1-I207";
			break;
		case "東証1部_ゴム製品":
			this.code = "T1-I210";
			break;
		case "東証1部_非鉄金属":
			this.code = "T1-I213";
			break;
		case "東証1部_電気機器":
			this.code = "T1-I216";
			break;
		case "東証1部_その他製品":
			this.code = "T1-I219";
			break;
		case "東証1部_海運業":
			this.code = "T1-I222";
			break;
		case "東証1部_情報・通信業":
			this.code = "T1-I225";
			break;
		case "東証1部_銀行業":
			this.code = "T1-I228";
			break;
		case "東証1部_その他金融業":
			this.code = "T1-I231";
			break;
		}
		//この中に指標の場合の処理を書く
		switch(codeName){
		case "日経平均株価":
			this.code = "I101";
			break;
		case "東証2部株価指数":
			this.code = "I104";
			break;
		case "TOPIX ラージ 70":
			this.code = "I112";
			break;
		case "TOPIX 500":
			this.code = "I115";
			break;
		case "TOPIX バリュー指数":
			this.code = "I118";
			break;
		case "TOPIX 500 グロース指数":
			this.code = "I121";
			break;
		case "TOPIX レバレッジ(2倍)指数":
			this.code = "I124";
			break;
		case "TOPIX Ex-Financials":
			this.code = "I130";
			break;
		case "東証REIT指数":
			this.code = "I133";
			break;
		case "東証REIT商業物流等指数":
			this.code = "I136";
			break;
		case "東証規模別株価指数 小型":
			this.code = "I139";
			break;
		case "TOPIX コンポジット 1500":
			this.code = "I143";
			break;
		case "東証マザーズ コンポジット株価指数":
			this.code = "I146";
			break;
		case "TOPIX-17 エネルギー資源":
			this.code = "I151";
			break;
		case "TOPIX-17 医薬品":
			this.code = "I154";
			break;
		case "TOPIX-17 機械":
			this.code = "I157";
			break;
		case "TOPIX-17 電力・ガス":
			this.code = "I160";
			break;
		case "TOPIX-17 小売":
			this.code = "I163";
			break;
		case "TOPIX-17 不動産":
			this.code = "I166";
			break;
		case "業種別株価指数 建設業":
			this.code = "I203";
			break;
		case "業種別株価指数 パルプ・紙":
			this.code = "I206";
			break;
		case "業種別株価指数 石油石炭製品":
			this.code = "I209";
			break;
		case "業種別株価指数 鉄鋼":
			this.code = "I212";
			break;
		case "業種別株価指数 機械":
			this.code = "I215";
			break;
		case "業種別株価指数 精密機器":
			this.code = "I218";
			break;
		case "業種別株価指数 陸運業":
			this.code = "I221";
			break;
		case "業種別株価指数 倉庫運輸関連":
			this.code = "I224";
			break;
		case "業種別株価指数 小売業":
			this.code = "I227";
			break;
		case "業種別株価指数 保険業":
			this.code = "I230";
			break;
		case "業種別株価指数 サービス業":
			this.code = "I233";
			break;
		case "JASDAQ INDEX グロース":
			this.code = "I303";
			break;
		case "TOPIX":
			this.code = "I102";
			break;
		case "東証マザーズ指数":
			this.code = "I105";
			break;
		case "TOPIX 100":
			this.code = "I113";
			break;
		case "TOPIX スモール":
			this.code = "I116";
			break;
		case "TOPIX グロース指数":
			this.code = "I119";
			break;
		case "TOPIX Small バリュー指数":
			this.code = "I122";
			break;
		case "TOPIX インバース(-1倍)指数":
			this.code = "I125";
			break;
		case "TOPIXアジア関連株指数":
			this.code = "I131";
			break;
		case "東証REITオフィス指数":
			this.code = "I134";
			break;
		case "東証規模別株価指数 大型":
			this.code = "I137";
			break;
		case "日経500種平均":
			this.code = "I141";
			break;
		case "TOPIX コンポジット":
			this.code = "I144";
			break;
		case "東証配当フォーカス100指数":
			this.code = "I147";
			break;
		case "TOPIX-17 建設・資材":
			this.code = "I152";
			break;
		case "TOPIX-17 自動車・輸送機":
			this.code = "I155";
			break;
		case "TOPIX-17 電機・精密":
			this.code = "I158";
			break;
		case "TOPIX-17 運輸・物流":
			this.code = "I161";
			break;
		case "TOPIX-17 銀行":
			this.code = "I164";
			break;
		case "業種別株価指数 水産・農林業":
			this.code = "I201";
			break;
		case "業種別株価指数 食料品":
			this.code = "I204";
			break;
		case "業種別株価指数 化学":
			this.code = "I207";
			break;
		case "業種別株価指数 ゴム製品":
			this.code = "I210";
			break;
		case "業種別株価指数 非鉄金属":
			this.code = "I213";
			break;
		case "業種別株価指数 電気機器":
			this.code = "I216";
			break;
		case "業種別株価指数 その他製品":
			this.code = "I219";
			break;
		case "業種別株価指数 海運業":
			this.code = "I222";
			break;
		case "業種別株価指数 情報・通信業":
			this.code = "I225";
			break;
		case "業種別株価指数 銀行業":
			this.code = "I228";
			break;
		case "業種別株価指数 その他金融業":
			this.code = "I231";
			break;
		case "JASDAQ INDEX":
			this.code = "I301";
			break;
		case "JASDAQ-TOP20":
			this.code = "I305";
			break;
		case "JPX日経インデックス400":
			this.code = "I103";
			break;
		case "TOPIX コア 30":
			this.code = "I111";
			break;
		case "TOPIX ミッド 400":
			this.code = "I114";
			break;
		case "TOPIX 1000":
			this.code = "I117";
			break;
		case "TOPIX 500 バリュー指数":
			this.code = "I120";
			break;
		case "TOPIX Small グロース指数":
			this.code = "I123";
			break;
		case "TOPIX ダブルインバース(-2倍)指数":
			this.code = "I126";
			break;
		case "東証マザーズCore指数":
			this.code = "I132";
			break;
		case "東証REIT住宅指数":
			this.code = "I135";
			break;
		case "東証規模別株価指数 中型":
			this.code = "I138";
			break;
		case "日経株価指数300":
			this.code = "I142";
			break;
		case "東証2部 コンポジット株価指数":
			this.code = "I145";
			break;
		case "TOPIX-17 食品":
			this.code = "I150";
			break;
		case "TOPIX-17 素材・化学":
			this.code = "I153";
			break;
		case "TOPIX-17 鉄鋼・非鉄":
			this.code = "I156";
			break;
		case "TOPIX-17 情報通信・サービスその他":
			this.code = "I159";
			break;
		case "TOPIX-17 商社・卸売":
			this.code = "I162";
			break;
		case "TOPIX-17 金融 (除く銀行)":
			this.code = "I165";
			break;
		case "業種別株価指数 鉱業":
			this.code = "I202";
			break;
		case "業種別株価指数 繊維製品":
			this.code = "I205";
			break;
		case "業種別株価指数 医薬品":
			this.code = "I208";
			break;
		case "業種別株価指数 ガラス土石製品":
			this.code = "I211";
			break;
		case "業種別株価指数 金属製品":
			this.code = "I214";
			break;
		case "業種別株価指数 輸送用機器":
			this.code = "I217";
			break;
		case "業種別株価指数 電気・ガス業":
			this.code = "I220";
			break;
		case "業種別株価指数 空運業":
			this.code = "I223";
			break;
		case "業種別株価指数 卸売業":
			this.code = "I226";
			break;
		case "業種別株価指数 証券商品先物":
			this.code = "I229";
			break;
		case "業種別株価指数 不動産業":
			this.code = "I232";
			break;
		case "JASDAQ INDEX スタンダード":
			this.code = "I302";
			break;
		case "日経ジャスダック平均株価":
			this.code = "I306";
			break;

		}

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
