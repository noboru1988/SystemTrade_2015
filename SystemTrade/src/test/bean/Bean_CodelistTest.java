package test.bean;

import org.junit.Test;

import proparty.S;
import proparty.controllDay;
import bean.Bean_CodeList;

public class Bean_CodelistTest {
	Bean_CodeList TARGET = new Bean_CodeList();
	S s = new S();

	@Test
	public void testSetCode() {
		TARGET.setCode("9468-o");
		int index = TARGET.getCode().lastIndexOf("―");
		int num   = TARGET.getCode().length();
		if(TARGET.getCode().lastIndexOf("―")+2!=TARGET.getCode().length()){
			System.out.println("koko");
		}
		System.out.println(controllDay.getAJUSTMAXDAY_STATISTICS(s));
		System.out.println(controllDay.getAJUSTMAXDAY_STOCK_INDEX(s));
		
		
//		fail("a");
//		assertThat(TARGET.getCode(), is("9468"));
	}

}
