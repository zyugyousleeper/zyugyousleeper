package utils;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpDelete;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPatch;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpRequestBase;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;


import model.Money;
import model.User;

public class Utils {
	
	public static final String baseUrl = "http://192.168.1.219/api/users/";
	
	public static HttpResponse HTTPExecute(HttpRequestBase reqest) throws Exception{
//		reqest.addHeader("Authorization", "Basic " + Base64.encodeBase64String("root:mokemokemokemoke".getBytes()));
//		reqest.setHeader("Authorization", "Basic " + "cm9vdDptb2tlbW9rZW1va2Vtb2tl");
		
		CloseableHttpClient client = HttpClients.createDefault();
		HttpResponse response = client.execute(reqest);
		
		int statusCode = response.getStatusLine().getStatusCode();
		if (statusCode %100 ==2) throw new Exception();
		
		return response;
	}
	
	public static String getReturnedJsonString(HttpResponse response) throws UnsupportedOperationException, IOException {
		HttpEntity entity = response.getEntity();
		InputStream content = entity.getContent();
		BufferedReader reader = new BufferedReader(new InputStreamReader(content));
		
		String line;
		StringBuilder builder = new StringBuilder();
		while ((line = reader.readLine()) != null) {
			builder.append(line);
		}
			
		return builder.toString();
	}
	
	public static User getUserFromJsonString(String jsonString) throws JSONException {
		JSONObject jsonObject = new JSONObject(jsonString);
		
		User user = new User();
		user.setStudentNum(jsonObject.getInt("user_id"));
		user.setName(jsonObject.getString("name"));
		user.setFelicaID(jsonObject.getString("felica_id"));
		user.setMoney(new Money(jsonObject.getInt("money")));
		
		return user;
	}
	
	public static ArrayList<User> getUsersFromJsonString(String jsonString) throws JSONException {
		JSONArray jsonArray = new JSONArray(jsonString);
		
		ArrayList<User> users = new ArrayList<User>();
		for (int i = 0; i < jsonArray.length(); i++) {
			users.add(getUserFromJsonString(jsonArray.getJSONObject(i).toString()));
		}
		
		return users;
	}
	
	public static String generateEntity(User user) {
		String entity = "{"
				+ "\"name\":\"" + user.getName() + "\","
				+ "\"user_id\":" + String.valueOf(user.getStudentNum()) + ","
				+ "\"felica_id\":\"" + user.getFelicaID() + "\","
				+ "\"money\":"+String.valueOf(user.getMoney().getMoney())
				+ "}";
		return entity;
	}

	public static User getUser(int userID) throws Exception {
		final String url = baseUrl + String.valueOf(userID) + "/";
		HttpGet get = new HttpGet(url);
		
		HttpResponse response = HTTPExecute(get);
		String jsonString = getReturnedJsonString(response);
		
		return getUserFromJsonString(jsonString);
	}
	
	public static User getUserFromFerica(String felicaID) throws Exception {
		User user = null;
		ArrayList<User> users = Utils.getUsers();
	
		for(User u : users) {
			if(u.getFelicaID().equals(felicaID)) user = u;
		}
		
		if(user==null) throw new Exception("そんなUSERは存在しない");
		return user;
	}
	
	public static ArrayList<User> getUsers() throws Exception {
		HttpGet get = new HttpGet(baseUrl);
		
		HttpResponse response = HTTPExecute(get);
		String jsonString = getReturnedJsonString(response);
		
		return getUsersFromJsonString(jsonString);
	}
	
	public static void deleteUser(int userID) throws Exception {
		final String url = baseUrl + String.valueOf(userID) + "/";
		HttpDelete delete = new HttpDelete(url);
		
		HTTPExecute(delete);	
	}
	
	public static User patchUser(User user) throws Exception {
		final String url = baseUrl + String.valueOf(user.getStudentNum()) + "/";
		HttpPatch patch = new HttpPatch(url);
        
		patch.setHeader("Content-type", "application/json; charset=UTF-8");
       patch.setEntity(new StringEntity(generateEntity(user), "UTF-8"));
		
       HttpResponse response = HTTPExecute(patch);
		String jsonString = getReturnedJsonString(response);
		
		return getUserFromJsonString(jsonString);
	}
	
	public static User postUser(User newUser) throws Exception{
		HttpPost post = new HttpPost(baseUrl);
        
		post.setHeader("Content-type", "application/json; charset=UTF-8");
       post.setEntity(new StringEntity(generateEntity(newUser), "UTF-8"));
		
       HttpResponse response = HTTPExecute(post);
		String jsonString = getReturnedJsonString(response);
		
		return getUserFromJsonString(jsonString);
	}
}
