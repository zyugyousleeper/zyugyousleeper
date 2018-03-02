package utils;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpRequestBase;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.json.JSONObject;

import model.User;

public class Utils {
	
	private static User HTTPExcute(HttpRequestBase reqest) throws Exception{
		
		CloseableHttpClient client = HttpClients.createDefault();
		StringBuilder builder = new StringBuilder();
		HttpResponse response = client.execute(reqest);
		
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
		user.setStudentNum(jsonObject.getInt("user_id"));
		user.setName(jsonObject.getString("name"));
		user.setFelicaID(jsonObject.getString("felica_id"));
			
		return user;
		
	}
	
	public static User getUser(int userID) throws Exception {
		final String url = "http://192.168.1.171:8080/api/users/" + String.valueOf(userID) + "/";
		HttpGet httpGet = new HttpGet(url+"/");
		return HTTPExcute(httpGet);
	}
	
	static void deleteUser(int userID) {
		
	}
	
	static void putUser(int userID) {
		
	}
	
	static void postUser(User newUser) {
		
	}
}
