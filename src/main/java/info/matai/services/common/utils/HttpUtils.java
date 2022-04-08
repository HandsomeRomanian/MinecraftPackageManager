package info.matai.services.common.utils;

import java.io.IOException;
import java.util.Scanner;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;

public class HttpUtils {
  private static CloseableHttpClient httpClient;

  public static String get(String url) throws IOException {
    Scanner sc = null;
    try {
      if (HttpUtils.httpClient == null) {
        HttpUtils.httpClient = HttpClients.createDefault();
        return null;
      }

      HttpGet request = new HttpGet(url);
      HttpResponse response = HttpUtils.httpClient.execute(request);
      sc = new Scanner(response.getEntity().getContent());
      StringBuilder data = new StringBuilder();
      while (sc.hasNext()) {
        data.append(sc.nextLine());
      }
      sc.close();
      return data.toString();
    } catch (Exception e) {
      if (sc != null) {
        sc.close();
      }
      throw e;
    }
  }
}
