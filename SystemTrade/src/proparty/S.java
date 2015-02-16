package proparty;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class S {
	public static Connection con = null;
	public static ResultSet rs = null;
	public static ResultSet p_rs = null;
	public static Statement stmt = null;
	public static PreparedStatement pstmt = null;

//	public S(){
//		try {
//			con = DriverManager.getConnection(
//				    "jdbc:mysql://localhost/kabudata", PROPARTY.DBUSER, PROPARTY.DBPASS);
//		} catch (SQLException e) {
//			// TODO 自動生成された catch ブロック
//			e.printStackTrace();
//		}
//	}

	public void getCon(){
		try {
			con = DriverManager.getConnection(
				    "jdbc:mysql://localhost/kabudata", PROPARTY.DBUSER, PROPARTY.DBPASS);
		} catch (SQLException e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
		}
	}


	//pstmtを作る。
	//使用後はP_createClose()
	public void setPstmt(String SQL){
		try {
			pstmt = con.prepareStatement(SQL);
		} catch (SQLException e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
		}
	}

	public PreparedStatement getPstmt(){
		return pstmt;

	}

	//sql文を入力するとSQLを実行できる。使い方は以下
	//		ResultSet S.p_rs = S.freeQuery("select * from 9999_dd");
	//			while (S.p_rs.next()) {
	//		}
	//使い回し可能。
	//ただし適当なタイミングでS.P_freeQueryClose()すべし。
	public static ResultSet freeQuery(String sql){
		try {

			pstmt = con.prepareStatement(sql);

			p_rs = pstmt.executeQuery();

			return p_rs;
		} catch (SQLException e) {
			// TODO 自動生成された catch ブロック
			//e.printStackTrace();
		}
		return p_rs;
	}

	//sql文を入力するとSQLを実行できる。
	//使い回し可能。
	//ただし適当なタイミングでS.P_createclose()すべし。
	public static void freeUpdateQuery(String sql){
		try {

			pstmt = con.prepareStatement(sql);

			pstmt.executeUpdate();

		} catch (SQLException e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
			System.out.println(sql);

		}
	}


	//使うときはこんな感じ
//	S.sqlGetter().executeUpdate("CREATE DATABASE db_User");
//	S.rs = S.sqlGetter().executeQuery("select * from 9999_dd");
//	while (S.rs.next()) {
//	}
//	S.DBClose();


	public static Statement sqlGetter(){

		try {

			// ３．SQL ステートメント・オブジェクトの作成
			stmt = con.createStatement();

			return stmt;

			} catch (SQLException e1) {
				System.out.println(
					"SQLException: " + e1.getMessage());
				System.out.println(
					"    SQLState: " + e1.getSQLState());
				System.out.println(
					" VendorError: " + e1.getErrorCode());
			} catch (Exception e2) {
				System.out.println(
					"Exception: " + e2.getMessage());
			}
		return stmt;
	}


	public static void closeConection(){
		try {
			rs.close();
		} catch (Exception e) {
		}

		try {
			pstmt.close();
		} catch (Exception e) {
		}

		try {
			con.close();
		} catch (Exception e) {
		}

		try {
			stmt.close();
		} catch (Exception e) {
		}

		try {
			p_rs.close();
		} catch (Exception e) {
		}
	}










}
