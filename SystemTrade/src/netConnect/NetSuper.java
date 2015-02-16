package netConnect;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public class NetSuper {
	//skipDay,skipTimeがnullの場合の処理
	private List<String> netFile = new ArrayList<String>();
	private boolean stopFlg;
	private boolean endFlg;


	//URL、スキップする行数、スキップする日付よりも小さい日付、スキップするよりも小さいタイム
	public void setPlusNetCSV(String URL,int skipLine,String skipDay,String skipTime){

		skipTime = skipDay + "," + skipTime;
		if (skipTime.equals("null,null")){
			skipTime = "";
		}

		HttpURLConnection connect = null;
		URL url = null;
		InputStream in = null;
		InputStreamReader isr = null;
		BufferedReader baf = null;
		try{ //概ねの操作で例外処理が必要です。
			//URLを作成する
			String adress= URL;
			url=new URL(adress);//URLを設定
			// URL接続
			connect = (HttpURLConnection)url.openConnection();//サイトに接続
			connect.setRequestMethod("GET");//プロトコルの設定
			in=connect.getInputStream();//ファイルを開く
			isr = new InputStreamReader( in,"SJIS");
			baf = new BufferedReader(isr);

			//スキップラインに入力された数だけ遅らせる。
			for (int i = 0;i<skipLine;i++){
				baf.readLine();
			}

			String lineRecord = baf.readLine();

			//重複ファイルのチェックを行う。netFileの0番目と現在読み取ったファイルの一行目を比較する。
			//同じだった場合、処理終了
			//異なった場合、処理続行
			try{
				if (lineRecord.equals(netFile.get(0))){
					stopFlg = false;
					return;
				}else{
					//Aの先頭文字がskiplineに等しくなければnetFileに追加する。
					//AがskipTime以前のものであればaddしない
					if(skipTime.compareTo(lineRecord)<0){
						//入れる
						netFile.add(lineRecord);
					}
				}
			}catch(IndexOutOfBoundsException e){

				//Aの先頭文字がskiplineに等しくなければnetFileに追加する。
				//AがskipTime以前のものであればaddしない
				if(skipTime.compareTo(lineRecord)<0){
					//入れる
					netFile.add(lineRecord);
				}

			}


			while ((lineRecord = baf.readLine()) != null) {
				//Aの先頭文字がskiplineに等しくなければnetFileに追加する。
				//AがskipTime以前のものであればaddしない
				if(skipTime.compareTo(lineRecord)<0){
					//入れる
					netFile.add(lineRecord);
				}
			}
		}catch(Exception e){
			//例外処理が発生したら、表示する
			//			System.out.println("Err =" + e);
			e.printStackTrace();
			stopFlg = false;
			System.out.println("ページがないよ：" + URL);
		}finally{
			try {
				//				URL切断
				baf.close();
				isr.close();
				in.close();//InputStreamを閉じる
				connect.disconnect();//サイトの接続を切断
			} catch (IOException e) {
			}
		}
	}

	public void setNetCSV(String URL,int skipLine,String skipDay,String skipTime){
		netFile = new ArrayList<String>();
		stopFlg = true;
		endFlg = true;
		setPlusNetCSV(URL,skipLine,skipTime);
	}

	public void setNetCSV(String URL,int skipLine,String skipDay){
		netFile = new ArrayList<String>();
		stopFlg = true;
		endFlg = true;
		setPlusNetCSV(URL,skipLine,skipDay);
	}

	public void setPlusNetCSV(String URL,int skipLine,String skipDay){

		HttpURLConnection connect = null;
		URL url = null;
		InputStream in = null;
		InputStreamReader isr = null;
		BufferedReader baf = null;
		try{ //概ねの操作で例外処理が必要です。
			//URLを作成する
			String adress= URL;
			url=new URL(adress);//URLを設定
			// URL接続
			connect = (HttpURLConnection)url.openConnection();//サイトに接続
			connect.setRequestMethod("GET");//プロトコルの設定
			in=connect.getInputStream();//ファイルを開く
			isr = new InputStreamReader( in,"SJIS");
			baf = new BufferedReader(isr);

			//スキップラインに入力された数だけ遅らせる。
			for (int i = 0;i<skipLine;i++){
				baf.readLine();
			}



			String lineRecord = baf.readLine();

			//重複ファイルのチェックを行う。netFileの0番目と現在読み取ったファイルの一行目を比較する。
			//同じだった場合、処理終了
			//異なった場合、処理続行
			try{
				//繰り返しページのチェック
				if (lineRecord.equals(netFile.get(0))){
					stopFlg = false;
					return;
				}else{

					//AがskipDay以前のものであればaddしない
					if(skipDay.compareTo(lineRecord)<0){
						//入れる
//						if (lineRecord.startsWith(skipDay)){
//
//						}else{
							netFile.add(lineRecord);
//						}
					}

				}
			}catch(IndexOutOfBoundsException e){

				//AがskipDay以前のものであればaddしない
				if(skipDay.compareTo(lineRecord)<0){
					//入れる
					if (lineRecord.startsWith(skipDay)){
						endFlg = false;
						return;
					}else{
						netFile.add(lineRecord);
					}
				}


			}


			while ((lineRecord = baf.readLine()) != null) {
				//AがskipDay以前のものであればaddしない
				if(skipDay.compareTo(lineRecord)<0){
					//入れる

						netFile.add(lineRecord);

				}


			}
		}catch(Exception e){
			//例外処理が発生したら、表示する
			//			System.out.println("Err =" + e);
			e.printStackTrace();
			stopFlg = false;
			System.out.println("ページがないよ：" + URL);
		}finally{
			try {
				//				URL切断
				baf.close();
				isr.close();
				in.close();//InputStreamを閉じる
				connect.disconnect();//サイトの接続を切断
			} catch (IOException e) {
			}
		}
	}

	public void setNetCSV(String URL,int skipLine){
		stopFlg = true;
		endFlg = true;
		netFile = new ArrayList<String>();
		setPlusNetCSV(URL,skipLine);

	}

	public void setPlusNetCSV(String URL,int skipLine){

		HttpURLConnection connect = null;
		URL url = null;
		InputStream in = null;
		InputStreamReader isr = null;
		BufferedReader baf = null;
		try{ //概ねの操作で例外処理が必要です。
			//URLを作成する
			String adress= URL;
			url=new URL(adress);//URLを設定
			// URL接続
			connect = (HttpURLConnection)url.openConnection();//サイトに接続
			connect.setRequestMethod("GET");//プロトコルの設定
			in=connect.getInputStream();//ファイルを開く
			isr = new InputStreamReader( in,"SJIS");
			baf = new BufferedReader(isr);

			//スキップラインに入力された数だけ遅らせる。
			for (int i = 0;i<skipLine;i++){
				baf.readLine();
			}

			String lineRecord = baf.readLine();

			//重複ファイルのチェックを行う。netFileの0番目と現在読み取ったファイルの一行目を比較する。
			//同じだった場合、処理終了
			//異なった場合、処理続行
			try{

				System.out.println(lineRecord);
				System.out.println(netFile.get(0));
				System.out.println(lineRecord.equals(netFile.get(0)));
				if (lineRecord.equals(netFile.get(0))){

					stopFlg = false;
					return;
				}else{
					netFile.add(lineRecord);
				}
			}catch(IndexOutOfBoundsException e){
				netFile.add(lineRecord);
			}



			while ((lineRecord = baf.readLine()) != null) {

				netFile.add(lineRecord);
			}
		}catch(Exception e){
			//例外処理が発生したら、表示する
			//			System.out.println("Err =" + e);
			e.printStackTrace();
			stopFlg = false;
			System.out.println("ページがないよ：" + URL);
		}finally{
			try {
				//				URL切断
				baf.close();
				isr.close();
				in.close();//InputStreamを閉じる
				connect.disconnect();//サイトの接続を切断
			} catch (IOException e) {
			}
		}
	}

	public void setNetCSV(String URL){
		stopFlg = true;
		netFile = new ArrayList<String>();
		setplusNetCSV(URL);

	}

	public void setplusNetCSV(String URL){

		HttpURLConnection connect = null;
		URL url = null;
		InputStream in = null;
		InputStreamReader isr = null;
		BufferedReader baf = null;
		try{ //概ねの操作で例外処理が必要です。
			//URLを作成する
			String adress= URL;
			url=new URL(adress);//URLを設定
			// URL接続
			connect = (HttpURLConnection)url.openConnection();//サイトに接続
			connect.setRequestMethod("GET");//プロトコルの設定
			in=connect.getInputStream();//ファイルを開く
			isr = new InputStreamReader( in,"SJIS");
			baf = new BufferedReader(isr);


			String A = null;
			while ((A = baf.readLine()) != null) {

				netFile.add(A);
			}
		}catch(Exception e){
			//例外処理が発生したら、表示する
			//			System.out.println("Err =" + e);
			e.printStackTrace();
			stopFlg = false;
			System.out.println("ページがないよ：" + URL);
		}finally{
			try {
				//				URL切断
				baf.close();
				isr.close();
				in.close();//InputStreamを閉じる
				connect.disconnect();//サイトの接続を切断
			} catch (IOException e) {
			}
		}
	}

	public List<String> getNetCSV(){
		return netFile;
	}



	public boolean getFlg(){
		return stopFlg;
	}

	public boolean getEndFlg(){
		return endFlg;
	}
}
