package utils;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.json.JSONObject;

import model.User;

public class Utils {
	static User getUser(int userID) throws Exception {
		CloseableHttpClient client = HttpClients.createDefault();
		HttpGet httpGet = new HttpGet("http://www.ekidata.jp/api/l/25001.json");
		StringBuilder builder = new StringBuilder();
		HttpResponse response = client.execute(httpGet);
		
		int statusCode = response.getStatusLine().getStatusCode();
		if (statusCode != 200) throw new Exception();
		
		HttpEntity entity = response.getEntity();
		InputStream content = entity.getContent();
		BufferedReader reader = new BufferedReader(new InputStreamReader(content));
		String line;
		while ((line = reader.readLine()) != null) {
			builder.append(line);
		}
		
		JSONObject jsonObject = new JSONObject(builder.toString());
		
		User user = new User();
		user.setStudentNum(jsonObject.getInt("userID"));
		user.setName(jsonObject.getString("name"));
		user.setFelicaID(jsonObject.getString("felicaID"));
			
		return user;
	}
	
	static void deleteUser(int userID) {
		
	}
	
	static void putUser(int userID) {
		
	}
	
	static void postUser(User newUser) {
		
	}
}
