package utils;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpDelete;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpRequestBase;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.protocol.HTTP;
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
		final String url = "http://192.168.1.219:8080/api/users/" + String.valueOf(userID) + "/";
		HttpGet httpGet = new HttpGet(url);
		return HTTPExcute(httpGet);
	}
	
	public static void deleteUser(int userID) throws Exception {
		final String url = "http://192.168.1.219:8080/api/users/" + String.valueOf(userID) + "/";
		HttpDelete httpGet = new HttpDelete(url+"/");
		HTTPExcute(httpGet);	
	}
	
	static void putUser(User user) throws Exception {
		final String url = "http://192.168.1.219:8080/api/users/" + String.valueOf(user.getStudentNum()) + "/";
		HttpPost put = new HttpPost(url);
		
		ArrayList<NameValuePair> params = new ArrayList<NameValuePair>();
		params.add(new BasicNameValuePair("name", user.getName()));
		params.add(new BasicNameValuePair("felica_id", user.getFelicaID()));
		params.add(new BasicNameValuePair("user_id", String.valueOf(user.getStudentNum())));
		
		HTTPExcute(put);
	}
	
	public static void postUser(User newUser) throws Exception{
		final String url = "http://192.168.1.219:8080/api/users/" + String.valueOf(newUser.getStudentNum()) + "/";
		HttpPost post = new HttpPost(url);
		
		ArrayList<NameValuePair> params = new ArrayList<NameValuePair>();
		params.add(new BasicNameValuePair("name", newUser.getName()));
		params.add(new BasicNameValuePair("felica_id", newUser.getFelicaID()));
		params.add(new BasicNameValuePair("user_id", String.valueOf(newUser.getStudentNum())));
		
		HTTPExcute(post);
	}
}
