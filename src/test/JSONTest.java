package test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.json.JSONArray;
import org.json.JSONObject;
import org.omg.CORBA_2_3.portable.InputStream;

import sun.net.www.http.HttpClient;

public class JSONTest {
	public static void main(String[] args) {
		StringBuilder builder = new StringBuilder();
		DefaultHttpClient client = new DefaultHttpClient();
		HttpGet httpGet = new HttpGet(
				"https://api.twitter.com/1/statuses/user_timeline.json?screen_name=takapon_jp");
		
		try {
			//リクエストしたリンクが存在するか確認するために、HTTPリクエストを送ってHTTPレスポンスを取得する
			HttpResponse response = client.execute(httpGet);
			//返却されたHTTPレスポンスの中のステータスコードを調べる
			// -> statusCodeが200だったらページが存在。404だったらNot found（ページが存在しない）。500はInternal server error。
			int statusCode = response.getStatusLine().getStatusCode();
			if (statusCode == 200) {
				//HTTPレスポンスが200よりページは存在する
				//レスポンスからHTTPエンティティ（実体）を生成
				HttpEntity entity = response.getEntity();
				//HTTPエンティティからコンテント（中身）を生成
				InputStream content = (InputStream) entity.getContent();
				//コンテントからInputStreamReaderを生成し、さらにBufferedReaderを作る
				//InputStreamReaderはテキストファイル（InputStream）を読み込む
				//BufferedReaderはテキストファイルを一行ずつ読み込む
				//（参考）http://www.tohoho-web.com/java/file.htm
				BufferedReader reader = new BufferedReader(new InputStreamReader(content));
				String line;
				//readerからreadline()で行を読んで、builder文字列(StringBuilderクラス)に格納していく。
				//※このプログラムの場合、lineは一行でなのでループは回っていない
				//※BufferedReaderを使うときは一般にこのように記述する。
				while ((line = reader.readLine()) != null) {
					builder.append(line);
				}
			} else {
				System.out.println("Failed to download file");
			}
		} catch (ClientProtocolException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		// 文字列をJSONオブジェクトに変換する
		try {
			//JSON Arrayを作成する(文字列としてのJSONをJSON Arrayに変換)
			//builderはStringBuilderクラスなのでtoString()で文字列に変換
			JSONArray jsonArray = new JSONArray(builder.toString());
			//JSON Arrayのサイズを表示
			System.out.println("Number of entries " + jsonArray.length());
			//JSON Objectを作成する
			for (int i = 0; i < jsonArray.length(); i++) {
				//getJSONObjectでJSON Arrayに格納された要素をJSON Objectとして取得できる
				JSONObject jsonObject = jsonArray.getJSONObject(i);
				//JSON Objectをパースする
				//表示する際はgetString("ほげほげ")で"ほげほげ"をキーとする値を取得できる
				//userのように入れ子になっているときは、getJSONObject()を使って階層を下っていく
                                System.out.println(i);
				System.out.println("投稿日："+jsonObject.getString("created_at"));
				System.out.println("ツイート内容："+jsonObject.getString("text"));
				System.out.println("ユーザー自己紹介："+jsonObject.getJSONObject("user").getString("description"));				
				System.out.println();//改行
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
