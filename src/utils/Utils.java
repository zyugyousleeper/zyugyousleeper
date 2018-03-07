package utils;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.Charset;
import java.util.ArrayList;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpDelete;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPatch;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpRequestBase;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.protocol.HTTP;
import org.json.JSONObject;

import com.mysql.jdbc.Buffer;

import model.Money;
import model.User;

public class Utils {
	
	private static User HTTPExcute(HttpRequestBase reqest) throws Exception{
		
		CloseableHttpClient client = HttpClients.createDefault();
		StringBuilder builder = new StringBuilder();
		HttpResponse response = client.execute(reqest);
		
		int statusCode = response.getStatusLine().getStatusCode();
		System.out.println(statusCode);
		if (statusCode %100 ==2) throw new Exception();
		
		HttpEntity entity = response.getEntity();
		if (entity == null) return new User();
		
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
		user.setMoney(new Money(jsonObject.getInt("money")));
			
		return user;
		
	}
	
	public static User getUser(int userID) throws Exception {
		final String url = "http://192.168.1.219/api/users/" + String.valueOf(userID) + "/";
		HttpGet get = new HttpGet(url);
		return HTTPExcute(get);
	}
	
	public static void deleteUser(int userID) throws Exception {
		final String url = "http://192.168.1.219/api/users/" + String.valueOf(userID) + "/";
		HttpDelete delete = new HttpDelete(url);
		HTTPExcute(delete);	
	}
	
	public static User patchUser(User user) throws Exception {
		final String url = "http://192.168.1.219/api/users/" + String.valueOf(user.getStudentNum()) + "/";
		HttpPatch patch = new HttpPatch(url);
		
		String entity = 
				"{\"name\":\""+user.getName()+"\",\"user_id\":"+String.valueOf(user.getStudentNum())+",\"felica_id\":\""+user.getFelicaID()+"\",\"money\":"+String.valueOf(user.getMoney().getMoney())+"}";
        
		patch.setHeader("Content-type", "application/json; charset=UTF-8");
       patch.setEntity(new StringEntity(entity,"UTF-8"));
		
		return HTTPExcute(patch);
	}
	
	public static User postUser(User newUser) throws Exception{
		HttpPost post = new HttpPost("http://192.168.1.219/api/users/");
		String entity = 
				"{\"name\":\""+newUser.getName()+"\",\"user_id\":"+String.valueOf(newUser.getStudentNum())+",\"felica_id\":\""+newUser.getFelicaID()+"\",\"money\":"+String.valueOf(newUser.getMoney().getMoney())+"}";
        
		post.setHeader("Content-type", "application/json; charset=UTF-8");
       post.setEntity(new StringEntity(entity,"UTF-8"));
		
		return HTTPExcute(post);
	}
}
