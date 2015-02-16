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

import SQLMETHOD.TESTSQL;
import controller.Create;
import controller.GetCodeList;

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
			
			
			aa.createCodeTBL();
			a.controllGetStockList();
			aa.createTimeSereisTBL_DD();


//			GetTimeSeries gt = new GetTimeSeries ();
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
}
