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

import netConnect.NetBean;
import SQLMETHOD.TESTSQL;

import common.commonAP;

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
		btnNewButton_1.setBounds(409, 37, 119, 27);
		add(btnNewButton_1);

		btnNewButton_2 = new JButton("テーブル作成");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNewButton_2.setAction(action_4);
		btnNewButton_2.setBounds(409, 80, 119, 27);
		add(btnNewButton_2);



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
			NB.takeCSV();
			commonAP cAP = new commonAP();
			System.out.println( cAP.checkDay("2015-11-30","2015-11-30"));
			System.out.println( cAP.checkDay("2015-11-29","2015-11-30"));
			System.out.println( cAP.checkDay("2015-11-31","2015-11-30"));
			System.out.println( cAP.checkDay("2016-11-31","2015-15-30"));
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
			putValue(NAME, "一覧作成");
			putValue(SHORT_DESCRIPTION, "Some short description");
		}
		public void actionPerformed(ActionEvent e) {
			Create aa = new Create();
			GetCodeList a = new GetCodeList();
			//コードリストテーブルを作る
			aa.createCodeTBL();

			a.controllGetStockList();

			a.controllGetFutureList();
			a.controllGetIndexList();
			a.controllGetStatisticalList();

		}
	}

	private class SwingAction_4 extends AbstractAction {
		public SwingAction_4() {
			putValue(NAME, "テーブル作成");
			putValue(SHORT_DESCRIPTION, "Some short description");
		}
		public void actionPerformed(ActionEvent e) {

			Create aa = new Create();
//			//証券とETFテーブルを作る
			aa.createTimeSereisTBL_DD();
		}
	}
}
