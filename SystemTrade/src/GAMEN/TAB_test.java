package GAMEN;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JProgressBar;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import netConnect.NC_Controller;
import netConnect.NetBean;
import proparty.S;
import proparty.controllDay;
import SQLMETHOD.TESTSQL;
import bean.Bean_Bean;

import common.commonAP;

import controller.CONTOLLBOTTON;
import controller.Create;
import controller.GetCodeList;
import controller.GetTimeSeries;

//いろいろテストする。

//とりあえずSQLをテストする

public class TAB_test extends JPanel {
	public static JTextField textField;
	private final Action action = new SwingAction();
	private JButton button;
	private final Action action_1 = new SwingAction_1();
	private JScrollPane scrollPane;
	public static  JTextArea textArea_SQLresult;
	private JButton button_1;
	private final Action action_2 = new SwingAction_2();
	private final Action action_3 = new SwingAction_3();
	private final Action action_4 = new SwingAction_4();
	private final Action action_5 = new SwingAction_5();
	private final Action action_6 = new SwingAction_6();
	private final Action action_7 = new SwingAction_7();
	private final Action action_8 = new SwingAction_8();
	private final Action action_9 = new SwingAction_9();
	private JButton btnNewButton_1;
	private JButton btnNewButton_2;

	/**
	 * Create the panel.
	 */
	public TAB_test() {
		setLayout(null);

		textField = new JTextField();
		textField.setBounds(52, 111, 136, 25);
		add(textField);
		textField.setColumns(10);

		JButton btnNewButton = new JButton("押す！");
		btnNewButton.setAction(action);
		btnNewButton.setBounds(52, 37, 119, 27);
		add(btnNewButton);

		button = new JButton("消す");
		button.setAction(action_1);
		button.setBounds(198, 37, 119, 27);
		add(button);

		scrollPane = new JScrollPane();
		scrollPane.setBounds(41, 180, 536, 277);
		add(scrollPane);

		textArea_SQLresult = new JTextArea();
		scrollPane.setViewportView(textArea_SQLresult);

		button_1 = new JButton("終了");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		button_1.setAction(action_2);
		button_1.setBounds(198, 80, 119, 27);
		add(button_1);

		JProgressBar progressBar = new JProgressBar();
		progressBar.setBounds(205, 122, 146, 14);
		add(progressBar);

		btnNewButton_1 = new JButton("一覧作成");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNewButton_1.setAction(action_3);
		btnNewButton_1.setBounds(360, 37, 168, 27);
		add(btnNewButton_1);

		btnNewButton_2 = new JButton("リスト挿入");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNewButton_2.setAction(action_4);
		btnNewButton_2.setBounds(360, 80, 168, 27);
		add(btnNewButton_2);

		JButton btnNewButton_3 = new JButton("テーブル作成");
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNewButton_3.setAction(action_5);
		btnNewButton_3.setBounds(545, 37, 155, 27);
		add(btnNewButton_3);

		JButton btnNewButton_4 = new JButton("New button");
		btnNewButton_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNewButton_4.setAction(action_6);
		btnNewButton_4.setBounds(545, 80, 155, 27);
		add(btnNewButton_4);

		JButton btnNewButton_5 = new JButton("New button");
		btnNewButton_5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNewButton_5.setAction(action_7);
		btnNewButton_5.setBounds(372, 138, 156, 27);
		add(btnNewButton_5);

		JButton btnNewButton_6 = new JButton("New button");
		btnNewButton_6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNewButton_6.setAction(action_8);
		btnNewButton_6.setBounds(545, 122, 155, 27);
		add(btnNewButton_6);

		JButton btnNewButton_7 = new JButton("New button");
		btnNewButton_7.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNewButton_7.setAction(action_9);
		btnNewButton_7.setBounds(581, 177, 155, 27);
		add(btnNewButton_7);



	}
	private class SwingAction extends AbstractAction {
		public SwingAction() {
			putValue(NAME, "押す！");
			putValue(SHORT_DESCRIPTION, "Some short description");
		}
		public void actionPerformed(ActionEvent e) {

			TESTSQL aaa = new TESTSQL();

//			aaa.testSQL(textField.getText());
			Create aa = new Create();
//			createDB DBMAKE  = new createDB();
//			S s = new S();
//			DBMAKE.CreateDB(s);
//			s.closeConection();

			GetCodeList a = new GetCodeList();
			NetBean NB = new NetBean();
			NC_Controller NC_Con = new NC_Controller();
//			NB.takeCSV();
			commonAP cAP = new commonAP();
//			NC_Con.setNC_ConUrlCsvS_STOCK_INDEX("http://k-db.com/?p=all&download=csv&date=", "2015-11-27", "2015-11-18",0);
//			NC_Con.setNC_ConUrlCsvS_STATISTICS("2015-11-27", "2015-11-18",0);
			NB.setUrlCsv("http://k-db.com/?p=all&download=csv", 2);
			Bean_Bean bbb = new Bean_Bean();
//			bbb.setList_CSVtoDTO_STOCK_INDEX(NB.getUrlCsv());
//			bbb.getList_CSVtoDTO_STOCK_INDEX();
			int p = 4149;
			System.out.println(bbb.getList_CSVtoDTO_STOCK_INDEX().get(p).getCode());
			System.out.println(bbb.getList_CSVtoDTO_STOCK_INDEX().get(p).getCodeName());
			System.out.println(bbb.getList_CSVtoDTO_STOCK_INDEX().get(p).getMarket());
			System.out.println(bbb.getList_CSVtoDTO_STOCK_INDEX().get(p).getCategory());
			System.out.println(bbb.getList_CSVtoDTO_STOCK_INDEX().get(p).getCateflg());

			for(int i=0;i<100;i++){

			}




//			for(int i = NB.getUrlCsvS().size()-1;i>=0;i--){
//				System.out.println(NB.getUrlCsvS().get(i).get(0));
//			}





//コードリストテーブルを作る
//			aa.createCodeTBL();

//			a.controllGetStockList();

//			a.controllGetFutureList();
//			a.controllGetIndexList();
//			a.controllGetStatisticalList();
//			//証券とETFテーブルを作る
//			aa.createTimeSereisTBL_DD();

//各日々データの取得
			GetTimeSeries gt = new GetTimeSeries ();
//			gt.getTimeSeries_DD();
			//x.codeGetter();
			textArea_SQLresult.append(textField.getText() + "\n");
		}
	}
	private class SwingAction_1 extends AbstractAction {
		public SwingAction_1() {
			putValue(NAME, "消す");
			putValue(SHORT_DESCRIPTION, "Some short description");
		}
		public void actionPerformed(ActionEvent e) {
			textArea_SQLresult.setText(null);

		}
	}
	private class SwingAction_2 extends AbstractAction {
		public SwingAction_2() {
			putValue(NAME, "終了");
			putValue(SHORT_DESCRIPTION, "Some short description");
		}
		public void actionPerformed(ActionEvent e) {
			System.exit(0);
		}
	}

