package test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.json.JSONArray;
import org.json.JSONObject;

public class JSONTest {
	public static void main(String[] args) {
		String buildString = "";
		CloseableHttpClient client = HttpClients.createDefault();
		HttpGet httpGet = new HttpGet(
				"http://www.ekidata.jp/api/l/25001.json");
		
		try {
			StringBuilder builder = new StringBuilder();
			HttpResponse response = client.execute(httpGet);
			int statusCode = response.getStatusLine().getStatusCode();
			if (statusCode == 200) {
				HttpEntity entity = response.getEntity();
				InputStream content = entity.getContent();
				BufferedReader reader = new BufferedReader(new InputStreamReader(content));
				String line;
				while ((line = reader.readLine()) != null) {
					builder.append(line);
				}
			} else {
				System.out.println("Failed to download file");
			}
			buildString = builder.toString();
		} catch (ClientProtocolException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		int cutStart = buildString.indexOf("[");
		int cutEnd = buildString.lastIndexOf("]");
		buildString = buildString.substring(cutStart , cutEnd+1);
		
		try {
			JSONArray jsonArray = new JSONArray(buildString);
			System.out.println("Number of entries " + jsonArray.length());
			for (int i = 0; i < jsonArray.length(); i++) {
				JSONObject jsonObject = jsonArray.getJSONObject(i);
				String buf = "駅名:" + jsonObject.getString("station_name") + "\n" +
						"緯度" + jsonObject.getString("lat") + "\n" +
						"経度" + jsonObject.getString("lon");
				System.out.println(buf);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
