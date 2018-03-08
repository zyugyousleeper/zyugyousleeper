package test;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;

import org.apache.http.Header;
import org.apache.http.HttpEntity;
import org.apache.http.HttpHeaders;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.protocol.HTTP;

import model.User;
import utils.*;

public class testUtils {
	public static void main(String[] args) throws Exception{
		final String url = "http://192.168.1.219/api/users/16001/";
		HttpGet get = new HttpGet(url);
		get.addHeader(HttpHeaders.CONTENT_TYPE, "application/json");
		get.addHeader(HttpHeaders.AUTHORIZATION, "Basic cm9vdDptb2tlbW9rZW1va2Vtb2tl");
		
//		HttpPost httpClient = new HttpPost(url);
//		httpClient.execute(new HttpGet(uri));
//		CookieStore cookieStore = httpClient.getCookieStore();
//		List <Cookie> cookies =  cookieStore.getCookies();
//		for (Cookie cookie: cookies) {
//		    if (cookie.getDomain().equals(Constants.CSRF_COOKIE_DOMAIN) && cookie.getName().equals("csrftoken")) {
//		        CSRFTOKEN = cookie.getValue();
//		    }
//		}
		
		get.addHeader("Cookie", "sessionid=btduxyqwuvthge2uj9smpias0rignv9l; csrftoken=HjjeD01lI44GlLK1eFHiaN0PuzFQnDtanlE2h5v20EkRDE3CTcJV5lY358zDNq5v");
		System.out.println(get.toString());
		Header[] headers = get.getAllHeaders();
		for (Header header : headers) {
			System.out.println(header.toString());
		}
		
		CloseableHttpClient client = HttpClients.createDefault();
		StringBuilder builder = new StringBuilder();
		HttpResponse response = client.execute(get);
		
		int statusCode = response.getStatusLine().getStatusCode();
		System.out.println(statusCode);
		if (statusCode %100 ==2) throw new Exception();
		
		HttpEntity entity = response.getEntity();
		
		InputStream content = entity.getContent();
		BufferedReader reader = new BufferedReader(new InputStreamReader(content));
		String line;
		while ((line = reader.readLine()) != null) {
			builder.append(line);
		}
		System.out.println(builder.toString());
	}
}