	private class SwingAction_3 extends AbstractAction {
		public SwingAction_3() {
			putValue(NAME, "一覧TBL&DB作成_毎日");
			putValue(SHORT_DESCRIPTION, "Some short description");
		}
		public void actionPerformed(ActionEvent e) {

			GetCodeList a = new GetCodeList();
			CONTOLLBOTTON CB = new CONTOLLBOTTON();
			long start = System.currentTimeMillis();
			S s = new S();
			//コードリストテーブルを作る、日々の更新をする。

			s.getCon();
			CB.everyDayBottonContoroll_STATISTICS (controllDay.getMAX_DD_STATISTICS(s) 		 ,
												   controllDay.getAJUSTMAXDAY_STATISTICS (s) ,
												   s											);
			CB.everyDayBottonContoroll_STOCK_INDEX(controllDay.getMAX_DD_STOCK_INDEX(s) 	 ,
												   controllDay.getAJUSTMAXDAY_STOCK_INDEX(s) ,
												   s											);

			System.out.println();
			System.out.println();

			s.closeConection();

			long stop = System.currentTimeMillis();
		    System.out.println("実行にかかった時間は " + (stop - start) + " ミリ秒です。");

		}
	}

	private class SwingAction_4 extends AbstractAction {
		public SwingAction_4() {
			putValue(NAME, "セットアップ");
			putValue(SHORT_DESCRIPTION, "Some short description");
		}
		public void actionPerformed(ActionEvent e) {
			GetCodeList GC = new GetCodeList();
			Create aa = new Create();
			aa.createDB_CodeTBL();
//			GC.controllCreateDB_GetList();

		}
	}

	private class SwingAction_5 extends AbstractAction {
		public SwingAction_5() {
			putValue(NAME, "テーブル作成");
			putValue(SHORT_DESCRIPTION, "Some short description");
		}
		public void actionPerformed(ActionEvent e) {

			System.out.println("a");
		}
	}

	private class SwingAction_6 extends AbstractAction {
		public SwingAction_6() {
			putValue(NAME, "テーブル作成ああ");
			putValue(SHORT_DESCRIPTION, "Some short description");
		}
		public void actionPerformed(ActionEvent e) {

			System.out.println("b");
		}
	}

	private class SwingAction_7 extends AbstractAction {
		public SwingAction_7() {
			putValue(NAME, "テーブル作成あ");
			putValue(SHORT_DESCRIPTION, "Some short description");
		}
		public void actionPerformed(ActionEvent e) {

			System.out.println("c");
		}
	}

	private class SwingAction_8 extends AbstractAction {
		public SwingAction_8() {
			putValue(NAME, "テーブル作成あ");
			putValue(SHORT_DESCRIPTION, "Some short description");
		}
		public void actionPerformed(ActionEvent e) {

			System.out.println("d");
		}
	}

	private class SwingAction_9 extends AbstractAction {
		public SwingAction_9() {
			putValue(NAME, "テーブル作成あ");
			putValue(SHORT_DESCRIPTION, "Some short description");
		}
		public void actionPerformed(ActionEvent e) {

			System.out.println("e");
		}
	}
}
