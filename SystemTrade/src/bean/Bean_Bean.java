package bean;

import java.util.List;

public class Bean_Bean {
	private List<Bean_CodeList> B_C = null;
	private List<Bean_FinancialStatement> B_F = null;
	private List<Bean_Oneline> B_O = null;
	private List<Bean_TBLRecord> B_T = null;

	public void setB_C(List<Bean_CodeList> x){
		B_C = x;
	}

	public List<Bean_CodeList> getB_C(){
		return B_C;
	}

	public void setB_F(List<Bean_FinancialStatement> x){
		B_F = x;
	}

	public List<Bean_FinancialStatement> getB_F(){
		return B_F;
	}

	public void setB_O(List<Bean_Oneline> x){
		B_O = x;
	}

	public List<Bean_Oneline> getB_O(){
		return B_O;
	}

	public void setB_T(List<Bean_TBLRecord> x){
		B_T = x;
	}

	public List<Bean_TBLRecord> getB_T(){
		return B_T;
	}
}
